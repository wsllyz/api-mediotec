package br.com.mediotec.apisenac.repository;

import br.com.mediotec.apisenac.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {}
