package controller.demo.service.impl;

import controller.demo.model.Student;
import controller.demo.repository.IStudentRepository;
import controller.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("studentService")
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository iStudentRepository;
    @Override
    public List<Student> getAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        this.iStudentRepository.save(student);
    }

    @Override
    public Student getStudentById(int id) {
        //c1:
 //       Optional<Student> student = iStudentRepository.findById(id);
//        if(student.isPresent()) {
//            return student.get();
//        } else {
//            return null;
//        }
        //c2:
        return iStudentRepository.findById(id).orElse(null);
    }

    @Override
    public Page getAll(Pageable pageable) {
        return iStudentRepository.findAll(pageable);
    }
}
