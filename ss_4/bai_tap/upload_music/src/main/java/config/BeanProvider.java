package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import service.SongService;

@Configuration
@ComponentScan(basePackages = "*")
public class BeanProvider {
    @Bean
    public SongService songService(){
        return new SongService();
    }
}
