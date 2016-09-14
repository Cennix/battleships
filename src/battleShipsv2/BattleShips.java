package battleShipsv2;
import java.util.Scanner;


public class BattleShips 
{
	public static void main(String[] args)
	{
		boolean gameActive = true;
		Board board = new Board(3,3);
		Scanner s = new Scanner(System.in);
		do
		{

			System.out.println(board);
			for (int i = 0;i< 2;i++)
			{
				System.out.println("Please input the X position of the back of ship number"+ (i+1) +" (length 2)");
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
					gameActive = false;
				}
			}

			gameActive = false;

		} while (gameActive);
		s.close();
	}
}
