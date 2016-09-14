package battleShipsv5;

import java.util.Arrays;

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
				array[i][j] = 'W';
			}
		}
		
	}

	public boolean placeShip(Ship ship) 
	{
		if(!canPlace(ship)) {return false;}
		int multix = 0;
		int multiy = 0;
		switch(ship.orientation)
		{
		
		case NORTH:
			multix = 0;
			multiy = -1;
			break;
		case SOUTH:
			for( int i = 0; i < ship.length;i++)
			multix= 0;
			multiy = 1;
			break;
		case WEST:
			multix = -1;
			multiy = 0;
			break;
		case EAST:
			multix = 1;
			multiy= 0;
			break;
		default:
			break;
			
		
		}
		for( int i = 0; i < ship.length;i++)
		{
			array[ship.y + (i*multiy)][ship.x + (i*multix)] = 'S';
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
			returnString.append(Arrays.toString(array[i]) + "\n");
		}
		
		return returnString.toString();
	}
}
