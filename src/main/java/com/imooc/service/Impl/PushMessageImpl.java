package com.imooc.service.Impl;

import com.imooc.config.WechatAccountConfig;
import com.imooc.dto.OrderDto;
import com.imooc.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class PushMessageImpl implements PushMessageService {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WechatAccountConfig accountConfig;

    @Override
    public void orderStatus(OrderDto orderDto) {

        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setTemplateId(accountConfig.getTemplateId().get("orderStatus"));
        templateMessage.setToUser(orderDto.getBuyerOpenid());

        List<WxMpTemplateData> data = Arrays.asList(
                new WxMpTemplateData("kw1","亲，请记得收货。"),
                new WxMpTemplateData("kw2","微信点餐"),
                new WxMpTemplateData("kw3","13997749303"),
                new WxMpTemplateData("kw4",orderDto.getOrderId()),
                new WxMpTemplateData("kw5",orderDto.getOrderStatusEnum().getMessage()),
                new WxMpTemplateData("kw6","¥" + orderDto.getOrderAmount()),
                new WxMpTemplateData("kw7","欢迎再次光临。")
        );
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            log.error("【微信模板消息】发送失败，{}", e);
        }

    }
}
