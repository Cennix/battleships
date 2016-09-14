package battleShipsv4;

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
	
	public boolean checkLost()
	{
		boolean result = true;
		for(char[] array:playerBoard.array)
		{
			for(char item:array)
			{
				if(item == 'S') result = false;
			}
		}
		return result;
	}

	public String toString()
	{
		return ("Player "+ playerNum);
	}
}
