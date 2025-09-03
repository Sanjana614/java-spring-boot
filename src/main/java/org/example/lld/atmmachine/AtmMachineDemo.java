package org.example.lld.atmmachine;

import org.example.lld.atmmachine.enums.OperationType;

public class AtmMachineDemo {
    public static void main(String[] args) {
        AtmMachine atmSystem = AtmMachine.getInstance();

        // Perform Check Balance operation
        atmSystem.insertCard("1234-5678-9012-3456");
        atmSystem.enterPin("1234");
        atmSystem.performOperation(OperationType.CHECK_BALANCE); // $1000
        System.out.println("================================================");

        // Perform Withdraw Cash operation
        atmSystem.insertCard("1234-5678-9012-3456");
        atmSystem.enterPin("1234");
        atmSystem.performOperation(OperationType.WITHDRAW_CASH, 570);
        System.out.println("================================================");


        // Perform Deposit Cash operation
        atmSystem.insertCard("1234-5678-9012-3456");
        atmSystem.enterPin("1234");
        atmSystem.performOperation(OperationType.DEPOSIT_CASH, 200);
        System.out.println("================================================");


        // Perform Check Balance operation
        atmSystem.insertCard("1234-5678-9012-3456");
        atmSystem.enterPin("1234");
        atmSystem.performOperation(OperationType.CHECK_BALANCE); // $630
        System.out.println("================================================");

        // Perform Withdraw Cash more than balance
        atmSystem.insertCard("1234-5678-9012-3456");
        atmSystem.enterPin("1234");
        atmSystem.performOperation(OperationType.WITHDRAW_CASH, 700); // Insufficient balance
        System.out.println("================================================");

        // Insert Incorrect PIN
        atmSystem.insertCard("1234-5678-9012-3456");
        atmSystem.enterPin("3425");
        System.out.println("================================================");

    }
}
