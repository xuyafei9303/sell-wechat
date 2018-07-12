package com.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    /**
     * 公众平台id
     */
    private String mpAppid;

    /**
     * 公众平台秘钥
     */
    private String mpAppSecret;

    /**
     * 开发平台id
     */
    private String openAppId;

    /**
     * 开发平台秘钥
     */
    private String openAppSecret;

    /**
     * 商户号
     */
    private String mchId;

    /**
     * 商户秘钥
     */
    private String mchKey;

    /**
     * 商户证书路径
     */
    private String keyPath;

    /**
     * 商户证书路径
     */
    private String notifyUrl;

    /**
     * 微信模板id
     */
    private Map<String, String> templateId;


}

