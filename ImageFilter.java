import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus {

  public ImageFilter(String fileName) {
    super(fileName);
  }

  /* 
   * Action Green Tint
   * Boosts green while lowering red/blue.
   */
  public void applyActionGreen() {
    Pixel[][] pixels = getImagePixels();
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel p = pixels[row][col];
        int newGreen = (int)(p.getGreen() * 1.8);
        p.setGreen(Math.min(newGreen, 255));
        p.setRed(p.getRed() / 3);
        p.setBlue(p.getBlue() / 3);
      }
    }
  }

  /* 
   * Grayscale
   * Averages RGB values.
   */
  public void applyGrayscale() {
    Pixel[][] pixels = getImagePixels();
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel p = pixels[row][col];
        int avg = (p.getRed() + p.getGreen() + p.getBlue()) / 3;
        p.setRed(avg);
        p.setGreen(avg);
        p.setBlue(avg);
      }
    }
  }

  /* 
   * Mirror Left-to-Right
   * Reflects the left side of the image onto the right side.
   */
  public void mirror() {
    Pixel[][] pixels = getImagePixels();
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < width / 2; col++) {
        pixels[row][width - 1 - col].setColor(pixels[row][col].getColor());
      }
    }
  }

  /* 
   * Invert Colors
   * Subtracts current color from 255 for a "negative" look.
   */
  public void invert() {
    Pixel[][] pixels = getImagePixels();
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel p = pixels[row][col];
        p.setRed(255 - p.getRed());
        p.setGreen(255 - p.getGreen());
        p.setBlue(255 - p.getBlue());
      }
    }
  }
}
