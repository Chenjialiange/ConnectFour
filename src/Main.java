import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
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
            int xwins = 0;
            int ywins = 0;
            while (true) {
                win = false;
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 6; j++) {
                        gameboard[i][j] = ' ';
                    }
                }
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
                        boolean boardFull = true;
                        for (int x = 0; x < 7; x++) {
                            if (gameboard[x][0] == ' ') {
                                boardFull = false;
                                break;
                            }
                        }
                        if (boardFull) {
                            System.out.println("It's a tie!");
                            win = true;
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

                        boolean boardFull = true;
                        for (int x = 0; x < 7; x++) {
                            if (gameboard[x][0] == ' ') {
                                boardFull = false;
                                break;
                            }
                        }
                        if (boardFull) {
                            System.out.println("It's a tie!");
                            win = true;
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
                            xwins++;
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
                            xwins++;
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
                            xwins++;
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
                            xwins++;
                            win = true;
                            break;
                        }
                        count = 0; // Win check for y ------------------------------------------------------------------------------------------------------
                    }
                    else {
                        for (int i = yplace; i < 6; i++) { //check for vertical win
                            if (gameboard[col][i] == 'Y') {
                                count++;
                            } else {
                                break;
                            }
                        }
                        if (count >= 4) {
                            System.out.println("Y wins vertically");
                            ywins++;
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
                            ywins++;
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
                            ywins++;
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
                            ywins++;
                            win = true;
                            break;
                        }
                        }

                    }

                System.out.println("Final Leaderboard:");
                System.out.println("Player X Wins: " + xwins);
                System.out.println("Player Y Wins: " + ywins);
                System.out.println("Play again? (Y/N):");
                String again = sc.next().trim().toUpperCase();
                if (!again.equals("Y")) {
                    System.out.println("thanks for playing");
                    break;

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
                    boolean boardFull = true;
                    for (int x = 0; x < 7; x++) {
                        if (gameboard[x][0] == ' ') {
                            boardFull = false;
                            break;
                        }
                    }
                    if (boardFull) {
                        System.out.println("It's a tie!");
                        win = true;
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
                } else { // ai turn -------------------------------------------------------------------------------------- ----------------------------------
                    boolean moved = false;
                    for (int x=0;x<7;x++){
                        for (int y=5; y>=0; y--){
                            if(gameboard[x][y] == 'X' || gameboard[x][y] == 'Y'){ // check for avaible sports
                                continue;
                            } else{
                                gameboard[x][y] = 'Y';
                            }
                            boolean foundWin = false; // check each spot for winning conditon
                            int count = 1;
                            // check down
                            for (int i = y + 1; i < 6; i++) {
                                if (gameboard[x][i] == 'Y') count++;
                                else break;
                            }
// check up
                            for (int i = y - 1; i >= 0; i--) {
                                if (gameboard[x][i] == 'Y') count++;
                                else break;
                            }
                            if (count >= 4) foundWin = true;
                            count = 1;
                            for (int i = x + 1; i < 7; i++) { // check horizontally
                                if (gameboard[i][y] == 'Y') count++;
                                else break;
                            }
                            for (int i = x - 1; i >= 0; i--) {
                                if (gameboard[i][y] == 'Y') count++;
                                else break;
                            }
                            if (count >= 4) foundWin = true;
                            count = 1;
                            int xd = x - 1, yd = y + 1; // diagonal check for /
                            while (xd >= 0 && yd < 6 && gameboard[xd][yd] == 'Y') {
                                count++; xd--; yd++;
                            }
                            xd = x + 1; yd = y - 1;
                            while (xd < 7 && yd >= 0 && gameboard[xd][yd] == 'Y') {
                                count++; xd++; yd--;
                            }
                            if (count >= 4) foundWin = true;
                            count = 1; // other diagonal check
                            xd = x - 1; yd = y - 1;
                            while (xd >= 0 && yd >= 0 && gameboard[xd][yd] == 'Y') {
                                count++; xd--; yd--;
                            }
                            xd = x + 1; yd = y + 1;
                            while (xd < 7 && yd < 6 && gameboard[xd][yd] == 'Y') {
                                count++; xd++; yd++;
                            }
                            if (count >= 4) foundWin = true;
                            if (foundWin == true){
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
                                if (gameboard[x][y] == 'X' || gameboard[x][y] == 'Y') { // check over every avaible x to see where the player can win and then replce with Y to block
                                    continue;
                                }
                                gameboard[x][y] = 'X';
                                boolean foundWin = false;
                                int count = 1;
                                for (int i = x + 1; i < 7; i++) { // check horzontally for win
                                    if (gameboard[i][y] == 'X') count++;
                                    else break;
                                }
                                for (int i = x - 1; i >= 0; i--) {
                                    if (gameboard[i][y] == 'X') count++;
                                    else break;
                                }
                                if (count >= 4) foundWin = true;
                                count = 1;
                                // check down
                                for (int i = y + 1; i < 6; i++) {
                                    if (gameboard[x][i] == 'X') count++;
                                    else break;
                                }
// check up
                                for (int i = y - 1; i >= 0; i--) {
                                    if (gameboard[x][i] == 'X') count++;
                                    else break;
                                }
                                if (count >= 4) foundWin = true;
                                count = 1;
                                int xd = x - 1, yd = y + 1; // check diagonal (/)
                                while (xd >= 0 && yd < 6 && gameboard[xd][yd] == 'X') {
                                    count++;
                                    xd--;
                                    yd++;
                                }
                                xd = x + 1;
                                yd = y - 1;
                                while (xd < 7 && yd >= 0 && gameboard[xd][yd] == 'X') {
                                    count++;
                                    xd++;
                                    yd--;
                                }
                                xd = x - 1;
                                yd = y - 1;
                                if (count >= 4) foundWin = true;
                                count = 1; // check diagonal (\)
                                while (xd >= 0 && yd >= 0 && gameboard[xd][yd] == 'X') {
                                    count++;
                                    xd--;
                                    yd--;
                                }
                                xd = x + 1;
                                yd = y + 1;
                                while (xd < 7 && yd < 6 && gameboard[xd][yd] == 'X') {
                                    count++;
                                    xd++;
                                    yd++;
                                }
                                if (count >= 4) foundWin = true;
                                if (foundWin) {
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
                    boolean boardFull = true;
                    for (int x = 0; x < 7; x++) {
                        if (gameboard[x][0] == ' ') {
                            boardFull = false;
                            break;
                        }
                    }
                    if (boardFull) {
                        System.out.println("Its a tie");
                        win = true;
                    }
                    playerturn = true;



                }

            }
        }




    }
}