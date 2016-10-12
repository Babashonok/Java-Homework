package bsu.tat.products;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * class that creates list of commands
 * and use methods to operate with these commands
 */
public class CommandList {

    private ArrayList<ParentCommand> commandsList = new ArrayList<>();

    /**
     * add command to the list of inheritors to ParentCommand
     * @param command
     * @return
     */
    public CommandList add(ParentCommand command) {
        commandsList.add(command);
        return this;
    }

    /**
     * ask user about another input
     * @return
     */
    public boolean waitForNewCommand() {
        System.out.println("enter Y if you want to continue input commands ");
        Scanner var = new Scanner(System.in);
        return (var.nextLine().equalsIgnoreCase("y"));
    }

    /**
     * check equality between the input string and the command name
     * and perform similar command
     * @param inputString
     * @param product
     */
    public void performCommandCall(String inputString,ProductData [] product) {
        boolean rightInput = false;
        for (ParentCommand command : commandsList) {
            if (command.isCalling(inputString)) {
                command.pefrormOperation(product);
                rightInput = true;
            }
        }
        if(!rightInput) {
            System.out.println("try to input valid commands");
        }
    }
}
