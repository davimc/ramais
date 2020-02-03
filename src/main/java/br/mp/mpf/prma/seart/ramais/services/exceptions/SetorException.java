package br.mp.mpf.prma.seart.ramais.services.exceptions;

public class SetorException extends Exception {
    public SetorException(Exception e) throws SetorException {
        super(e);
    }
}
