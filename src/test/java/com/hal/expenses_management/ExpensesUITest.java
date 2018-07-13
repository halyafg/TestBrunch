package com.hal.expenses_management;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ExpensesUITest {

    @Test
//    @Ignore
    public void checkWrongCommandFromUser() {

        String message1 = "add 2017-04-25 2 USD Jogurt";
        String message2 = "add 2017-04-25 3 EUR “French fries”";
        String message3 = "add 2017-04-27 4.75 EUR Beer";
        String[] message4 = "add 2017-04-26 2.5 PLN Sweets".split(" ");
        String[] message5 = "list".split(" ");
        String[] message6 = "clear 2017-04-27".split(" ");
        String[] message7 = "total EUR".split(" ");
        String message8 = "exit";

        FakeIO fakeIO = new FakeIO(message1, message2, message3, message8);
        ExpensesUI ui = new ExpensesUI(fakeIO, new Expenses());
        ui.start();

        assertEquals(9, fakeIO.output.size());

        assertEquals(fakeIO.output.get(7), "\nAvailable commands: " + Arrays.toString(Commands.values()) + "\n>>  ");
        assertEquals(fakeIO.output.get(8), "Bye!");


//        String message1 = "add 2017-04-25 2 USD Jogurt";
//
//        FakeIO fakeIO = new FakeIO(message1);
//        ExpensesUI ui = new ExpensesUI(fakeIO, new Expenses());
//        ui.start();
//
//        assertEquals(3, fakeIO.output.size());



//        String expectedFirstLine = "I will guess your age";
//        String expectedSecondLine = String.format("Are you %d years old? ", expenses.getPurchaseMap());
//        String expectedThirdLine = "Hooray! I only needed 0 hints";
//
//        assertTrue("first message wasn't instructions",
//                io.output.get(0).contains(expectedFirstLine));
//
//        assertTrue("second message doesn't contain the guess",
//                io.output.get(1).contains(expectedSecondLine));
//
//        assertTrue("third message doesn't contain a count of guesses",
//                io.output.get(2).contains(expectedThirdLine));
    }

    @Test
    public void testRunApplicationUntilExit(){

        String message1 = "add 2017-04-25 2 USD Jogurt";
        String message2 = "add 2017-04-25 3 EUR “French fries”";
        String message3 = "add 2017-04-27 4.75 EUR Beer";
        String[] message4 = "add 2017-04-26 2.5 PLN Sweets".split(" ");
        String[] message5 = "list".split(" ");
        String[] message6 = "clear 2017-04-27".split(" ");
        String[] message7 = "total EUR".split(" ");
        String message8 = "exit";

        FakeIO fakeIO = new FakeIO(message1, message2, message3, message8);
        ExpensesUI ui = new ExpensesUI(fakeIO, new Expenses());
        ui.start();

        assertEquals(9, fakeIO.output.size());

        assertEquals(fakeIO.output.get(7), "\nAvailable commands: " + Arrays.toString(Commands.values()) + "\n>>  ");
        assertEquals(fakeIO.output.get(8), "Bye!");

    }

}