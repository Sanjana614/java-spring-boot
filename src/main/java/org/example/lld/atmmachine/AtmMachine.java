package org.example.lld.atmmachine;

import org.example.lld.atmmachine.chainofresponsibility.NoteDispenser;
import org.example.lld.atmmachine.chainofresponsibility.NoteDispenser20;
import org.example.lld.atmmachine.chainofresponsibility.NoteDispenser50;
import org.example.lld.atmmachine.chainofresponsibility.NoteDispenser100;
import org.example.lld.atmmachine.enums.OperationType;
import org.example.lld.atmmachine.model.BankService;
import org.example.lld.atmmachine.model.Card;
import org.example.lld.atmmachine.model.CashDispensingProcessor;
import org.example.lld.atmmachine.state.AtmState;
import org.example.lld.atmmachine.state.ReadyState;

import java.util.Objects;

public class AtmMachine {
    private static volatile AtmMachine instance;
    private final BankService bankService;
    private final CashDispensingProcessor cashDispensingProcessor;
    private AtmState currentState;
    private Card currentCard;


    private AtmMachine() {
        this.currentState = new ReadyState();
        this.bankService = new BankService();
        NoteDispenser100 noteDispenser100 = getNoteDispenser100();
        this.cashDispensingProcessor = new CashDispensingProcessor(noteDispenser100);
    }

    private static NoteDispenser100 getNoteDispenser100() {
        NoteDispenser100 noteDispenser100 = new NoteDispenser100(10);
        NoteDispenser50 noteDispenser50 = new NoteDispenser50(20);
        NoteDispenser20 noteDispenser20 = new NoteDispenser20(30);
        noteDispenser100.setNext(noteDispenser50);
        noteDispenser50.setNext(noteDispenser20);
        return noteDispenser100;
    }

    public static AtmMachine getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (AtmMachine.class) {
                if (Objects.isNull(instance)) {
                    instance = new AtmMachine();
                }
            }
        }
        return instance;
    }

    public void insertCard(String cardNumber) {
        currentState.insertCard(this, cardNumber);
    }

    public void enterPin(String pin) {
        currentState.enterPin(this, pin);
    }

    public void performOperation(OperationType operationType, int... args) {
        currentState.performOperation(this, operationType, args);
    }

    public void withdrawMoney(int amount) {
        if (amount % 10 != 0) {
            System.out.println("Invalid amount. Note of available denomination not present.");
            return;
        }
        NoteDispenser noteDispenser = cashDispensingProcessor.getNoteDispenser();
        if (!noteDispenser.canDispense(amount)) {
            System.out.println("Insufficient cash available in ATM.");
            return;
        }
        boolean withdrawalSuccess = bankService.withdrawAmount(currentCard, amount);
        if (!withdrawalSuccess) {
            System.out.println("Some error occurred while withdrawal");
            return;
        }
        noteDispenser.dispense(amount);
    }

    public void reset() {
        this.currentState = new ReadyState();
        this.currentCard = null;
    }

    public BankService getBankService() {
        return bankService;
    }

    public AtmState getCurrentState() {
        return currentState;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public void setCurrentState(AtmState currentState) {
        this.currentState = currentState;
    }

    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }
}
