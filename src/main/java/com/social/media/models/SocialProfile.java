package com.social.media.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SocialProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long socialProfileid ;


    @OneToOne()
    @JoinColumn(name = "socialUserId")
    @JsonIgnore
    private SocialUser socialUser;

    private String description ;

    public void setSocialUser(SocialUser socialUser){
        this.socialUser = socialUser;
        if(socialUser.getSocialProfile() != this){
            socialUser.setSocialProfile(this);
        }
    }
}
