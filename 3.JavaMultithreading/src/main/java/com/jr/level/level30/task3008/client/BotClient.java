package com.jr.level.level30.task3008.client;


import com.jr.level.level30.task3008.ConsoleHelper;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class BotClient extends Client {
    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        String userName = String.format("date_bot_%d", (int) (Math.random() * 100));
        return userName;
    }

    public static void main(String[] args){
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends Client.SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            sendTextMessage(
                "Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды."
                );
            super.clientMainLoop();
        }
        
        @Override
        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
            if(!message.contains(": "))
                return;
            
            String[] words = message.split(": ");
            String format = "";
            if("дата".equals(words[1]))
                format = "d.MM.YYYY";
            else if("день".equals(words[1]))
                format = "d";
            else if("месяц".equals(words[1]))
                format = "MMMM";
            else if("год".equals(words[1]))
                format = "YYYY";
            else if("время".equals(words[1]))
                format = "H:mm:ss";
            else if("час".equals(words[1]))
                format = "H";
            else if("минуты".equals(words[1]))
                format = "m";
            else if("секунды".equals(words[1]))
                format = "s";
            else
                return;
            
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            String str = String.format("Информация для %s: %s", words[0], (sdf.format(Calendar.getInstance().getTime())));
            sendTextMessage(str);
        }
    }
}
