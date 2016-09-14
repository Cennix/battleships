package battleShipsv6;

public class Player 
{
	Board playerBoard;
	Board ShootingBoard;
	int playerNum;
	public Player(Board shipBoard, Board hitBoard, int num)
	{
		playerBoard = shipBoard;
		ShootingBoard = hitBoard;
		playerNum = num;
	}

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
	

	public String toString()
	{
		return ("Player " + playerNum);
	}

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
