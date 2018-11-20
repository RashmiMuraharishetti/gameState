package com.thanksgivingProject.game.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Item not in Data Source")
public class NotFound extends RuntimeException {
}
