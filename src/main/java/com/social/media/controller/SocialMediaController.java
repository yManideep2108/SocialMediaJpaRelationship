package com.social.media.controller;

import com.social.media.models.SocialUser;
import com.social.media.service.SocialMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SocialMediaController {
    @Autowired
    private SocialMedia socialMedia ;

    @GetMapping("/social/users")
    public ResponseEntity<List<SocialUser>> getAllSocialUser(){
        return new ResponseEntity<>(socialMedia.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/social/users")
    public ResponseEntity<SocialUser> createSocialUser(@RequestBody SocialUser socialUser){
        return new ResponseEntity<>(socialMedia.saveUser(socialUser),HttpStatus.CREATED);
    }

}
