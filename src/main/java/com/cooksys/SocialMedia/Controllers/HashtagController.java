package com.cooksys.SocialMedia.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.SocialMedia.Services.HashtagService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("tags")
@AllArgsConstructor
public class HashtagController {
  private HashtagService hashtagService;

}
