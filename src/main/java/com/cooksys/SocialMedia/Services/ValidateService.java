package com.cooksys.SocialMedia.Services;

public interface ValidateService {

    boolean labelExists(String label);

    boolean usernameExists(String username);

    boolean usernameAvailable(String username);

}
