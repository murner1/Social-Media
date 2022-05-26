package com.cooksys.SocialMedia.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

    @AllArgsConstructor
    @Getter
    @Setter
    public class BadRequestException extends RuntimeException  {

        private String message;

}
