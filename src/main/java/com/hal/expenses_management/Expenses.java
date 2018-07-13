package com.hal.expenses_management;

import com.hal.expenses_management.currencyConverter.Converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Halyna Hoy
 */
public class Expenses {

    private Map<String, List<Purchase>> purchaseMap;

    public Expenses() {
        this.purchaseMap = new TreeMap<>();
    }

    private final static int NUMBER_OF_ELEMENTS_IN_ADD_COMMAND = 5;

    public Map<String, List<Purchase>> getPurchaseMap() {
        return purchaseMap;
    }

    public void setPurchaseMap(Map<String, List<Purchase>> purchaseMap) {
        this.purchaseMap = purchaseMap;
    }

    /**
     * this method adds new Purchase to the Map
     *
     * @param message - message from user in console
     */
    public Map<String, List<Purchase>> addPurchase(String[] message) {

        Purchase purchase = extractPurchase(message);
        if (purchase == null) {
            return this.purchaseMap;
        }

        purchaseMap.putIfAbsent(purchase.getDate(), new ArrayList<>());
        purchaseMap.get(purchase.getDate()).add(purchase);

        return this.purchaseMap;

    }

    /**
     * this method gets new Purchase from array message
     *
     * @param message - message from user in console
     * @return new Purchase
     */
    public Purchase extractPurchase(String[] message) {

        if (message.length < NUMBER_OF_ELEMENTS_IN_ADD_COMMAND) {
            return null;
        }

        String date = message[1];

        double amount = 0;
        try {
            amount = Double.parseDouble(message[2]);
        } catch (NumberFormatException e) {
            final ConsoleIO io = new ConsoleIOImplementation();
            io.printLine("Wrong amount: " + message[2] + "\n");
        }

        String currency = message[3];

        String productName = "";
        for (int i = NUMBER_OF_ELEMENTS_IN_ADD_COMMAND - 1; i < message.length; i++) {
            productName = productName.concat(message[i]).concat(" ");
        }

        return new Purchase(date, amount, currency, productName.trim());
    }

    /**
     * this method removes all expenses for specified date.
     *
     * @param message - message from user in console
     */
    public boolean deletePurchase(String[] message) {

        if (message.length > 1) {
            String date = message[1];
            if (purchaseMap.containsKey(date)) {
                purchaseMap.remove(date);
                return true;
            }

        }

        return false;
    }

    /**
     * this method calculates the total amount of money spent and presents it to user in specified currency
     *
     * @param message - message from user in console
     */
    public double getTotalAmountInSpecifiedCurrency(String[] message) {

        //get specified currency from message
        if (message.length == 1) {
//            System.out.println("Input: TOTAL currencyCOD");
            return 0.0;
        }
        String specifiedCurrency = message[1];

        double RateOfSpecifiedCurrency = Converter.convertToBaseEUR(specifiedCurrency.toUpperCase());
        double counter = 0;

        //calculates the total amount in specified currency
        for (Map.Entry<String, List<Purchase>> item : purchaseMap.entrySet()) {
            for (Purchase purchase : item.getValue()) {

                double rate = Converter.convertToBaseEUR(purchase.getCurrency().toUpperCase());
                if (rate == 0) {
                    ConsoleIO io = new ConsoleIOImplementation();
                    io.printLine("No such currency according to ISO: " + purchase.getCurrency() + "\n");
                    continue;
                }

                counter += RateOfSpecifiedCurrency / rate * purchase.getAmount();
            }
        }

        counter = (double) (Math.round(counter * 100)) / 100;
        return counter;
    }

}
