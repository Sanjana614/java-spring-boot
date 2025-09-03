package org.example.lld.atmmachine.state;

import org.example.lld.atmmachine.AtmMachine;
import org.example.lld.atmmachine.model.BankService;
import org.example.lld.atmmachine.enums.OperationType;
import org.example.lld.atmmachine.model.Account;

public class AuthenticatedState implements AtmState {

    @Override
    public void insertCard(AtmMachine atmMachine, String cardNumber) {
        System.out.println("Card already inserted!");
    }

    @Override
    public void enterPin(AtmMachine atmMachine, String pin) {
        System.out.println("Already authenticated.");
    }

    @Override
    public void performOperation(AtmMachine atmMachine, OperationType operationType, int... args) {
        BankService bankService = atmMachine.getBankService();
        int balance = bankService.fetchBalance(atmMachine.getCurrentCard());
        switch (operationType) {
            case CHECK_BALANCE:
                System.out.println("Current balance is : " + balance);
                break;
            case WITHDRAW_CASH:
                if (args.length == 0 || args[0] <= 0) {
                    System.out.println("Invalid withdrawal specified amount.");
                    break;
                }
                int withdrawalAmount = args[0];
                if (balance < withdrawalAmount) {
                    System.out.println("Insufficient balance.");
                    break;
                }
                atmMachine.withdrawMoney(withdrawalAmount);
                break;
            case DEPOSIT_CASH:
                if (args.length == 0 || args[0] <= 0) {
                    System.out.println("Invalid deposit specified amount.");
                    break;
                }
                int depositAmount = args[0];
                bankService.depositAmount(atmMachine.getCurrentCard(), depositAmount);
                System.out.println("Amount deposit successful. Current balance is: " + balance);
                break;
            default:
                System.out.println("Invalid operation.");
                break;
        }
        ejectCard(atmMachine);
    }

    @Override
    public void ejectCard(AtmMachine atmMachine) {
        System.out.println("Ejecting Card!");
        atmMachine.reset();
    }
}
