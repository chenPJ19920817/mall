package com.xxmzz.common;

/**
 * @author CHEN-PJ
 * @title: IErrorCode
 * @projectName mall
 * @description: TODO
 * @date 2022/2/809:18
 */
public interface IErrorCode {
    /**
     * 返回码
     */
    long getCode();

    /**
     * 返回信息
     */
    String getMessage();
}
