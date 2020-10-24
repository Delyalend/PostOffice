package com.postalSystem.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class PostOfficeNotFoundException extends RuntimeException{
}
