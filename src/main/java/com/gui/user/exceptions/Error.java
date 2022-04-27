package com.gui.user.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Error {

    private String message;

    public Error(String message) {
        this.message = message;
    }
}