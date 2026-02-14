import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    // Historical Jersey Numbers & Years Retired
    int[][] numbersData = {
      {12, 1984}, // The 12th Man
      {80, 2004}, // Steve Largent
      {71, 2005}  // Walter Jones
    };

    // Defensive Stats for the "Legion of Boom" (INTs, Tackles, Fumbles)
    int[][] defenseStats = {
      {8, 60, 2}, // Richard Sherman
      {5, 90, 3}, // Earl Thomas
      {2, 100, 4} // Kam Chancellor
    };

    // Instantiate Scene subclass objects
    HistoryScene scene1 = new HistoryScene(numbersData);
    DefenseScene scene2 = new DefenseScene(defenseStats);
    
    // Call drawScene methods in each subclass
    scene1.drawScene();
    scene2.drawScene();
    
    // Play scenes in Theater
    Theater.playScenes(scene1, scene2);
  }
}
