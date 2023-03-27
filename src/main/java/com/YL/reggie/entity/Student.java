package com.YL.reggie.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 返回学生的状态
 */
@Data
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    //学习状态
    private Integer status;
    //学习照片

    //时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime time;

    //学习状态图片路径
    private String path;
}
