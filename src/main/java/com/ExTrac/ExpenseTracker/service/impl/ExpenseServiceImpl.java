package com.ExTrac.ExpenseTracker.service.impl;

import com.ExTrac.ExpenseTracker.dto.ExpenseDTO;
import com.ExTrac.ExpenseTracker.entity.Expense;
import com.ExTrac.ExpenseTracker.repository.ExpenseRepository;
import com.ExTrac.ExpenseTracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository repository;

    @Override
    public Expense saveExpense(ExpenseDTO dto) {
        Expense expense = new Expense();
        expense.setCategory(dto.getCategory());
        expense.setDescription(dto.getDescription());
        expense.setAmount(dto.getAmount());
        expense.setDate(dto.getDate());
        return repository.save(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    //@Override
    //  public Map<String, Double> getMonthlyStats() {
    //     List<Object[]> data = repository.getMonthlyStats();
    //     Map<String, Double> result = new LinkedHashMap<>();
    //     for (Object[] obj : data) {
    //         result.put("Month " + ((Double)obj[0]).intValue(), (Double) obj[1]);
    //     }
    //     return result;
    //  }
    @Override
public Map<String, Double> getMonthlyStats() {
    List<Object[]> data = repository.getMonthlyStats();
    Map<String, Double> result = new LinkedHashMap<>();
    for (Object[] obj : data) {
        // Cast month correctly as Integer
        Integer month = (Integer) obj[0]; 
        Double totalAmount = ((Number) obj[1]).doubleValue(); // Handles both Double/BigDecimal
        result.put("Month " + month, totalAmount);
    }
    return result;
}


    @Override
    public Map<String, Double> getCategoryStats() {
        List<Object[]> data = repository.getCategoryStats();
        Map<String, Double> result = new LinkedHashMap<>();
        for (Object[] obj : data) {
            result.put((String) obj[0], (Double) obj[1]);
        }
        return result;
    }
}
