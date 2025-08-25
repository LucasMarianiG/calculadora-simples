package br.ifes.ps.CalculadoraMelhor.controller;

import br.ifes.ps.CalculadoraMelhor.model.Calculadora;
import br.ifes.ps.CalculadoraMelhor.model.Operacao;
import br.ifes.ps.CalculadoraMelhor.view.Menu;

public class ControllerCalc {
    private final Menu menu;
    private final Calculadora calc;

    public ControllerCalc(Menu menu, Calculadora calc) {
        this.menu = menu;
        this.calc = calc;
    }

    public void executar() {
        menu.mostrarCabecalho();

        while (true) {
            //primeiro número
            String entrada = menu.pedirPrimeiroNum();
            if (menu.isSair(entrada)) break;
            Double a = parseNumero(entrada);
            if (a == null) { menu.erroNumInvalido(); continue; }

            //operação
            entrada = menu.pedirOperador(); // certifique-se que este nome existe na sua Menu
            if (menu.isSair(entrada)) break;
            Operacao op = calc.resolverOperacao(entrada);
            if (op == null) { menu.erroOpInvalida(); continue; }

            //segundo número
            entrada = menu.pedirSegundoNum();
            if (menu.isSair(entrada)) break;
            Double b = parseNumero(entrada);
            if (b == null) { menu.erroNumInvalido(); continue; }

            //calculo
            try {
                double r = calc.calcular(op, a, b);
                menu.mostrarResultado(a, op.simboloOperacao(), b, r);
            } catch (ArithmeticException e) {
                menu.erroDivzero();
            }
        }

        menu.mostrarEncerramento();
        menu.fechar();
    }
    private Double parseNumero(String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
