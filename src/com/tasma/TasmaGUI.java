package com.tasma;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.List;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;

public class TasmaGUI extends JFrame implements TasmaUserInterface {

	private static final long serialVersionUID = 7369112773183099080L;

	private static final int WINDOW_DEFAULT_WIDTH = 480;
	private static final int WINDOW_DEFAULT_HEIGHT = 320;

	private JPanel contentPane;
	private PlaceholderTextField textCommand;
	private JTextArea textDisplay = new JTextArea();

	private Controller controller;
	private ZebraJList list = new ZebraJList();
	private JScrollPane scrollPane = new JScrollPane();

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public TasmaGUI() {
		decorateFrame();
		addWindowEvents();

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		BorderLayout contentPaneLayout = new BorderLayout();
		contentPane.setLayout(contentPaneLayout);
		setContentPane(contentPane);

		textCommand = new PlaceholderTextField();
		textCommand.setPlaceholder("What would you like to do?");
		textCommand.setPlaceholderColor(Palette.PLACEHOLDER_TEXT);
		textCommand.setBorder(new EmptyBorder(10, 10, 10, 10));
		textCommand.setSize(new Dimension(480, 40));
		textCommand.setBackground(Palette.THEME_BLUE);
		textCommand.setForeground(Color.WHITE);
		textCommand.setCaretColor(Color.WHITE);
		textCommand.setFont(textCommand.getFont().deriveFont(14.0f));
		textCommand.setDocument(new JTextFieldLimit(70));
		contentPane.add(textCommand, BorderLayout.PAGE_START);
		textCommand.setColumns(10);
		JFrame thisFrame = this;
		textCommand.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					thisFrame.setVisible(false);
				} else if (e.getKeyCode() == KeyEvent.VK_ENTER && !textCommand.getText().trim().equals(""))  {
					textDisplay.setVisible(false);
					thisFrame.setSize(WINDOW_DEFAULT_WIDTH, WINDOW_DEFAULT_HEIGHT);
					String command = textCommand.getText();
					textCommand.setText("");
					controller.executeInput(command);
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {}
		});
		textDisplay.setEditable(false);
		textDisplay.setBackground(Color.WHITE);
		textDisplay.setRows(1);
		textDisplay.setLineWrap(true);
		textDisplay.setVisible(false);
		textDisplay.setWrapStyleWord(true);
		textDisplay.setTabSize(3);
		textDisplay.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(textDisplay, BorderLayout.PAGE_END);

		list.setSelectionModel(new DisabledItemSelectionModel());
		list.setCellRenderer(new CustomListRenderer());
		scrollPane.getVerticalScrollBar().setUI(new MyScrollBarUI());
		scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		scrollPane.setPreferredSize(new Dimension(470, 220));

		contentPane.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(list);
	}

	//@author A0132763
	private void decorateFrame() {
		setTitle("TASMA");
		setIconImage(createImage("res/logo.png", "icon"));
		setAlwaysOnTop(true);
		// must use HIDE on CLOSE for the TrayIcon to work properly
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(528, 329);

		// sets the window to center of the screen
		setLocationRelativeTo(null);
	}

	private void addWindowEvents() {
		JFrame thisFrame = this;
		this.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				thisFrame.setSize(WINDOW_DEFAULT_WIDTH, WINDOW_DEFAULT_HEIGHT);
                textCommand.requestFocus();
			}
		});
	}

	@Override
	public void initialize(Controller controller) throws Exception {
		this.controller = controller;
		this.controller.setUserInterface(this);
	}

	public class CustomListRenderer implements ListCellRenderer<Object> {

		@SuppressWarnings("serial")
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index,
			boolean isSelected, boolean cellHasFocus) {
		    Task task = (Task)value;

		    JPanel panel = new JPanel();
		    GridBagLayout layout = new GridBagLayout();
		    panel.setLayout(layout);
		    
		    GridBagConstraints c = new GridBagConstraints();
		       
		    JTextArea textIndex = new JTextArea();
		    textIndex.setBorder(new EmptyBorder(5, 5, 5, 5));
		    textIndex.setText(Integer.toString(index + 1));
		    textIndex.setBackground(null);
		    textIndex.setFont(textIndex.getFont().deriveFont(16.0f));
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.gridx = 0; 
		    c.gridy = 0;
		    panel.add(textIndex, c);

		    JTextArea textDetails = new JTextArea();
		    textDetails.setBorder(new EmptyBorder(5, 5, 5, 5));
		    textDetails.setText(task.getDetails());
		    textDetails.setLineWrap(true);
		    textDetails.setBackground(null);
		    textDetails.setFont(textDetails.getFont().deriveFont(16.0f));
		    c = new GridBagConstraints();
	        c.fill = GridBagConstraints.HORIZONTAL;
	        c.gridx = 1;
	        c.gridy = 0;
	        c.weightx = 1;
	        panel.add(textDetails, c);
	
	        JTextArea textDateTime = new JTextArea();
	        textDateTime.setBorder(new EmptyBorder(5, 5, 5, 5));
	        textDateTime.setText(task.getStringStartDateTime());
	        textDateTime.setLineWrap(true);
	        textDateTime.setBackground(null);
	        textDateTime.setFont(textDateTime.getFont().deriveFont(12.0f));
	        c = new GridBagConstraints();
	        c.fill = GridBagConstraints.HORIZONTAL;
	        c.gridx = 1;
	        c.gridy = 1;
	        panel.add(textDateTime, c);	
	
	        return panel;
	    }
	}

	//For disabling the selection capability of the list
	private class DisabledItemSelectionModel extends DefaultListSelectionModel {

		private static final long serialVersionUID = 1L;

		@Override
		public void setSelectionInterval(int index0, int index1) {
			super.setSelectionInterval(-1, -1);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void displayTasks(List<Task> tasks) {
		list.setListData(tasks.toArray());
	}

	private String fill(int length, String with) {
	    StringBuilder sb = new StringBuilder(length);
	    while (sb.length() < length) {
	        sb.append(with);
	    }
	    return sb.toString();
	}

	private String fill(String value, int length, String with) {

	    StringBuilder result = new StringBuilder(length);
	    result.append(value);
	    result.append(fill(Math.max(0, length - value.length()), with));

	    return result.toString();

	}

	@Override
	public void displayMessage(String message) {
		displayMessage(message, Palette.MESSAGE_DEFAULT);
	}

	@Override
	public void displayMessage(String message, Color color) {
		textDisplay.setText(message);
		textDisplay.setForeground(color);
		textDisplay.setVisible(true);
		setSize(WINDOW_DEFAULT_WIDTH, WINDOW_DEFAULT_HEIGHT + textDisplay.getPreferredSize().height);
	}

	public void editCmdDisplay (String task) {
		textCommand.setText(task);
	}

	 //Obtain the image URL
    protected static Image createImage(String path, String description) {
        URL imageURL = TrayIcon.class.getResource(path);

        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }

    @SuppressWarnings("deprecation")
	@Override
    public void show() {
    	super.show();
    	setState(NORMAL);
    	toFront();
    }
}
