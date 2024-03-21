package org.onlinecourse401.project.backEnd.dto;

public class ClientResponseDto<T> {
    private int responseCode;
    // 200 - Ok
    // 400 - error
    // ...

    private T responseInfo;

    private String message;
    // запись данных произведена успешно
    // таких данных в коллекции нет


    public ClientResponseDto(int responseCode, T responseInfo, String message) {
        this.responseCode = responseCode;
        this.responseInfo = responseInfo;
        this.message = message;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public T getResponseInfo() {
        return responseInfo;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ClientResponse{" +
                "responseCode=" + responseCode +
                ", responseInfo=" + responseInfo +
                ", message='" + message + '\'' +
                '}';
    }
}
