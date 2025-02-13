package org.wcl.mfn.ui.controller.forms.contractcalculator;

public record RequestedRemunerationForm(int salary, int bonus, SalaryEscalatorForm escalator) {
}