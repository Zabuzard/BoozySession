package de.zabuza.boozysession.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;

import de.zabuza.boozysession.view.MainFrameView;

/**
 * Listener of the start button.
 * 
 * @author Zabuza
 * 
 */
public final class StartListener implements ActionListener {
	/**
	 * Random generator.
	 */
	private final Random rnd;
	/**
	 * The view of the main frame.
	 */
	private final MainFrameView view;
	/**
	 * Images for the left icon.
	 */
	private final ImageIcon[] lftIcnImages;
	/**
	 * Images for the right icon.
	 */
	private final ImageIcon[] rgtIcnImages;

	/**
	 * Creates a new listener of the start button.
	 * 
	 * @param thatView
	 *            view of the main frame
	 */
	public StartListener(final MainFrameView thatView,
			final ImageIcon[] thatLftIcnImages, final ImageIcon[] thatRgtIcnImages) {
		view = thatView;
		lftIcnImages = thatLftIcnImages;
		rgtIcnImages = thatRgtIcnImages;
		rnd = new Random();
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		if (lftIcnImages == null || rgtIcnImages == null) {
			return;
		}
		
		int lftIndex = rnd.nextInt(lftIcnImages.length - 1) + 1;
		view.setLftImageIcn(lftIcnImages[lftIndex]);
		int rgtIndex = rnd.nextInt(rgtIcnImages.length - 1) + 1;
		view.setRgtImageIcn(rgtIcnImages[rgtIndex]);
		
		String logText = "";
		if (lftIndex == 1 && rgtIndex == 1) {
			logText = "Lasse jemand anderen exen.";
		} else if (lftIndex == 6 && rgtIndex == 6) {
			logText = "Du musst exen.";
		} else if (lftIndex == rgtIndex) {
			logText = "Lasse jemand anderen " + lftIndex + " mal trinken.";
		} else if (lftIndex >= 1 && lftIndex <= 4) {
			logText = "Trinke " + lftIndex + " mal.";
		} else if (lftIndex == 5) {
			logText = "Du setzt aus.";
		} else if (lftIndex == 6) {
			logText = "Trinke Wasser.";
		}
		
		view.logAction(logText);
	}

}
