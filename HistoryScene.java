import org.code.theater.*;

public class HistoryScene extends Scene {
  private int[][] data;

  public HistoryScene(int[][] data) {
    this.data = data;
  }

  /*
   * Orchestrates History visualization.
   * Uses Action Green and Invert filters.
   */
  public void drawScene() {
    clear("navy");
    setTextColor("green");
    setTextHeight(30);
    
    // Play the crowd noise audio file
    playSound("cheer.wav");
    
    drawText("The 12th Man Tradition", 45, 40);
    
    ImageFilter logo = new ImageFilter("seahawks.png");
    drawImage(logo, 50, 60, 300);
    pause(1.5);
    
    // Action Green
    logo.applyActionGreen();
    drawImage(logo, 50, 60, 300);
    pause(1.0);
    
    // Invert
    logo.invert();
    drawImage(logo, 50, 60, 300);
    pause(1.0);

    setTextHeight(25);
    for (int i = 0; i < data.length; i++) {
      drawText("No. " + data[i][0] + " retired in " + data[i][1], 80, 300 + (i * 25));
    pause(1.0);
    }
    pause(3.0);
  }
}
