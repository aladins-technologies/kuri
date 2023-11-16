package com.app.kuri.Utils;

public enum CustomHttpStatus {
    
    SUCCESS(0),
    FAILED(1);


    private final int status;

    CustomHttpStatus(int status) {
        this.status = status;
    }

    public int asStatus() {
        return status;
    }
}
