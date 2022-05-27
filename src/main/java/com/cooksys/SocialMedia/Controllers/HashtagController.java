package com.cooksys.SocialMedia.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.SocialMedia.Dtos.HashtagDto;
import com.cooksys.SocialMedia.Services.HashtagService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("tags")
@AllArgsConstructor
public class HashtagController {
  private HashtagService hashtagService;

  //Get tags
  @GetMapping
  public List<HashtagDto> getAllTags(){
	  return hashtagService.getAllTags();
  }
  
}
