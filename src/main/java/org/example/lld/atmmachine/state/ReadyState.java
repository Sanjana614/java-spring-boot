package org.example.lld.atmmachine.state;

import org.example.lld.atmmachine.AtmMachine;
import org.example.lld.atmmachine.enums.OperationType;
import org.example.lld.atmmachine.model.Card;

public class ReadyState implements AtmState {

    @Override
    public void insertCard(AtmMachine atmMachine, String cardNumber) {
        Card card = atmMachine.getBankService().fetchCard(cardNumber);
        atmMachine.setCurrentCard(card);
        atmMachine.setCurrentState(new HasCardState());
    }

    @Override
    public void enterPin(AtmMachine atmMachine, String pin) {
        System.out.println("Please insert card first.");
    }

    @Override
    public void performOperation(AtmMachine atmMachine, OperationType operationType, int... args) {
        System.out.println("Please insert card first.");
    }

    @Override
    public void ejectCard(AtmMachine atmMachine) {
        System.out.println("Please insert card first.");
    }
}
