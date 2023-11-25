package com.app.kuri.Exception;

public class CustomerException extends KuriException{
    
    public CustomerException(String msg) {
        super();
        this.setErrorMsg(msg);
    }
}
