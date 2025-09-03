package org.example.lld.atmmachine.state;

import org.example.lld.atmmachine.AtmMachine;
import org.example.lld.atmmachine.enums.OperationType;
import org.example.lld.atmmachine.model.Card;

public class HasCardState implements AtmState {

    @Override
    public void insertCard(AtmMachine atmMachine, String cardNumber) {
        System.out.println("Card already inserted.");
    }

    @Override
    public void enterPin(AtmMachine atmMachine, String pin) {
        Card currentCard = atmMachine.getCurrentCard();
        if (!pin.equals(currentCard.getPin())) {
            System.out.println("Wrong pin!");
            return;
        }
        atmMachine.setCurrentState(new AuthenticatedState());
    }

    @Override
    public void performOperation(AtmMachine atmMachine, OperationType operationType, int... args) {
        System.out.println("Please enter pin first.");
    }

    @Override
    public void ejectCard(AtmMachine atmMachine) {
        System.out.println("Ejecting Card!");
        atmMachine.reset();
    }
}
