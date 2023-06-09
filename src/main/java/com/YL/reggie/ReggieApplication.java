package com.YL.reggie;

import cn.xuyanwu.spring.file.storage.EnableFileStorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@Slf4j
@EnableFileStorage
@SpringBootApplication
@ServletComponentScan //开启组件扫描（扫描过滤器）
public class ReggieApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReggieApplication.class,args);
        log.info("项目启动成功");
    }
}
