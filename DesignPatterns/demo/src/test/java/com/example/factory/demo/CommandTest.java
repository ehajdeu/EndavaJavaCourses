package com.example.factory.demo;

import com.example.factory.demo.Command.OpenTextFileOperation;
import com.example.factory.demo.Command.SaveTextFileOperation;
import com.example.factory.demo.Command.TextFile;
import com.example.factory.demo.Command.TextFileOperationExecutor;
import org.junit.jupiter.api.Test;

public class CommandTest {
    @Test
    public void test1() {
        TextFileOperationExecutor textFileOperationExecutor
                = new TextFileOperationExecutor();
        textFileOperationExecutor.executeOperation(
                new OpenTextFileOperation(new TextFile("file1.txt")));
        textFileOperationExecutor.executeOperation(
                new SaveTextFileOperation(new TextFile("file2.txt")));
//
//        TextFileOperationExecutor textFileOperationExecutor2
//                = new TextFileOperationExecutor();
//        TextFile textFile = new TextFile("file1.txt");
//        textFileOperationExecutor2.executeOperation(textFile::open);
//        textFileOperationExecutor2.executeOperation(textFile::save);
    }
}
