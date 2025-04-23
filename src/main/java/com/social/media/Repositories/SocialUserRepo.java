package com.social.media.Repositories;

import com.social.media.models.SocialUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialUserRepo extends JpaRepository<SocialUser, Long> {
}
