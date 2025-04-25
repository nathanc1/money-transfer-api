package com.example.money_transfer_api.service;

import com.example.money_transfer_api.model.Account;
import com.example.money_transfer_api.model.Transaction;
import com.example.money_transfer_api.repository.AccountRepository;
import com.example.money_transfer_api.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class TransferService {

    private final AccountRepository accountRepo;
    private final TransactionRepository transactionRepo;

    public TransferService(AccountRepository accountRepo, TransactionRepository transactionRepo) {
        this.accountRepo = accountRepo;
        this.transactionRepo = transactionRepo;
    }

    @Transactional
    public String transfer(Long fromId, Long toId, BigDecimal amount) {
        Optional<Account> fromOpt = accountRepo.findById(fromId); // using optional to not crash when no account is found
        Optional<Account> toOpt = accountRepo.findById(toId);  // using optional to not crash when no account is found

        if (fromOpt.isEmpty() || toOpt.isEmpty()) {
            return "One or both accounts not found";
        }

        Account from = fromOpt.get();
        Account to = toOpt.get();

        if (from.getBalance().compareTo(amount) < 0) {
            return "Insufficient balance";
        }

        from.setBalance(from.getBalance().subtract(amount));
        to.setBalance(to.getBalance().add(amount));

        accountRepo.save(from);
        accountRepo.save(to);

        Transaction transaction = new Transaction(from, to, amount);
        transactionRepo.save(transaction);

        return "Transfer finished successfully";
    }
}
