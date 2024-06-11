package org.crm.crmproject.controller.error;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    // statusCode : 예외와 함께 전달될 HTTP 상태 코드
    private final int statusCode;

    // 예외 메시지와 상태 코드를 매개변수로 받아서 초기화
    public CustomException(String msg, int statusCode) {
        super(msg);
        this.statusCode = statusCode;
    }

}