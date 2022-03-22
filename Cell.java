package SudokuCode;

import java.util.LinkedList;
import java.util.List;

public class Cell {
	
	private int value, row, column;
	private List<Cell> neighbours;
	private List<Integer> possible;
	private List<Integer> neighbourType; //Type 1 is same row, type 2 is same column, type 3 is same block.
	
	public Cell()
	{
		this.value = 0;
		this.neighbours = new LinkedList<Cell>();
		this.possible = new LinkedList<Integer>();
		this.neighbourType = new LinkedList<Integer>();
		this.row = 0;
		this.column = 0;
	}
	
	public void setAddress(int row, int column) 
	{
		this.row = row;
		this.column = column;
	}
	
	public int getRow()
	{
		return this.row;
	}
	
	public int getColumn()
	{
		return this.column;
	}
	
	public void setValue(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return this.value;
	}
	
	public void setNeighbourType(int value)
	{
		this.neighbourType.add(value);
	}
	
	public List<Integer> getNeighbourType()
	{
		return this.neighbourType;
	}
	
	public void setPossible(int value) //Initializes the possibilities to the numbers from one to nine
	{			
		if(value == 0)
			for(int i = 1; i <= 9; i++)
				this.possible.add(i);
	}
	
	public List<Integer> getPossible() //Gets the list of possibilities
	{			
		return this.possible;
	}
	
	public void removePossible(int value)
	{	
		for(int i = 0; i < this.possible.size(); i++)
			if(this.possible.get(i) == value)
			{
				this.possible.remove(i);
				return;
			}
				
	}
	
	public void addPossible(int value)
	{	
		this.possible.add(value);
	}
	
	public void emptyList()
	{
		this.possible.clear();
	}
	
	public void setNeighbour(Cell cell)
	{
		this.neighbours.add(cell);
	}
	
	public List<Cell> getNeighbour()
	{
		return this.neighbours;
	}

}
