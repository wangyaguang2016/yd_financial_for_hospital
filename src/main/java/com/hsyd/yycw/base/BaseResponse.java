package com.hsyd.yycw.base;

public enum BaseResponse {

    // 成功
    SUCCESS(1),

    // 失败
    ERROR(2);

    // 其他状态

    // 错误对应的编码
    private Integer code;

    private BaseResponse(Integer code) {
        this.code = code;
    }
}