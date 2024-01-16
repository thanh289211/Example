package com.example.base.helpers.enums;

public interface IResponseStatus {
    String message();

    String messageCode();

    default IResponseStatus setMessage(String message) {
        return null;
    }

}
