import java.util.ArrayList;

public class Wildcard extends NormalJewel {
	private final int number_of_points = 10;
	public Wildcard(int row_coordinate, int column_coordinate) {
		super(row_coordinate, column_coordinate);
	}

	@Override
	int match(GameGrid gameGrid) {
		int score = 0;
		ArrayList<Jewel> jewels = new ArrayList<>();
		jewels.add(new Triangle(getRow_coordinate(), getColumn_coordinate()));
		jewels.add(new Square(getRow_coordinate(), getColumn_coordinate()));
		jewels.add(new Diamond(getRow_coordinate(), getColumn_coordinate()));
		int i = 0;
		while (!(gameGrid.getGameGrid().get(getRow_coordinate()).get(getColumn_coordinate()) instanceof DeletedJewel) && (i<jewels.size()) && (score == 0)) 
		{
			gameGrid.getGameGrid().get(getRow_coordinate()).set(getColumn_coordinate(),jewels.get(i));
			gameGrid.getGameGrid().get(getRow_coordinate()).get(getColumn_coordinate()).setFake(true);
			score = gameGrid.getGameGrid().get(getRow_coordinate()).get(getColumn_coordinate()).fake_match(gameGrid);
			if (score != 0) {
				return score;
			}
			else {
				gameGrid.getGameGrid().get(getRow_coordinate()).set(getColumn_coordinate(),new Wildcard(getRow_coordinate(), getColumn_coordinate()));
				if (i==0) {
					score = triangle_rule(gameGrid, score);
				}
				else if (i==1) {
					score = square_rule(gameGrid, score);
				}
				else {
					score = diamond_rule(gameGrid, score);
				}
			}
			i++;
		}
		return score;
	}
	
	public int triangle_rule(GameGrid gameGrid, int score) {
		try {
			if ((gameGrid.getGameGrid().get(this.getRow_coordinate()-2).get(this.getColumn_coordinate()) instanceof Wildcard && gameGrid.getGameGrid().get(this.getRow_coordinate()-1).get(this.getColumn_coordinate()) instanceof NormalJewel)||(gameGrid.getGameGrid().get(this.getRow_coordinate()-2).get(this.getColumn_coordinate()) instanceof NormalJewel && gameGrid.getGameGrid().get(this.getRow_coordinate()-1).get(this.getColumn_coordinate()) instanceof Wildcard)) 
			{
				Jewel jewel1 = gameGrid.getGameGrid().get(this.getRow_coordinate()-2).get(this.getColumn_coordinate());
				Jewel jewel2 = gameGrid.getGameGrid().get(this.getRow_coordinate()-1).get(this.getColumn_coordinate());
				Jewel jewel3 = gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate());
				if (gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()).isPriority_match_found() == false) 
				{
					score = this.delete_match_pairs(jewel1, jewel2, jewel3, gameGrid);
					gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()).setPriority_match_found(true);
					
				}
			}
		}
		catch (Exception e) {
			;
		}
		try {
			if ((gameGrid.getGameGrid().get(this.getRow_coordinate()+2).get(this.getColumn_coordinate()) instanceof Wildcard && gameGrid.getGameGrid().get(this.getRow_coordinate()+1).get(this.getColumn_coordinate()) instanceof NormalJewel)||(gameGrid.getGameGrid().get(this.getRow_coordinate()+2).get(this.getColumn_coordinate()) instanceof NormalJewel && gameGrid.getGameGrid().get(this.getRow_coordinate()+1).get(this.getColumn_coordinate()) instanceof Wildcard)) 
			{
				Jewel jewel1 = gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate());
				Jewel jewel2 = gameGrid.getGameGrid().get(this.getRow_coordinate()+1).get(this.getColumn_coordinate());
				Jewel jewel3 = gameGrid.getGameGrid().get(this.getRow_coordinate()+2).get(this.getColumn_coordinate());
				if (gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()).isPriority_match_found() == false) 
				{
					score = this.delete_match_pairs(jewel1, jewel2, jewel3, gameGrid);
					gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()).setPriority_match_found(true);
					
				}
			}
		} catch (Exception e) {
			;
		}
		return score;
	}
	
	public int square_rule(GameGrid gameGrid, int score) {
		try {
			if ((gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()-2) instanceof Wildcard && gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()-1) instanceof NormalJewel)||(gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()-2) instanceof NormalJewel && gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()-1) instanceof Wildcard)) 
			{
				Jewel jewel1 = gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()-2);
				Jewel jewel2 = gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()-1);
				Jewel jewel3 = gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate());
				if (gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()).isPriority_match_found() == false) 
				{
					score = this.delete_match_pairs(jewel1, jewel2, jewel3, gameGrid);
					gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()).setPriority_match_found(true);
					
				}
			}
		}
		catch (Exception e) {
			;
		}
		try {
			if ((gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()+2) instanceof Wildcard && gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()+1) instanceof NormalJewel)||(gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()+2) instanceof NormalJewel && gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()+1) instanceof Wildcard)) 
			{
				Jewel jewel1 = gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate());
				Jewel jewel2 = gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()+1);
				Jewel jewel3 = gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()+2);
				if (gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()).isPriority_match_found() == false) 
				{
					score = this.delete_match_pairs(jewel1, jewel2, jewel3, gameGrid);
					gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()).setPriority_match_found(true);
					
				}
			}
		} 
		catch (Exception e) {
			;
		}
		return score;
	}
	
	public int diamond_rule(GameGrid gameGrid, int score) {
		try {
			if ((gameGrid.getGameGrid().get(this.getRow_coordinate()-2).get(this.getColumn_coordinate()-2) instanceof Wildcard && gameGrid.getGameGrid().get(this.getRow_coordinate()-1).get(this.getColumn_coordinate()-1) instanceof NormalJewel)||(gameGrid.getGameGrid().get(this.getRow_coordinate()-2).get(this.getColumn_coordinate()-2) instanceof NormalJewel && gameGrid.getGameGrid().get(this.getRow_coordinate()-1).get(this.getColumn_coordinate()-1) instanceof Wildcard)) 
			{
				Jewel jewel1 = gameGrid.getGameGrid().get(this.getRow_coordinate()-2).get(this.getColumn_coordinate()-2);
				Jewel jewel2 = gameGrid.getGameGrid().get(this.getRow_coordinate()-1).get(this.getColumn_coordinate()-1);
				Jewel jewel3 = gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate());
				if (gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()).isPriority_match_found() == false) 
				{
					score = this.delete_match_pairs(jewel1, jewel2, jewel3, gameGrid);
					gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()).setPriority_match_found(true);
					
				}
			}
		}
		catch (Exception e) {
			;
		}
		try {
			if ((gameGrid.getGameGrid().get(this.getRow_coordinate()+2).get(this.getColumn_coordinate()+2) instanceof Wildcard && gameGrid.getGameGrid().get(this.getRow_coordinate()+1).get(this.getColumn_coordinate()+1) instanceof NormalJewel)||(gameGrid.getGameGrid().get(this.getRow_coordinate()+2).get(this.getColumn_coordinate()+2) instanceof NormalJewel && gameGrid.getGameGrid().get(this.getRow_coordinate()+1).get(this.getColumn_coordinate()+1) instanceof Wildcard)) 
			{
				Jewel jewel1 = gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate());
				Jewel jewel2 = gameGrid.getGameGrid().get(this.getRow_coordinate()+1).get(this.getColumn_coordinate()+1);
				Jewel jewel3 = gameGrid.getGameGrid().get(this.getRow_coordinate()+2).get(this.getColumn_coordinate()+2);
				if (gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()).isPriority_match_found() == false) 
				{
					score = this.delete_match_pairs(jewel1, jewel2, jewel3, gameGrid);
					gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()).setPriority_match_found(true);
				}
			}
		} 
		catch (Exception e) {
			;
		}
		try {
			if ((gameGrid.getGameGrid().get(this.getRow_coordinate()-2).get(this.getColumn_coordinate()+2) instanceof Wildcard && gameGrid.getGameGrid().get(this.getRow_coordinate()-1).get(this.getColumn_coordinate()+1) instanceof NormalJewel)||(gameGrid.getGameGrid().get(this.getRow_coordinate()-2).get(this.getColumn_coordinate()+2) instanceof NormalJewel && gameGrid.getGameGrid().get(this.getRow_coordinate()-1).get(this.getColumn_coordinate()+1) instanceof Wildcard)) 
			{
				Jewel jewel1 = gameGrid.getGameGrid().get(this.getRow_coordinate()-2).get(this.getColumn_coordinate()+2);
				Jewel jewel2 = gameGrid.getGameGrid().get(this.getRow_coordinate()-1).get(this.getColumn_coordinate()+1);
				Jewel jewel3 = gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate());
				if (gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()).isPriority_match_found() == false) 
				{
					score = this.delete_match_pairs(jewel1, jewel2, jewel3, gameGrid);
					gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()).setPriority_match_found(true);
					
				}
			}
		} 
		catch (Exception e) {
			;
		}	
		try {
			if ((gameGrid.getGameGrid().get(this.getRow_coordinate()+1).get(this.getColumn_coordinate()-1) instanceof Wildcard && gameGrid.getGameGrid().get(this.getRow_coordinate()+2).get(this.getColumn_coordinate()-2) instanceof NormalJewel)||(gameGrid.getGameGrid().get(this.getRow_coordinate()+1).get(this.getColumn_coordinate()-1) instanceof NormalJewel && gameGrid.getGameGrid().get(this.getRow_coordinate()+2).get(this.getColumn_coordinate()-2) instanceof Wildcard)) 
			{
				Jewel jewel1 = gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate());
				Jewel jewel2 = gameGrid.getGameGrid().get(this.getRow_coordinate()+1).get(this.getColumn_coordinate()-1);
				Jewel jewel3 = gameGrid.getGameGrid().get(this.getRow_coordinate()+2).get(this.getColumn_coordinate()-2);
				if (gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()).isPriority_match_found() == false) 
				{
					score = this.delete_match_pairs(jewel1, jewel2, jewel3, gameGrid);
					gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()).setPriority_match_found(true);
					
				}
			}
		} 
		catch (Exception e) {
			;
		}
		return score;
	}

	public int getNumber_of_points() {
		return number_of_points;
	}
}
