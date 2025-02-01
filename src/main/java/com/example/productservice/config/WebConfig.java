package com.example.productservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//이 메서드는 특정 요청 URL을 컨트롤러 없이 뷰로 바로 연결하는 역할을 합니
@Configuration
public class WebConfig implements WebMvcConfigurer {

//    이 메서드는 CORS(Cross-Origin Resource Sharing) 정책을 설정합니다.
//    CORS는 브라우저가 다른 도메인에서 리소스를 요청할 때 발생하는 보안 제약을 제어하기 위한 설정입니다.
    //모든 경로에 대해 CORS 정책을 적용.
    //모든 도메인에서 오는 요청을 허용.
    //허용된 HTTP 메서드만 사용할 수 있도록 설정.
    //.allowedOrigins("https://example.com", "https://anotherdomain.com")
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "OPTIONS");
    }
}
