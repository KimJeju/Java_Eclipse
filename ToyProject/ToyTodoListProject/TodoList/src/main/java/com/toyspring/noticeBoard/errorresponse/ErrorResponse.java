package com.toyspring.noticeBoard.errorresponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.FieldError;

import java.util.List;

@AllArgsConstructor
@Getter
public class ErrorResponse {


    //예외 발생시 실패한 변수에 대한 정보만 담기 위한 에러리스폰 클래스 입니다.

    //예외는 하나가 아닐 수 있기 떄문에 리스트로 받아 주었습니다.
    private List<FieldError> fieldError;

    @Getter
    @AllArgsConstructor
    public static class FieldError{
        private String field;
        private Object rejectedValue;
        private String reason;
    }
}
