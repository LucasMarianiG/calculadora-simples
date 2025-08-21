package br.ifes.ps.CalculadoraMelhor.model;

public interface Operacao {
    double aplicar(double a, double b);
    String simboloOperacao();
}
