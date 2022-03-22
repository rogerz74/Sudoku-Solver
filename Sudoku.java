package SudokuCode;

import java.util.Scanner;
import java.io.File;

public class Sudoku {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SudokuMainFrame user = new SudokuMainFrame();
		user.userInterface();
	}
	
	public static Cell[][] sudokuSolver(int[][] values) 
	{
		Cell[][] board = new Cell[9][9];
		Solution result = new Solution();
		result.initialize(board);
		populate(board, values); //Sets everything in the cell except for its neighbours.
		result.neighbours(board);
		result.solve(board);		
		return board;
	}

	public static void populate(Cell[][] board, int[][] values)
	{
		int temp = 0;
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board[i].length; j++)
			{
				temp = values[i][j];
				board[i][j].setValue(temp);
				board[i][j].setAddress(i, j);
				board[i][j].setPossible(temp);
			}
	}
}
