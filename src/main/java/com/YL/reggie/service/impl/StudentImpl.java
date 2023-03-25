package com.YL.reggie.service.impl;

import com.YL.reggie.entity.Student;
import com.YL.reggie.mapper.StudentMapper;
import com.YL.reggie.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class StudentImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
}
