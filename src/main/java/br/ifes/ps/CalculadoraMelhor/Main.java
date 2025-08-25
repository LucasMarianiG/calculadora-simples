package br.ifes.ps.CalculadoraMelhor;

import br.ifes.ps.CalculadoraMelhor.controller.ControllerCalc;
import br.ifes.ps.CalculadoraMelhor.model.Calculadora;
import br.ifes.ps.CalculadoraMelhor.view.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Calculadora calc = new Calculadora();
        ControllerCalc controller = new ControllerCalc(menu, calc);
        controller.executar();
    }
}
