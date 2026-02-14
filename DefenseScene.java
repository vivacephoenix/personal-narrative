import org.code.theater.*;

public class DefenseScene extends Scene {
  private int[][] stats;

  public DefenseScene(int[][] stats) {
    this.stats = stats;
  }

  /*
   * Orchestrates Defense visualization.
   * Uses Grayscale and Mirror filters.
   */
  public void drawScene() {
    clear("green");
    setTextColor("navy");
    setTextHeight(35);
    
    drawText("Legion of Boom", 75, 45);
    
    ImageFilter player = new ImageFilter("defense.jpg");
    drawImage(player, 0, 60, 400);
    pause(1.5);
    
    // Mirror
    player.mirror();
    drawImage(player, 0, 60, 400);
    pause(1.0);
    
    // Grayscale
    player.applyGrayscale();
    drawImage(player, 0, 60, 400);

    setTextHeight(22);
    drawText("Total Group Tackles: " + getTotalTackles(), 70, 360);
    pause(1.5);
  }

  public int getTotalTackles() {
    int sum = 0;
    for (int[] row : stats) {
      sum += row[1]; // Index 1 is Tackles
    }
    return sum;
  }
}
