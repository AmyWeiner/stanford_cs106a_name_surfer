/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends ConsoleProgram implements NameSurferConstants {

	/* Method: init() */
	/**
	 * This method has the responsibility for reading in the data base
	 * and initializing the interactors at the bottom of the window.
	 */
	public void init() {
		nameField = new JTextField(JTEXT_FIELD_SIZE);
		nameField.addActionListener(this);
		add(new JLabel("Name"), SOUTH);
		add(nameField, SOUTH);
		add(new JButton("Graph"), SOUTH);
		add(new JButton("Clear"), SOUTH);
		addActionListeners();
	}

	/* Method: actionPerformed(e) */
	/**
	 * This class is responsible for detecting when the buttons are
	 * clicked, so you will have to define a method to respond to
	 * button actions.
	 */
	public void actionPerformed(ActionEvent e) {
		String abel = "Abel 664 613 626 575 542 491 497 422 381 385 354 582";
		NameSurferEntry entry = new NameSurferEntry(abel);
		println(entry);
		println("Name:" + entry.getName());
		for (int i = 0; i < NDECADES; i ++) {
		println("Rank: " + entry.getRank(i));
		}
		
		if (e.getSource() == nameField) {
			println("Graph: " + "\"" + nameField.getText() + "\"");
		}
		if (e.getActionCommand().equals("Graph")) {
			println("Graph: " + "\"" + nameField.getText() + "\"");
		}
		if (e.getActionCommand().equals("Clear")) println("Clear");
	}
	
	private JTextField nameField;
}
