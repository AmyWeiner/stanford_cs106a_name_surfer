/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends Program implements NameSurferConstants {

	/* Method: init() */
	/**
	 * This method has the responsibility for reading in the data base
	 * and initializing the interactors at the bottom of the window.
	 */
	public void init() {
		db = new NameSurferDataBase(NAMES_DATA_FILE);
		nameField = new JTextField(JTEXT_FIELD_SIZE);
		nameField.addActionListener(this);
		add(new JLabel("Name"), SOUTH);
		add(nameField, SOUTH);
		add(new JButton("Graph"), SOUTH);
		add(new JButton("Clear"), SOUTH);
		graph = new NameSurferGraph();
	    add(graph, CENTER);
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
			String name = nameField.getText();
			NameSurferEntry entry = db.findEntry(name);
			graph.addEntry(entry);
			//graph.update();
		}
		if (e.getActionCommand().equals("Graph")) {
			String name = nameField.getText();
			NameSurferEntry entry = db.findEntry(name);
			graph.addEntry(entry);
			//graph.update();
		}
		if (e.getActionCommand().equals("Clear")) {
			graph.clear();
			graph.update();
		}
	}
	
	private JTextField nameField;
	private NameSurferGraph graph;
	private NameSurferDataBase db;
}
