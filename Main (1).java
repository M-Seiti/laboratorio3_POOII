interface CalculadoraDecimal {
    int somar(int a, int b);
    int subtrair(int a, int b);
    int multiplicar(int a, int b);
}

class CalculadoraBinaria {
    public String somar(String a, String b) {
        int num1 = Integer.parseInt(a, 2);
        int num2 = Integer.parseInt(b, 2);
        int soma = num1 + num2;
        return Integer.toBinaryString(soma);
    }

    public String subtrair(String a, String b) {
        int num1 = Integer.parseInt(a, 2);
        int num2 = Integer.parseInt(b, 2);
        int diferenca = num1 - num2;
        return Integer.toBinaryString(diferenca);
    }
}

class CalculadoraAdapter implements CalculadoraDecimal {
    private CalculadoraBinaria calculadoraBinaria;

    public CalculadoraAdapter(CalculadoraBinaria calculadoraBinaria) {
        this.calculadoraBinaria = calculadoraBinaria;
    }

    @Override
    public int somar(int a, int b) {
        String binA = Integer.toBinaryString(a);
        String binB = Integer.toBinaryString(b);
        String resultadoBinario = calculadoraBinaria.somar(binA, binB);
        return Integer.parseInt(resultadoBinario, 2);
    }

    @Override
    public int subtrair(int a, int b) {
        String binA = Integer.toBinaryString(a);
        String binB = Integer.toBinaryString(b);
        String resultadoBinario = calculadoraBinaria.subtrair(binA, binB);
        return Integer.parseInt(resultadoBinario, 2);
    }

    @Override
    public int multiplicar(int a, int b) {
        return a * b;
    }
}

public class Main {
    public static void main(String[] args) {
        CalculadoraBinaria calculadoraBinaria = new CalculadoraBinaria();
        CalculadoraDecimal calculadora = new CalculadoraAdapter(calculadoraBinaria);

        int a = 10;
        int b = 5;

        System.out.println("Operações com a Calculadora Adaptada:");
        System.out.println("Somar " + a + " + " + b + " = " + calculadora.somar(a, b));
        System.out.println("Subtrair " + a + " - " + b + " = " + calculadora.subtrair(a, b));
        System.out.println("Multiplicar " + a + " * " + b + " = " + calculadora.multiplicar(a, b));
    }
}
