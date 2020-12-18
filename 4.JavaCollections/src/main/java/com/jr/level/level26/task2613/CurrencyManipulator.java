package com.jr.level.level26.task2613;

import com.jr.level.level26.task2613.exception.NotEnoughMoneyException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new TreeMap<>(Comparator.reverseOrder());
    private int totalAmount;

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count){
        this.denominations.merge(denomination, count, Integer::sum);
        totalAmount += count * denomination;
    }

    public int getTotalAmount(){
        return totalAmount;
    }

    public boolean hasMoney(){
        return totalAmount > 0;
    }

    public boolean isAmountAvailable(int expectedAmount){
        return totalAmount >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        Map<Integer, Integer> result = getCurrencySet(expectedAmount);
        withdrawMoney(result, expectedAmount);
        return result;
    }

    private Map<Integer, Integer> getCurrencySet(int expectedAmount) throws  NotEnoughMoneyException {
        Map<Integer, Integer> result = new HashMap<>();

        for(Map.Entry<Integer, Integer> entry: denominations.entrySet()){
            int tmp = Math.min(expectedAmount / entry.getKey(), entry.getValue());
            if(tmp > 0) {
                expectedAmount -= tmp * entry.getKey();
                result.put(entry.getKey(), tmp);
            }

            if(expectedAmount <= 0) break;
        }

        if(expectedAmount != 0)
            throw new NotEnoughMoneyException();

        return result;
    }

    private void withdrawMoney(Map<Integer, Integer> money, int amount) {
        money.forEach((key, value) -> denominations.merge(
                key, value,
                (v1, v2) ->  v1 - v2 <= 0 ? null : v1 - v2
        ));
        totalAmount -= amount;
    }

}
