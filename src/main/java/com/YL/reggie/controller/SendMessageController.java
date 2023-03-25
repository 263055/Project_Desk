package com.YL.reggie.controller;

import com.YL.reggie.common.R;
import com.YL.reggie.entity.SendMessage;
import com.YL.reggie.entity.Student;
import com.YL.reggie.service.SendMessageService;
import com.YL.reggie.service.StudentService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/message")
public class SendMessageController {
    @Autowired
    private SendMessageService sendMessageService;

    @Autowired
    private StudentService studentService;

    //发送十条最近家长的信息 /message/parents
    @GetMapping("/parents")
    public R<List<SendMessage>> parents() {
        //从数据库表send message查询信息集合
        LambdaQueryWrapper<SendMessage> queryWrapper = new LambdaQueryWrapper<>();
        //根据时间查询最近十次信息
        queryWrapper.orderByDesc(SendMessage::getTime);
        queryWrapper.last("limit 0,10");
        List<SendMessage> list = sendMessageService.list(queryWrapper);
        //遍历send message对象集合,获取每个对象中封装的信息
//        ArrayList<String> list1 = new ArrayList<>();
//        for (SendMessage mess : list) {
//            list1.add(mess.getContent());
//        }
//        //返回信息
//        return R.success(list1);
        //返回信息
        return R.success(list);
    }
    // 家长发送消息
    @GetMapping("/sentMessage")
    public R<String> sentMessage(@RequestParam String message) {

        SendMessage messageInfo = new SendMessage();
        messageInfo.setContent(message);
        boolean isOk = sendMessageService.save(messageInfo);
        return isOk ? R.success("发送成功") : R.error("发送失败");
    }

    //返回学生的学习状态
    @PostMapping("/students")
    public R<List<Student>> students(String s) {
        //需要返回的信息集合
        List<Student> contents = new ArrayList<>();
        //从数据库表student查询信息集合
        LambdaQueryWrapper<Student> queryWrapper = new LambdaQueryWrapper<>();
        //根据时间查询一次的学生状态
        queryWrapper.orderByDesc(Student::getTime);
        queryWrapper.last("limit 0,10");
//        queryWrapper.last("limit 1");
//        Student one = studentService.getOne(queryWrapper);
        List<Student> list = studentService.list(queryWrapper);
        //返回学生状态
        return R.success(list);
    }
}
