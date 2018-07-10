package com.imooc.service;

import com.imooc.dataobject.SellerInfo;
import org.springframework.stereotype.Service;

/**
 * 卖家端
 */
public interface SellerService {

    /**
     * 通过openid查询卖家端信息
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
