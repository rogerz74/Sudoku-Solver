package SudokuCode;

import java.util.LinkedList;
import java.util.List;

public class Solution {

	public String solve(Cell[][] board)
	{	
		String solutionStatus = LogicCycle1(board);
	
		if(solutionStatus.equals("incomplete"))
		{
			solutionStatus = LogicCycle2(board);
			if(solutionStatus.equals("incomplete"))
				solutionStatus = Guesser(board);
				
		}
		
		return solutionStatus;
	}
	
	public String LogicCycle1(Cell[][] board)
	{
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board[i].length; j++)
				if(board[i][j].getValue() != 0)
					remove(board[i][j]);
		
		return complete(board);
	}
	
	public void remove(Cell element) //Removes the possibilites for neighbours to be a certain value based on the value of the element. 
	{
		List<Integer> lstPossible = new LinkedList<Integer>();
		List<Cell> lstNeighbours = new LinkedList<Cell>();
		
		lstNeighbours = element.getNeighbour(); //Gets all the neighbours for a particular cell.
		Cell neighbour;
		
		for(int k = 0; k < lstNeighbours.size(); k++)
		{
			neighbour = lstNeighbours.get(k);
			neighbour.removePossible(element.getValue()); //Removes the value of the board from its neighbours.
			lstPossible = neighbour.getPossible(); //Gets the remaining possibilites after removal
			
			if(lstPossible.size() == 1) //If the neighbour only has one possible value.
			{
				neighbour.setValue(lstPossible.get(0));
				neighbour.emptyList();
				remove(neighbour);
			}
		}
	}
	
	public String LogicCycle2(Cell[][] board)
	{
		List<Integer> possible = new LinkedList<Integer>();
		List<Cell> neighbours = new LinkedList<Cell>();
		boolean unique;
		int neighbourType;
		
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board[i].length; j++)
				if(board[i][j].getValue() == 0)
				{
					possible = board[i][j].getPossible();
					neighbours = board[i][j].getNeighbour(); 
					
					for(int a = 0; a < possible.size(); a++)//Loops through each possibility in board[i][j]
					{
						unique = true;
						//Gets the type of neighbour.
						initialize(neighbours, i, j); 
						neighbourType = 1;
					
						while(neighbourType <= 3)
						{
							for(int k = 0; k < neighbours.size(); k++) 
								if(neighbours.get(k).getNeighbourType().contains(neighbourType) 
										&& neighbours.get(k).getPossible().contains(possible.get(a)))
								{
									unique = false;
									break;
								}
							
							if(unique)
							{
								board[i][j].setValue(possible.get(a));
								board[i][j].emptyList();
								remove(board[i][j]); //Runs through logic 1.
								break;
							}
							
							neighbourType++;
						}
							
					}
						
				}
		
		return complete(board);
					
	}
	
	public void initialize(List<Cell> neighbours, int row, int column)
	{
		int newRow, newColumn; //Column and row addresses of the neighbours.
		Cell neighbourElement;
		
		for(int i = 0; i < neighbours.size(); i++)
		{
			neighbourElement = neighbours.get(i);
			newRow = neighbourElement.getRow();
			newColumn = neighbours.get(i).getColumn();
			
			if(newRow == row)
				neighbourElement.setNeighbourType(1);
				
			if(newColumn == column)
				neighbourElement.setNeighbourType(2);
				
			if(newRow - newRow % 3 == row - row % 3 && newColumn - newColumn % 3 == column - column % 3)
				neighbourElement.setNeighbourType(3);
		}
	}
	
	public String Guesser(Cell[][] board)
	{
		Cell[][] boardCopy = new Cell[9][9];
		initialize(boardCopy);
		neighbours(boardCopy);
		copy(boardCopy, board); //Copies contents of board into boardCopy.
		int[] index = new int[2];
		int target = 2;
		String temp;
		
		while(exist(board, target, index) == -1)
			target++;
		
		while(board[index[0]][index[1]].getPossible().size() != 0)
		{
			boardCopy[index[0]][index[1]].setValue(board[index[0]][index[1]].getPossible().get(0));
			board[index[0]][index[1]].removePossible(board[index[0]][index[1]].getPossible().get(0));
			boardCopy[index[0]][index[1]].emptyList();
			
			temp = solve(boardCopy);
			
			if(temp.equalsIgnoreCase("complete"))
			{
				copy(board, boardCopy);
				return temp;
			}
				
			else if(temp.equalsIgnoreCase("invalid"))
				copy(boardCopy, board);
				
		}
		
		return complete(board);
			
	}
	
	public void copy(Cell[][] copy, Cell[][] original)
	{
		for(int i = 0; i < copy.length; i++)
			for(int j = 0; j < copy[i].length; j++)
			{
				copy[i][j].emptyList();
				copy[i][j].setValue(original[i][j].getValue());
				copy[i][j].setAddress(i, j);		
				for(int k = 0; k < original[i][j].getPossible().size(); k++)
					copy[i][j].addPossible(original[i][j].getPossible().get(k));
	
			}
	}
	
	public int exist(Cell[][] board, int target, int[] index)
	{
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board[i].length; j++)
				if(board[i][j].getPossible().size() == target)
				{
					index[0] = i;
					index[1] = j;
					return target;
				}
					
		
		return -1;
	}
	
	public void initialize(Cell[][] board)
	{
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board[i].length; j++)
				board[i][j] = new Cell();
	}
	
	public String complete(Cell[][] board)
	{
		List<Cell> neighbours = new LinkedList<Cell>();
		
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board[i].length; j++)
			{
				neighbours = board[i][j].getNeighbour();
				for(int k = 0; k < neighbours.size(); k++)
					if(board[i][j].getValue() != 0 && neighbours.get(k).getValue() == board[i][j].getValue() || board[i][j].getValue() == 0 && board[i][j].getPossible().size() == 0)
						return "invalid";
			}
		
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board[i].length; j++)
				if(board[i][j].getValue() == 0)
					return "incomplete";
			
		return "complete";
	}
	
	public void neighbours(Cell[][] board) 
	{
		for(int i = 0; i < board.length; i++) //Loops through the row
			for(int j = 0; j < board[i].length; j++) //Loops through the column
				for(int a = 0; a < board.length; a++) //For each cell, loops through rows and column again
					for(int b = 0; b < board[i].length; b++)
					{
						if(a == i && b == j)
							continue;
						
						if(a == i || b == j || a - a % 3 == i - i % 3 && b - b % 3 == j - j % 3) //Same row, column, block.
							board[i][j].setNeighbour(board[a][b]);
					}
						
	}
	
	public void display(Cell[][] board)
	{
		System.out.println();
		
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[i].length; j++)
			{
				System.out.print(board[i][j].getValue() + "    ");
				if(j % 3 == 2)
					System.out.print("|     ");
			}
				
			System.out.println();
			
			if(i % 3 == 2)
				System.out.println("----------------------------------------------------------");
		}	
	}
}
