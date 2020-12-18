package com.jr.level.level26.task2613;

import com.jr.level.level26.task2613.exception.InterruptOperationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

import static com.jr.level.level26.task2613.CashMachine.RESOURCE_PATH;
import static java.lang.String.format;

public class ConsoleHelper {
    private static final ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "common");
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    private ConsoleHelper(){
        throw new AssertionError();
    }


    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        try {
            String line = bis.readLine();
            if("EXIT".equals(line.toUpperCase())){
                throw new InterruptOperationException();
            }
            return line;
        } catch (IOException ignored) { }
        return "";
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        while(true){
            writeMessage(res.getString("choose.currency.code"));
            String currencyCode = readString().trim();
            if(currencyCode.length() == 3){
                currencyCode = currencyCode.toUpperCase();
                return currencyCode;
            }
            printIncorrectDataMessage();
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        while (true) {
            ConsoleHelper.writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
            String s = ConsoleHelper.readString();
            String[] split = null;
            if (s == null || (split = s.split(" ")).length != 2) {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
            } else {
                try {
                    if (Integer.parseInt(split[0]) <= 0 || Integer.parseInt(split[1]) <= 0)
                        ConsoleHelper.writeMessage(res.getString("invalid.data"));
                } catch (NumberFormatException e) {
                    ConsoleHelper.writeMessage(res.getString("invalid.data"));
                    continue;
                }
                return split;
            }
        }
    }

    

    public static Operation askOperation() throws InterruptOperationException {
        while(true){
            writeMessage(res.getString("choose.operation"));
            try {
                writeMessage(format("[1 = %s] [2 = %s] [3 = %s] [4 = %s]",
                        res.getString("operation.INFO"),
                        res.getString("operation.DEPOSIT"),
                        res.getString("operation.WITHDRAW"),
                        res.getString("operation.EXIT")
                ));
                Integer number = Integer.parseInt(readString());
                return Operation.getAllowableOperationByOrdinal(number);
            }catch (NumberFormatException e){
                printIncorrectDataMessage();
            }
        }
    }

    public static void printExitMessage(){
        writeMessage(res.getString("the.end"));
    }


    private static void printIncorrectDataMessage(){
        writeMessage(res.getString("invalid.data"));
    }
    }
