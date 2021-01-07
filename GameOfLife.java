import java.util.Random;
public class GameOfLife 
{
	public static void start()
	{
		int firstGeneration[][]; //2D Array for firstGeneration;

		firstGeneration = generateFirstGeneration(); //Generate firstGeneration

		gameOfLifeNextGeneration(firstGeneration); //Get NextGeneration
	}

	public static int[][] generateFirstGeneration()
	{
		/* Static Data	int[][] firstGeneration = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 	             { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 }, 	             { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, 	             { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 	             { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 	             { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 }, 	             { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 }, 	             { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 }, 	             { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, 	             { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } 	         };

	  	Lets Generate Dynamic Random Values*/

	  	Random rand = new Random(); //instance of random class
      	int binaryGridData = 2;
		int[][] firstGeneration = new int[10][10];
		for(int i=0; i<firstGeneration.length; i++)
		{
			for(int j=0; j<firstGeneration[0].length; j++)
			{
				firstGeneration[i][j] = rand.nextInt(binaryGridData); 
			}
		}

		System.out.println("Random Generated Data: ");

		printGeneration(firstGeneration);

		return firstGeneration;
	}

	public static void printGeneration(int[][] firstGeneration)
	{
		for(int i=0; i<firstGeneration.length;i++)
		{
			for(int j=0;j<firstGeneration[0].length;j++)
			{
				System.out.print(firstGeneration[i][j]);
			}
			System.out.println();
		}
	}

	public static int[][] gameOfLifeNextGeneration(int[][] firstGeneration)
	{
		int heightOfBoard = firstGeneration.length; //heightOfBoard
		int widthOfBoard = firstGeneration[0].length; //widthOfBoard

		int[][] nextGeneration = new int[heightOfBoard][widthOfBoard];

		int[][] neighbourCellCordinate = new int[][]
		{
			{-1, 0},
			{-1, 1},
			{0,  1},
			{1,  1},
			{1,  0},
			{1, -1},
			{0, -1},
			{-1, -1},
		};

		for(int i=0; i < heightOfBoard;i++)
		{
			for(int j = 0; j < widthOfBoard; j++)
			{
				int aliveCount = 0;
				for(int[] dir : neighbourCellCordinate)
				{

					int xCordinate = dir[0] + i; //taking X Co-ordinate of Cell
					int yCordinate = dir[1] + j; //taking Y Co-ordinate of Cell

					if( xCordinate >= 0 && xCordinate < heightOfBoard && 
						yCordinate >=0  && yCordinate < widthOfBoard  && 
						firstGeneration[xCordinate][yCordinate] == 1 ) //Checking whether Cell is not out of range and cell should be Alive Cell
					{
						aliveCount++;
					}
				}
				if(firstGeneration[i][j] == 0 && aliveCount == 3)
				{
					nextGeneration[i][j] = 1;
				}
				else if(firstGeneration[i][j] == 1)
				{
					if(aliveCount == 2 || aliveCount == 3)
					{
						nextGeneration[i][j] =1;
					}
				}
			}
		}

		for(int i=0; i<heightOfBoard;i++)
		{
			for(int j = 0; j<widthOfBoard; j++)
			{
				firstGeneration[i][j] = nextGeneration[i][j];
			}
		}
		System.out.println("Next Generatation Data: ");
		printGeneration(firstGeneration);
		return firstGeneration;
	}
	
}
