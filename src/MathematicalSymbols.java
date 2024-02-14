
public abstract class MathematicalSymbols extends Jewel {
	private final int number_of_points = 20;
	public MathematicalSymbols(int row_coordinate, int column_coordinate) {
		super(row_coordinate, column_coordinate);
	}
	public int getNumber_of_points() {
		return number_of_points;
	}
}
