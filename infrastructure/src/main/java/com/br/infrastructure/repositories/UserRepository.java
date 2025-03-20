package com.br.infrastructure.repositories;

import com.br.infrastructure.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
