package com.ExTrac.ExpenseTracker.repository;

import com.ExTrac.ExpenseTracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    @Query("SELECT EXTRACT(MONTH FROM e.date), SUM(e.amount) FROM Expense e GROUP BY EXTRACT(MONTH FROM e.date)")
    List<Object[]> getMonthlyStats();

    @Query("SELECT e.category, SUM(e.amount) FROM Expense e GROUP BY e.category")
    List<Object[]> getCategoryStats();
}
