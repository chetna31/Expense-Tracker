package com.ExTrac.ExpenseTracker.controller;

import com.ExTrac.ExpenseTracker.dto.ExpenseDTO;
import com.ExTrac.ExpenseTracker.entity.Expense;
import com.ExTrac.ExpenseTracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService service;

    @PostMapping
    public ResponseEntity<Expense> createExpense(@RequestBody ExpenseDTO dto) {
        return ResponseEntity.ok(service.saveExpense(dto));
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAll() {
        return ResponseEntity.ok(service.getAllExpenses());
    }

    @GetMapping("/monthly-stats")
    public ResponseEntity<Map<String, Double>> getMonthlyStats() {
        return ResponseEntity.ok(service.getMonthlyStats());
    }

    @GetMapping("/category-stats")
    public ResponseEntity<Map<String, Double>> getCategoryStats() {
        return ResponseEntity.ok(service.getCategoryStats());
    }
}
