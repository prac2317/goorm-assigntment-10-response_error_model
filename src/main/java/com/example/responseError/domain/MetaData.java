package com.example.responseError.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MetaData {
    private int resultCount;

    public MetaData(int resultCount) {
        this.resultCount = resultCount;
    }
}
