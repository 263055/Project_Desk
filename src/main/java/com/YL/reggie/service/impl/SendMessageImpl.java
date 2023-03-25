package com.YL.reggie.service.impl;

import com.YL.reggie.entity.SendMessage;
import com.YL.reggie.mapper.SendMessageMapper;
import com.YL.reggie.service.SendMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SendMessageImpl extends ServiceImpl<SendMessageMapper, SendMessage> implements SendMessageService {
}
