package com.YL.reggie.entity;

import lombok.Data;

@Data
public class Picture {
    private FileDetail fileDetail;
    private byte[] aByte;

    public Picture(FileDetail fileDetail, byte[] aByte) {
        this.fileDetail = fileDetail;
        this.aByte = aByte;
    }

    public Picture() {
    }
}
