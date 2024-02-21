package com.aju.fit.ajufit.repository;

import com.aju.fit.ajufit.repository.model.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  Optional<UserEntity> findByPhoneAndEmail(final String phone, final String email);
}
