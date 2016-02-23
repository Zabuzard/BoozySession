package de.zabuza.boozysession;

import java.awt.Container;
import javax.swing.JApplet;

import de.zabuza.boozysession.controller.MainFrameController;
import de.zabuza.boozysession.view.MainFrameView;

/**
 * Starts the game in an applet.
 * 
 * @author Zabuza
 * 
 */
public final class AppletLauncher extends JApplet {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * True if tool has started.
	 */
	private boolean started = false;

	@Override
	public void init() {

	}

	@Override
	public void start() {
		if (!started) {
			started = true;
			try {
				Container container = new Container();
				MainFrameView window = new MainFrameView(container);
				try {
					MainFrameController controller = new MainFrameController(
							window);
					controller.initialize();
				} catch (Exception e) {
					window.logError("Ein unbekannter Fehler trat auf.");
					if (e.getMessage() != null) {
						window.logError(e.getMessage());
					}
				} finally {
					setContentPane(container);
					setFocusable(false);
					container.setFocusCycleRoot(true);
					container.setVisible(true);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void stop() {
		if (started) {
			started = false;
		}
	}

}
