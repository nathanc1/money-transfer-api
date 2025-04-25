package com.example.money_transfer_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.money_transfer_api.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}   
