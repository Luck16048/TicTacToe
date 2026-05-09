package org.example;

import java.util.Scanner;


public class TicTacToe {
    static char[][] board = new char[3][3];
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            board = initBoard(board);
            currentPlayer = 'X';

            while (true) {
                printBoard();
                makeMove();

                if (checkWin(currentPlayer)) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }

                if (isDraw()) {
                    printBoard();
                    System.out.println("It`s a draw!");
                    break;
                }

                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
            System.out.print("Want to play again? (yes/no):");
            String answer = sc.next().toLowerCase();

            if(!answer.equals("yes")){
                System.out.println("Thanks for the game! 👋");
                break;
            }
        }
    }

    public static char[][] initBoard(char[][] board) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
        return board;
    }

    static void printBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) System.out.println("---+---+---");
        }
        System.out.println();
    }

    static void makeMove() {
        Scanner sc = new Scanner(System.in);
        int row, col;

        while (true) {
            System.out.print("Player " + currentPlayer + ", enter row (0-2): ");
            row = sc.nextInt();
            System.out.print("Enter col (0-2): ");
            col = sc.nextInt();

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                break;
            }

            System.out.println("Invalid move! Try again.");
        }
    }

    static boolean checkWin(char p) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == p && board[i][1] == p && board[i][2] == p) return true;
            if (board[0][i] == p && board[1][i] == p && board[2][i] == p) return true;
        }
        if (board[0][0] == p && board[1][1] == p && board[2][2] == p) return true;
        if (board[0][2] == p && board[1][1] == p && board[2][0] == p) return true;
        return false;
    }

    static boolean isDraw() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ') return false;
        return true;

    }
}

