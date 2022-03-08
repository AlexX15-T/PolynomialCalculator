package MVC1;

import MVC1.Polynomial;

public class DivideResult {
    Polynomial q;
    Polynomial rest;

    public DivideResult() {
    }

    public DivideResult(Polynomial q, Polynomial rest) {
        this.q = q;
        this.rest = rest;
    }

    public Polynomial getQ() {
        return q;
    }

    public Polynomial getRest() {
        return rest;
    }
}