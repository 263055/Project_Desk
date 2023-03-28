package com.YL.reggie.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class FileDetail {
  public static final String COL_URL = "D:/Temp/test/";


    private String id;
    private String url;
    private long size;
    private String filename;
    private String originalFilename;
    private String basePath;
    private String path;
    private String ext;
    private String contentType;
    private String platform;
    private String thUrl;
    private String thFilename;
    private long thSize;
    private String thContentType;
    private String objectId;
    private String objectType;
    private String attr;
    private Timestamp createTime; // LocalDateTime
}
