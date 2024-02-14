
public abstract class Jewel {
	private final int number_of_points = 0; // all jewel classes have predetermined number of points
	private int row_coordinate;
	private int column_coordinate;
	private boolean priority_match_found; // finding the first match
	private boolean fake; // the jewel is actually a wildcard
	
	public Jewel(int row_coordinate, int column_coordinate) {
		this.row_coordinate = row_coordinate;
		this.column_coordinate = column_coordinate;
	}
	
	public int getRow_coordinate() {
		return row_coordinate;
	}

	public void setRow_coordinate(int row_coordinate) {
		this.row_coordinate = row_coordinate;
	}

	public int getColumn_coordinate() {
		return column_coordinate;
	}

	public void setColumn_coordinate(int column_coordinate) {
		this.column_coordinate = column_coordinate;
	}
	
	public boolean isPriority_match_found() {
		return priority_match_found;
	}

	public void setPriority_match_found(boolean priority_match_found) {
		this.priority_match_found = priority_match_found;
	}
	
	public boolean isFake() {
		return fake;
	}

	public void setFake(boolean fake) {
		this.fake = fake;
	} 
	
	public int getNumber_of_points() {
		return number_of_points;
	}
	// all jewel classes have different match rules
	// first determine the match
	// then calculate score
	// finally transform the jewels to deleted jewel
	abstract int match(GameGrid gameGrid);
	// match for wildcard 
	public int fake_match(GameGrid gameGrid) {
		return 0;
	}
	// transforms to deleted jewel
	public int delete_match_pairs(Jewel jewel1, Jewel jewel2, Jewel jewel3, GameGrid gameGrid) {
		Jewel[] jewel_array = {jewel1,jewel2,jewel3};
		int score = score(jewel_array);
		gameGrid.getGameGrid().get(jewel1.row_coordinate).set(jewel1.column_coordinate, new DeletedJewel(jewel1.row_coordinate, jewel1.column_coordinate));
		gameGrid.getGameGrid().get(jewel2.row_coordinate).set(jewel2.column_coordinate, new DeletedJewel(jewel2.row_coordinate, jewel2.column_coordinate));
		gameGrid.getGameGrid().get(jewel3.row_coordinate).set(jewel3.column_coordinate, new DeletedJewel(jewel3.row_coordinate, jewel3.column_coordinate));
		return score;
	}
	// calculates score
	public int score(Jewel[] jewel_array) {
		int score = 0;
		for (Jewel jewel : jewel_array) 
		{
			if (jewel.isFake() == true) {
				score += 10;
				
			}
			else {
				score += jewel.getNumber_of_points();
			}
		}
		return score;
	}	
}