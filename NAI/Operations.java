public class Operations {

    public static void plus(int[] arg1,int[] arg2){
        if (arg1.length != arg2.length)
            throw new IndexOutOfBoundsException("Różne rozmiary");

        int[] tab = new int[arg1.length];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = arg1[i] + arg2[i];
            System.out.print(tab[i] + " ");
        }
    }

    public static void minus(int[] arg1,int[] arg2){
        if (arg1.length != arg2.length)
            throw new IndexOutOfBoundsException("Różne rozmiary");

        int[] tab = new int[arg1.length];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = arg1[i] - arg2[i];
            System.out.print(tab[i] + " ");
        }
    }

    public void multiplyConst(int[] arg1,int constans){
        int[] tab = new int[arg1.length];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = arg1[i] * constans;
            System.out.print(tab[i] + " ");
        }
    }

    public void multiplyScalar(int[] arg1,int[] arg2){
        if(arg1.length != arg2.length)
            throw new ArrayIndexOutOfBoundsException("Różne rozmiary");

        int[] tab = new int[arg1.length];
        int sum = 0;
        System.out.println("Dodajemy do siebie");
        for (int i = 0; i < tab.length; i++) {
            tab[i] += arg1[i] * arg2[i];
            sum += tab[i];
            System.out.print(tab[i] + " ");
        }
        System.out.println();
        System.out.println("I otrzymujemy skalar "+ sum );
    }

    public void multiplyMatrix(int[] arg1,int[] arg2) {
        if (arg1.length != arg2.length)
            throw new ArrayIndexOutOfBoundsException("Różne rozmiary");

        int[][] wynik = new int[arg1.length][arg2.length];

        for (int i = 0; i < arg1.length; i++) { 
            for (int j = 0; j < arg2.length; j++) { 
                wynik[i][j] = arg1[i] * arg2[j]; 
            }
        }
        System.out.println("Macierz wynikowa:");
        for (int[] row : wynik) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public void transpose2(int[] arg1){
        int[][] transposed = new int[arg1.length][1];
        for (int i = 0; i < arg1.length; i++) {
            transposed[i][0] = arg1[i];
            System.out.println(transposed[i][0]);
        }

    }
}