package br.ifes.ps.CalculadoraMelhor.model;

public class Calculadora {

    // Instâncias únicas (sem coleções, sem Map)
    private static final Somar SOMAR = new Somar();
    private static final Subtrair SUBTRAIR = new Subtrair();
    private static final Multiplicar MULTIPLICAR = new Multiplicar();
    private static final Dividir DIVIDIR = new Dividir();

    public Operacao resolverOperacao(String simbolo) {
        if (simbolo == null) return null;
        switch (simbolo) {
            case "+": return SOMAR;
            case "-": return SUBTRAIR;
            case "*": return MULTIPLICAR;
            case "/": return DIVIDIR;
            default:  return null; // operação inválida
        }
    }

    public double calcular(Operacao op, double a, double b) {
        return op.aplicar(a, b);
    }
}
