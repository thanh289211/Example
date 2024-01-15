package com.example.base.request;

import lombok.Data;
import lombok.ToString;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Data
@ToString
public class BaseRequest {
    public static final String REQUEST_ID = "request_id";

    private String requestId = UUID.randomUUID().toString();

    private String requestDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
}

