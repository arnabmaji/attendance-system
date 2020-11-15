package io.github.arnabmaji19.attendancesystem.model;

import java.util.List;

public class ErrorResponse {

    private int statusCode;
    private List<String> errors;

    public ErrorResponse() {
    }

    public ErrorResponse(int statusCode, List<String> errors) {
        this.statusCode = statusCode;
        this.errors = errors;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
