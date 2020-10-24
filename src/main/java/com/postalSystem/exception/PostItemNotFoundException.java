package com.postalSystem.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class PostItemNotFoundException extends RuntimeException{
}
