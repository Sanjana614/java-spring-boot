package org.example.lld.atmmachine.state;

import org.example.lld.atmmachine.AtmMachine;
import org.example.lld.atmmachine.enums.OperationType;

public interface AtmState {
    void insertCard(AtmMachine atmMachine, String cardNumber);
    void enterPin(AtmMachine atmMachine, String pin);
    void performOperation(AtmMachine atmMachine, OperationType operationType, int... args);
    void ejectCard(AtmMachine atmMachine);
}
