package com.kyurao.simplelibray.repository;

import com.kyurao.simplelibray.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByIdCard(String idCard);

}
