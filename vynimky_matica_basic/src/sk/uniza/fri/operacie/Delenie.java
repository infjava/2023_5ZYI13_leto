package sk.uniza.fri.operacie;

import sk.uniza.fri.vynimky.DelenieNulouException;

public class Delenie implements Operacia {
    @Override
    public double vykonaj(double operand1, double operand2) throws DelenieNulouException {
        if (operand2 == 0) {
            throw new DelenieNulouException();
        }
        return operand1 / operand2;
    }
}
