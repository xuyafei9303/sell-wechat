package com.imooc.VO;

import lombok.Data;

/**
 * http请求返回的最外层对象
 */
@Data
public class ResultVo<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示状态信息
     */
    private String msg;

    /**
     * 返回的具体内容
     */
    private T data;
}
