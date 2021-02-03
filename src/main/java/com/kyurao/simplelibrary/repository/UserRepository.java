package com.kyurao.simplelibrary.repository;

import com.kyurao.simplelibrary.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByIdCard(String idCard);

}
