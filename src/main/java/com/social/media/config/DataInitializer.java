package com.social.media.config;

import com.social.media.Repositories.SocialGroupRepo;
import com.social.media.Repositories.SocialPostRepo;
import com.social.media.Repositories.SocialProfileRepo;
import com.social.media.Repositories.SocialUserRepo;
import com.social.media.models.Post;
import com.social.media.models.SocialGroup;
import com.social.media.models.SocialProfile;
import com.social.media.models.SocialUser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    private final SocialUserRepo socialUserRepo ;
    private final SocialGroupRepo socialGroupRepo;
    private final SocialProfileRepo socialProfileRepo;
    private final SocialPostRepo socialPostRepo;

    public DataInitializer(SocialUserRepo socialUserRepo, SocialGroupRepo socialGroupRepo, SocialProfileRepo socialProfileRepo, SocialPostRepo socialPostRepo) {
        this.socialUserRepo = socialUserRepo;
        this.socialGroupRepo = socialGroupRepo;
        this.socialProfileRepo = socialProfileRepo;
        this.socialPostRepo = socialPostRepo;
    }

    @Bean
    public CommandLineRunner initializeData(){

        return args -> {
            //create social user and save users
            SocialUser user1 = new SocialUser();
            SocialUser user2 = new SocialUser();
            SocialUser user3 = new SocialUser();

            socialUserRepo.save(user1);
            socialUserRepo.save(user2);
            socialUserRepo.save(user3);

            //creating and saving groups and assiociate to users
            SocialGroup group1 = new SocialGroup();
            SocialGroup group2 = new SocialGroup();

            group1.getUsers().add(user1);
            group1.getUsers().add(user2);

            group2.getUsers().add(user2);
            group2.getUsers().add(user3);

            socialGroupRepo.save(group1);
            socialGroupRepo.save(group2);

            //Assiociate groups to User
            user1.getGroups().add(group1);
            user1.getGroups().add(group2);
            user2.getGroups().add(group2);
            user3.getGroups().add(group2);

            socialUserRepo.save(user1);
            socialUserRepo.save(user2);
            socialUserRepo.save(user3);

            //Save posts
            Post post1 = new Post();
            Post post2 = new Post();
            Post post3 = new Post();

            post1.setSocialUser(user1);
            post2.setSocialUser(user2);
            post3.setSocialUser(user3);

            socialPostRepo.save(post1);
            socialPostRepo.save(post2);
            socialPostRepo.save(post3);

            SocialProfile profile1 = new SocialProfile();
            SocialProfile profile2 = new SocialProfile();
            SocialProfile profile3 = new SocialProfile();

            profile1.setSocialUser(user1);
            profile2.setSocialUser(user2);
            profile3.setSocialUser(user3);

            socialProfileRepo.save(profile1);
            socialProfileRepo.save(profile2);
            socialProfileRepo.save(profile3);
        };
    }
}
