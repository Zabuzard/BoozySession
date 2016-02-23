package de.zabuza.boozysession.controller;

import javax.swing.ImageIcon;

import de.zabuza.boozysession.io.ImageLoader;
import de.zabuza.boozysession.listener.StartListener;
import de.zabuza.boozysession.view.MainFrameView;

/**
 * The controller of the main frame.
 * 
 * @author Zabuza
 * 
 */
public final class MainFrameController {
	/**
	 * Images for the left icon.
	 */
	private ImageIcon[] lftIcnImages;
	/**
	 * Images for the right icon.
	 */
	private ImageIcon[] rgtIcnImages;
	/**
	 * The view of the main frame.
	 */
	private final MainFrameView view;

	/**
	 * Creates a new controller of the main frame by connecting it to the view.
	 * 
	 * @param thatView
	 *            view of the main frame
	 */
	public MainFrameController(final MainFrameView thatView) {
		view = thatView;
	}

	/**
	 * Initializes the controller.
	 */
	public void initialize() {
		loadImages();
		linkListener();
	}

	/**
	 * Links the listener to the view.
	 */
	private void linkListener() {
		view.addListenerToStartButton(new StartListener(view, lftIcnImages, rgtIcnImages));
	}

	/**
	 * Loads the data to the view.
	 */
	private void loadImages() {
		lftIcnImages = ImageLoader.loadImagesLftIcn(view);
		if (lftIcnImages != null) {
			view.setLftImageIcn(lftIcnImages[0]);
		}
		rgtIcnImages = ImageLoader.loadImagesRgtIcn(view);
		if (rgtIcnImages != null) {
			view.setRgtImageIcn(rgtIcnImages[0]);
		}
	}
}