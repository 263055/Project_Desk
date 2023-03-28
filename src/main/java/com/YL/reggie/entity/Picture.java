package com.YL.reggie.entity;

import lombok.Data;

@Data
public class Picture {
    private FileDetail fileDetail;
    private String url;
    private String status;
}
