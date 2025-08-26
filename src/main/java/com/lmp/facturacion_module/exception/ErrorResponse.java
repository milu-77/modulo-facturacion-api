package com.lmp.facturacion_module.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
 @Setter
public class ErrorResponse {
    // Getters
    private int status;
    private String message;

    public ErrorResponse(int status, String message) {


        this.status = status;
        this.message = message;
    }

}