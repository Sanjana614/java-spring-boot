package org.example.lld.atmmachine.chainofresponsibility;

public interface Dispenser {
    void dispense(int amount);
    boolean canDispense(int amount);
    void setNext(Dispenser dispenser);
}
