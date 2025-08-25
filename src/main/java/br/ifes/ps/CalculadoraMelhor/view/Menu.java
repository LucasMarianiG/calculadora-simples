package br.ifes.ps.CalculadoraMelhor.view;

import br.ifes.ps.CalculadoraMelhor.model.Operacao;
import org.reflections.Reflections;
import java.util.Set;

import java.util.Scanner;

public class Menu {
    private final Scanner sc = new Scanner(System.in);

    public void mostrarCabecalho(){
        System.out.println("=== Calculadora Simples ===");
        System.out.println("Digite 'sair' caso deseje encerrar o programa.");
        listarOperacoesDetectadas();         // mostra operações encontradas
    }

    public void mostrarEncerramento(){
        System.out.println("\nEncerrando a calculadora. Até mais!");
    }

    // ---------- Reflection para descobrir operações ----------
    private void listarOperacoesDetectadas() {
        // Varre o pacote onde estão Somar/Subtrair/Multiplicar/Dividir
        Reflections reflections = new Reflections("br.ifes.ps.CalculadoraMelhor.model");

        Set<Class<? extends Operacao>> tipos = reflections.getSubTypesOf(Operacao.class);

        if (tipos.isEmpty()) {
            System.out.println("(Nenhuma operação encontrada via reflection)\n");
            return;
        }

        System.out.println("Operações disponíveis:");
        for (Class<? extends Operacao> clazz : tipos) {
            try {
                Operacao op = clazz.getDeclaredConstructor().newInstance();
                System.out.println(" - " + clazz.getSimpleName() + " (símbolo: " + op.simboloOperacao() + " )");
            } catch (Exception e) {
                System.out.println(" - " + clazz.getSimpleName() + " (erro ao instanciar)");
            }
        }
        System.out.println();
    }
    // ---------------------------------------------------------------

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

    public void erroNumInvalido(){ System.out.println("Número inválido, tente novamente."); }
    public void erroOpInvalida(){ System.out.println("ERRO: Operação Inválida"); }
    public void erroDivzero(){ System.out.println("Erro: divisão por zero não é permitida!"); }

    public void mostrarResultado(double a, String op, double b, double resultado) {
        System.out.println("Resultado: " + a + " " + op + " " + b + " = " + resultado);
    }

    public boolean isSair(String entrada) { return "sair".equalsIgnoreCase(entrada); }
    public void fechar() { sc.close(); }
}
