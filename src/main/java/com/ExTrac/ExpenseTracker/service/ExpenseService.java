package com.ExTrac.ExpenseTracker.service;

import com.ExTrac.ExpenseTracker.dto.ExpenseDTO;
import com.ExTrac.ExpenseTracker.entity.Expense;

import java.util.List;
import java.util.Map;

public interface ExpenseService {
    Expense saveExpense(ExpenseDTO dto);
    List<Expense> getAllExpenses();
    Map<String, Double> getMonthlyStats();
    Map<String, Double> getCategoryStats();
}
