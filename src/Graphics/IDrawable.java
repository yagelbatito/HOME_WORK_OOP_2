/**
 Yagel Batito 318271863
 Hai Karmi 207265687
 */

package Graphics;

import java.awt.Graphics;

/**
 * The `IDrawable` interface defines the contract for objects that can be drawn on a
 * graphical component. It provides methods to handle the drawing of objects and
 * loading of images required for rendering.
 */
public interface IDrawable {

    /**
     * The path to the picture used for drawing.
     * This is a placeholder constant that can be overridden or set in implementing classes.
     */
    public final static String PICTURE_PATH = "…";

    /**
     * Draws the object on the provided graphics context.
     *
     * @param g The `Graphics` object used for drawing the object.
     */
    public void drawObject(Graphics g);

    /**
     * Loads images from the specified paths for use in drawing the object.
     *
     * @param path1 The path to the first image.
     * @param path2 The path to the second image.
     * @param path3 The path to the third image.
     * @param path4 The path to the fourth image.
     */
    public void loadImages(String path1, String path2, String path3, String path4);
}
