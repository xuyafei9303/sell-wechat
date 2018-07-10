package com.imooc.form;

import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductForm {

    private String productId;

    /**
     * 商品名
     */
    private String productName;

    /**
     * 商品价格
     */
    private BigDecimal productPrice;

    /**
     * 商品库存
     */
    private Integer productStock;

    /**
     * 商品详情
     */
    private String productDescription;

    /**
     * 商品小图
     */
    private String productIcon;

    /**
     * 类目编号
     */
    private Integer categoryType;
}
