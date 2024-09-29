package cnu.moksoriro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping(("/**"))
                .allowedOrigins("*")
                //추후 frontend 배포 이후 ip추가
                .allowedHeaders("*")
                .allowedMethods("*");
    }
}
