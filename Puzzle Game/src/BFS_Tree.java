
public class BFS_Tree
{
	BFS_Node root;
	BFS_HashTable h;
	int size;
	private boolean isvisited;
	
	public BFS_Tree ()
	{
		
	}
	
	public BFS_Tree(BFS_Node root)
	{
		this.size=size;
		this.root=root;
		
		h = new BFS_HashTable(1000);
		//root=new Node(size);
	}
	
	public BFS_Node bfs()
	{
		Board_BFS b = new Board_BFS();
		BFS_Node temp = new BFS_Node(b.parent);
		Queue q = new Queue(183000);
		q.enqueue(root);
		while(!q.isEmpty())
		{
			temp = (BFS_Node)q.dequeue();
			if (temp.getBoard().isGoal(temp))
			{
				break;
			}
			BFS_Node[] childss = childs(temp);
			for (int i = 0; i < childss.length; i++)
			{
				if (temp!=null&&childss[i]!=null)
				{
					q.enqueue(childss[i]);
					h.insert(childss[i].getBoard());
					childss[i].setParent(temp);
					childss[i].setLevel(childss[i].getParent().getLevel()+1);
				}
			}
		}
		return temp;
	}
	
	public BFS_Node[] childs(BFS_Node temp)
	{
		BFS_Node[] childs = new BFS_Node[4];
		for (int j = 0; j < childs.length; j++)
		{	
			childs[j] = child(j, temp);
			if (childs[j] !=  null&& h.search(childs[j].getBoard().getArray()))
			{
				childs[j] = null;	
			}
		}
		return childs;
	}
	
	public BFS_Node child(int position, BFS_Node temp)
	{
		temp.getBoard().getCol();
		temp.getBoard().getRow();
		byte[][] a = new byte[3][3];
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a.length; j++)
			{
				a[i][j] = getArray()[i][j];
			}
		}
		if (position == 0&& temp.getBoard().isUp()) 
		{
			byte x = a[temp.getBoard().getRow()-1][temp.getBoard().getCol()];
			a[temp.getBoard().getRow()-1][temp.getBoard().getCol()] = 0;
			a[temp.getBoard().getRow()][temp.getBoard().getCol()] = x;
			return new BFS_Node(new Board_BFS(a));
		}
		else if (position == 1 && temp.getBoard().isDown())
		{
            byte x = a[temp.getBoard().getRow()+1][temp.getBoard().getCol()];
            a[temp.getBoard().getRow()+1][temp.getBoard().getCol()] = 0;
            a[temp.getBoard().getRow()][temp.getBoard().getCol()] = x;
            return new BFS_Node(new Board_BFS(a));
		}
		else if (position == 2 && temp.getBoard().isLeft()) 
		{
            byte x = a[temp.getBoard().getRow()][temp.getBoard().getCol()-1];
            a[temp.getBoard().getRow()][temp.getBoard().getCol()-1] = 0;
            a[temp.getBoard().getRow()][temp.getBoard().getCol()] = x;
            return new BFS_Node(new Board_BFS(a));
		}
		else if (position == 3 && temp.getBoard().isRight()) 
		{
          byte x = a[temp.getBoard().getRow()][temp.getBoard().getCol()+1];
          a[temp.getBoard().getRow()][temp.getBoard().getCol()+1] = 0;
          a[temp.getBoard().getRow()][temp.getBoard().getCol()] = x;
          return new BFS_Node(new Board_BFS(a));
		}
		else
		{
			return null;
		}
	}

	private byte[][] getArray()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
