package battleShipsv8;
import java.util.Scanner;


public class BattleShips 
{
	public static void main(String[] args)
	{
		// set the game to active
		boolean gameActive = true;
		// initialise the size of the boards
		int size = 12;
		//initialise the scanner
		Scanner s = new Scanner(System.in);

		//sort out vs AI or not?
		System.out.println("Would you like to play 2 player, vs AI or 2 ai's vs each other? (2/V/B)");


		String scannerIn = s.nextLine();

		//booleans for the AI.
		boolean ai = scannerIn.toUpperCase().equals("V");
		boolean p1ai = scannerIn.toUpperCase().equals("B");

		// empty player classes
		Player p1;
		Player p2;

		// Set up players for both AI and normal play
		if(p1ai)
		{
			p1 = new AIPlayer(new Board(size,size), new Board(size,size),1);
			((AIPlayer) p1).deployShips();
			System.out.println("P1 deployed!");
		}
		else
		{
			p1 = new Player(initializeBoard(s,size), new Board(size,size), 1);
		}
		if(ai|| p1ai)
		{
			p2 = new AIPlayer(new Board(size,size), new Board(size,size),2);
			((AIPlayer) p2).deployShips();
			System.out.println("P2 deployed!");
		}
		else
		{
			p2 = new Player(initializeBoard(s,size), new Board(size,size), 2);
		}

		Player temp;
		int i = 2;
		do
		{
			System.out.println("Turn: " + (i/2) + "\t - Player "+p1.playerNum + " Shoot!");
			gameActive = playerTurn(p1,p2,s);
			if(gameActive)
			{
				temp = p1;
				p1 = p2;
				p2 = temp;
				i++;
			}


		} while (gameActive);

		System.out.println("Ship Map:\n" + p1.playerBoard +"\nHit Map: \n" +p1.ShootingBoard);
		s.close();
	}

	public static Board initializeBoard(Scanner s, int size)
	{
		Board board = new Board(size,size);
		System.out.println(board);
		int[] shipLengths = {2,2,3,3,3,4,5};
		for (int i = 0;i< shipLengths.length;i++)
		{
			Ship ship;
			do
			{
				ship = createShip(s, shipLengths[i]);
				if(!board.canPlace(ship)) System.out.println("Invalid Ship Placement! please try again.");
			}while(!board.placeShip(ship));
			System.out.println(board);
		}
		return board;
	}
	
	public static boolean playerTurn(Player p1, Player p2, Scanner s)
	{
		if(p1.isAI)
		{
			if(((AIPlayer) p1).shootAt(p2)) System.out.println("Hit!"); else System.out.println("Miss!");
		}
		else
		{
			if(shootPlayer(s,p1,p2)) System.out.println("Hit!"); else System.out.println("Miss!");
		}

		if(!p2.hasShipsLeft())
		{
			System.out.println("Player"+p1.playerNum+" has Won!");
			return false;
		}
		else
		{
			return true;
		}

	}

	public static boolean shootPlayer(Scanner s,Player p1, Player p2)
	{
		System.out.println(p1.ShootingBoard);
		System.out.println("Player "+p1+", choose your shot!");
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


		String orientation;
		do
		{
			System.out.println("Please input the orientation of the ship (N,S,E,W)");
			orientation = s.nextLine();
			orientation = orientation.toUpperCase();

		}while(!(orientation.equals("N")||orientation.equals("S")||orientation.equals("E")||orientation.equals("W")));

		return new Ship(x,y,orientation,length);
	}

	

}
