package battleShipsv8;


public class AIPlayer extends Player 
{
	//constructor for an AI player
	public AIPlayer(Board shipBoard, Board hitBoard, int num) 
	{
		super(shipBoard, hitBoard, num);
		isAI = true;
	}
	// method for an AI player to shoot at another player, returns true if successful, false if a miss
	public boolean shootAt(Player p2)
	{
		int x;
		int y;
		
		do
		{
			x = (int) Math.floor(Math.random() * this.ShootingBoard.array[0].length);
			y = (int) Math.floor(Math.random() * this.ShootingBoard.array.length);
		}
		while(this.ShootingBoard.array[y][x]!='W');
		
		return shootAt(p2,x,y);
	}
	
	
	// deploys all the ships on the board
	public void deployShips()
	{
		int[] shipLengths = {2,2,3,3,3,4,5};

		for(int i = 0;i< shipLengths.length;i++)
		{
			Ship ship;
			do
			{
				ship = new Ship(playerBoard.array.length,playerBoard.array[0].length,shipLengths[i]);
			}while(!playerBoard.placeShip(ship));

		}
	}

}
