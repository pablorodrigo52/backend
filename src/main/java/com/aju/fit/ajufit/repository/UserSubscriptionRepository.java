package com.aju.fit.ajufit.repository;

import com.aju.fit.ajufit.repository.model.UserSubscriptionEntity;
import com.aju.fit.ajufit.repository.model.keys.UserSubscriptionKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSubscriptionRepository
    extends JpaRepository<UserSubscriptionEntity, UserSubscriptionKey> {}
