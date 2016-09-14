package battleShipsv8;

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
	
	public Ship(int limitX, int limitY,int length)
	{
		this.x = (int) Math.floor(Math.random() * limitX);
		this.y = (int) Math.floor(Math.random() * limitY);
		double rand = Math.random();
		if(rand < 0.25)
		{
			this.orientation = Orientation.NORTH;
		}
		else if( rand < 0.5)
		{
			this.orientation = Orientation.SOUTH;
		}
		else if (rand < 0.75)
		{
			this.orientation = Orientation.EAST;
		}
		else
		{
			this.orientation = Orientation.WEST;
		}
		
		this.length = length;
	}

}
