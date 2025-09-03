package org.example.lld.atmmachine.chainofresponsibility;

import org.example.lld.atmmachine.enums.NoteDenomination;

public class NoteDispenser50 extends NoteDispenser {

    public NoteDispenser50(int noteAvailable) {
        super(NoteDenomination.FIFTY.getValue(), noteAvailable);
    }
}
