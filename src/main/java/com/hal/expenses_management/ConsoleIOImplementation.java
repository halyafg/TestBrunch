package com.hal.expenses_management;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public final class ConsoleIOImplementation implements ConsoleIO {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getUserInput() {
        return scanner.nextLine();
    }

    @Override
    public void printLine(String line) {
        System.out.print(line);
    }

    @Override
    public void printLine (Map<String, List<Purchase>> purchaseMap){
        purchaseMap.forEach((k, v) -> {
            printLine("\n\t" + k);
            v.forEach(p -> printLine("\n\t" + p));
            printLine("\n");
        });
    }
}
