import java.util.Scanner;

public class StartGame{
    private static Scanner put = new Scanner(System.in);

    public static void main(String[] args){
        System.out.print("Silahkan masukan angka anda");
        int angka  = put.nextInt();
        MyTictactoe tictactoe = new MyTictactoe(angka);
        tictactoe.start();
    }
}