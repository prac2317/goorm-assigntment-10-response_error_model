package com.example.responseError.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ApiResponse<T> {

    private Status status;
    private MetaData metaData;
    private List<T> result;

    public ApiResponse(List<T> result) {
        this.result = result;
    }

    public ApiResponse(Status status, MetaData metaData, List<T> result) {
        this.status = status;
        this.metaData = metaData;
        this.result = result;
    }
}
