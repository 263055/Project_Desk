package com.YL.reggie.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImageConfig implements WebMvcConfigurer {

    @Override // http://localhost:8080/getImg/64225f40f3b66ec4f6e486f8.jpg
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //和页面有关的静态目录都放在项目的static目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //上传的图片在D盘下的upLoadImg目录下，访问路径如：http://localhost:8081/upLoadImg/d3cf0281-bb7f-40e0-ab77-406db95ccf2c.jpg
        //其中OTA表示访问的前缀。"file:D:/upLoadImg/"是文件真实的存储路径upLoadImg
        registry.addResourceHandler("/getImg/**").addResourceLocations("file:D:/Temp/test/");
    }
}
