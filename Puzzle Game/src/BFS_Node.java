
public class BFS_Node
{
	public byte[][] value;
	public int key;
	private Board_BFS board;
	private BFS_Node parent;
	private BFS_Node child1;
	private BFS_Node child2;
	private BFS_Node child3;
	private BFS_Node child4;
	private int level;
	
	public BFS_Node(Board_BFS root)
	{
		super();
			level=0;
		
		this.board=root;
		
	}
	public Board_BFS getBoard()
	{
		return board;
	}
	public BFS_Node getChild3()
	{
		return child3;
	}
	public void setChild3(BFS_Node child3)
	{
		this.child3 = child3;
	}
	public BFS_Node getChild4()
	{
		return child4;
	}
	public void setChild4(BFS_Node child4)
	{
		this.child4 = child4;
	}
	public void setBoard(Board_BFS board)
	{
		this.board = board;
	}
	public BFS_Node getParent()
	{
		return parent;
	}
	public void setParent(BFS_Node parent)
	{
		this.parent = parent;
	}
	public BFS_Node getChild1()
	{
		return child1;
	}
	public void setChild1(BFS_Node child1)
	{
		this.child1 = child1;
	}
	public BFS_Node getChild2()
	{
		return child2;
	}
	public void setChild2(BFS_Node child2)
	{
		this.child2 = child2;
	}
	public int getLevel()
	{
		return level;
	}
	public void setLevel(int level)
	{
		this.level = level;
	}
}
