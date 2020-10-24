package com.postalSystem.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class PostOfficeAlreadyExists extends RuntimeException {
}
