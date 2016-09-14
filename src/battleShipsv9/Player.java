package battleShipsv9;

public class Player 
{
	Board playerBoard;
	Board ShootingBoard;
	int playerNum;
	boolean isAI;
	
	// constructor
	public Player(Board shipBoard, Board hitBoard, int num)
	{
		playerBoard = shipBoard;
		ShootingBoard = hitBoard;
		playerNum = num;
		isAI = false;
	}
	
	
	/*
	 * Method for shooting at a player
	 * returns true if successful
	 * returns false if not successful
	 */
	public boolean shootAt(Player p2,int x, int y)
	{
		
		if(p2.playerBoard.array[y][x] == 'S') 
		{
			this.ShootingBoard.array[y][x] = 'H';
			p2.playerBoard.array[y][x] = 'D';
			
			return true;
		}
		else
		{
			this.ShootingBoard.array[y][x] = 'M';
			return false;
		}

	}
	
	// returns the player number
	public String toString()
	{
		return ("Player " + playerNum);
	}

	//checks if the player has any ships left in their board
	public boolean hasShipsLeft() 
	{
		for(int i = 0; i<playerBoard.array.length;i++)
		{
			for(int j = 0; j<playerBoard.array[i].length;j++)
			{
				if(playerBoard.array[i][j] == 'S') {return true;}
			}
		}
		return false;
	}
}
