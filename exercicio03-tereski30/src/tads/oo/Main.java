package tads.oo;

public class Main {

    public static int metodo2(int x){
        return x-1;
    }


    public static void metodo1(int x){
        int y=0;

        y=metodo2(x)+1;

        System.out.println("Valor de y="+y);
    }

    public static void main(String[] args) {
	// write your code here

        System.out.println("Hello world!!");

        metodo1(10);

        System.out.println("Fim...");

    }
}
