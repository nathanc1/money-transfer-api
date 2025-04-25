package com.example.money_transfer_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.money_transfer_api.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
