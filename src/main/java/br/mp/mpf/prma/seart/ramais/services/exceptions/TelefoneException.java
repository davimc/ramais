package br.mp.mpf.prma.seart.ramais.services.exceptions;

public class TelefoneException extends Exception {
    public TelefoneException(Exception e) throws TelefoneException {
        super(e);
    }
}
