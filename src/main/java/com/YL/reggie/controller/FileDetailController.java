package com.YL.reggie.controller;

import cn.xuyanwu.spring.file.storage.FileInfo;
import cn.xuyanwu.spring.file.storage.FileStorageService;
import com.YL.reggie.entity.FileDetail;
import com.YL.reggie.entity.SendMessage;
import com.YL.reggie.service.FileDetailService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/image")
public class FileDetailController {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private FileDetailService fileDetailService;

    @PostMapping("/uploadImage") // 给我写一个Java代码，要求用get请求，没有参数，
    public FileInfo uploadImage(MultipartFile image) {
        return fileStorageService.of(image)
                .image(img -> img.size(1000, 1000))
                .upload();
//        log.info(tempFileInfo.toString());
//        FileDetail fileDetail = new FileDetail();
//        fileDetail.setId("");
//        fileDetail.setUrl(fileDetail.getUrl());
//        fileDetail.setSize(fileDetail.getSize());
//        fileDetail.setFilename(fileDetail.getFilename());
//        fileDetail.setOriginalFilename(fileDetail.getOriginalFilename());
//        fileDetail.setBasePath(fileDetail.getBasePath());
//        fileDetail.setPath(fileDetail.getPath());
//        fileDetail.setExt(fileDetail.getExt());
//        fileDetail.setContentType(fileDetail.getContentType());
//        fileDetail.setPlatform(fileDetail.getPlatform());
//        fileDetail.setCreateTime(fileDetail.getCreateTime());
//        fileDetail.setThUrl("");
//        fileDetail.setThFilename("");
//        fileDetail.setThSize(0L);
//        fileDetail.setObjectId("");
//        fileDetail.setObjectType("");
//        fileDetail.setAttr("");
//        fileDetailService.save(fileDetail);
//        boolean isOK = fileDetailService.record(tempFileInfo);
//        return isOK ? tempFileInfo : null;
    }

    @GetMapping("/getImage") // 给我写一个Java代码，要求用get请求，没有参数，
    public FileInfo getImage() {
        //从数据库表send message查询信息集合
        LambdaQueryWrapper<FileDetail> queryWrapper = new LambdaQueryWrapper<>();
        //根据时间查询最近十次信息
//        queryWrapper.orderByDesc(fileDetailService::);
        queryWrapper.last("limit 0,10");
        List<FileDetail> list = fileDetailService.list(queryWrapper);
        // 下载为字节数组
//        byte[] bytes = fileStorageService.download(fileInfo).bytes();
        return null;
    }
}