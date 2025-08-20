package br.ifes.ps.CalculadoraMelhor.view;

import java.util.Scanner;

public class Menu {
        private final Scanner sc = new Scanner(System.in);

        public void mostrarCabecalho(){
            System.out.println("=== Calculadora Simples ===");
            System.out.println("Digite 'sair' caso deseje encerrar o programa.");
        }

        public void mostrarEncerramento(){
            System.out.println("\nEncerrando a calculadora. Até mais!");
        }

        public String pedirPrimeiroNum(){
            System.out.println("\nDigite um número: ");
            return sc.next();
        }
        public String pedirOperador(){
            System.out.println("Digite a operação: ( +, -, *, / )");
            return sc.next();
        }

        public String pedirSegundoNum(){
            System.out.println("Digite outro número: ");
            return sc.next();
        }

        public void erroNumInvalido(){
            System.out.println("Número inválido, tente novamente.");
        }

        public void erroOpInvalida(){
            System.out.println("ERRO: Operação Inválida");
        }

        public void erroDivzero(){
            System.out.println("Erro: divisão por zero não é permitida!");
        }

        public void mostrarResultado(double a, String op, double b, double resultado) {
            System.out.println("Resultado: " + a + " " + op + " " + b + " = " + resultado);
        }

        // Utilitários
        public boolean isSair(String entrada) {
            return "sair".equalsIgnoreCase(entrada);
        }

        public void fechar() {
            sc.close();
        }


}
