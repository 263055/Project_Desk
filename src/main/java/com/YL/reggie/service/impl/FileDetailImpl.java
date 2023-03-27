package com.YL.reggie.service.impl;

import com.YL.reggie.entity.FileDetail;
import com.YL.reggie.mapper.FileDetailMapper;
import com.YL.reggie.service.FileDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class FileDetailImpl extends ServiceImpl<FileDetailMapper, FileDetail> implements FileDetailService {
}
