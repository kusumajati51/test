import java.util.Scanner;

class StartGame {
  private static Scanner put = new Scanner(System.in);
  public static void main(String[] args) {
      justPlay();
  }

 static void justPlay(){
  System.out.print("how many box you want to play: ");
    int angka  = put.nextInt();
    if(angka < 3){
      System.out.print("Your number is lees than 3 \n ");
      justPlay();
    }else{
      MyTictactoe tictactoe = new MyTictactoe(angka);
      tictactoe.start();  
    }
  }
}