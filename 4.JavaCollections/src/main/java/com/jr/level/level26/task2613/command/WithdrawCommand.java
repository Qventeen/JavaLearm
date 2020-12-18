package com.jr.level.level26.task2613.command;

import com.jr.level.level26.task2613.CurrencyManipulator;
import com.jr.level.level26.task2613.CurrencyManipulatorFactory;
import com.jr.level.level26.task2613.exception.InterruptOperationException;
import com.jr.level.level26.task2613.exception.NotEnoughMoneyException;
import java.util.Map;
import java.util.ResourceBundle;

import static com.jr.level.level26.task2613.CashMachine.RESOURCE_PATH;
import static com.jr.level.level26.task2613.ConsoleHelper.*;
import static java.lang.String.format;


class WithdrawCommand implements Command {
    private final ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "withdraw");


    @Override
    public void execute() throws InterruptOperationException {
        writeMessage(res.getString("before"));
        String currencyCode = askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        int takeCurrency;

        while(true){
            try {
                writeMessage(res.getString("specify.amount"));
                takeCurrency = Integer.parseInt(readString());
                if(manipulator.isAmountAvailable(takeCurrency)){
                    Map<Integer, Integer> money = manipulator.withdrawAmount(takeCurrency);
                    printResult(money);
                    break;
                }
                writeMessage(res.getString("not.enough.money"));
            } catch (NumberFormatException e) {
                writeMessage(res.getString("specify.not.empty.amount"));
            } catch (NotEnoughMoneyException e){
                writeMessage(res.getString("exact.amount.not.available"));
            }
        }

    }

    private void printResult(Map<Integer, Integer> map){
        map.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getKey(), e1.getKey()))
                .forEach(e -> writeMessage(format(res.getString("success.format"), e.getKey(), e.getValue())));
    }
}
