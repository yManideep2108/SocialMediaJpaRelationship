package com.social.media.service;

import com.social.media.models.SocialUser;

import java.util.List;

public interface SocialMedia {
    public List<SocialUser> getAllUsers();
    public SocialUser saveUser(SocialUser socialUser);
}
