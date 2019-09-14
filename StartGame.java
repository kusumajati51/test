import java.util.Scanner;

public class StartGame{
    private static Scanner put = new Scanner(System.in);

    public static void main(String[] args){
        System.out.print("Silahkan masukan angka anda: ");
        int angka  = put.nextInt();
        if (angka < 3) {
            System.out.print("Angka Anda kurang dari 3");
        } else {
            MyTictactoe tictactoe = new MyTictactoe(angka);
            tictactoe.start();
        }
    }
}