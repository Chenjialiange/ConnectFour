import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class temp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] gameboard = new char[7][6];
        for (int x = 0; x < 7; x++) { // make all cells ' '
            for (int y = 0; y < 6; y++) {
                gameboard[x][y] = ' ';
            }
        }
        int yplace = 0;
        int col = 0;
        Boolean Xturn = true;
        Boolean win = false;
        System.out.println("Choose mode by typing a number");
        System.out.println("PVP:1");
        System.out.println("vs Computer(random):2");
        System.out.println("vs Computer(never loses):3");
        int mode = 0;
        while (true){
            mode = sc.nextInt();
            if (mode >= 1 && mode <= 3){
                break;
            } else{
                System.out.println("Invalid, Enter 1-3");
            }
        }
        if (mode == 1) { // PVP ------------------------------------------------------------------------------------------------------------------------------
            System.out.println(" 1  2  3  4  5  6  7");
            for (int y = 0; y < 6; y++) { // print board for choice ---------------------------------------
                System.out.println("[ ][ ][ ][ ][ ][ ][ ]");
            }
            while (win == false) {
                if (Xturn == true) {
                    System.out.println("X Move, Column:");
                    col = sc.nextInt() - 1;
                    if (col > 6 || col < 0) { //check for out of bounds input
                        System.out.println("Enter 1-7");
                        continue;
                    }
                    if (gameboard[col][0] == 'X' || gameboard[col][0] == 'Y') {// check for full
                        System.out.println("Column is full");
                        Xturn = true; //give turn back
                        continue;
                    }
                    for (int y = 5; y > -1; y--) { // place x in the column in the lowest place
                        if (gameboard[col][y] == ('X') || gameboard[col][y] == 'Y') {
                            continue;
                        } else {
                            gameboard[col][y] = 'X';
                            yplace = y;
                            break;
                        }
                    }
                    System.out.println(" 1  2  3  4  5  6  7");
                    for (int y = 0; y < 6; y++) { // print updated board with new elements ---------------------------------------
                        for (int x = 0; x < 7; x++) {
                            if (gameboard[x][y] == 'X') {
                                System.out.print("[X]");
                            } else if (gameboard[x][y] == 'Y') {
                                System.out.print("[Y]");
                            } else {
                                System.out.print("[ ]");
                            }
                        }
                        System.out.println();
                    }

                    Xturn = false; // switch turns
                } else if (Xturn == false) {
                    System.out.println("Y Move, Column:");
                    col = sc.nextInt() - 1;
                    if (col > 6 || col < 0) { //check for out of bounds input
                        System.out.println("Enter 1-7");
                        continue;
                    }
                    if (gameboard[col][0] == 'X' || gameboard[col][0] == 'Y') {// check for full
                        System.out.println("Column is full");
                        Xturn = true; //give turn back
                        continue;
                    }
                    for (int y = 5; y > -1; y--) { // place y in the column in the lowest place
                        if (gameboard[col][y] == ('X') || gameboard[col][y] == 'Y') {
                            continue;
                        } else {
                            gameboard[col][y] = 'Y';
                            yplace = y;
                            break;
                        }
                    }
                    System.out.println(" 1  2  3  4  5  6  7");
                    for (int y = 0; y < 6; y++) { // print updated board with new elements ---------------------------------------
                        for (int x = 0; x < 7; x++) {
                            if (gameboard[x][y] == 'X') {
                                System.out.print("[X]");
                            } else if (gameboard[x][y] == 'Y') {
                                System.out.print("[Y]");
                            } else {
                                System.out.print("[ ]");
                            }
                        }
                        System.out.println();
                    }


                    Xturn = true; // switch turns
                }

                int count = 0; // check wins----------------------------------------------------------------------
                if (Xturn == false) {
                    for (int i = yplace; i < 6; i++) { //check for vertical win
                        if (gameboard[col][i] == 'X') {
                            count++;
                        } else {
                            break;
                        }
                    }
                    if (count >= 4) {
                        System.out.println("X wins vertically");
                        win = true;
                        break;
                    }
                    count = 1;
                    for (int i = col - 1; i >= 0; i--) { //check for horizontral win left
                        if (gameboard[i][yplace] == 'X') {
                            count++;
                        } else {
                            break;
                        }
                    }

                    for (int i = col + 1; i < 7; i++) { //check for horizontral win right
                        if (gameboard[i][yplace] == 'X') {
                            count++;
                        } else {
                            break;
                        }
                    }
                    if (count >= 4) {
                        System.out.println("X wins horizontally");
                        win = true;
                        break;
                    }
                    count = 1; // check win for bottom left and top right----------------------------
                    int xd = col - 1;
                    int yd = yplace + 1;
                    while (xd >= 0 && yd < 6) {
                        if (gameboard[xd][yd] == 'X') {// check for diagonal
                            count++;
                            xd--;
                            yd++;
                        } else {
                            break;
                        }
                    }
                    xd = col + 1;
                    yd = yplace - 1;
                    while (xd < 7 && yd >= 0) {
                        if (gameboard[xd][yd] == 'X') {// check for diagonal
                            count++;
                            xd++;
                            yd--;
                        } else {
                            break;
                        }
                    }
                    if (count >= 4) {
                        System.out.println("X wins diagonally");
                        win = true;
                        break;
                    }
                    count = 1; // check up left and down right ------------------------------
                    xd = col - 1;
                    yd = yplace - 1;
                    while (xd >= 0 && yd >= 0) {
                        if (gameboard[xd][yd] == 'X') {// check for diagonal
                            count++;
                            xd--;
                            yd--;
                        } else {
                            break;
                        }
                    }
                    xd = col + 1;
                    yd = yplace + 1;
                    while (xd < 7 && yd < 6) {
                        if (gameboard[xd][yd] == 'X') {// check for diagonal
                            count++;
                            xd++;
                            yd++;
                        } else {
                            break;
                        }
                    }
                    if (count >= 4) {
                        System.out.println("X wins diagonally");
                        win = true;
                        break;
                    }
                    count = 0; // Win check for y ------------------------------------------------------------------------------------------------------
                    if (Xturn == false) {
                        for (int i = yplace; i < 6; i++) { //check for vertical win
                            if (gameboard[col][i] == 'Y') {
                                count++;
                            } else {
                                break;
                            }
                        }
                        if (count >= 4) {
                            System.out.println("Y wins vertically");
                            win = true;
                            break;
                        }
                        count = 1;
                        for (int i = col - 1; i >= 0; i--) { //check for horizontral win left
                            if (gameboard[i][yplace] == 'Y') {
                                count++;
                            } else {
                                break;
                            }
                        }

                        for (int i = col + 1; i < 7; i++) { //check for horizontral win right
                            if (gameboard[i][yplace] == 'Y') {
                                count++;
                            } else {
                                break;
                            }
                        }
                        if (count >= 4) {
                            System.out.println("Y wins horizontally");
                            win = true;
                            break;
                        }
                        count = 1; // check win for bottom left and top right----------------------------
                        xd = col - 1;
                        yd = yplace + 1;
                        while (xd >= 0 && yd < 6) {
                            if (gameboard[xd][yd] == 'Y') {// check for diagonal
                                count++;
                                xd--;
                                yd++;
                            } else {
                                break;
                            }
                        }
                        xd = col + 1;
                        yd = yplace - 1;
                        while (xd < 7 && yd >= 0) {
                            if (gameboard[xd][yd] == 'Y') {// check for diagonal
                                count++;
                                xd++;
                                yd--;
                            } else {
                                break;
                            }
                        }
                        if (count >= 4) {
                            System.out.println("Y wins diagonally");
                            win = true;
                            break;
                        }
                        count = 1; // check up left and down right ------------------------------
                        xd = col - 1;
                        yd = yplace - 1;
                        while (xd >= 0 && yd >= 0) {
                            if (gameboard[xd][yd] == 'Y') {// check for diagonal
                                count++;
                                xd--;
                                yd--;
                            } else {
                                break;
                            }
                        }
                        xd = col + 1;
                        yd = yplace + 1;
                        while (xd < 7 && yd < 6) {
                            if (gameboard[xd][yd] == 'Y') {// check for diagonal
                                count++;
                                xd++;
                                yd++;
                            } else {
                                break;
                            }
                        }
                        if (count >= 4) {
                            System.out.println("Y wins diagonally");
                            win = true;
                            break;
                        }
                    }

                }
            }
        }
        if (mode == 2) {
            win = false;
            Boolean playerturn = true;
            System.out.println(" 1  2  3  4  5  6  7");
            for (int y = 0; y < 6; y++) { // print board for choice ---------------------------------------
                System.out.println("[ ][ ][ ][ ][ ][ ][ ]");
            }
            while (win == false) {
                if (playerturn == true) {
                    System.out.println("Column:");
                    col = sc.nextInt() - 1;
                    if (col > 6 || col < 0) { //check for out of bounds input
                        System.out.println("Enter 1-7");
                        continue;
                    }
                    if (gameboard[col][0] == 'X' || gameboard[col][0] == 'Y') {// check for full
                        System.out.println("Column is full");
                        Xturn = true; //give turn back
                        continue;
                    }
                    for (int y = 5; y > -1; y--) { // place x in the column in the lowest place
                        if (gameboard[col][y] == ('X') || gameboard[col][y] == 'Y') {
                            continue;
                        } else {
                            gameboard[col][y] = 'X';
                            yplace = y;
                            break;
                        }
                    }

                    System.out.println(" 1  2  3  4  5  6  7");
                    for (int y = 0; y < 6; y++) { // print updated board with new elements ---------------------------------------
                        for (int x = 0; x < 7; x++) {
                            if (gameboard[x][y] == 'X') {
                                System.out.print("[X]");
                            } else if (gameboard[x][y] == 'Y') {
                                System.out.print("[Y]");
                            } else {
                                System.out.print("[ ]");
                            }
                        }
                        System.out.println();
                    }

                    playerturn = false;
                    int count = 0; // check wins for x----------------------------------------------------------------------
                    for (int i = yplace; i < 6; i++) { //check for vertical win
                        if (gameboard[col][i] == 'X') {
                            count++;
                        } else {
                            break;
                        }
                    }
                    if (count >= 4) {
                        System.out.println("X wins vertically");
                        win = true;
                        break;
                    }
                    count = 1;
                    for (int i = col - 1; i >= 0; i--) { //check for horizontral win left
                        if (gameboard[i][yplace] == 'X') {
                            count++;
                        } else {
                            break;
                        }
                    }

                    for (int i = col + 1; i < 7; i++) { //check for horizontral win right
                        if (gameboard[i][yplace] == 'X') {
                            count++;
                        } else {
                            break;
                        }
                    }
                    if (count >= 4) {
                        System.out.println("X wins horizontally");
                        win = true;
                        break;
                    }
                    count = 1; // check win for bottom left and top right----------------------------
                    int xd = col - 1;
                    int yd = yplace + 1;
                    while (xd >= 0 && yd < 6) {
                        if (gameboard[xd][yd] == 'X') {// check for diagonal
                            count++;
                            xd--;
                            yd++;
                        } else {
                            break;
                        }
                    }
                    xd = col + 1;
                    yd = yplace - 1;
                    while (xd < 7 && yd >= 0) {
                        if (gameboard[xd][yd] == 'X') {// check for diagonal
                            count++;
                            xd++;
                            yd--;
                        } else {
                            break;
                        }
                    }
                    if (count >= 4) {
                        System.out.println("X wins diagonally");
                        win = true;
                        break;
                    }
                    count = 1; // check up left and down right ------------------------------
                    xd = col - 1;
                    yd = yplace - 1;
                    while (xd >= 0 && yd >= 0) {
                        if (gameboard[xd][yd] == 'X') {// check for diagonal
                            count++;
                            xd--;
                            yd--;
                        } else {
                            break;
                        }
                    }
                    xd = col + 1;
                    yd = yplace + 1;
                    while (xd < 7 && yd < 6) {
                        if (gameboard[xd][yd] == 'X') {// check for diagonal
                            count++;
                            xd++;
                            yd++;
                        } else {
                            break;
                        }
                    }
                    if (count >= 4) {
                        System.out.println("X wins diagonally");
                        win = true;
                        break;
                    }
                } else {
                    int randomcol = (int) (Math.random() * (7));
                    if (gameboard[randomcol][0] == 'X' || gameboard[randomcol][0] == 'Y') {// check for full
                        System.out.println("Column is full");
                        continue;
                    }
                    for (int y = 5; y > -1; y--) { // place y in the random column in the lowest place
                        if (gameboard[randomcol][y] == ('X') || gameboard[randomcol][y] == 'Y') {
                            continue;
                        } else {
                            gameboard[randomcol][y] = 'Y';
                            yplace = y;
                            break;
                        }
                    }

                    System.out.println(" 1  2  3  4  5  6  7");
                    for (int y = 0; y < 6; y++) { // print updated board with new elements ---------------------------------------
                        for (int x = 0; x < 7; x++) {
                            if (gameboard[x][y] == 'X') {
                                System.out.print("[X]");
                            } else if (gameboard[x][y] == 'Y') {
                                System.out.print("[Y]");
                            } else {
                                System.out.print("[ ]");
                            }
                        }
                        System.out.println();
                    }

                    playerturn = true;
                    int count = 0; // Win check for y ------------------------------------------------------------------------------------------------------
                    col = randomcol;
                    for (int i = yplace; i < 6; i++) { //check for vertical win
                        if (gameboard[col][i] == 'Y') {
                            count++;
                        } else {
                            break;
                        }
                    }
                    if (count >= 4) {
                        System.out.println("Y wins vertically");
                        win = true;
                        break;
                    }
                    count = 1;
                    for (int i = col - 1; i >= 0; i--) { //check for horizontral win left
                        if (gameboard[i][yplace] == 'Y') {
                            count++;
                        } else {
                            break;
                        }
                    }

                    for (int i = col + 1; i < 7; i++) { //check for horizontral win right
                        if (gameboard[i][yplace] == 'Y') {
                            count++;
                        } else {
                            break;
                        }
                    }
                    if (count >= 4) {
                        System.out.println("Y wins horizontally");
                        win = true;
                        break;
                    }
                    count = 1; // check win for bottom left and top right----------------------------
                    int xd = col - 1;
                    int yd = yplace + 1;
                    while (xd >= 0 && yd < 6) {
                        if (gameboard[xd][yd] == 'Y') {// check for diagonal
                            count++;
                            xd--;
                            yd++;
                        } else {
                            break;
                        }
                    }
                    xd = col + 1;
                    yd = yplace - 1;
                    while (xd < 7 && yd >= 0) {
                        if (gameboard[xd][yd] == 'Y') {// check for diagonal
                            count++;
                            xd++;
                            yd--;
                        } else {
                            break;
                        }
                    }
                    if (count >= 4) {
                        System.out.println("Y wins diagonally");
                        win = true;
                        break;
                    }
                    count = 1; // check up left and down right ------------------------------
                    xd = col - 1;
                    yd = yplace - 1;
                    while (xd >= 0 && yd >= 0) {
                        if (gameboard[xd][yd] == 'Y') {// check for diagonal
                            count++;
                            xd--;
                            yd--;
                        } else {
                            break;
                        }
                    }
                    xd = col + 1;
                    yd = yplace + 1;
                    while (xd < 7 && yd < 6) {
                        if (gameboard[xd][yd] == 'Y') {// check for diagonal
                            count++;
                            xd++;
                            yd++;
                        } else {
                            break;
                        }
                    }
                    if (count >= 4) {
                        System.out.println("Y wins diagonally");
                        win = true;
                        break;
                    }


                }

            }
        }
        if (mode == 3) { //-------------------------------------------------------------------------------------------------------------------------------
            win = false;
            Boolean playerturn = true;
            System.out.println(" 1  2  3  4  5  6  7");
            for (int y = 0; y < 6; y++) { // print board for choice ---------------------------------------
                System.out.println("[ ][ ][ ][ ][ ][ ][ ]");
            }
            while (win == false) {
                if (playerturn == true) {
                    System.out.println("Column:");
                    col = sc.nextInt() - 1;
                    if (col > 6 || col < 0) { //check for out of bounds input
                        System.out.println("Enter 1-7");
                        continue;
                    }
                    if (gameboard[col][0] == 'X' || gameboard[col][0] == 'Y') {// check for full
                        System.out.println("Column is full");
                        Xturn = true; //give turn back
                        continue;
                    }
                    for (int y = 5; y > -1; y--) { // place x in the column in the lowest place
                        if (gameboard[col][y] == ('X') || gameboard[col][y] == 'Y') {
                            continue;
                        } else {
                            gameboard[col][y] = 'X';
                            yplace = y;
                            break;
                        }
                    }

                    System.out.println(" 1  2  3  4  5  6  7");
                    for (int y = 0; y < 6; y++) { // print updated board with new elements ---------------------------------------
                        for (int x = 0; x < 7; x++) {
                            if (gameboard[x][y] == 'X') {
                                System.out.print("[X]");
                            } else if (gameboard[x][y] == 'Y') {
                                System.out.print("[Y]");
                            } else {
                                System.out.print("[ ]");
                            }
                        }
                        System.out.println();
                    }

                    playerturn = false;
                    int count = 0; // check wins for x----------------------------------------------------------------------
                    for (int i = yplace; i < 6; i++) { //check for vertical win
                        if (gameboard[col][i] == 'X') {
                            count++;
                        } else {
                            break;
                        }
                    }
                    if (count >= 4) {
                        System.out.println("X wins vertically");
                        win = true;
                        break;
                    }
                    count = 1;
                    for (int i = col - 1; i >= 0; i--) { //check for horizontral win left
                        if (gameboard[i][yplace] == 'X') {
                            count++;
                        } else {
                            break;
                        }
                    }

                    for (int i = col + 1; i < 7; i++) { //check for horizontral win right
                        if (gameboard[i][yplace] == 'X') {
                            count++;
                        } else {
                            break;
                        }
                    }
                    if (count >= 4) {
                        System.out.println("X wins horizontally");
                        win = true;
                        break;
                    }
                    count = 1; // check win for bottom left and top right----------------------------
                    int xd = col - 1;
                    int yd = yplace + 1;
                    while (xd >= 0 && yd < 6) {
                        if (gameboard[xd][yd] == 'X') {// check for diagonal
                            count++;
                            xd--;
                            yd++;
                        } else {
                            break;
                        }
                    }
                    xd = col + 1;
                    yd = yplace - 1;
                    while (xd < 7 && yd >= 0) {
                        if (gameboard[xd][yd] == 'X') {// check for diagonal
                            count++;
                            xd++;
                            yd--;
                        } else {
                            break;
                        }
                    }
                    if (count >= 4) {
                        System.out.println("X wins diagonally");
                        win = true;
                        break;
                    }
                    count = 1; // check up left and down right ------------------------------
                    xd = col - 1;
                    yd = yplace - 1;
                    while (xd >= 0 && yd >= 0) {
                        if (gameboard[xd][yd] == 'X') {// check for diagonal
                            count++;
                            xd--;
                            yd--;
                        } else {
                            break;
                        }
                    }
                    xd = col + 1;
                    yd = yplace + 1;
                    while (xd < 7 && yd < 6) {
                        if (gameboard[xd][yd] == 'X') {// check for diagonal
                            count++;
                            xd++;
                            yd++;
                        } else {
                            break;
                        }
                    }
                    if (count >= 4) {
                        System.out.println("X wins diagonally");
                        win = true;
                        break;
                    }
                } else {
                    boolean moved = false;
                    for (int x=0;x<7;x++){
                        for (int y=5; y>=0; y--){
                            if(gameboard[x][y] == 'X' || gameboard[x][y] == 'Y'){
                                continue;
                            } else{
                                gameboard[x][y] = 'Y';
                            }
                            int count = 0; // check wins for x----------------------------------------------------------------------
                            for (int i = yplace; i < 6; i++) { //check for vertical win
                                if (gameboard[col][i] == 'Y') {
                                    count++;
                                } else {
                                    break;
                                }
                            }
                            if (count >= 4) {
                                win = true;
                                break;
                            }
                            count = 1;
                            for (int i = col - 1; i >= 0; i--) { //check for horizontral win left
                                if (gameboard[i][yplace] == 'Y') {
                                    count++;
                                } else {
                                    break;
                                }
                            }

                            for (int i = col + 1; i < 7; i++) { //check for horizontral win right
                                if (gameboard[i][yplace] == 'Y') {
                                    count++;
                                } else {
                                    break;
                                }
                            }
                            if (count >= 4) {
                                win = true;
                                break;
                            }
                            count = 1; // check win for bottom left and top right----------------------------
                            int xd = col - 1;
                            int yd = yplace + 1;
                            while (xd >= 0 && yd < 6) {
                                if (gameboard[xd][yd] == 'Y') {// check for diagonal
                                    count++;
                                    xd--;
                                    yd++;
                                } else {
                                    break;
                                }
                            }
                            xd = col + 1;
                            yd = yplace - 1;
                            while (xd < 7 && yd >= 0) {
                                if (gameboard[xd][yd] == 'Y') {// check for diagonal
                                    count++;
                                    xd++;
                                    yd--;
                                } else {
                                    break;
                                }
                            }
                            if (count >= 4) {
                                win = true;
                                break;
                            }
                            count = 1; // check up left and down right ------------------------------
                            xd = col - 1;
                            yd = yplace - 1;
                            while (xd >= 0 && yd >= 0) {
                                if (gameboard[xd][yd] == 'Y') {// check for diagonal
                                    count++;
                                    xd--;
                                    yd--;
                                } else {
                                    break;
                                }
                            }
                            xd = col + 1;
                            yd = yplace + 1;
                            while (xd < 7 && yd < 6) {
                                if (gameboard[xd][yd] == 'Y') {// check for diagonal
                                    count++;
                                    xd++;
                                    yd++;
                                } else {
                                    break;
                                }
                            }
                            if (count >= 4){
                                yplace = y;
                                col = x;
                                moved = true;
                                break;
                            } else {
                                gameboard[x][y] = ' ';
                            }

                        }
                        if (moved == true){
                            break;
                        }
                    }
                    if (moved == false){ // check if the ai can block the player from winning
                        for (int x = 0; x < 7; x++) {
                            for (int y = 5; y >= 0; y--) {
                                if (gameboard[x][y] == 'X' || gameboard[x][y] == 'Y') { // check over every avaible x to see where the player can win
                                    continue;
                                }
                                gameboard[x][y] = 'X';
                                int count = 0; // check wins for x----------------------------------------------------------------------
                                for (int i = yplace; i < 6; i++) { //check for vertical win
                                    if (gameboard[col][i] == 'X') {
                                        count++;
                                    } else {
                                        break;
                                    }
                                }
                                if (count >= 4) {
                                    win = true;
                                    break;
                                }
                                count = 1;
                                for (int i = col - 1; i >= 0; i--) { //check for horizontral win left
                                    if (gameboard[i][yplace] == 'X') {
                                        count++;
                                    } else {
                                        break;
                                    }
                                }

                                for (int i = col + 1; i < 7; i++) { //check for horizontral win right
                                    if (gameboard[i][yplace] == 'X') {
                                        count++;
                                    } else {
                                        break;
                                    }
                                }
                                if (count >= 4) {
                                    win = true;
                                    break;
                                }
                                count = 1; // check win for bottom left and top right----------------------------
                                int xd = col - 1;
                                int yd = yplace + 1;
                                while (xd >= 0 && yd < 6) {
                                    if (gameboard[xd][yd] == 'X') {// check for diagonal
                                        count++;
                                        xd--;
                                        yd++;
                                    } else {
                                        break;
                                    }
                                }
                                xd = col + 1;
                                yd = yplace - 1;
                                while (xd < 7 && yd >= 0) {
                                    if (gameboard[xd][yd] == 'X') {// check for diagonal
                                        count++;
                                        xd++;
                                        yd--;
                                    } else {
                                        break;
                                    }
                                }
                                if (count >= 4) {
                                    win = true;
                                    break;
                                }
                                count = 1; // check up left and down right ------------------------------
                                xd = col - 1;
                                yd = yplace - 1;
                                while (xd >= 0 && yd >= 0) {
                                    if (gameboard[xd][yd] == 'X') {// check for diagonal
                                        count++;
                                        xd--;
                                        yd--;
                                    } else {
                                        break;
                                    }
                                }
                                xd = col + 1;
                                yd = yplace + 1;
                                while (xd < 7 && yd < 6) {
                                    if (gameboard[xd][yd] == 'X') {// check for diagonal
                                        count++;
                                        xd++;
                                        yd++;
                                    } else {
                                        break;
                                    }
                                }

                                if (count >= 4) {
                                    gameboard[x][y] = 'Y';
                                    yplace = y;
                                    col = x;
                                    moved = true;
                                    break;
                                } else {
                                    gameboard[x][y] = ' ';
                                }
                            }
                            if (moved == true) {
                                break;
                            }
                        }
                    }
                    int randomcol = (int) (Math.random() * (7));
                    if (moved == false) {
                        while (gameboard[randomcol][0] == 'X' || gameboard[randomcol][0] == 'Y') { // check for full
                            randomcol = (int) (Math.random() * 7);
                        }
                        for (int y = 5; y >= 0; y--) {
                            if (gameboard[randomcol][y] == ' ') {  // puts y at lowest point
                                gameboard[randomcol][y] = 'Y';
                                yplace = y;
                                break;
                            }
                        }
                    }

                    System.out.println(" 1  2  3  4  5  6  7");
                    for (int y = 0; y < 6; y++) { // print updated board with new elements ---------------------------------------
                        for (int x = 0; x < 7; x++) {
                            if (gameboard[x][y] == 'X') {
                                System.out.print("[X]");
                            } else if (gameboard[x][y] == 'Y') {
                                System.out.print("[Y]");
                            } else {
                                System.out.print("[ ]");
                            }
                        }
                        System.out.println();
                    }
                    playerturn = true;



                }

            }
        }




    }
}
