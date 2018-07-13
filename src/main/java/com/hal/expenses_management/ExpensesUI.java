package com.hal.expenses_management;

import java.util.Arrays;

import static com.hal.expenses_management.Commands.*;
import static com.hal.expenses_management.Commands.CLEAR;
import static com.hal.expenses_management.Commands.TOTAL;
import static java.lang.String.valueOf;

public class ExpensesUI {

    private final ConsoleIO io;
    private final Expenses expenses;

    public ExpensesUI(ConsoleIO io, Expenses expenses) {
        this.io = io;
        this.expenses = expenses;
    }

    public void start() {

        io.printLine("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=\n" +
                "Hello from Expenses Management!\n" +
                "=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");


        while (true) {

            io.printLine("\nAvailable commands: " + Arrays.toString(values()) + "\n>>  ");

            String[] commandFromUser = io.getUserInput().split(" ");

            String command = commandFromUser[0].toUpperCase();

            if (command.equals(valueOf(EXIT)) && commandFromUser.length == 1) {

                break;

            } else if (command.equals(valueOf(ADD))) {

                expenses.addPurchase(commandFromUser);
                io.printLine(expenses.getPurchaseMap());

            } else if (command.equals(valueOf(LIST)) && commandFromUser.length == 1) {

                io.printLine(expenses.getPurchaseMap());

            } else if (command.equals(valueOf(CLEAR))) {

                expenses.deletePurchase(commandFromUser);
                io.printLine(expenses.getPurchaseMap());

            } else if (command.equals(valueOf(TOTAL))) {

                double counter = expenses.getTotalAmountInSpecifiedCurrency(commandFromUser);
                if(counter == 0 ){
                    io.printLine("!!!  There is a mistake in currency's name");
                }
                io.printLine("\n\t" + counter + " " + commandFromUser[1].toUpperCase()+"\n");

            } else {

                io.printLine("!!!  Wrong Command! Try again ;-)\n");

            }

        }

        io.printLine("Bye!");
    }
}
