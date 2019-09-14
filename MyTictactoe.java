import java.util.Scanner;

public class MyTictactoe{
    private char papanPermainan[][];
    private final int ROW;
    private final int COLUMN;

    private char giliranPemain;

    private enum statusGame{
        WIN,
        DRAW,
        PROCESS
    }

    private static Scanner input = new Scanner(System.in);

    public MyTictactoe(int number){
        ROW = number;
        COLUMN = number;
        papanPermainan = new char[ROW][COLUMN];
        System.out.println("Welcome To Tic Tac Toe Game");
        System.out.println("***************************");  

        do{
            System.out.print("Silakan masukkan 1 untuk memilih karakter xn atau 2"
             + "untuk memilih karakter on kemudian tekan Enter: ");
             int pilihKarakter = input.nextInt();
             if(pilihKarakter == 1){
                 giliranPemain = 'x';
                 System.out.println("Papan telah diinisilisasin"
     + "**************************");
             }else if(pilihKarakter == 2){
                 giliranPemain = 'o';
                 System.out.println("Papan telah diinisilisasin"
     + "**************************");
             } else{
                 System.out.println("Pilihan anda tidak valid!n"
      + "*************************");
             }
        } while (cekPilihKarakter(giliranPemain) == false);
        inisialisasiPapan();
        tampilkanPapan();
    }

     private void inisialisasiPapan(){
         for (int i = 0; i < ROW; i ++){
             for (int k = 0; k < COLUMN; k++) {
                 papanPermainan[i][k] = '?';
            }
         }
         char playerSatu;
         char playerDua;
         if(giliranPemain == 'x'){
            playerSatu = 'x';
            playerDua = 'o';
            System.out.println("PLAYER SATU: " + playerSatu);
            System.out.println("PLAYER DUA: " + playerDua);
         } else if (giliranPemain == 'o') {
            playerSatu = 'o';
            playerDua = 'x';
            System.out.println("PLAYER SATU: " + playerSatu);
            System.out.println("PLAYER DUA: " + playerDua);
        }
     }

     private boolean cekPilihKarakter(char giliranPemain) {
        boolean pilihKarakter = false;
        if (giliranPemain == 'x' || giliranPemain == 'o') {
            pilihKarakter = true;
        } else {
            pilihKarakter = false;
        }
        return pilihKarakter;
    }

    private void tampilkanPapan() {
        System.out.println("=============");
        for (int i = 0; i < ROW; i++) {
            System.out.print("| ");
            for (int j = 0; j < COLUMN; j++) {
                System.out.print(papanPermainan[i][j] + " | ");
            }
            System.out.println();
            System.out.println("=============");
        }
    }

    private void gantiPemain() {
        if (giliranPemain == 'x') {
            giliranPemain = 'o';
        } else {
            giliranPemain = 'x';
        }
    }

    private boolean cekPemenang() {
        return (cekBarisPemenang() || cekKolomPemenang() || cekDiagonalPemenang());
    }

    private boolean cekBarisPemenang() {
        for (int i = 0; i < ROW; i++) {
            if (cekBarisKolom(papanPermainan[i][0], papanPermainan[i][1], papanPermainan[i][2]) == true) {
                return true;
            }
        }
        return false;
    }

    private boolean cekKolomPemenang() {
        for (int i = 0; i < COLUMN; i++) {
            if (cekBarisKolom(papanPermainan[0][i], papanPermainan[1][i], papanPermainan[2][i]) == true) {
                return true;
            }
        }
        return false;
    }

    private boolean cekDiagonalPemenang() {
        return ((cekBarisKolom(papanPermainan[0][0], papanPermainan[1][1], papanPermainan[2][2]) == true)
                || (cekBarisKolom(papanPermainan[0][2], papanPermainan[1][1], papanPermainan[2][0]) == true));
    }

    private boolean cekBarisKolom(char a1, char a2, char a3) {
        return ((a1 != '?') && (a1 == a2) && (a2 == a3));
    }

    private boolean cekDraw() {
        boolean draw = true;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                if (papanPermainan[i][j] == '?') {
                    draw = false;
                }
            }
        }
        return draw;
    }

    private statusGame statusSekarang() {
        if (cekPemenang() == true)
            return statusGame.WIN;
        else if (cekDraw() == true)
            return statusGame.DRAW;
        else
            return statusGame.PROCESS;
    }

    private void tampilkanStatus() {
        statusGame status = statusSekarang();
        if (status == statusGame.WIN)
            System.out.println("PEMAIN " + giliranPemain + " MENANG!!");
        else if (status == statusGame.DRAW)
            System.out.println("PERMAINAN BERAKHIR DRAW!!");
    }

    private void inputKarakter() {

        cekPemenang();
        cekDraw();
        statusSekarang();

        System.out.print("Pemain " + giliranPemain + " silakan pilih baris (0-2): ");
        int row = input.nextInt();
        System.out.print("Pemain " + giliranPemain + " silakan pilih kolom (0-2): ");
        int col = input.nextInt();

        if ((row < 0) || (row > 2))
            System.out.println("Baris tidak valid, coba lagi");
        else if ((col < 0) || (col > 2))
            System.out.println("Kolom tidak valid, coba lagi!");

        else if (papanPermainan[row][col] != '?')
            System.out.println("Area ini sudah terisi, coba lagi!");

        else {
            tandaiPapan(row, col, giliranPemain);
            tampilkanPapan();
            if (statusSekarang() == statusGame.PROCESS) {
                gantiPemain();
            }

        }
    }

    private void tandaiPapan(int baris, int kolom, char c) {
        papanPermainan[baris][kolom] = c;
    }

    public void start(){
      do{
       inputKarakter();
      }while(statusSekarang() == statusGame.PROCESS);
      tampilkanStatus();
     }
}