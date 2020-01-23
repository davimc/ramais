package br.mp.mpf.prma.seart.ramais.services.exceptions;

public class ContatoException extends Exception {
    public ContatoException(Exception e) throws ContatoException{
        super(e);
    }
}
