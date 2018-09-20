package com.edatablock.rpa.email;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jms.annotation.EnableJms;

import java.util.Scanner;

@SpringBootApplication
@EnableJms
@Configuration
@ImportResource("classpath:integration/gmail-imap-idle-config.xml")

public class EmailApplication {
    private static final Log LOGGER = LogFactory.getLog(EmailApplication.class);

    private static final String HORIZONTAL_LINE =
            "\n=========================================================";


    public static void main(String[] args) {
        SpringApplication.run(EmailApplication.class, args);

        LOGGER.info(HORIZONTAL_LINE
                + "\n"
                + "\n          Welcome to EdataBlock                         "
                + "\n"
                + "\n    For more information please visit:                   "
                + "\n    http://www.edatablock.com/                           "
                + "\n"
                + HORIZONTAL_LINE );
//
//        final AbstractApplicationContext context =
//                new ClassPathXmlApplicationContext("classpath:integration/gmail-imap-idle-config.xml");
//
//        context.registerShutdownHook();

        final Scanner scanner = new Scanner(System.in);

        LOGGER.info(HORIZONTAL_LINE
                + "\n"
                + "\n    Please press 'q + Enter' to quit the application.    "
                + "\n"
                + HORIZONTAL_LINE );

        while (true) {

            final String input = scanner.nextLine();

            if("q".equals(input.trim())) {
                break;
            }

        }

        LOGGER.info("Exiting application...bye.");

        scanner.close();
       // context.close();
    }
}







