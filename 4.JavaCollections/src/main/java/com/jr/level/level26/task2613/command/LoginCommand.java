package com.jr.level.level26.task2613.command;



import com.jr.level.level26.task2613.CashMachine;
import com.jr.level.level26.task2613.exception.InterruptOperationException;
import java.util.ResourceBundle;

import static com.jr.level.level26.task2613.CashMachine.RESOURCE_PATH;
import static com.jr.level.level26.task2613.ConsoleHelper.*;
import static java.lang.String.format;

public class LoginCommand implements Command {
    private final ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.verifiedCards");
    private final ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "login");


    @Override
    public void execute() throws InterruptOperationException {
        writeMessage(res.getString("before"));
        writeMessage(res.getString("specify.data"));
        do {
            try {
                String cardNumber = "";
                String cardPin = "";
                do{
                    cardNumber = readString().trim();
                    cardPin = readString().trim();
                    if(cardNumber.length() != 12 || cardPin.length() != 4){
                        writeMessage(res.getString("try.again.with.details"));
                    } else {
                        break;
                    }
                }while (true);

                if(validCreditCards.containsKey(cardNumber) && validCreditCards.getString(cardNumber).equals(cardPin)){
                    writeMessage(format(res.getString("success.format"),cardNumber));
                    return;
                }
                writeMessage(format(res.getString("not.verified.format"), cardNumber));
            } catch (NumberFormatException ignored) {}
            writeMessage(res.getString("try.again.or.exit"));
        } while (true);
    }


}
