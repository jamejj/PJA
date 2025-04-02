package GUI.GUI05;

public class Rekurencje {
    public static void main(String[] args) {

        System.out.println(silniaRek(10));
        System.out.println(sumaRek(4));
        trojkatPascala(5);

    }

    public static int silniaRek(int n){
        if(n == 0)
            return 1;
        return n * silniaRek(n - 1);
    }

    public static int sumaRek(int n){
        if(n == 0)
            return 0;
        return n + sumaRek(n - 1);
    }

    public static int pascalRek(int n, int k){
            if (k == 0 || k == n) 
                return 1;

            return pascalRek(n - 1, k-1) + pascalRek(n - 1, k );
        }

    public static void trojkatPascala(int wysokosc) {
        for (int i = 0; i < wysokosc; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(pascalRek(i, j) + " ");
            }
            System.out.println();
        }


        }
    }

