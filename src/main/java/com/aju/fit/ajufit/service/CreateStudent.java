package com.aju.fit.ajufit.service;

import com.aju.fit.ajufit.exception.IncompatibleUserException;
import com.aju.fit.ajufit.model.UserDto;
import com.aju.fit.ajufit.model.UserProfessorDto;
import com.aju.fit.ajufit.repository.UserRepository;
import com.aju.fit.ajufit.repository.UserSubscriptionRepository;
import com.aju.fit.ajufit.repository.model.UserEntity;
import com.aju.fit.ajufit.repository.model.UserSubscriptionEntity;
import com.aju.fit.ajufit.repository.model.keys.UserSubscriptionKey;
import com.aju.fit.ajufit.statics.UserType;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateStudent implements CreateUserStrategy {
  private final UserRepository userRepository;
  private final UserSubscriptionRepository userSubscriptionRepository;

  public CreateStudent(
      @Autowired UserRepository userRepository,
      @Autowired UserSubscriptionRepository userSubscriptionRepository) {
    this.userRepository = userRepository;
    this.userSubscriptionRepository = userSubscriptionRepository;
  }

  @Override
  public UserEntity create(UserDto userRequest) throws Exception {
    if (UserType.isStudent(userRequest.type()) && hasProfessorData(userRequest.professor())) {

      final var professorOptional =
          userRepository.findByPhoneAndEmail(
              userRequest.professor().phone(), userRequest.professor().email());

      final var isActive = professorOptional.map(UserEntity::getIsActive).orElse(Boolean.FALSE);

      if (isActive) {
        final var studentOptional =
            userRepository.findByPhoneAndEmail(userRequest.phone(), userRequest.email());

        if (studentOptional.isEmpty()) {
          final var professor = professorOptional.get();
          final var student = saveUser(userRequest.toUserEntity().build());

          student.setProfessor(
              UserSubscriptionEntity.builder()
                  .id(new UserSubscriptionKey(professor.getId(), student.getId()))
                  .professor(professor)
                  .student(student)
                  .build());

          // saving twice to update relation btw professor and student
          return saveUser(student);
        }
        throw new IncompatibleUserException("Student already exists");
      }
      throw new IncompatibleUserException("Can`t create user, professor is inactive");
    }
    throw new IncompatibleUserException("Can`t create user, incompatible types");
  }

  private UserEntity saveUser(UserEntity user) {
    return userRepository.save(user);
  }

  private UserSubscriptionEntity saveSubscription(UserSubscriptionEntity userSubscriptionEntity) {
    return userSubscriptionRepository.save(userSubscriptionEntity);
  }

  private boolean hasProfessorData(UserProfessorDto userProfessorRequest) {
    return userProfessorRequest != null
        && Strings.isNotBlank(userProfessorRequest.phone())
        && Strings.isNotBlank(userProfessorRequest.email());
  }
}
