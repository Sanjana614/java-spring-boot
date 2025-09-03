package org.example.lld.atmmachine.chainofresponsibility;

import java.util.Objects;

public abstract class NoteDispenser implements Dispenser {
    protected Dispenser next;
    protected int noteValue;
    protected int noteAvailable;

    public NoteDispenser(int noteValue, int noteAvailable) {
        this.noteValue = noteValue;
        this.noteAvailable = noteAvailable;
    }

    public void dispense(int amount) {
        int noteToDispense = Math.min((amount / noteValue), noteAvailable);
        noteAvailable -= noteToDispense;
        int remainingAmount = amount - (noteToDispense * noteValue);
        System.out.println("Dispensed Note of value: " + noteValue + " | Qty: " + noteToDispense);
        if (remainingAmount > 0 && Objects.nonNull(next)) {
            next.dispense(remainingAmount);
        }
    }

    public final boolean canDispense(int amount) {
        if (amount == 0) {
            return true;
        }
        if (noteAvailable == 0 || amount % 10 != 0) {
            return false;
        }
        if (amount < noteValue) {
            return Objects.nonNull(next) && next.canDispense(amount);
        }
        int noteToDispense = Math.min((amount / noteValue), noteAvailable);
        int remainingAmount = amount - (noteToDispense * noteValue);
        if (remainingAmount == 0) {
            return true;
        }
        return Objects.nonNull(next) && next.canDispense(remainingAmount);
    }

    public int getNoteValue() {
        return this.noteValue;
    }

    public int getNoteAvailable() {
        return this.noteAvailable;
    }

    @Override
    public void setNext(Dispenser dispenser) {
        this.next = dispenser;
    }
}
