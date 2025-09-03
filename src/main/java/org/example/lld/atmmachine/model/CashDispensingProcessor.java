package org.example.lld.atmmachine.model;

import org.example.lld.atmmachine.chainofresponsibility.NoteDispenser;

public class CashDispensingProcessor {
    private final NoteDispenser noteDispenser;

    public CashDispensingProcessor(NoteDispenser noteDispenser) {
        this.noteDispenser = noteDispenser;
    }

    public NoteDispenser getNoteDispenser() {
        return noteDispenser;
    }
}
