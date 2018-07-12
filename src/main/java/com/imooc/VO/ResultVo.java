package com.imooc.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的最外层对象
 */
@Data
public class ResultVo<T> implements Serializable {

    // 快速生成的快捷键 control + command + K
    private static final long serialVersionUID = 6866921590711160769L;
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
