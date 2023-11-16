package com.app.kuri.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiResponse {
    
    private final Map<String, Object> responseData;
    private final String message;
    private final Integer status;
    private List<String> detailedMessages;


    public ApiResponse(Map<String, Object> responseData, List<String> detailedMessages, String message, Integer status) {
        this.responseData = responseData;
        this.message = message;
        this.status = status;
        this.detailedMessages = detailedMessages;
    }

    public ApiResponse(Map<String, Object> responseData, String message, Integer status) {
        this.responseData = responseData;
        this.message = message;
        this.status = status;
    }

    public ApiResponse(String message, Integer status) {
        this.responseData = new HashMap<>();
        this.message = message;
        this.status = status;
    }

    public Map<String, Object> getResponseData() {
        return responseData;
    }

    public List<String> getDetailedMessages() {
        return detailedMessages;
    }

    public void setDetailedMessages(List<String> detailedMessages) {
        this.detailedMessages = detailedMessages;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return status;
    }
}
