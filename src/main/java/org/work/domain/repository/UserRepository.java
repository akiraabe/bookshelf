package org.work.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.work.domain.model.User;

/**
 * Created by akiraabe on 2017/06/17.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
