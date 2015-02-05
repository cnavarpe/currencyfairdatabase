package com.currencyfair.database.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.currencyfair.database.model.MoneyTransaction;

public interface MoneyTransactionRepository extends
		JpaRepository<MoneyTransaction, Integer> {
	@Query("SELECT mt from MoneyTransaction mt ORDER BY mt.user.id ASC")
	List<MoneyTransaction> findAllOrderByUserOrderByUserAsc();

	@Query("SELECT mt.currencyFrom, mt.currencyTo, SUM(mt.amountSell), SUM(mt.amountBuy) from MoneyTransaction mt GROUP BY mt.amountSell, mt.amountBuy")
	List<Object> findAllGroupByCurrency();

}
