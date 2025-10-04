package org.gfg.Library_Management_Minor.repository;

import org.gfg.Library_Management_Minor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
