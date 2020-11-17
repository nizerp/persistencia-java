import java.io.IOException;

public class Teste {

    public static void main(String[] args) {
        int a = 0;
        int b = 10;

        System.out.println("Iniciando calculo...");
        calcular(a, b);
        System.out.println("Fim do programa!");
    }

    public static void calcular(int a, int b) {
        try {
            calcular2(a, b);
        } catch (IOException e) {
            //
        }
    }

    public static void calcular2(int a, int b) throws IOException {
        try {
            int result = b / a;        
            System.out.println("O resultado é: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Erro ao executar o calculo");
        }
    }
}
