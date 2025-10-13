package org.gfg.Library_Management_Minor.repository;

import jakarta.validation.constraints.NotBlank;
import org.gfg.Library_Management_Minor.model.User;
import org.gfg.Library_Management_Minor.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByPhoneNo(String phoneNo);

    User findByPhoneNoAndUserType(@NotBlank(message = "User phone number cannot be blank") String userPhoneNo, UserType userType);
}
