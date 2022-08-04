package com.sparta.jwtt.Dto;

import lombok.Getter;


@Getter
public class noticeRequestDto<T> {
//    private Id;
//    private String title;
//    private String content;
//    private String author;
//    private String commmentRequestDtoList;

    private boolean success;
    private T data;
    private String error;
    public noticeRequestDto(boolean success, T data, String error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }
}
