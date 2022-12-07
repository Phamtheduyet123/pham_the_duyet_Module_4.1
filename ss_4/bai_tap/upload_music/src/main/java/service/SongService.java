package service;

import model.Song;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import util.CommonlUtil;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SongService {
    private List<Song> songs = new ArrayList<>();

    public ResponseEntity<Resource> downloadFile(String code) {
        Resource resource = null;
        String id = code.substring(0, code.length() - 2);
        int idDecode = Integer.parseInt(CommonlUtil.decode64(id));
        Optional<Song> opSong = songs.stream().filter(e -> e.getId() == idDecode).findFirst();

        String fileName = "";
        String mime = "";
        if (opSong.isPresent()) {
            String path = opSong.get().getPath();
            resource = loadFileAsResource(path);
            fileName = opSong.get().getName();
            mime = opSong.get().getFileType();
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mime))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }

    public void create(Song song) {
        int lastId = 0;

        if (songs.size() > 0) {
            lastId = songs.get(songs.size() - 1).getId();
        }
        song.setId(lastId + 1);
        MultipartFile multipartFile = song.getImage();
        String idEncode = CommonlUtil.encode64(String.valueOf(song.getId()));
        try {
            String path = getAbsolutePath("") + CommonlUtil.encodeMD5(multipartFile.getName() + LocalDateTime.now());
            FileCopyUtils.copy(multipartFile.getBytes(), new File(path));
            String url = ServletUriComponentsBuilder.fromCurrentRequest().toUriString();
            URI uri = new URI(url);
            song.setLink(String.format("%s://%s:8080/img/%s", uri.getScheme(), uri.getHost(), idEncode + "QG"));
            song.setPath(path);
            song.setFileType(CommonlUtil.getMimeTypeFromFileName(multipartFile.getOriginalFilename()));
            songs.add(song);
        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
        }
    }

    public List<Song> getAll() {
        return songs;
    }

    public Resource loadFileAsResource(String filePath) {
        Resource resource = null;
        try {
            resource = new UrlResource(Paths.get(filePath).toUri());
            if (resource.exists())
                return resource;
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        return resource;
    }

    private String getAbsolutePath(String code) {
//            System.getProperty("user.dir");
//            String saveDirectory= request.getSession().getServletContext().getRealPath("/");
        String rootPath = System.getProperty("catalina.home");
        File dir = new File(rootPath + File.separator + "img");
        if (!dir.exists())
            dir.mkdirs();

        return dir.getAbsolutePath() + "\\" + code;
    }
}
