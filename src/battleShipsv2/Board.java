package battleShipsv2;

public class Board 
{
	char[][] array;
	
	public Board(int x, int y)
	{
		array = new char[x][y];
		for(int i = 0;i<array.length;i++)
		{
			for(int j = 0;j<array[i].length;j++)
			{
				array[i][j] = 'X';
			}
		}
		
	}

	public boolean placeShip(Ship ship) 
	{
		if(!canPlace(ship)) {return false;}
		int multi = 1;
		switch(ship.orientation)
		{
		
		case NORTH:
			multi = -1;
		case SOUTH:
			for( int i = 0; i < ship.length;i++)
			{
				array[ship.y + (i*multi)][ship.x] = 'S';
			}
			break;
		case WEST:
			multi = -1;
		case EAST:
			for( int i = 0; i < ship.length;i++)
			{
				array[ship.y][ship.x + (i*multi)] = 'S';
			}
			break;
		default:
			break;
			
		}
		return true;
		
		
	}

	private boolean canPlace(Ship ship) {
		// TODO Auto-generated method stub
		int multi = 1;
		int shipBow;
		switch(ship.orientation)
		{
		
		case NORTH:
			multi = -1;
		case SOUTH:
			shipBow = ship.y + (multi * (ship.length-1));
			if(shipBow < 0 || shipBow >= array.length) return false;
			for( int i = 0; i < ship.length;i++)
			{
				if(array[ship.y + (i*multi)][ship.x] == 'S') return false;
			}
			break;
		case WEST:
			multi = -1;
		case EAST:
			shipBow = ship.x + (multi * (ship.length-1));
			if(shipBow < 0 || shipBow >= array[ship.y].length) return false;
			for( int i = 0; i < ship.length;i++)
			{
				if(array[ship.y][ship.x + (i*multi)] == 'S') return false;
			}
			break;
		default:
			break;
			
		}
		return true;
	}
	
	public String toString()
	{
		StringBuilder returnString = new StringBuilder();
		for (int i = 0;i< array.length;i++)
		{
			for(int j = 0;j<array[i].length;j++)
			{
				returnString.append(array[i][j] + ",");
			}
			returnString.append("\n");
		}
		
		return returnString.toString();
	}
}
