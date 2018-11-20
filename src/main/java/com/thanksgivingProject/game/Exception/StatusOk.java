package com.thanksgivingProject.game.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class StatusOk extends RuntimeException {
}
