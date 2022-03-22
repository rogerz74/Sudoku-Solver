package code;
import java.io.File;
import java.util.Scanner;


	/*
	 * Throughout this code, you will find a lot of unnecessary else & else if statements for the logic cycles and guessing.
	 * This is because it helped me organize my train of thought and helped to isolate my mistakes when debugging.
	 * These statements could all be removed and deleted but I kept them in b/c it helped me with organization
	 */

	public class Board {
		/*The Sudoku Board is made of 9x9 cells for a total of 81 cells.
		 * In this program we will be representing the Board using a 2D Array of cells.
		 * 
		 */
	
		private static Cell[][] board = new Cell[9][9];
		
		//an array of int to copy the values from the sudoku board and transfer it into a second array
		//this is used for the guessing mechanism, which is found later
		private static int [][] sub = new int [9][9];
		
		//The variable "level" records the level of the puzzle being solved.
		private static String level = "";
			
		
		public static void findBoxID() //setting all the cells to a specific grid ID
		{
			for (int x = 0; x < 9; x++)
			{
				for (int y = 0; y < 9; y++)
				{
					//first row box IDs: 1,2,3
					if ( x < 3 && y < 3)
					{
						board[x][y].setBoxID(1);
					}
					else if ( x < 3 && y >= 3 && y < 6 )
					{
						board[x][y].setBoxID(2);
					}
					else if ( x < 3 && y >= 6 && y < 9 )
					{
						board[x][y].setBoxID(3);
					}
					///////////////////////////////////////////////
					
					//second row box IDs: 1,2,3
					else if ( (x >= 3 && x < 6) && y < 3)
					{
						board[x][y].setBoxID(4);
					}
					else if ( (x >= 3 && x < 6) && (y >= 3 && y < 6))
					{
						board[x][y].setBoxID(5);
					}
					else if ( (x >= 3 && x < 6) && (y >= 6 && y < 9) )
					{
						board[x][y].setBoxID(6);
					}
					///////////////////////////////////////////////
					
					//third row box IDs: 1,2,3
					else if ( (x >= 6 && x < 9) && y < 3 )
					{
						board[x][y].setBoxID(7);
					}
					else if ( (x >= 6 && x < 9) && (y >= 3 && y < 6) )
					{
						board[x][y].setBoxID(8);
					}
					else if ( (x >= 6 && x < 9) &&  (y >= 6 && y < 9) )
					{
						board[x][y].setBoxID(9);
					}
				}
			}
			
		}
		
		
		///TODO: CONSTRUCTOR
		//This must initialize every cell on the board with a generic cell.  It must also assign all of the boxIDs to the cells
		public static void Board()
		{
			for(int x = 0; x < 9; x++)
				for(int y = 0 ; y < 9; y++)
				{
					board[x][y] = new Cell();
					findBoxID();
					board[x][y].setBoxID( 3*(x/3) + (y)/3+1);
				}
		}
		
	
		
		///TODO: loadPuzzle
		/*This method will take a single String as a parameter.  The String must be either "easy", "medium" or "hard"
		 * If it is none of these, the method will set the String to "easy".  The method will set each of the 9x9 grid
		 * of cells by accessing either "easyPuzzle.txt", "mediumPuzzle.txt" or "hardPuzzle.txt" and setting the Cell.number to 
		 * the number given in the file.  
		 * 
		 * This must also set the "level" variable
		 * TIP: Remember that setting a cell's number affects the other cells on the board.
		 */
		public static void loadPuzzle(String filename) throws Exception
		{
			Scanner input = new Scanner ( new File(filename));
			
			for(int x = 0; x < 9; x++)
			{
				for(int y = 0 ; y < 9; y++)
				{
					board[x][y] = new Cell();
					board[x][y].setBoxID( 3*(x/3) + (y)/3+1);
					board[x][y].setNumber(input.nextInt());
					
					//sub[x][y].setNumber(input.nextInt());
					
				}
			}	
		}
		
		
		
		///TODO: isSolved
		/*This method scans the board and returns TRUE if every cell has been solved.  Otherwise it returns FALSE
		 * 
		 */
		
		public static void main(String[] args)throws Exception ////////////////////////   MAIN CODE   ////////////////////////////////////
		{
			
			loadPuzzle("medium.txt");
			
			display();
			System.out.println("");
			
			//logicCycles();
		
			System.out.println("");
			//System.out.println("The number of changes made: " +changesMade);
			System.out.println("");
			display();
			
			if(isSolved() == true)
			{
				System.out.println("The Program is Solved via Logic Cycles!!");
			}
			else if (isSolved() == false)
			{
				GuessingValues();
				System.out.println("");
				//System.out.println("The number of changes made: " +changesMade);
				System.out.println("");
				display();
			}
			
			
			
			
		}
		
		///////////////////////////////////////////////////////////////////////////////////////////
		
		public static boolean isSolved()
		{
			int checker = 0;
			for (int x = 0; x < 9; x ++)
			{
				for (int y = 0; y < 9; y ++)
				{
					if (board[x][y].getNumber() == 0)
					{
						checker = 1;
						break;
					}
					else
					{
						
					}
				}
			}
			
			if( checker == 1)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		
	
		///TODO: DISPLAY
		/*This method displays the board neatly to the screen.  It must have dividing lines to show where the box boundaries are
		 * as well as lines indicating the outer border of the puzzle
		 */
		public static void display()
		{
			for (int x = 0; x < 9; x ++)
			{
			
				if (x == 3 || x == 6)
				{
					//do nothing
				}
				else
					System.out.println();
					
					for (int y = 0; y < 9; y++)
						{
							if (y == 2 || y == 5)
							{
								System.out.print(board[x][y].getNumber() +" | ");
							}
							else
								System.out.print(board[x][y].getNumber() +" ");
						}
					
					if (x == 2 || x == 5)
					{
						System.out.println();
						System.out.println("---------------------");
					}
				
			}
			
			System.out.println("");
			System.out.println("");
		}
		
		
		
		
		///TODO: solveForPotential
		/*This method solves a single cell at x,y for number.  It also must adjust the potentials of the remaining cells in the same row,
		 * column, and box.
		 */
		
		
		public static void solveForPotential(int x, int y) //solving for the number potential numbers at an x,y coord
		{
			//to see if the number can be used by checking the row
			for (int a = 0; a < 9; a++)
			{
				
				if (board[x][a].getNumber() == 0)
				{
					board[x][y].cantBe(0);
				}
				else
				{
					board[x][y].cantBe(board[x][a].getNumber());
				}
			}
			
			//to see if the number can be used by checking the column
			for (int b = 0; b < 9; b++)
			{
				if (board[b][y].getNumber() == 0)
				{
					board[x][y].cantBe(0);
				}
				else
				{
					board[x][y].cantBe(board[b][y].getNumber());
				}
			}
			
			
			//checking for the numbers within the BoxID (the 3 x 3) grid to see what numbers it can't be
				for (int a = 0; a < 9; a ++)
				{
					for (int b = 0; b < 9; b ++)
					{
						if (board[a][b].getBoxID() == board[x][y].getBoxID()) //if a cell is to found as the same boxID as the current cell
						{
							board[x][y].cantBe(board[a][b].getNumber());
						}
						else
						{
							//do nothing
						}
							
					}
				}
			
		
			
			
			
		}
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//logicCycles() continuously cycles through the different logic algorithms until no more changes are being made.
		public static void logicCycles()
		{
				int changesMade = 0;
				do
				{
					changesMade = 0;
					changesMade += logic1();
					changesMade += logic2r();
					changesMade += logic2c();
					changesMade += logic3();
					changesMade += logic4r();
					changesMade += logic4c();
					changesMade += logic4b();
					
					for (int a = 0; a < 9; a ++)
					{
						for (int b = 0; b < 9; b++)
						{
							if( ZeroPotential(a, b) == true)
							{
								break;
							}
						}
					}
					

				}while(changesMade != 0);	
		}
		
		
		///TODO: logic1
		/*This method searches each row of the puzzle and looks for cells that only have one potential.  If it finds a cell like this, it solves the cell 
		 * for that number. This also tracks the number of cells that it solved as it traversed the board and returns that number.
		 */
		public static int logic1()
		{
			int changesMade = 0;
			
			for (int x = 0; x < 9; x++) //going vertical
			{
				for (int y = 0; y < 9; y++) //going horizontal
				{
					if (board[x][y].getNumber() == 0) //if the box is empty
					{
						int value = 0; //how many potential numbers the cell can be
						solveForPotential(x, y); //solve for the potential values of the cell
						
						for (int a = 0; a < 10; a ++) //this is the code that determines the number of the potential values for the cell
						{
							boolean[] potential = board[x][y].getPossible();
							
							if( potential[a] == true)
							{
								value ++; //counting the number of potentials
							}
						}
						//System.out.println("Number of Values: " +value);
						
						/////////////////////////////////////////////////////////////
						
						if (value == 1) //if there's only one possiblity for the cell (this is what logic 1 is looking for)
						{
							for (int a = 0; a < 10; a ++)  //looking for which value the cell can be
							{
								boolean[] potential = board[x][y].getPossible();
								
								if( potential[a] == true)
								{
									board[x][y].setNumber(a);
									changesMade ++;
									break;
								}
							}
						}
						else
						{
							//do nothing
						}
						
					}
					else
					{
						//do nothing and move on to the next coordinate
					}
				}
			}
	
			
			return changesMade;
						
		}
		
		///TODO: logic2
		/*This method searches each row for a cell that is the only cell that has the potential to be a given number.  If it finds such a cell and it
		 * is not already solved, it solves the cell.  It then does the same thing for the columns.This also tracks the number of cells that 
		 * it solved as it traversed the board and returns that number.
		 */
		
		public static int logic2r()
		{
			int changesMade = 0;
			
			for (int x = 0; x < 9; x ++)
			{
				for (int y = 0; y < 9; y++)
				{
						
					if (board[x][y].getNumber() == 0) //if the box is empty
					{
						
						/////////////PART A: Solving for the number of potentials of a cell and listing them into an array////
						
						solveForPotential(x, y); //solve for the potential values of the cell
						int[] array = new int[10]; //to store the potential values
						boolean[] potential = board[x][y].getPossible();
						for (int a = 0; a < 10; a ++) //this is the code that determines the number of the potential values for the cell
						{

							if( potential[a] == true)
							{
								array[a] = a;
								
							}
							else
							{
								array[a] = 0;
							}
						}
						
						
						/////////PART B: looking for an unsolved cell within a row that may
						//have more than one possible number but is the only cell within
						//that row that can be a given number////////////
						
						outerloop: for (int valid = 0; valid < 10; valid ++)
						{
							boolean checker = false;
							
							if(array[valid] == 0)
							{
								//DO nothing
							}
							else if (array[valid] != 0)
							{
								innerloop: for (int b = 0; b < 9; b++)
								{
									if (b == y)
									{
										//do nothing
									}
									else if (b != y)
									{
										if(board[x][b].getNumber() != 0)
										{
											//do nothing
										}
										else if (board[x][b].getNumber() == 0)
										{
											solveForPotential(x,b);
											int[] Newarray = new int[10]; //to store the potential values of (x,b)
											boolean[] Newpotential = board[x][b].getPossible();
											for (int c = 0; c < 10; c ++) //this is the code that determines the number of the potential values for the cell
											{
	
												if( Newpotential[c] == true)
												{
													Newarray[c] = c;
												}
												else
												{
													Newarray[c] = 0;
												}
											}
											
											if(Newarray[valid] == array[valid])
											{
												checker = false;
												//System.out.println("It gets here.");
												break innerloop;
											}
											else if (Newarray[valid] != array[valid])
											{
												checker = true;
											}
											
											
											
										}
									}
									
								}
							
								if(checker == true)
								{
									//System.out.println("This point is reached");
									board[x][y].setNumber(array[valid]);
									changesMade ++;
									break outerloop;
								}
								else
								{
									
								}
							}
						}
						
					}
					else
					{
						//DO nothing
					}
				}
			}	
			
			return changesMade;
		}
		
		public static int logic2c()
		{
			int changesMade = 0;
			
			for (int x = 0; x < 9; x ++)
			{
				for (int y = 0; y < 9; y++)
				{
						
					if (board[x][y].getNumber() == 0) //if the box is empty
					{
						
						/////////////PART A: Solving for the number of potentials of a cell and listing them into an array////
						
						solveForPotential(x, y); //solve for the potential values of the cell
						int[] array = new int[10]; //to store the potential values
						boolean[] potential = board[x][y].getPossible();
						for (int a = 0; a < 10; a ++) //this is the code that determines the number of the potential values for the cell
						{

							if( potential[a] == true)
							{
								array[a] = a;
								
							}
							else
							{
								array[a] = 0;
							}
						}
						
						
						/////////PART B: looking for an unsolved cell within a row that may
						//have more than one possible number but is the only cell within
						//that row that can be a given number////////////
						
						outerloop: for (int valid = 0; valid < 10; valid ++)
						{
							boolean checker = false;
							
							if(array[valid] == 0)
							{
								//DO nothing
							}
							else if (array[valid] != 0)
							{
								innerloop: for (int b = 0; b < 9; b++)
								{
									if (b == x)
									{
										//do nothing
									}
									else if (b != x)
									{
										if(board[b][y].getNumber() != 0)
										{
											//do nothing
										}
										else if (board[b][y].getNumber() == 0)
										{
											solveForPotential(b,y);
											int[] Newarray = new int[10]; //to store the potential values of (x,b)
											boolean[] Newpotential = board[b][y].getPossible();
											for (int c = 0; c < 10; c ++) //this is the code that determines the number of the potential values for the cell
											{
	
												if( Newpotential[c] == true)
												{
													Newarray[c] = c;
												}
												else
												{
													Newarray[c] = 0;
												}
											}
											
											if(Newarray[valid] == array[valid])
											{
												checker = false;
												//System.out.println("It gets here.");
												break innerloop;
											}
											else if (Newarray[valid] != array[valid])
											{
												checker = true;
											}
											
											
											
										}
									}
									
								}
							
								if(checker == true)
								{
									//System.out.println("This point is reached");
									board[x][y].setNumber(array[valid]);
									changesMade ++;
									break outerloop;
								}
								else
								{
									
								}
							}
						}
						
					}
					else
					{
						//DO nothing
					}
				}
			}	
			
			return changesMade;
		}
		
		///TODO: logic3
		/*This method searches each box for a cell that is the only cell that has the potential to be a given number.  If it finds such a cell and it
		 * is not already solved, it solves the cell. This also tracks the number of cells that it solved as it traversed the board and returns that number.
		 */
		public static int logic3() 
		{
			int changesMade = 0;
			
			for (int x = 0; x < 9; x ++)
			{
				for (int y = 0; y < 9; y++)
				{
						
					if (board[x][y].getNumber() == 0) //if the box is empty
					{
						
						/////////////PART A: Solving for the number of potentials of a cell and listing them into an array////
						
						solveForPotential(x, y); //solve for the potential values of the cell
						int[] array = new int[10]; //to store the potential values
						for (int a = 0; a < 10; a ++) //this is the code that determines the number of the potential values for the cell
						{
							boolean[] potential = board[x][y].getPossible();
							
							if( potential[a] == true)
							{
								array[a] = a;
								
							}
							else
							{
								
							}
						}
						
						//System.out.println("Number of Values: " +value);
						
						/////////PART B: looking for an
						//unsolved cell in a box that is the only cell that can hold a
						//particular value//////////////
						//System.out.println("This step was reached");
						
						outerloop: for (int valid = 0; valid < 10; valid ++)
						{
							int boxCounter = 0;
							boolean checker = false;
							
							if(array[valid] == 0)
							{
								//DO nothing
							}
							else if (array[valid] != 0)
							{
								innerloop: for (int m = 0; m < 9; m++)
								{
									for (int n = 0; n < 9; n ++)
									{

										
										if (board[m][n].getNumber() == 0 && board[m][n] != board[x][y])
										{//////////////////
											if (board[m][n].getBoxID() == board[x][y].getBoxID()) 
											//if a cell is to found as the same boxID as the current cell
											{
												solveForPotential(m,n);
												int[] Newarray = new int[10]; //to store the potential values of (x,b)
												boolean[] Newpotential = board[m][n].getPossible();
												for (int c = 0; c < 10; c ++) 
												//this is the code that determines the number of the potential values for the cell
												{
													if( Newpotential[c] == true)
													{
														Newarray[c] = c;
													}
													else
													{
														Newarray[c] = 0;
													}
												}
												
												
												if(Newarray[valid] == array[valid] && Newarray[valid] != 0)
												{
													checker = false;
													//System.out.println("It gets here.");
													break innerloop;
												}
												else if (Newarray[valid] != array[valid])
												{
													//System.out.println("NewArray: " +Newarray[valid]);
													//System.out.println(array[valid]);
													checker = true;
												}
											}
											else
											{
												//do nothing
											}
										}//////////////////////
										else
										{
											
											//do nothing
										}
										
										
									}
									
									
								}
							
								for (int g = 0; g < 9; g ++) //This is the code for if all 8 boxes are filled up in a boxID
								{
									for(int h = 0; h < 9; h ++)
									{
										//System.out.println("Gets here");
										if (board[g][h].getBoxID() == board[x][y].getBoxID() 
												&& board[g][h].getNumber() != 0 && board[x][y].getNumber() == 0)
										{
											boxCounter ++;
										}
										else
										{
											
										}
									}
								}

								if(checker == true)
								{
									//System.out.println("This point is reached");
									board[x][y].setNumber(array[valid]);
									//System.out.println(valid);
									changesMade ++;
									break outerloop;
								}
								else if (boxCounter == 8)
								{
										//System.out.println("This point is reached");
										board[x][y].setNumber(array[valid]);
										//System.out.println(valid);
										changesMade ++;
										break outerloop;

								}
								else
								{
									
								}
							}
						}
						
						
						//////////////////////////////////////////////
						
					}
					else
					{
						//DO nothing
					}
				}
			}
			
			return changesMade;
		}
		
		
		///TODO: logic4
			/*This method searches each row for the following conditions:
			 * 1. There are two unsolved cells that only have two potential numbers that they can be
			 * 2. These two cells have the same two potentials (They can't be anything else)
			 * 
			 * Once this occurs, all of the other cells in the row cannot have these two potentials.  
			 * Write an algorithm to set these two potentials to be false
			 * for all other cells in the row.
			 * 
			 * Repeat this process for columns and rows.
			 * 
			 * This also tracks the number of cells that it solved as it traversed the board and returns that number.
			 */
		public static int logic4r() //logic 4 for rows
		{
			int changesMade = 0;
			boolean rowSimilar = false;
			int unknowns = 0; //checking if there are exactly 2 unknown/potential data points
			for (int x = 0; x < 9; x ++)
			{
				for (int y = 0; y < 9; y++)
				{
						
					if (board[x][y].getNumber() == 0) //if the box is empty
					{
						
						/////////////PART A: Solving for the number of potentials of a cell and listing them into an array////
						
						unknowns = 0;
						solveForPotential(x, y); //solve for the potential values of the cell
						int[] array = new int[10]; //to store the potential values
						for (int a = 0; a < 10; a ++) //this is the code that determines the number of the potential values for the cell
						{
							boolean[] potential = board[x][y].getPossible();
							
							if( potential[a] == true)
							{
								array[a] = a;
								unknowns ++; //to get the number of potentials (2 potentials are required for this logic)
								
							}
							else
							{
								
							}
						}
						
						
						if (unknowns == 2) //only if there's 2 unknowns/potential numbers
						{

							//////////////////////////////////////////////////////////
							/*For the next section, the program will check the rows, columns, and boxs for other grids with
							 * the exact two potentials as cell (x,y).
							 * The code used for Rows, Columns and Boxes are all very similar, each with slight modifications*/
							/////////////////////////////////////////////////////////
							
							//////////ROWS//////////
							for (int a = 0; a < 9; a ++) //finding the potentials for all the cells in a row and checking if they match
							{
								int[] Newarray = new int[10]; //to store the potential values of (x,b)
								if (board[x][a].getNumber() == 0 && board[x][a] != board[x][y]) //finding the potentials for the cell
								{
									
									//Part A: solving for the potential of the other cell
									
									solveForPotential(x,a);
									boolean[] Newpotential = board[x][a].getPossible();
									for (int c = 0; c < 10; c ++) 
									//this is the code that determines the number of the potential values for the cell
									{
										if( Newpotential[c] == true)
										{
											Newarray[c] = c;
										}
										else
										{
											Newarray[c] = 0;
										}
									}
									
									//Part B: Checking for similarity of the potentials of cells (x,y) and (x,a)
									
									for (int z = 0; z < 10; z ++) //checking the similarity between the two cell's potentials
									//going across the array row & Newarray row; that's what the z value represents
									{
										if (array[z] == Newarray[z]) //if it matches
										{
											//do nothing if they match
											if (z == 9)
											{
												rowSimilar = true;
											}
											//if it matches perfectly
										}
										else if (array[z] != Newarray[z]) //if it doesnt match
										{
											rowSimilar = false;
											break;
											
										}	
										
									}
									
									//Part C: Changing the cell potentials if rowSimiliar is true
									
									if (rowSimilar == true)
									{
										//System.out.println("It gets here");
										for (int change = 0; change < 9; change ++) 
										//changing the potentials of the cell throughout the row
										{
											if (board[x][change] != board[x][y] && board[x][change] != board[x][a] 
													&& board[x][change].getNumber() == 0)
											{
												for (int q = 0; q < 10; q ++)
												{ //setting it false for all the potentials of cell (x,y) and (x,a)
													board[x][change].cantBe(array[q]);
													
													if (array[q] != 0)
													{
														changesMade ++;
													}
													
												}
												
												
												
											}
											else
											{
												//do nothing if the third cell that is being changed is either cell (x,y) or (x,a)
											}
										}
										
									}
									else if (rowSimilar = false)
									{
										//do nothing if (x,y) and (x,a) don't share the exact same potentials
									}
								}
								else
								{
									//do nothing if (x,a) isn't a zero or if (x,a) = (x,y)
								}
							}
						
						}
						
						
					}
					else
					{
						//do nothing if the cell isn't empty
					}
				}
			}
			
			return changesMade;
		}
		
		public static int logic4c() //logic 4 for columns
		{
			int changesMade = 0;
			boolean columnSimilar = false;
			int unknowns = 0; //checking if there are exactly 2 unknown/potential data points
			for (int x = 0; x < 9; x ++)
			{
				for (int y = 0; y < 9; y++)
				{
						
					if (board[x][y].getNumber() == 0) //if the box is empty
					{
						
						/////////////PART A: Solving for the number of potentials of a cell and listing them into an array////
						unknowns = 0;
						solveForPotential(x, y); //solve for the potential values of the cell
						int[] array = new int[10]; //to store the potential values
						for (int a = 0; a < 10; a ++) //this is the code that determines the number of the potential values for the cell
						{
							boolean[] potential = board[x][y].getPossible();
							
							if( potential[a] == true)
							{
								array[a] = a;
								unknowns ++; //to get the number of potentials (2 potentials are required for this logic)
								
							}
							else
							{
								
							}
						}
						
						
						if (unknowns == 2) //only if there's 2 unknowns/potential numbers
						{
							//////////////////////////////////////////////////////////
							/*For the next section, the program will check the rows, columns, and boxs for other grids with
							 * the exact two potentials as cell (x,y).
							 * The code used for Rows, Columns and Boxes are all very similar, each with slight modifications*/
							/////////////////////////////////////////////////////////
							
							//////////ROWS//////////
							for (int a = 0; a < 9; a ++) //finding the potentials for all the cells in a row and checking if they match
							{
								int[] Newarray = new int[10]; //to store the potential values of (x,b)
								if (board[a][y].getNumber() == 0 && board[a][y] != board[x][y]) //finding the potentials for the cell
								{
									
									//Part A: solving for the potential of the other cell
									
									solveForPotential(a,y);
									boolean[] Newpotential = board[a][y].getPossible();
									for (int c = 0; c < 10; c ++) 
									//this is the code that determines the number of the potential values for the cell
									{
										if( Newpotential[c] == true)
										{
											Newarray[c] = c;
										}
										else
										{
											Newarray[c] = 0;
										}
									}
									
									//Part B: Checking for similarity of the potentials of cells (x,y) and (x,a)
									
									for (int z = 0; z < 10; z ++) //checking the similarity between the two cell's potentials
									//going across the array row & Newarray row; that's what the z value represents
									{
										if (array[z] == Newarray[z]) //if it matches
										{
											//do nothing if they match
											if (z == 9)
											{
												columnSimilar = true;
											}
											//if it matches perfectly
										}
										else if (array[z] != Newarray[z]) //if it doesnt match
										{
											columnSimilar = false;
											break;
											
										}	
										
									}
									
									//Part C: Changing the cell potentials if rowSimiliar is true
									
									if (columnSimilar == true)
									{
										for (int change = 0; change < 9; change ++) 
										//changing the potentials of the cell throughout the row
										{
											if (board[change][y] != board[x][y] && board[change][y] != board[a][y] 
													&& board[change][y].getNumber() == 0)
											{
												for (int q = 0; q < 10; q ++)
												{ //setting it false for all the potentials of cell (x,y) and (x,a)
													board[change][y].cantBe(array[q]);
													
													if (array[q] != 0)
													{
														changesMade ++;
													}
													
												}
												
												
												
											}
											else
											{
												//do nothing if the third cell that is being changed is either cell (x,y) or (x,a)
											}
										}
										
									}
									else if (columnSimilar = false)
									{
										//do nothing if (x,y) and (x,a) don't share the exact same potentials
									}
								}
								else
								{
									//do nothing if (x,a) isn't a zero or if (x,a) = (x,y)
								}
							}
						
						}
						
						
					}
					else
					{
						//do nothing if the cell isn't empty
					}
				}
			}
			
			return changesMade;
		}
		
		public static int logic4b() //logic 4 for boxes
		{
			int changesMade = 0;
			boolean boxSimilar = false;
			int unknowns = 0; //checking if there are exactly 2 unknown/potential data points
			for (int x = 0; x < 9; x ++)
			{
				for (int y = 0; y < 9; y++)
				{
					unknowns = 0;	
					if (board[x][y].getNumber() == 0) //if the box is empty
					{
						
						/////////////PART A: Solving for the number of potentials of a cell and listing them into an array////
						
						solveForPotential(x, y); //solve for the potential values of the cell
						int[] array = new int[10]; //to store the potential values
						for (int a = 0; a < 10; a ++) //this is the code that determines the number of the potential values for the cell
						{
							boolean[] potential = board[x][y].getPossible();
							
							if( potential[a] == true)
							{
								array[a] = a;
								unknowns ++; //to get the number of potentials (2 potentials are required for this logic)
								
							}
							else
							{
								
							}
						}
						
						
						if (unknowns == 2) //only if there's 2 unknowns/potential numbers
						{
							//////////////////////////////////////////////////////////
							/*For the next section, the program will check the rows, columns, and boxs for other grids with
							 * the exact two potentials as cell (x,y).
							 * The code used for Rows, Columns and Boxes are all very similar, each with slight modifications*/
							/////////////////////////////////////////////////////////
							
							//////////BOXS//////////
							for(int c = 0; c < 9; c ++)
								{
									for(int d = 0; d < 9; d ++)
									{
										if (board[c][d].getBoxID() == board[x][y].getBoxID() && board[c][d] != board[x][y])
										{
											int[] Newarray = new int[10]; //to store the potential values of (c,d)
											if (board[c][d].getNumber() == 0) //finding the potentials for the cell
											{
																
												//Part A: solving for the potential of the other cell
																
												solveForPotential(c,d);
												boolean[] Newpotential = board[c][d].getPossible();
												for (int e = 0; e < 10; e ++) 
												//this is the code that determines the number of the potential values for the cell
												{
													if( Newpotential[e] == true)
													{
														Newarray[e] = e;
													}
													else
													{
														Newarray[e] = 0;
													}
												}
																
												//Part B: Checking for similarity of the potentials of cells
																
												for (int z = 0; z < 10; z ++) //checking the similarity between the two cells, potential error if all 0s
												//going across the array row & Newarray row; that's what the z value represents
												{
													if (array[z] == Newarray[z]) //if it matches
													{
														if (z == 8)
														{
															boxSimilar = true;
														}
														//if it matches perfectly
													}
													else if (array[z] != Newarray[z]) //if it doesnt match
													{
														boxSimilar = false;
														break;
													}	
																	
												}
																
												//Part C: Changing the cell potentials
																
												if (boxSimilar == true)
												{
													for (int f = 0; f < 9; f ++) 
													{
														for (int g = 0; g < 0; g ++)
														//changing the potentials of the cell throughout the row
														{
															if (board[f][g] != board[x][y] && board[f][g] != board[c][d] 
																&& board[f][g].getNumber() == 0)
															{
																for (int z = 0; z < 10; z ++)
																{ //going across the array of potential numbers for the cell (0-9)
																	board[f][g].cantBe(array[z]);
																	changesMade ++;
																}
																				
																				
															}
															else
															{
																//do nothing
															}
														}
																		
																		
													}
												}
												else if (boxSimilar == false)
												{
													//do nothing if the the two cells being compared (x,y) & (c,d) aren't similar
												}
											}
											else
											{
												//do nothing if cell (c,d) does not equal zero
											}
										}
										else
										{
											//do nothing if the boxIDs aren't similar
										}
														
						
									}
								}
						
						}
						
						
					}
					else
					{
						//do nothing if the cell isn't empty
					}
				}
			}
			
			return changesMade;
		}
		
		public static boolean ZeroPotential(int vert, int hori) //to find if a cell has zero potential
		{
			boolean checker = false;
			solveForPotential(vert, hori); //solve for the potential values of the cell
			int occurence = 0;
			for (int a = 0; a < 10; a ++) 
			//this is the code that determines the number of the potential values for the cell
			{
				boolean[] potential = board[vert][hori].getPossible();		
				if( potential[a] == false)
				{
					occurence += 1;
				}
				else if (potential[a] == true)
				{
					//do nothing
				}

			}
					
			if (occurence == 10)
			{
				checker = true;
			}
			else
			{
				checker = false;

			}
					
			return checker;

		}
		
		public static void BoardToSubArray() //turning the board into an int array that can be stored in storage
		{
			for (int a = 0; a < 9; a++)
			{
				for (int b = 0; b < 9; b ++)
				{
					sub[a][b] = board[a][b].getNumber();
				}
			}
		}
		
		public static void SubArrayToBoard() //turning the sub array (which came from the "storage array" and copying it onto the board
		{
			for (int a = 0; a < 9; a++)
			{
				for (int b = 0; b < 9; b ++)
				{
					board[a][b].setNumber(sub[a][b]);
				}
			}
		}
		
		public static void GuessingValues() //the GUESSING CODE for SUDOKU SOLVER
		{
			Guess [] storage = new Guess [82]; //this is the array that stores all the potential "grids" of the guesses
			for (int a = 0; a < 82; a ++) //setting up the array of boards
			{
				storage[a] = new Guess();	//initializing it
				
			}
			
			sub = new int [9][9];
			BoardToSubArray();
			storage[0].setGuessGrid(sub);
			int tries = 0;
			//boolean revert = false;
			
			outsideloop:for(int x = 0; x < 9; x ++)
			{
				for (int y = 0; y < 9; y++)
				{			
					if (board[x][y].getNumber() == 0)
					{
						//STEP 1: SOLVING FOR THE POTENTIALS OF THE CELL//
						solveForPotential(x, y);
						boolean[] ptnls = board[x][y].getPossible(); //array that stores the potentials of a cell
						
						GuessLoop:for (int value = 0; value < 10; value ++)
						{
							if (ptnls[value] == true)
							{
								//STEP 2: GUESSING THE NUMBER 
								
								//System.out.println("The guess is: " +value);
								board[x][y].setNumber(value);
								
								tries ++;
								//System.out.println("The number tries taken is: " +tries);
								
								storage[tries].setX(x);
								storage[tries].setY(y);
								//System.out.println("Coord: (" +x +", " +y +")");
								
								logicCycles();
								
								sub = new int [9][9];
								BoardToSubArray();
								storage[tries].setGuessGrid(sub);
								
								//STEP 3: checking if there any any numbers with 0 potentials
								ZeroPotentialChecker: for (int c = 0; c < 9; c ++)
								{
									for (int d = 0; d < 9; d++)
									{
										if (board[c][d].getNumber() == 0)
										{
											boolean halt = ZeroPotential(c, d);
											
											if (halt == true) //if there is a value with a potential of 0
											{
												board[x][y].setNumber(0);
												int [][] blank = new int [9][9];
												storage[tries].setGuessGrid(blank);
												storage[tries].setX(0);
												storage[tries].setY(0);
												
												int [][]swap = storage[tries-1].getGuessGrid();
												sub = new int [9][9];
												for (int e = 0; e < 9; e ++)
												{
													for (int f = 0; f < 9; f ++)
													{
														sub[e][f] = swap[e][f];
													}
												}
												tries --;
												
												//resetting the board
												for(int n = 0; n < 9; n++)
													for(int m = 0 ; m < 9; m++)
													{
														board[n][m] = new Cell();
														findBoxID();
													}
												
												SubArrayToBoard(); //replacing the values
												
												//resolving all the potential values for every cell
												//this is b/c board gets reset every time to gets subbed in with new values
												for (int p = 0; p < 9; p++)
												{
													for (int o = 0; o < 9; o ++)
													{
														solveForPotential(p,o);
													}
												}
												
												//System.out.println("The grid has been reverted back to Grid " +tries);
												break ZeroPotentialChecker;
												//display();
												
												
											}
											else if (halt == false && c == 8 && d == 8)
											{
												break GuessLoop;
											}
											else if (halt == false)
											{
												//proceed as normal
											}
											
										}
										else
										{
											//do nothing if the value is not equal to zero
										}
									}
								}
								
						
							}
							else
							{
								//do nothing if "value" is not one of the potentials
							}
						}
						
						
					}
					else
					{
						//do nothing ifthe number is not equal to 0
					}
				}
			}
			
			//checking if the board has been finished
			if (isSolved() == true)
			{
				System.out.println("");
				System.out.println("");
				System.out.println("The Sudoku has been solved with Logic Cycles and then Guessing!");
			}
			else if (isSolved() == false)
			{
				System.out.println("The sudoku can't be solved with Guessing");
			}
			
			
			
			
		}
		

		
		
		

		///TODO: errorFound
		/*This method scans the board to see if any logical errors have been made.  
		 *It can detect this by looking for a cell that no longer has the potential to be 
		 * any number.
		 */
		//public boolean errorFound()
		//{
		//	
		//}
	}
