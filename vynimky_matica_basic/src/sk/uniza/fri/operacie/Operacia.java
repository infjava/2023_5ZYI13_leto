package sk.uniza.fri.operacie;

import sk.uniza.fri.vynimky.DelenieNulouException;

public interface Operacia {
    double vykonaj(double operand1, double operand2) throws DelenieNulouException;
}
