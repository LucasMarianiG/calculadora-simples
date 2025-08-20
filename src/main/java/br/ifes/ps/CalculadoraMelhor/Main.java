package br.ifes.ps.CalculadoraMelhor;

import br.ifes.ps.CalculadoraMelhor.view.Menu;

public class Main{
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.mostrarCabecalho();

        while (true) {
            String entrada;
            double primeiroNumero, segundoNumero;

            //primeiro numero
            entrada = menu.pedirPrimeiroNum();
            if (menu.isSair(entrada)) break;
            try {
                primeiroNumero = Double.parseDouble(entrada);
            }catch (NumberFormatException e){
                menu.erroNumInvalido();
                continue;
            }

            //Operador
            entrada = menu.pedirOperador();
            if (menu.isSair(entrada)) break;
            String operacao = entrada;
            try {
                if (!(operacao.equals("+") || operacao.equals("-")
                        || operacao.equals("*") || operacao.equals("/"))) {
                    throw new IllegalArgumentException();
                }
            }catch (IllegalArgumentException e){
                menu.erroOpInvalida();
                continue;
            }

            //Segundo numero
            entrada = menu.pedirSegundoNum();
            if(menu.isSair(entrada)) break;
            try {
                segundoNumero = Double.parseDouble(entrada);
            }catch (NumberFormatException e){
                menu.erroNumInvalido();
                continue;
            }


            double resultado;

            switch (operacao) {
                case "+":
                    resultado = primeiroNumero + segundoNumero;
                    menu.mostrarResultado(primeiroNumero,operacao,segundoNumero, resultado);
                    break;

                case "-":
                    resultado = primeiroNumero - segundoNumero;
                    menu.mostrarResultado(primeiroNumero,operacao,segundoNumero, resultado);
                    break;

                case "*":
                    resultado = primeiroNumero * segundoNumero;
                    menu.mostrarResultado(primeiroNumero,operacao,segundoNumero, resultado);
                    break;

                case "/":
                    if (segundoNumero == 0) {
                        menu.erroDivzero();
                    } else {
                        resultado = primeiroNumero / segundoNumero;
                        menu.mostrarResultado(primeiroNumero,operacao,segundoNumero, resultado);
                    }
                    break;

            }

        }
        menu.mostrarEncerramento();
        menu.fechar();
    }
}