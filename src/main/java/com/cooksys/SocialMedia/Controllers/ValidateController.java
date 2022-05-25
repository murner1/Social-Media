package com.cooksys.SocialMedia.Controllers;

import java.util.List;

import com.cooksys.SocialMedia.Services.ValidateService;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("validate")
public class ValidateController {

    private ValidateService validateService;


}
