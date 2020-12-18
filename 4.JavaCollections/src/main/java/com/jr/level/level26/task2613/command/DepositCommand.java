package com.jr.level.level26.task2613.command;

import com.jr.level.level26.task2613.CurrencyManipulator;
import com.jr.level.level26.task2613.CurrencyManipulatorFactory;
import com.jr.level.level26.task2613.exception.InterruptOperationException;
import java.util.ResourceBundle;

import static com.jr.level.level26.task2613.ConsoleHelper.*;
import static com.jr.level.level26.task2613.CashMachine.*;

class DepositCommand implements Command {
    private final ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "deposit");

    @Override
    public void execute() throws InterruptOperationException {
        writeMessage(res.getString("before"));
        String currencyCode = askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        int denomination = 0;
        int count = 0;

        while(true) {
            String[] currencyNominal = getValidTwoDigits(currencyCode);
            try {
                denomination = Integer.parseInt(currencyNominal[0]);
                count = Integer.parseInt(currencyNominal[1]);
                manipulator.addAmount(denomination, count);
                writeMessage(String.format(res.getString("success.format"), denomination * count, currencyCode));
                break;
            }catch (NumberFormatException e){
                writeMessage(res.getString("invalid.data"));
            }
        }

    }
}
