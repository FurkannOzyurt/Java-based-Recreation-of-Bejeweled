import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		// Creating a game grid by using 2D array
		File game_grid_file = new File(args[0]);
		Scanner game_grid_reader = new Scanner(game_grid_file);
		ArrayList<ArrayList<Jewel>> gameGrid_matrix = new ArrayList<>();
		Gamegrid_Creator.create_gameGrid(game_grid_reader, gameGrid_matrix);
		GameGrid gameGrid = new GameGrid(gameGrid_matrix);
		// Reading commands and creating text files
		BufferedWriter monitoring_writer = new BufferedWriter(new FileWriter("monitoring.txt"));
		BufferedWriter leaderboard_writer = new BufferedWriter(new FileWriter("leaderboard.txt",true));
		File command_file = new File(args[1]);
		Scanner command_reader = new Scanner(command_file);
		ArrayList<Player> leaderboard_list = new ArrayList<>();
		FileManager.manage_file(monitoring_writer, leaderboard_writer, gameGrid, command_reader, leaderboard_list);
	}
}