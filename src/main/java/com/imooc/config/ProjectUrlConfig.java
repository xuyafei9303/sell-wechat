package com.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "ProjectUrl")
@Component
public class ProjectUrlConfig {

    /**
     * 微信公众平台账号授权url
     */
    public String wechatMpAuthrize;

    /**
     * 微信开发平台账号授权url
     */
    public String wechatOpenAuthrize;

    /**
     * 点餐系统
     */
    private String sell;
}
