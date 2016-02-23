package de.zabuza.boozysession.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.text.DefaultCaret;

/**
 * View of the main frame.
 * 
 * @author Zabuza
 * 
 */
public final class MainFrameView {

	/**
	 * The default font size of the view.
	 */
	private static final int DEFAULT_FONT_SIZE = 11;

	/**
	 * Container of the view.
	 */
	private Container container;
	/**
	 * Main panel of the view.
	 */
	private JPanel mainPanel;
	/**
	 * Footer panel of the view.
	 */
	private JPanel footerPanel;
	/**
	 * Scroll pane of the view for the log area.
	 */
	private JScrollPane scrollPane;
	/**
	 * Area for logging.
	 */
	private JTextArea actionArea;
	/**
	 * Button to start a game run.
	 */
	private JButton startBtn;
	/**
	 * Image icon of the left image.
	 */
	private ImageIcon lftIcn;
	/**
	 * Image icon of the right image.
	 */
	private ImageIcon rgtIcn;
	/**
	 * Label for the left image icon.
	 */
	private JLabel lftImgLbl;
	/**
	 * Label for the right image icon.
	 */
	private JLabel rgtImgLbl;

	/**
	 * Create the view.
	 * 
	 * @param thatContainer container of the view
	 */
	public MainFrameView(final Container thatContainer) {
		container = thatContainer;
		initialize();
	}
	
	/**
	 * Adds an action listener to the start button.
	 * 
	 * @param listener
	 *            listener to add
	 */
	public void addListenerToStartButton(final ActionListener listener) {
		startBtn.addActionListener(listener);
		startBtn.addActionListener(null);
	}
	
	/**
	 * Sets the image of the left icon.
	 * @param icon Image to set
	 */
	public void setLftImageIcn(final Icon icon) {
		lftImgLbl.setIcon(icon);
	}
	
	/**
	 * Sets the image of the right icon.
	 * @param icon Image to set
	 */
	public void setRgtImageIcn(final Icon icon) {
		rgtImgLbl.setIcon(icon);
	}
	
	/**
	 * Appends a line to the action area.
	 * 
	 * @param line
	 *            line to append
	 */
	public void logAction(final String line) {
		actionArea.setForeground(Color.BLACK);
		actionArea.append(getTimestamp() + " - " + line + "\n");
	}
	
	/**
	 * Appends a line to the action area using a red font.
	 * 
	 * @param line
	 *            line to append
	 */
	public void logError(final String line) {
		actionArea.setForeground(Color.RED);
		actionArea.append(getTimestamp() + " - " + line + "\n");
	}
	
	/**
	 * Gets the current timestamp in hh:mm:ss format.
	 * 
	 * @return Current timestamp in hh:mm:ss format
	 */
	private String getTimestamp() {
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		String hourText = hour + "";
		if (hour < 10) {
			hourText = "0" + hour;
		}
		String minuteText = minute + "";
		if (minute < 10) {
			minuteText = "0" + minute;
		}
		String secondText = second + "";
		if (second < 10) {
			secondText = "0" + second;
		}
		return hourText + ":" + minuteText + ":" + secondText;
	}

	/**
	 * Initialize the contents of the view.
	 */
	private void initialize() {
		initializePanels();
		initializeLabels();
		initializeIcons();
		initializeButtons();

		actionArea = new JTextArea();
		actionArea.setEditable(false);
		actionArea.setFont(new Font("Monospaced", Font.PLAIN, DEFAULT_FONT_SIZE));
		actionArea.setLineWrap(true);
		DefaultCaret caret = (DefaultCaret) actionArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		scrollPane.setViewportView(actionArea);
	}
	
	/**
	 * Initialize the buttons.
	 */
	private void initializeButtons() {
		startBtn = new JButton("Start");
		startBtn.setFont(new Font("Tahoma", Font.PLAIN, DEFAULT_FONT_SIZE));
		startBtn.setBounds(140, 220, 120, 30);
		mainPanel.add(startBtn);
	}
	
	/**
	 * Initialize the icons.
	 */
	private void initializeIcons() {
		lftIcn = new ImageIcon();
		lftImgLbl = new JLabel(lftIcn);
		lftImgLbl.setBounds(20, 20, 170, 170);
		mainPanel.add(lftImgLbl);
		
		rgtIcn = new ImageIcon();
		rgtImgLbl = new JLabel(rgtIcn);
		rgtImgLbl.setBounds(210, 20, 170, 170);
		mainPanel.add(rgtImgLbl);
	}
	
	/**
	 * Initialize the labels.
	 */
	private void initializeLabels() {
		JLabel lblAction = new JLabel("Aktion:");
		lblAction.setFont(new Font("Tahoma", Font.PLAIN, DEFAULT_FONT_SIZE));
		lblAction.setBounds(10, 264, 65, 14);
		mainPanel.add(lblAction);

		JLabel lblByZabuza = new JLabel("by Zabuza");
		lblByZabuza.setFont(new Font("Tahoma", Font.PLAIN,
				DEFAULT_FONT_SIZE));
		lblByZabuza.setBounds(340, 0, 111, 24);
		footerPanel.add(lblByZabuza);
	}

	/**
	 * Initialize the panels.
	 */
	private void initializePanels() {
		mainPanel = new JPanel();
		mainPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		mainPanel.setBounds(0, 0, 400, 401);
		container.add(mainPanel);
		mainPanel.setLayout(null);

		footerPanel = new JPanel();
		footerPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		footerPanel.setBounds(0, 402, 400, 21);
		container.add(footerPanel);
		footerPanel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null,
				null, null, null));
		scrollPane.setBounds(10, 280, 380, 111);
		mainPanel.add(scrollPane);
	}
}