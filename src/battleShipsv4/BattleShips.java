package battleShipsv4;
import java.util.Scanner;


public class BattleShips 
{
	public static void main(String[] args)
	{
		boolean gameActive = true;
		int size = 3;
		Scanner s = new Scanner(System.in);
		Player p1 = new Player(initializeBoard(s,size), new Board(size,size),1);
		Player p2 = new Player(initializeBoard(s,size), new Board(size,size),2);
		
		do
		{
			
			if(shootPlayer(s,p1,p2)) System.out.println("HIT!");
			if(shootPlayer(s,p2,p1)) System.out.println("HIT!");

			gameActive = false;

		} while (gameActive);
		s.close();
	}
	
	public static Board initializeBoard(Scanner s, int size)
	{
		Board board = new Board(3,3);
		System.out.println(board);
		for (int i = 0;i< 2;i++)
		{
			System.out.println("Please input the X position of the back of ship number "+ (i+1) +" (length 2)");
			int x = s.nextInt();
			System.out.println("Please input the Y position of the back of the "+ (i+1) + " ship (length 2)");
			int y = s.nextInt();
			System.out.println("Please input the orientation of the ship (N,S,E,W)");
			String orientation;
			do
			{
				orientation = s.nextLine();
				orientation = orientation.toUpperCase();

			}while(!(orientation.equals("N")||orientation.equals("S")||orientation.equals("E")||orientation.equals("W")));

			Ship ship = new Ship(x,y,orientation,2);
			try {
				if(!board.placeShip(ship))throw new Exception("INVALID PLACEMENT!");
				else System.out.println(board);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
		return board;
	}
	
	public static boolean shootPlayer(Scanner s,Player p1, Player p2)
	{
		System.out.println("Player 1, choose your shot!");
		System.out.println("Insert the X coordinate:");
		int x = s.nextInt();
		System.out.println("Insert the Y coordinate:");
		int y = s.nextInt();
		
		if(p1.shootAt(p2, x, y)) return true; else return false;
		
	}
}
