/*
 * File: NameSurferGraph.java
 * --------------------------
 * This class is responsible for updating the graph whenever the
 * list of entries changes or the window is resized.
 */

import acm.graphics.*;
import java.awt.*;
import java.util.*;

public class NameSurferGraph extends ResizableGCanvas
implements NameSurferConstants {

	/**
	 * Creates a new NameSurferGraph object that displays the data.
	 */
	public NameSurferGraph() {

	}

	/**
	 * Clears the list of name surfer entries stored inside this class.
	 */
	public void clear() {
		// You fill this in
	}

	/**
	 * Adds a new NameSurferEntry to the list of entries on the display.
	 * Note that this method does not actually draw the graph, but
	 * simply stores the entry; the graph is drawn by calling update.
	 */
	public void addEntry(NameSurferEntry entry) {
		// You fill this in
	}

	/**
	 * Updates the display image by deleting all the graphical objects from
	 * the canvas and then reassembling the display according to the list
	 * of entries.  Your application must call update after calling either
	 * clear or addEntry; update is also called automatically whenever the
	 * size of the canvas changes.
	 */
	public void update() {
		drawMargins();
		drawGridLines();
	}

	private void drawMargins() {
		drawTopMargins();
		drawBottomMargins();
	}

	private void drawTopMargins() {
		int xUpperLeft = 0;
		int xUpperRight = getWidth();
		int yUpper = GRAPH_MARGIN_SIZE;
		GLine line = new GLine(xUpperLeft, yUpper, xUpperRight, yUpper);
		add(line);
	}
	
	private void drawBottomMargins() {
		int xLowerLeft = 0;
		int xLowerRight = getWidth();
		int yLower = getHeight() - GRAPH_MARGIN_SIZE;
		GLine line = new GLine(xLowerLeft, yLower, xLowerRight, yLower);
		add(line);
	}
	
	private void drawGridLines() {
		int yUpper = 0;
		int yLower = getHeight();
		int separation = getWidth() / 12;
		for (int i = 0; i < NDECADES - 1; i ++) {
			drawVerticalLine(separation * i, yUpper, separation * i, yLower);
		}
	}
	
	private void drawVerticalLine(int x1, int y1, int x2, int y2) {
		GLine line = new GLine(x1, y1, x2, y2);
		add(line);
	}
}


