package com.hal.expenses_management;

public class Application {
    public static void main(String[] args) {
        ExpensesUI ui = new ExpensesUI(new ConsoleIOImplementation(), new Expenses());
        ui.start();
    }

}
