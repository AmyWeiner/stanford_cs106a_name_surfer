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
		
		if (e.getSource() == nameField) {
			println("Graph: " + "\"" + nameField.getText() + "\"");
		}
		if (e.getActionCommand().equals("Graph")) {
		//	String name = nameField.getText();
			println("Graph: " + "\"" + nameField.getText() + "\"");
		}
		if (e.getActionCommand().equals("Clear")) println("Clear");
	}
	
	private JTextField nameField;
}
