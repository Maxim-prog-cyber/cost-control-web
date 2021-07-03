package com.exam.costcontrol.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such customer")
public class AccountNotFoundException extends RuntimeException{
}
