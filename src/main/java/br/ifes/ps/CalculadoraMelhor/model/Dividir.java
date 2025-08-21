package br.ifes.ps.CalculadoraMelhor.model;

public class Dividir implements Operacao{
    @Override
    public double aplicar(double a, double b) {
        if(b == 0) throw new ArithmeticException("Divisão por zero");
        return a/b;
    }

    public String simboloOperacao() {return "/";}

}
