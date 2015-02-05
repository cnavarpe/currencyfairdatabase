package com.currencyfair.database.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.currencyfair.database.model.support.CurrencySupport;

@Entity
@Table(name = "money_transaction", indexes = @Index(name = "user_id_mon_trans_idx", columnList = "user_id"))
@Cacheable(true)
public class MoneyTransaction implements Serializable {

    private static final long serialVersionUID = 6558380651022934941L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "currency_from", nullable = false)
    @Enumerated(EnumType.STRING)
    private CurrencySupport currencyFrom;

    @Column(name = "currency_to", nullable = false)
    @Enumerated(EnumType.STRING)
    private CurrencySupport currencyTo;

    @Column(name = "amount_sell", nullable = false)
    private BigInteger amountSell;

    @Column(name = "amount_buy", nullable = false)
    private BigInteger amountBuy;

    @Column(name = "rate", nullable = false)
    private Double rate;

    @Column(name = "time_placed", nullable = false)
    private Timestamp timePlaced;

    @Column(name = "originating_country", nullable = false)
    private String originatingCountry;

    public MoneyTransaction() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CurrencySupport getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(CurrencySupport currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public CurrencySupport getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(CurrencySupport currencyTo) {
        this.currencyTo = currencyTo;
    }

    public BigInteger getAmountSell() {
        return amountSell;
    }

    public void setAmountSell(BigInteger amountSell) {
        this.amountSell = amountSell;
    }

    public BigInteger getAmountBuy() {
        return amountBuy;
    }

    public void setAmountBuy(BigInteger amountBuy) {
        this.amountBuy = amountBuy;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Timestamp getTimePlaced() {
        return timePlaced;
    }

    public void setTimePlaced(Timestamp timePlaced) {
        this.timePlaced = timePlaced;
    }

    public String getOriginatingCountry() {
        return originatingCountry;
    }

    public void setOriginatingCountry(String originatingCountry) {
        this.originatingCountry = originatingCountry;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

}
