import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Calculadora Simples ===");
        System.out.println("Digite 'sair' caso deseje encerrar o programa.");


        while (true) {
            String entrada;
            double primeiroNumero, segundoNumero;

            //selecionando o primeiro número e checando se é valido
            System.out.println("\nDigite um número: ");
            entrada = sc.next();
            if (entrada.equalsIgnoreCase("sair")) break;
            try {
                primeiroNumero = Double.parseDouble(entrada);
            }catch (NumberFormatException e) {
                System.out.println("Número inválido, tente novamente.");
                continue;
            }

            //selecionando a operação e checando se ela é válida.
            System.out.println("Digite a operação: ( +, -, *, / )");
            entrada = sc.next();
            if (entrada.equalsIgnoreCase("sair")) break;
            String operacao = entrada;
            try {
                if (!(operacao.equals("+") || operacao.equals("-")
                        || operacao.equals("*") || operacao.equals("/"))) {
                    throw new IllegalArgumentException("Operação inválida. Use apenas +, -, * ou /.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            //selecionando o segundo número e checando se é valido
            System.out.println("Digite outro número: ");
            entrada = sc.next();
            if (entrada.equalsIgnoreCase("sair")) break;
            try {
                segundoNumero = Double.parseDouble(entrada);
            }catch (NumberFormatException e){
                System.out.println("Número inválido, tente novamente.");
                continue;
            }

            double resultado;

            switch (operacao) {
                case "+":
                    resultado = primeiroNumero + segundoNumero;
                    System.out.println("A soma de " + primeiroNumero + " + " + segundoNumero + " é igual a: " + resultado);
                    break;

                case "-":
                    resultado = primeiroNumero - segundoNumero;
                    System.out.println("A subtração de  " + primeiroNumero + " - " + segundoNumero + " é igual a: " + resultado);
                    break;

                case "*":
                    resultado = primeiroNumero * segundoNumero;
                    System.out.println("A multiplicação de  " + primeiroNumero + " * " + segundoNumero + " é igual a: " + resultado);
                    break;

                case "/":
                    if (segundoNumero == 0) {
                        System.out.println("Erro: divisão por zero não é permitida!");
                    } else {
                        resultado = primeiroNumero / segundoNumero;
                        System.out.println("A divisão de  " + primeiroNumero + " / " + segundoNumero + " é igual a: " + resultado);
                    }
                    break;
                default:
                    System.out.println("Operação inválida. Use +, -, * ou /. ");
            }

        }
        System.out.println("\nEncerrando a calculadora. Até mais!");
        sc.close();
    }
}