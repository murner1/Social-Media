package com.cooksys.SocialMedia.Controllers.Advice;

import javax.servlet.http.HttpServletRequest;

import com.cooksys.SocialMedia.Dtos.ErrorDto;
import com.cooksys.SocialMedia.Exceptions.BadRequestException;
import com.cooksys.SocialMedia.Exceptions.NotAuthorizedException;
import com.cooksys.SocialMedia.Exceptions.NotFoundException;
import org.aspectj.weaver.ast.Not;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.fasterxml.jackson.databind.deser.impl.ErrorThrowingDeserializer;

@RestControllerAdvice(basePackages = {"com.cooksys.SocialMedia.Controllers"})

public class ControllerAdvice {
	//BadRequest
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadRequest.class)
	public ErrorDto handleBadRequestException(HttpServletRequest request, BadRequestException badRequestException) {
		return new ErrorDto(badRequestException.getMessage());
	}
	
	
	//NotFoundException
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public ErrorDto handleNotFoundException(HttpServletRequest request, NotFoundException notFoundException){
		return new ErrorDto(notFoundException.getMessage());
	}
	//NotAuthorizedException
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(NotAuthorizedException.class)
	public ErrorDto handleNorAuthorizedException(HttpServletRequest request, NotAuthorizedException notAuthorizedException){
		return new ErrorDto(notAuthorizedException.getMessage());
	}
	

}
