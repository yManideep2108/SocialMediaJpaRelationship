package com.social.media.service;

import com.social.media.Repositories.SocialUserRepo;
import com.social.media.models.SocialUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialMediaImplementatiom implements SocialMedia {

    @Autowired
    public SocialUserRepo socialUserRepo;
    @Override
    public List<SocialUser> getAllUsers() {
        return socialUserRepo.findAll();
    }

    @Override
    public SocialUser saveUser(SocialUser socialUser) {
        return socialUserRepo.save(socialUser);
    }
}
