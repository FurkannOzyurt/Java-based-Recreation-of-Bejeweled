import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Gamegrid_Creator {
	public static void create_gameGrid(Scanner game_grid_reader,ArrayList<ArrayList<Jewel>> gameGrid_matrix) {
		int row = 0;
		while (game_grid_reader.hasNext()) {
			ArrayList<Object> line = new ArrayList<Object>(Arrays.asList(game_grid_reader.nextLine().split(" ")));
			ArrayList<Jewel> matrix_row = new ArrayList<>();
			for (int column = 0; column < line.size(); column++) {
				if (line.get(column).equals("D")) 
				{
					matrix_row.add(new Diamond(row, column));
				}
				else if (line.get(column).equals("S")) 
				{
					matrix_row.add(new Square(row, column));
				}
				else if (line.get(column).equals("T")) 
				{
					matrix_row.add(new Triangle(row, column));
				}
				else if (line.get(column).equals("W")) 
				{
					matrix_row.add(new Wildcard(row, column));
				}
				else 
				{
					if (line.get(column).equals("/")) 
					{
						matrix_row.add(new RightDiagonalSymbol(row, column));
					}
					else if (line.get(column).equals("-")) 
					{
						matrix_row.add(new MinusSymbol(row, column));
					}
					else if (line.get(column).equals("+")) 
					{
						matrix_row.add(new PlusSymbol(row, column));
					}
					else if (line.get(column).equals("|"))
					{
						matrix_row.add(new VerticalSymbol(row, column));
					}
					else 
					{
						matrix_row.add(new LeftDiagonalSymbol(row, column));
					}
				}
			}
			gameGrid_matrix.add(matrix_row);
			row++;
		}
		game_grid_reader.close();
	}
}