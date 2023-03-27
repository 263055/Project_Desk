package com.YL.reggie.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 返回家长发送的信息
 */
@Data
public class SendMessage implements Serializable {

    private static final long COL_URL = 1L;

    //返回的信息
    private String content;

    //更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime time;
}
