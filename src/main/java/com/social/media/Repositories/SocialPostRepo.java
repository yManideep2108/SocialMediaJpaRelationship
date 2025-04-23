package com.social.media.Repositories;

import com.social.media.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialPostRepo extends JpaRepository<Post, Long> {
}
