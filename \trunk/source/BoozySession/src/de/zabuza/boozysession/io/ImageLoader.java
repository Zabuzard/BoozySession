package de.zabuza.boozysession.io;

import javax.swing.ImageIcon;

import de.zabuza.boozysession.view.MainFrameView;

/**
 * Utility class for loading image files.
 * 
 * @author Zabuza
 * 
 */
public final class ImageLoader {

	/**
	 * Path to the images.
	 */
	private static final String PATH = "/res/img/";
	/**
	 * Starting text of images files for the left icon.
	 */
	private static final String IMAGE_PRE_LFT = "leftIcn";
	/**
	 * Starting text of images files for the right icon.
	 */
	private static final String IMAGE_PRE_RGT = "rgtIcn";
	/**
	 * Ending text of image files.
	 */
	private static final String IMAGE_SUC = ".png";
	/**
	 * Amount of images per image icon.
	 */
	private static final int IMAGE_AMOUNT_PER_ICON = 7;

	/**
	 * Loads images for the left icon located in {@link #PATH} as image icons.
	 * 
	 * @param view
	 *            view to print errors to
	 * @return Array which holds all loaded images
	 */
	public static ImageIcon[] loadImagesLftIcn(final MainFrameView view) {
		return loadImages(view, IMAGE_PRE_LFT);
	}
	
	/**
	 * Loads images for the right icon located in {@link #PATH} as image icons.
	 * 
	 * @param view
	 *            view to print errors to
	 * @return Array which holds all loaded images
	 */
	public static ImageIcon[] loadImagesRgtIcn(final MainFrameView view) {
		return loadImages(view, IMAGE_PRE_RGT);
	}
	
	/**
	 * Loads images for the given icon located in {@link #PATH} as image icons.
	 * @param view
	 *            view to print errors to
	 * @param imgPre
	 *            starting text of the image files
	 * @return Array which holds all loaded images
	 */
	private static ImageIcon[] loadImages(final MainFrameView view, final String imgPre) {
		ImageIcon[] result = new ImageIcon[IMAGE_AMOUNT_PER_ICON];
		for (int i = 0; i < IMAGE_AMOUNT_PER_ICON; i++) {
			String fullPath = PATH + imgPre + i + IMAGE_SUC;
			try {
				ImageIcon img = new ImageIcon(ImageLoader.class.getResource(fullPath));
				result[i] = img;
			} catch (NullPointerException e) {
				view.logError("Fehler beim Lesen der Bilder. "
						+ "Konnte '" + fullPath + "' nicht finden.");
				return null;
			}
		}
		return result;
	}

	/**
	 * Utility class. No implementation.
	 */
	private ImageLoader() {

	}
}