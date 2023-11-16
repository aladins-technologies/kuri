package com.app.kuri.Exception;

public class KuriException extends RuntimeException {
    private String errorMsg;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public KuriException(String errorMsg) {
        super();
        this.errorMsg = errorMsg;
    }

    public KuriException() {
        super();
    }
}
