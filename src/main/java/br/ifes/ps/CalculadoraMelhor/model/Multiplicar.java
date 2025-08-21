package br.ifes.ps.CalculadoraMelhor.model;

public class Multiplicar implements Operacao{
    @Override
    public double aplicar(double a, double b) {return a * b;}

    @Override
    public String simboloOperacao(){return "*";}
}
