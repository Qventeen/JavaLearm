package com.jr.level.level31.task3110.command;

import com.jr.level.level31.task3110.ConsoleHelper;
import com.jr.level.level31.task3110.FileProperties;
import com.jr.level.level31.task3110.ZipFileManager;
import java.util.List;

public class ZipContentCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Просмотр содержимого архива.");

        ZipFileManager zipFileManager = getZipFileManager();

        ConsoleHelper.writeMessage("Содержимое архива:");

        List<FileProperties> files = zipFileManager.getFilesList();
        for (FileProperties file : files) {
            ConsoleHelper.writeMessage(file.toString());
        }

        ConsoleHelper.writeMessage("Содержимое архива прочитано.");
    }
}
