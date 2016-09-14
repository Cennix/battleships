package battleShipsv6;
import java.util.Scanner;


public class BattleShips 
{
	public static void main(String[] args)
	{
		boolean gameActive = true;
		int size = 3;
		Scanner s = new Scanner(System.in);
		Player p1 = new Player(initializeBoard(s,size), new Board(size,size), 1);
		Player p2 = new Player(initializeBoard(s,size), new Board(size,size), 2);

		do
		{

			if(shootPlayer(s,p1,p2)) System.out.println("HIT!");
			if(!p2.hasShipsLeft())
			{
				gameActive = false;
				System.out.println("Player 1 has Won!");
				break;
			}


			if(shootPlayer(s,p2,p1)) System.out.println("HIT!");
			if(!p1.hasShipsLeft())
			{
				gameActive = false;
				System.out.println("Player 2 has Won!");
			}



		} while (gameActive);
		s.close();
	}

	public static Board initializeBoard(Scanner s, int size)
	{
		Board board = new Board(12,12);
		System.out.println(board);
		int[] shipLengths = {2,2,3,3,3,4,5};
		for (int i = 0;i< shipLengths.length;i++)
		{
			Ship ship = createShip(s, shipLengths[i]);
			try {
				if(!board.placeShip(ship))throw new Exception("INVALID PLACEMENT!");
				else System.out.println(board);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(0);
			}
		}
		return board;
	}

	public static boolean shootPlayer(Scanner s,Player p1, Player p2)
	{
		System.out.println(p1.ShootingBoard);
		System.out.println("Player 1, choose your shot!");
		System.out.println("Insert the X coordinate:");
		int x = s.nextInt()-1;
		System.out.println("Insert the Y coordinate:");
		int y = s.nextInt()-1;

		if(p1.shootAt(p2, x, y)) return true; else return false;

	}

	public static Ship createShip(Scanner s, int length)
	{
		System.out.println("Please input the X position of the stern of ship (length "+length +")");
		int x = s.nextInt()-1;
		System.out.println("Please input the Y position of the stern of ship (length "+length +")");
		int y = s.nextInt()-1;
		System.out.println("Please input the orientation of the ship (N,S,E,W)");
		String orientation;
		do
		{
			orientation = s.nextLine();
			orientation = orientation.toUpperCase();

		}while(!(orientation.equals("N")||orientation.equals("S")||orientation.equals("E")||orientation.equals("W")));

		return new Ship(x,y,orientation,length);
	}

}
