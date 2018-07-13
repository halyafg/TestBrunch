package com.hal.expenses_management;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FakeIO implements ConsoleIO {
    private int lineIndex = 0;
    private final String[] lines;

    // This is public so the test can inspect it easily
    public final List<String> output = new ArrayList<String>();

    // lines are what will pretend to be coming from System.in
    public FakeIO( String... lines) {
        this.lines = lines;
    }

    @Override
    public String getUserInput() {
        // return the next line that was passed in
        return lines[lineIndex++];
    }

    @Override
    public void printLine(String line) {
        // the SUT calls this, and we just record it for later inspection
        output.add(line);
    }

    @Override
    public void printLine(Map<String, List<Purchase>> purchaseMap) {
        output.add(purchaseMap.toString());
    }
}
