
public class DeletedJewel extends Jewel {

	public DeletedJewel(int row_coordinate, int column_coordinate) {
		super(row_coordinate, column_coordinate);
	}

	@Override
	int match(GameGrid gameGrid) {
		return 0;
	}
}