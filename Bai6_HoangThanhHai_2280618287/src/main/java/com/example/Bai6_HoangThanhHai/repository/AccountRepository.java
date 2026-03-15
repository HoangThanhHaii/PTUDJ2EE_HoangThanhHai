package com.example.Bai6_HoangThanhHai.repository;

import com.example.Bai6_HoangThanhHai.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Integer> {

    Optional<Account> findByLoginName(String loginName);

}