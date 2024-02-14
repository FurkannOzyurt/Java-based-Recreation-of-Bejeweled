
public class Square extends NormalJewel {

	private final int number_of_points = 15;
	public Square(int row_coordinate, int column_coordinate) {
		super(row_coordinate, column_coordinate);
	}

	@Override
	int match(GameGrid gameGrid) {
		int score = 0;
		try {
			if (gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()-2) instanceof Square && gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()-1) instanceof Square) 
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
			if (gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()+2) instanceof Square && gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()+1) instanceof Square) 
			{
				Jewel jewel1 = gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate());
				Jewel jewel2 = gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()+1);
				Jewel jewel3 = gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()+2);
				if (gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()).isPriority_match_found() == false) 
				{
					score = this.delete_match_pairs(jewel1, jewel2, jewel3, gameGrid);
					System.out.println(score);
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

    public int fake_match(GameGrid gameGrid) {
    	int score = 0;
		try {
			if (gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()-2).getClass().equals(gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()-1).getClass()) && gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()-1) instanceof NormalJewel) 
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
			if (gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()+2).getClass().equals(gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()+1).getClass()) && gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()+1) instanceof NormalJewel) 
			{
				Jewel jewel1 = gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate());
				Jewel jewel2 = gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()+1);
				Jewel jewel3 = gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()+2);
				if (gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()).isPriority_match_found() == false) 
				{
					score = this.delete_match_pairs(jewel1, jewel2, jewel3, gameGrid);
					System.out.println(score);
					gameGrid.getGameGrid().get(this.getRow_coordinate()).get(this.getColumn_coordinate()).setPriority_match_found(true);
				}
			}
		} 
		catch (Exception e) {
			;
		}
		return score;
	}
}