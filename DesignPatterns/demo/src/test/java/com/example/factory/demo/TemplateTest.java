package com.example.factory.demo;

import com.example.factory.demo.Template.Facebook;
import com.example.factory.demo.Template.Network;
import com.example.factory.demo.Template.Twitter;
import org.junit.jupiter.api.Test;

public class TemplateTest {
    @Test
    public void Test2() {
        Network network = null;
        System.out.print("Input user name: ");
        String userName = "esegov";
        System.out.print("Input password: ");
        String password = "fakePass";

        System.out.print("Input message: ");
        String message = "Message";

        System.out.println("\nChoose social network for posting message.\n" +
                "1 - Facebook\n" +
                "2 - Twitter");
        int choice = 2;

        if (choice == 1) {
            network = new Facebook(userName, password);
        } else if (choice == 2) {
            network = new Twitter(userName, password);
        }
        network.post(message);
    }
}
