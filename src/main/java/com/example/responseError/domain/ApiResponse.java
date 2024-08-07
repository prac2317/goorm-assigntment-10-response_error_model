package com.example.responseError.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ApiResponse<T> {

    private Status status;
    private MetaData metaData;
    private T result;

    public ApiResponse(T result) {
        this.result = result;
    }

    public ApiResponse(Status status, MetaData metaData, T result) {
        this.status = status;
        this.metaData = metaData;
        this.result = result;
    }
}
