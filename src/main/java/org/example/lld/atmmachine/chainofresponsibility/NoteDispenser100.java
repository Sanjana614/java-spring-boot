package org.example.lld.atmmachine.chainofresponsibility;

import org.example.lld.atmmachine.enums.NoteDenomination;

public class NoteDispenser100 extends NoteDispenser {

    public NoteDispenser100(int noteAvailable) {
        super(NoteDenomination.HUNDRED.getValue(), noteAvailable);
    }
}
