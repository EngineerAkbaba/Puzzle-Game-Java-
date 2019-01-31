import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Board_BFS
{
	private byte row; // Row of the board
	private byte column; // Column of the board
	private boolean isUp = true; // Moving to up
	private boolean isDown = true; // Moving to down
	private boolean isLeft = true; // Moving to left
	private boolean isRight = true; // Moving to right
	public Board_BFS parent; // The parent of the state we in it
	public Board_BFS sibling; // The brother of the state we int it
	public Board_BFS left_child; // The left child of the state we in it
	public Board_BFS right_child; // The right child of the state we in in
	public byte size; // The size of the board N
	public int hamming; // The hamming value 
	public int manhattan;  // The manhattan value
	public boolean isGoal; // Is the state we in it, goal?
	public boolean isSolvable; // Is the given initial board solvable?
	byte [][] blocks; // Board as two dimensional array
	int priority;
	byte [][]goal; // The goal state
	public boolean isgoal;
	byte array;
	public int key;
	
	// Constructor without parameter
	public Board_BFS()
	{
		
	}
	// Constructor with parameter
	public Board_BFS(byte size, int hamming, int manhattan, boolean isGoal,
			boolean isSolvable, byte [][] blocks, int priority, int [] hamming_size)
	{
		this.size = size;
		this.hamming = hamming;
		this.manhattan = manhattan;
		this.isGoal = isGoal;
		this.isSolvable = isSolvable;
		this.blocks = blocks;
		this.priority = priority;
		int a = 0;
		for (int i = 0; i < hamming_size.length; i++) 
		{
			for (int j = 0; j < hamming_size.length; j++)
			{
				if(hamming_size[i] < hamming_size[j])
					a = 1;
			}
		}
		this.priority = a;
	}
	
	// Read the initial board from the file
	public void ReadText() throws IOException 
	{
		String[] veriler = new String[2000]; // Define a string array
		FileReader read = new FileReader("input.txt");
		BufferedReader reader = new BufferedReader(read);
		String satir = new String();
		int i = 0;
		while((satir = reader.readLine()) != null) // Read until the end of the file
		{
			veriler[i] = satir;
			i++;
		}
		for(int j = 0; j < i; j++) // Print the board we read from the file, to the screen
		{
			System.out.println(veriler[j]);
		}
		reader.close();
	}
	
	public Board_BFS(byte [][] blocks)
	{
		int hamle = 0;
		int x = 0;
		int y = 0;
		for (int i = 0; i < blocks[0].length; i++)
		{
			for (int j = 0; j < blocks[1].length; j++)
			{
				if(blocks[i][j]==0)
				{
					x = i;
					y = j;
				}
				if(x-1 >= 0)
				{
					blocks[x][y] = blocks[x-1][y];
					blocks[x-1][y] = 0;
					hamle++;
				}
				if(x+1 <= blocks.length)
				{
					blocks[x][y] = blocks[x+1][y];
					blocks[x+1][y] = 0;
					hamle++;
				}
				if(y-1 >= 0)
				{
                  	blocks[x][y] = blocks[x][y-1];
					blocks[x][y-1] = 0;
					hamle++;
				}
				if(y+1 <= blocks.length)
				{
					blocks[x][y] = blocks[x][y+1];
					blocks[x][y+1] = 0;
					hamle++;
				}
			}
		}
	}
	
	byte[][] left(byte[][] temp)
	{
		boolean flag = false;
		int x = 0;
		int y = 0;
		for(int i = 0; i < temp.length; i++)
		{
			for(int k = 0; k < temp.length; k++)
			{
				if(temp[i][k] == 0)
				{
					x = i;
					y = k;
					flag = true;
					break;
				}
			}
			if(flag == true)
			{
				break;
			}
		}
		if(x == 0)
		{
			return null;
		}
		else
		{
			byte num = temp[x-1][y];
			temp[x-1][y] = temp[x][y];
			temp[x][y] = num;
			return temp;
		}
	}
	
	byte[][] right(byte[][] temp)
	{
		boolean flag = false;
		int x = 0;
		int y = 0;
		for(int i = 0; i < temp.length; i++)
		{
			for(int k = 0;k < temp.length; k++)
			{
				if(temp[i][k] == 0)
				{
					x = i;
					y = k;
					flag = true;
					break;
				}
			}
			if(flag == true)
			{
				break;
			}
		}
		if(x == 2)
		{
			return null;
		}
		else
		{
			byte num = temp[x+1][y];
			temp[x+1][y] = temp[x][y];
			temp[x][y] = num;
			return temp;
		}
	}
	
	byte[][] down(byte[][] temp)
	{
		boolean flag = false;
		int x = 0;
		int y = 0;
		for(int i = 0; i < temp.length; i++)
		{
			for(int k = 0; k<temp.length;k++)
			{
				if(temp[i][k] == 0)
				{
					x = i;
					y = k;
					flag = true;
					break;
				}
			}
			if(flag == true)
			{
				break;
			}
		}
		if(y == 2)
		{
			return null;
		}
		else
		{
			byte num = temp[x][y+1];
			temp[x][y+1] = temp[x][y];
			temp[x][y] = num;
			return temp;
		}
	}
	
	byte[][] up(byte[][] temp)
	{
		boolean flag = false;
		int x = 0;
		int y = 0;
		for(int i = 0; i < temp.length; i++)
		{
			for(int k = 0; k < temp.length; k++)
			{
				if(temp[i][k] == 0)
				{
					x = i;
					y = k;
					flag = true;
					break;
				}
			}
			if(flag == true)
			{
				break;
			}
		}
		if(y == 0)
		{
			return null;
		}
		else
		{
			byte num = temp[x][y-1];
			temp[x][y-1] = temp[x][y];
			temp[x][y] = num;
			return temp;
		}
	}
	
	public void write()
	{
		for (int i = 0; i < blocks.length; i++)
		{
			for (int j = 0; j < blocks[i].length; j++)
			{
				if(blocks[i][j] == 0)
				{
					System.out.print("X" + " ");
				}
				else
				{
					System.out.print(blocks[i][j] + " ");
				}
			}
			System.out.println();
		}
		System.out.println("---------");
	}
	
	// Move ability of the blocks
	public void setMoveAbility()
	{
		if(row-1 < 0)
		{
			isUp = false;
		}
		if(row+1 > blocks.length-1)
		{
			isDown = false;
		}
		if(column-1 < 0)
		{
			isLeft = false;
		}
		if(column+1 > blocks[0].length-1)
		{
			isRight = false;
		}
	}
		
	// Move the blocks up
	public void shiftUp()
	{
		if(isUp)
		{
			byte temp = blocks[row-1][column];
			blocks[row-1][column] = blocks[row][column];
			blocks[row][column] = temp;
			row = (byte)(row-1);
			setMoveAbility();
			//isShiftUp=false;
		}
	}
		
	// Move the blocks down
	public void shiftDown()
	{
		if(isDown)
		{
			byte temp = blocks[row+1][column];
			blocks[row+1][column] = blocks[row][column];
			blocks[row][column] = temp;
			row = (byte)(row+1);
			setMoveAbility();
			//isShiftDown=false;
		}
	}
		
	// Move the blocks left
	public void shiftLeft()
	{
		if(isLeft)
		{
			byte temp = blocks[row][column-1];
			blocks[row][column-1] = blocks[row][column];
			blocks[row][column] = temp;
			column = (byte)(column-1);
			setMoveAbility();
			//isShiftLeft=false;
		}
	}
		
	// Move the blocks right
	public void shiftRight()
	{
		if(isRight)
		{
			byte temp = blocks[row][column+1];
			blocks[row][column+1] = blocks[row][column];
			blocks[row][column] = temp;
			column = (byte)(column+1);
			setMoveAbility();
			//isShiftRight=false;
		}
	}
	
	public void move(int direction)
	{
		
	} 
	
	public Board_BFS getStateOnMovement(int direction)
	{
		return null; 
	} 
	
	public boolean movePossible(int direction)
	{
		return isGoal; 
	}
	
    public byte[] getPossibleMovements()
    {//hareketi mümkün mü?
    	return null;
	}
    
	public void expand()
	{ 
		
	}
	
	public boolean equals(Board_BFS anotherState) 
	{
		return isGoal; 
	}
	
	public boolean isGoalState()
	{
		return isGoal; 
	}
	
	public void print()
	{ 

	}
	
	public boolean isSolvablemethod()
	{
		return isSolvable; 
	}
	
	public boolean equals(Object y)    // does this board equal y?
	{
		return false;
	}   
	
	public Iterable<Board_BFS> neighbors()  // all neighboring boards
	{
		return null;
	}
	
	public String toString()// string representation of the board (in the output format specified below)
	{
		return null;
	}
	public byte getRow() {
		return row;
	}
	public void setRow(byte row) {
		this.row = row;
	}
	public byte getCol() {
		return column;
	}
	public void setCol(byte column) {
		this.column = column;
	}
	public boolean isUp() {
		return isUp;
	}
	public void setUp(boolean isUp) {
		this.isUp = isUp;
	}
	public boolean isDown() {
		return isDown;
	}
	public void setDown(boolean isDown) {
		this.isDown = isDown;
	}
	public boolean isLeft() {
		return isLeft;
	}
	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}
	public boolean isRight() {
		return isRight;
	}
	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}
	public Board_BFS getParent() {
		return parent;
	}
	public void setParent(Board_BFS parent) {
		this.parent = parent;
	}
	public Board_BFS getSibling() {
		return sibling;
	}
	public void setSibling(Board_BFS sibling) {
		this.sibling = sibling;
	}
	public Board_BFS getLeft_child() {
		return left_child;
	}
	public void setLeft_child(Board_BFS left_child) {
		this.left_child = left_child;
	}
	public Board_BFS getRight_child() {
		return right_child;
	}
	public void setRight_child(Board_BFS right_child) {
		this.right_child = right_child;
	}
	public byte getSize() {
		return size;
	}
	public void setSize(byte size) {
		this.size = size;
	}
	public int getHamming() {
		return hamming;
	}
	public void setHamming(int hamming) {
		this.hamming = hamming;
	}
	public int getManhattan() {
		return manhattan;
	}
	public void setManhattan(int manhattan) {
		this.manhattan = manhattan;
	}
	public boolean isGoal(BFS_Node temp) {
		return isGoal;
	}
	public void setGoal(boolean isGoal) {
		this.isGoal = isGoal;
	}
	public boolean isSolvable() {
		return isSolvable;
	}
	public void setSolvable(boolean isSolvable) {
		this.isSolvable = isSolvable;
	}
	public byte[][] getBlocks() {
		return blocks;
	}
	public void setBlocks(byte[][] blocks) {
		this.blocks = blocks;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public byte[][] getGoal() {
		return goal;
	}
	public void setGoal(byte[][] goal) {
		this.goal = goal;
	}
	public boolean isIsgoal() {
		return isgoal;
	}
	public void setIsgoal(boolean isgoal) {
		this.isgoal = isgoal;
	}
	public byte getArray() {
		return array;
	}
	public void setArray(byte array) {
		this.array = array;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
}
	
	