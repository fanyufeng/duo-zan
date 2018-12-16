package com.duode.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by fanyufeng in 18/12/16
 */

@Configuration
public class UploadConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //和页面有关的静态目录都放在项目的static目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/ads/**").addResourceLocations("classpath:/ads/");
        //上传的图片在D盘下的OTA目录下，访问路径如：http://localhost:8081/OTA/d3cf0281-bb7f-40e0-ab77-406db95ccf2c.jpg
        //其中OTA表示访问的前缀。"file:D:/OTA/"是文件真实的存储路径
        //registry.addResourceHandler("/**").addResourceLocations("/duode/dituo/dituo/document/");
        registry.addResourceHandler("/images/**").addResourceLocations("file:/duode/dituo/images/");
        registry.addResourceHandler("/videos/**").addResourceLocations("file:/duode/dituo/video");
    }
}

