import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GameGrid {
	private ArrayList<ArrayList<Jewel>> gameGrid = new ArrayList<ArrayList<Jewel>>();

	public GameGrid(ArrayList<ArrayList<Jewel>> gameGrid) {
		this.gameGrid = gameGrid;
	}

	public ArrayList<ArrayList<Jewel>> getGameGrid() {
		return gameGrid;
	}

	public void setGameGrid(ArrayList<ArrayList<Jewel>> gameGrid) {
		this.gameGrid= gameGrid;
	}
	// updates game grid according to deleted jewels
	public void update_gameGrid() {
		boolean loop_over = false;
		while (loop_over == false) 
		{
			loop_over = true;
			
			for (ArrayList<Jewel> row : this.getGameGrid()) 
			{
				for (Jewel jewel : row) 
				{
					try 
					{
						if (jewel instanceof DeletedJewel && !(this.getGameGrid().get(jewel.getRow_coordinate()-1).get(jewel.getColumn_coordinate()) instanceof DeletedJewel)) 
						{	
							this.gameGrid.get(jewel.getRow_coordinate()).set(jewel.getColumn_coordinate(),this.gameGrid.get(jewel.getRow_coordinate()-1).get(jewel.getColumn_coordinate()));
							this.gameGrid.get(jewel.getRow_coordinate()).get(jewel.getColumn_coordinate()).setRow_coordinate(jewel.getRow_coordinate());
							this.gameGrid.get(jewel.getRow_coordinate()-1).set(jewel.getColumn_coordinate(),jewel);
							this.gameGrid.get(jewel.getRow_coordinate()-1).get(jewel.getColumn_coordinate()).setRow_coordinate(jewel.getRow_coordinate()-1);;
						    loop_over = false; 
						}
					}
					catch (Exception e) 
					{
						continue;
					}	
				}
			}
		}
	}
	// general show of game grid
	public void show_gameGrid(int score,BufferedWriter monitoring_writer) throws IOException {
		show_gameGrid(monitoring_writer);
		monitoring_writer.write("Score: " + score + " points");
		monitoring_writer.newLine();
		monitoring_writer.newLine();
	}
    // first show of game grid
	public void show_gameGrid(BufferedWriter monitoring_writer) throws IOException {
		for (ArrayList<Jewel> row : this.getGameGrid()) {
			for (Jewel jewel : row) {
				if (jewel instanceof Diamond) 
				{
					monitoring_writer.write("D ");
				}
				else if (jewel instanceof Square) 
				{
					monitoring_writer.write("S ");
				}
				else if (jewel instanceof Triangle) 
				{
					monitoring_writer.write("T ");
				}
				else if (jewel instanceof Wildcard) 
				{
					monitoring_writer.write("W ");
				}
				else if (jewel instanceof MinusSymbol) 
				{
					monitoring_writer.write("- ");
				}
				else if (jewel instanceof PlusSymbol) 
				{
					monitoring_writer.write("+ ");
				}
				else if (jewel instanceof LeftDiagonalSymbol) 
				{
					monitoring_writer.write("\\ ");
				}
				else if (jewel instanceof RightDiagonalSymbol) 
				{
					monitoring_writer.write("/ ");
				}
				else if (jewel instanceof VerticalSymbol) 
				{
					monitoring_writer.write("| ");
				}
				else 
				{
					monitoring_writer.write(" "+" ");
				}
			}
			monitoring_writer.newLine();
		}
		monitoring_writer.newLine();
	}
}