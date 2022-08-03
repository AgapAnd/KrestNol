package KrestNol;

import java.util.Scanner;

public class KrestNol {
    static String predZnak = " ";
    static int player = 1;
    static String[][] pole = new String[3][3];
    public static void main(String[] args) {
        System.out.println("\n\t\t\t\tGame TIC TAC TOE");
        int index = 0;
        for(int i = 0; i<3; i++) {
            for(int j = 0; j<3; j++) {
                pole[i][j] = "▫";
            }
        }
        vivodPolya(pole);
        hodIgroka(pole);
        vivodPolya(pole);
        while(!Pobeda(pole)) {
            if (player == 1)
                player++;
            else
                player--;
            hodIgroka(pole);
            vivodPolya(pole);
            if (draw()) {
                System.out.println("DRAW!");
                index = 1;
                break;
            }
        }
        if (index==0)
            System.out.println("Winner is player " + player);

    }
    public static String[][] hodIgroka(String[][] pole) {
        while (true) {
            System.out.println("\nPlayer " + player + ", make your move (format: X/O,1..3,1..3)");
            Scanner scan = new Scanner(System.in);
            String[] line = scan.next().split(",");
            int x = Integer.parseInt(line[1]);
            int y = Integer.parseInt(line[2]);
            String znak = line[0];
            if (proverkaVvoda(x,y,znak)) {
                pole[x - 1][y - 1] = znak;
                predZnak = znak;
                break;
            }
        }
        return pole;

    }
    public static boolean proverkaVvoda(int x, int y, String znak) {
        if ((pole[x-1][y-1].equals("X") || pole[x-1][y-1].equals("O"))) {
            System.out.println("This field is already taken, enter another coordinates");
            return false;
        }
        if (znak.equals(predZnak)) {
            System.out.println("Wrong sign, enter another");
            return false;
        }
        if ((znak.equals("X")) || (znak.equals("O"))) {
            return true;
        }
        else {
            System.out.println("Valid signs are only Х and О");
            return false;
        }
    }

    public static void vivodPolya(String[][] pole) {
        System.out.println();
        for(int i = 0; i<3; i++) {
            for(int j = 0; j<3; j++) {
                System.out.print(pole[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean Pobeda(String[][] pole) {
        if
        ((pole[0][0].equals("X") && pole[1][1].equals("X") && pole[2][2].equals("X") ||
                pole[0][0].equals("X") && pole[0][1].equals("X") && pole[0][2].equals("X") ||
                pole[0][0].equals("X") && pole[1][0].equals("X") && pole[2][0].equals("X") ||
                pole[0][1].equals("X") && pole[1][1].equals("X") && pole[2][1].equals("X") ||
                pole[0][2].equals("X") && pole[1][2].equals("X") && pole[2][2].equals("X") ||
                pole[1][0].equals("X") && pole[1][1].equals("X") && pole[1][2].equals("X") ||
                pole[2][0].equals("X") && pole[2][1].equals("X") && pole[2][2].equals("X") ||
                pole[0][2].equals("X") && pole[1][1].equals("X") && pole[2][0].equals("X")) ||
        (pole[0][0].equals("O") && pole[0][1].equals("O") && pole[0][2].equals("O") ||
                pole[0][0].equals("O") && pole[1][0].equals("O") && pole[2][0].equals("O") ||
                pole[0][1].equals("O") && pole[1][1].equals("O") && pole[2][1].equals("O") ||
                pole[0][2].equals("O") && pole[1][2].equals("O") && pole[2][2].equals("O") ||
                pole[1][0].equals("O") && pole[1][1].equals("O") && pole[1][2].equals("O") ||
                pole[2][0].equals("O") && pole[2][1].equals("O") && pole[2][2].equals("O") ||
                pole[0][2].equals("O") && pole[1][1].equals("O") && pole[2][0].equals("O")))
            return true;
        else
            return false;
    }
    public static boolean draw() {
        int index = 0;
        for(int i = 0; i<3; i++) {
            for(int j = 0; j<3; j++) {
                if (pole[i][j].equals("▫"))
                    index++;
            }
        }
        if (index>0)
            return false;
        else
            return true;
    }
}
