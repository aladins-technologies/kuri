package com.app.kuri.Exception;

public class UserException extends KuriException {

    public UserException(String msg) {
        super();
        this.setErrorMsg(msg);
    }
}
