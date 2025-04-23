package com.social.media.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SocialUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long socialUserid ;

    @OneToOne(mappedBy = "socialUser" , cascade = CascadeType.ALL)
    private SocialProfile socialProfile;
    @OneToMany(mappedBy = "socialUser")
    private List<Post> posts = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "user_group" ,
            joinColumns = @JoinColumn(name = "socialUserId" ),
            inverseJoinColumns = @JoinColumn(name = "socialGroupId")
    )
    Set<SocialGroup> groups = new HashSet<>();

    @Override
    public int hashCode(){
        return Objects.hash(socialUserid);
    }
}
