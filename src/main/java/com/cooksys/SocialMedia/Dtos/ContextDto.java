package com.cooksys.SocialMedia.Dtos;

import com.cooksys.SocialMedia.Entities.Tweet;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ContextDto {
    private Tweet target;

    private Tweet before;

    private Tweet after;
}
