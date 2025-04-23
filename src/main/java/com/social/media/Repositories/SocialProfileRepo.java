package com.social.media.Repositories;

import com.social.media.models.SocialProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialProfileRepo extends JpaRepository<SocialProfile,Long> {
}
