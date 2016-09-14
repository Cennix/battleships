package battleShipsv4;

public class Ship {

	int x, y;
	Orientation orientation;
	public int length;
	public Ship(int x, int y, String orient, int length) 
	{
		this.x = x;
		this.y = y;
		switch(orient)
		{
			case "N": 
				this.orientation = Orientation.NORTH;
				break;
			case "S":
				this.orientation = Orientation.SOUTH;
				break;
			case "E": 
				this.orientation = Orientation.EAST;
				break;
			case "W":
				this.orientation = Orientation.WEST;
				break;
			default:	
				this.orientation = Orientation.NORTH;
				break;			
		}
		this.length = length;

		
	}

}
