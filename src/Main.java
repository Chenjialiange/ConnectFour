import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] gameboard = new char[7][6];
        Boolean Xturn = true;
        Boolean win = false;
        while (win == false){
            if (Xturn == true){
                System.out.println("X Move, Column:");
                int col = sc.nextInt();
                for (int i = 0; i<6; i++){
                    if (gameboard[col][i] == ('X') || gameboard[col][i] == 'Y'){
                        continue;
                    } else{
                        gameboard[col][i] = 'X';
                    }
                }
                for (int i = 0; i<7; i++){
                    for (int j  = 0; i<6; j++){
                        if(gameboard[i][j] == 'X'){
                            System.out.print("[X]");
                        } if(gameboard[i][j] == 'Y'){
                            System.out.print("[Y]");
                        }else{
                            System.out.print("[]");
                        }
                        System.out.println();
                    }

                }
            }


        }
    }
}