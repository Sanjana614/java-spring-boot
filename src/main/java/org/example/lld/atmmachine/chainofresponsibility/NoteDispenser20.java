package org.example.lld.atmmachine.chainofresponsibility;

import org.example.lld.atmmachine.enums.NoteDenomination;

public class NoteDispenser20 extends NoteDispenser {

    public NoteDispenser20(int noteAvailable) {
        super(NoteDenomination.TWENTY.getValue(), noteAvailable);
    }
}
