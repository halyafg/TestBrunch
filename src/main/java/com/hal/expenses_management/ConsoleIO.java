package com.hal.expenses_management;

import java.util.List;
import java.util.Map;

public interface ConsoleIO {
    String getUserInput();

    void printLine(String line);

    void printLine(Map<String, List<Purchase>> purchaseMap);

//    void printPurchaseMap(Map<String, List<Purchase>> purchaseMap);
}
