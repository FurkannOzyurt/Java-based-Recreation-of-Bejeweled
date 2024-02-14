import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class FileManager {
	public static void manage_file(BufferedWriter monitoring_writer,BufferedWriter leaderboard_writer,GameGrid gameGrid,Scanner command_reader,ArrayList<Player> leaderboard_list) throws IOException {
		monitoring_writer.write("Game grid:");
		monitoring_writer.newLine();
		monitoring_writer.newLine();
		gameGrid.show_gameGrid(monitoring_writer);
		int total_score = 0;
		while (command_reader.hasNext()) 
		{
			ArrayList<String> line = new ArrayList<String>(Arrays.asList(command_reader.nextLine().split(" ")));	
			if (line.size() == 2) 
			{
				monitoring_writer.write("Select coordinate or enter E to end the game: " + line.get(0) + " " + line.get(1));
				monitoring_writer.newLine();
				monitoring_writer.newLine();
				int row_input = Integer.parseInt(line.get(0));
				int column_input =  Integer.parseInt(line.get(1));
				try 
				{
					if (gameGrid.getGameGrid().get(row_input).get(column_input) instanceof DeletedJewel) 
					{
						monitoring_writer.write("Please enter a valid coordinate");
						monitoring_writer.newLine();
						monitoring_writer.newLine();
					} 
					else 
					{
						int score = gameGrid.getGameGrid().get(row_input).get(column_input).match(gameGrid);
						total_score += score;
						gameGrid.update_gameGrid();
						gameGrid.show_gameGrid(score,monitoring_writer);
					}	
				} 
				catch (Exception e) 
				{
					monitoring_writer.write("Please enter a valid coordinate");
					monitoring_writer.newLine();
					monitoring_writer.newLine();
				}
				
			} 
			else 
			{
				if (line.get(0).equals("E")) 
				{
					monitoring_writer.write("Select coordinate or enter E to end the game: " + line.get(0));
					monitoring_writer.newLine();
					monitoring_writer.newLine();
				} 
				else 
				{
					monitoring_writer.write("Total score: " + total_score);
					monitoring_writer.newLine();
					monitoring_writer.newLine();
					monitoring_writer.write("Enter name: " + line.get(0));
					monitoring_writer.newLine();
					monitoring_writer.newLine();
					Player player = new Player(line.get(0), total_score);
					leaderboard_list.add(player);
					leaderboard_writer.newLine();
					leaderboard_writer.write(player.getName() + " " + player.getScore());
					
					File leaderboard_file = new File("leaderboard.txt");
					Scanner leaderboard_reader = new Scanner(leaderboard_file);
					
					while (leaderboard_reader.hasNext()) {
						ArrayList<String> leaderboard_line = new ArrayList<String>(Arrays.asList(leaderboard_reader.nextLine().split(" ")));
						leaderboard_list.add(new Player(leaderboard_line.get(0),Integer.parseInt(leaderboard_line.get(1))));
						
					}
					leaderboard_reader.close();
					Collections.sort(leaderboard_list);
					
					int rank = leaderboard_list.size() - leaderboard_list.indexOf(player);
					if (rank == 1) 
					{
						monitoring_writer.write("Your rank is " + (rank) + "/" + leaderboard_list.size() + ", your score is " + (player.getScore() - leaderboard_list.get(leaderboard_list.indexOf(player)-1).getScore()) + " points higher than " + leaderboard_list.get(leaderboard_list.indexOf(player)-1).getName());
					}
					else if (rank == leaderboard_list.size()) {
						monitoring_writer.write("Your rank is " + (rank) + "/" + leaderboard_list.size() + ", your score is " + (leaderboard_list.get(leaderboard_list.indexOf(player)+1).getScore() - player.getScore()) + " points lower than " + leaderboard_list.get(leaderboard_list.indexOf(player)+1).getName());
					}
					else 
					{
						monitoring_writer.write("Your rank is " + (rank) + "/" + leaderboard_list.size() + ", your score is " + (leaderboard_list.get(leaderboard_list.indexOf(player)+1).getScore() - player.getScore()) + " points lower than " + leaderboard_list.get(leaderboard_list.indexOf(player)+1).getName() + " and " + (player.getScore() - leaderboard_list.get(leaderboard_list.indexOf(player)-1).getScore()) + " points higher than " + leaderboard_list.get(leaderboard_list.indexOf(player)-1).getName());
					}
					monitoring_writer.newLine();
					monitoring_writer.newLine();
					monitoring_writer.write("Good bye!");
				}
			}
		}
		command_reader.close();	
		monitoring_writer.close();
		leaderboard_writer.close();
	}
}