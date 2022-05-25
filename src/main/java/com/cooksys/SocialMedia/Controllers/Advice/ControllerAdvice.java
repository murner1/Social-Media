package com.cooksys.SocialMedia.Controllers.Advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.cooksys.SocialMedia.Exceptions.NotFoundException;
import com.fasterxml.jackson.databind.deser.impl.ErrorThrowingDeserializer;

@RestControllerAdvice

public class ControllerAdvice {
	//BadRequest
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadRequest.class)
	public ErrorDto handleBadRequestException(HttpServletRequest request, BadRequestException badRequestException) {
		return new ErrorDto(BadRequestException.getMessage());
	}
	
	
	
	
	//NotFoundException
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public ErrorDto handleNotFoundException(HttpServletRequest request, NotFoundException notFoundException) {
		return new ErrorDto(notFoundException.getMessage());
	}
	
	//NotAuthorizedException
	@ResponseStatus
	@ExceptionHandler(NotAuthorizedException.class)
	public ErrorDto handleNotAuthorizedException(HttpServletRequest request, NotAuthorizedException notAuthorizedException) {
		return new ErrorDto(notAuthorizedException.getMessage());
	}
	

}
