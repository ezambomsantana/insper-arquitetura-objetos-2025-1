package br.edu.insper.banco.common;

import java.time.LocalDateTime;

public class ErrorDTO {

    private String message;
    private int statusCode;
    private LocalDateTime errorHour;

    public ErrorDTO(String message, int statusCode, LocalDateTime errorHour) {
        this.message = message;
        this.statusCode = statusCode;
        this.errorHour = errorHour;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public LocalDateTime getErrorHour() {
        return errorHour;
    }

    public void setErrorHour(LocalDateTime errorHour) {
        this.errorHour = errorHour;
    }
}
