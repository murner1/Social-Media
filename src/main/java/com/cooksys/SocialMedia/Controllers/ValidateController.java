package com.cooksys.SocialMedia.Controllers;

import java.util.List;

import com.cooksys.SocialMedia.Dtos.HashtagDto;
import com.cooksys.SocialMedia.Services.ValidateService;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("validate")
public class ValidateController {

    private ValidateService validateService;

    //GET validate/tag/exists/{label}
    @GetMapping("/tag/exists/{label}")
    public boolean labelExists(@PathVariable String label) {
        return validateService.labelExists(label);

    }
    //GET validate/username/exists/@{username}
    @GetMapping("/username/exists/@{username}")
    public boolean usernameExists(@PathVariable String username){
        return validateService.usernameExists(username);
    }
    //GET validate/username/available/@{username}
    @GetMapping("/username/available/@{username}")
    public boolean usernameAvailable(@PathVariable String username){
        return validateService.usernameAvailable(username);
    }

}
