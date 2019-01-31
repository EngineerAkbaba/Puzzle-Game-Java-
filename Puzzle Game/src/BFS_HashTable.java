class BFS_HashTable
{
	BFS_Node[] hashTable = new BFS_Node [500];
	BFS_Node[] newHashTable = new BFS_Node[1000];
	int counter = 0;
	int place = 0;
	private int size;
	Board_BFS b = new Board_BFS();
	
	// Hash function1
	int hash_function1(int key, int capacity)
	{
		return (key*key)%capacity;
	}
	
	// Hash function2
	int hash_function2(int key)
	{
		return (7-(key%7));
	}
	
	public BFS_HashTable (int size)
	{
		this.size = size;
	}
	
	public void insert(Board_BFS board)
	{
		 place = hash_function1(board.key, hashTable.length);
		//buradan tablodaki yeri olarak þimdilik alalým
		if(hashTable[place] == null)
		{//eðer boþ  ise
			hashTable[place] = new BFS_Node(b.parent);
		}
		else
		{
			do
			{
				place = hash_function2(place);
				//boþ olan yeri bulana kadar ikinci foksiyonu döndür
			}while(hashTable[place] != null);
			hashTable[place] = new BFS_Node(board);
		}
		counter++;
	}
	
	boolean search(byte c)
	{
		boolean flag = true;
		place = hash_function1(c, hashTable.length);
		for (int i = 0; i < c; i++)
		{
			for (int j = 0; j < c; j++)
			{
				if(hashTable[place] != null)
				{
					if(hashTable[place] != (Object)c)
					{
						flag = false;
					}
				}
				else
				{
					flag = false;
				}
			}
		}
		return flag;
	}
}
