package com.sparta.jwtt.Dto;

import lombok.Getter;


@Getter
public class noticeDto<T> {
    private boolean success;
    private T data;
    private String error;
    public noticeDto(boolean success, T data, String error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }
}
