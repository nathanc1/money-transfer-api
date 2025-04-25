package com.example.money_transfer_api.controller;

import com.example.money_transfer_api.model.Account;
import com.example.money_transfer_api.repository.AccountRepository;
import com.example.money_transfer_api.service.TransferService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TransferController {

    private final AccountRepository accountRepo;
    private final TransferService transferService;

    public TransferController(AccountRepository accountRepo, TransferService transferService) {
        this.accountRepo = accountRepo;
        this.transferService = transferService;
    }

    @PostMapping("/accounts")
    public Account createAccount(@RequestBody Map<String, String> body) {
        String owner = body.get("owner");
        BigDecimal balance = new BigDecimal(body.get("balance"));
        Account account = new Account(owner, balance);
        return accountRepo.save(account);
    }

    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        return accountRepo.findAll();
    }

    @PostMapping("/transfer")
    public String transfer(@RequestBody Map<String, String> body) {
        Long from = Long.parseLong(body.get("from"));
        Long to = Long.parseLong(body.get("to"));
        BigDecimal amount = new BigDecimal(body.get("amount"));
        return transferService.transfer(from, to, amount);
    }
}
