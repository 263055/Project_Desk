package com.YL.reggie.controller;

import com.YL.reggie.entity.Student;
import com.YL.reggie.service.StudentService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/photo")
public class PhotoController {
    @Value("${reggie.path}")
    private String basePath;

    @Autowired
    private StudentService studentService;

    @GetMapping("/download")
    public void download(HttpServletResponse response){
        try {
            //查询最近十次学生信息
            LambdaQueryWrapper<Student> queryWrapper=new LambdaQueryWrapper<>();
            queryWrapper.orderByDesc(Student::getTime);
            queryWrapper.last("limit 0,10");
            List<Student> list = studentService.list(queryWrapper);
            //查询最近十次图片路径
            ArrayList<String> paths = new ArrayList<>();
            Iterator<Student> iterator = list.iterator();
            while(iterator.hasNext()){
                Student st = iterator.next();
                String path = st.getPath();
                paths.add(path);
            }
            for(int i=0;i<paths.size();i++){
                //输入流，通过输入流读取文件内容
                FileInputStream fileInputStream=new FileInputStream(new File(basePath+paths.get(i)));

                //输出流，通过输出流将文件写回浏览器，在浏览器展示图片
                ServletOutputStream outputStream = response.getOutputStream();

                response.setContentType("image/jpeg");

                int len=0;
                byte[] bytes=new byte[1024];
                while((len=fileInputStream.read(bytes))!=-1){
                    outputStream.write(bytes,0,len);
                    outputStream.flush();
                }

                //关闭资源
                outputStream.close();
                fileInputStream.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
