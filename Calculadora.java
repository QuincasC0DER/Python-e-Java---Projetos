public class Calculadora {
    public static double sqrt(double valor) {
        return Math.sqrt(valor);
    }

    public static double log(double valor) {
        return Math.log(valor);
    }

    public static void main(String[] args) {
        int x = 25;
        int y = 100;

        double raiz = Calculadora.sqrt(x);
        double logaritmo = Calculadora.log(y);

        System.out.printf("Raiz quadrada de %d: %f \n", x, raiz);
        System.out.printf("Logaritmo de %d: %f \n", y, logaritmo);
    }
}

