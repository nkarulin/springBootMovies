package su.nkarulin.emojmovies;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import su.nkarulin.emojmovies.domain.Movie;

@EnableAutoConfiguration
@ComponentScan("su.nkarulin.emojmovies")
public class Application implements WebMvcConfigurer {

    @Value("${emojmovies.picsfolder}")
    String imagesLocation;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:" + imagesLocation)
                .setCachePeriod(0);
    }
}
