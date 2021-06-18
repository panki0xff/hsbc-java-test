package io.panki0xff.hsbcjavatest;

import io.panki0xff.hsbcjavatest.service.CommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@RequiredArgsConstructor
@Component
public class CommandRunner implements CommandLineRunner {

    private final CommandService commandService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("System started, please input [CCY value]");
        Scanner scanner = new Scanner(System.in);
        String line = "";
        do {
            line = scanner.nextLine();
            commandService.readCommand(line);
        } while (!"quit".equalsIgnoreCase(line));
        System.out.println("GoodBye");
    }
}