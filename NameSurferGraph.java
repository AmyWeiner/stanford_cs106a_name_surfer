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
		entryList = new ArrayList<NameSurferEntry>();
	}

	/**
	 * Clears the list of name surfer entries stored inside this class.
	 */
	public void clear() {
		entryList.clear();
	}

	/**
	 * Adds a new NameSurferEntry to the list of entries on the display.
	 * Note that this method does not actually draw the graph, but
	 * simply stores the entry; the graph is drawn by calling update.
	 */
	public void addEntry(NameSurferEntry entry) {
		entryList.add(entry);
	}

	/**
	 * Updates the display image by deleting all the graphical objects from
	 * the canvas and then reassembling the display according to the list
	 * of entries.  Your application must call update after calling either
	 * clear or addEntry; update is also called automatically whenever the
	 * size of the canvas changes.
	 */
	public void update() {
		removeAll();
		drawBorders();
		drawGridLines();
		drawDecades();
		drawGraph();
	}

	private void drawBorders() {
		drawTopBorders();
		drawBottomBorders();
	}

	private void drawTopBorders() {
		int xUpperLeft = 0;
		int xUpperRight = getWidth();
		int yUpper = GRAPH_MARGIN_SIZE;
		GLine line = new GLine(xUpperLeft, yUpper, xUpperRight, yUpper);
		add(line);
	}

	private void drawBottomBorders() {
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
		for (int i = 0; i < NDECADES; i ++) {
			GLine line = new GLine(separation * i, yUpper, separation * i, yLower);
			add(line);
		}
	}

	private void drawDecades() {
		int yLower = getHeight();
		int separation = getWidth() / 12;
		for (int i = 0; i < NDECADES; i ++) {
			int offset = 5;
			int year = START_DECADE + (10 * i);
			GLabel label = new GLabel("" + year, offset + separation * i, yLower);
			add(label);
		}
	}

	public void drawGraph() {
		int separation = getWidth() / 12;

		for (int i = 0; i < entryList.size(); i ++) {
			ArrayList<GPoint> points = new ArrayList<GPoint>();
			NameSurferEntry entry = entryList.get(i);
			String name = entry.getName();
			for (int j = 0; j < NDECADES; j ++) {
				int rank = entry.getRank(j);
				int graphPoint = rank;
				if (rank > 0 && rank < GRAPH_MARGIN_SIZE) {
					graphPoint = GRAPH_MARGIN_SIZE;
				} else if (rank == 0) {
					graphPoint = getHeight() - GRAPH_MARGIN_SIZE;
				}else if (rank > getHeight() - GRAPH_MARGIN_SIZE) {
					graphPoint = getHeight() - GRAPH_MARGIN_SIZE;
				} else {
					graphPoint = rank;
				}
				GLabel label = new GLabel(name + " " + rank, j * separation, graphPoint);
				if (rank == 0) label.setLabel(name + " " + rank + " *");
				add(label);
				label.setColor(colorGraph(i));
				GPoint point = new GPoint(j * separation, graphPoint);
				points.add(point);

			}
			graphRankings(points, i);
		}

	}

	private Color colorGraph(int c) {
		if (c % 4 == 0) {
			return Color.RED;
		} else if (c % 4 == 1) {
			return Color.BLUE;
		} else if (c % 4 == 2) {
			return Color.ORANGE;
		}else { 
			return Color.MAGENTA;
		} 
	}

	private void graphRankings(ArrayList<GPoint> points, int c) {
		for (int i = 0; i < points.size() -1; i ++) {
			double x1 = points.get(i).getX();
			double y1 = points.get(i).getY();
			double x2 = points.get(i + 1).getX();
			double y2 = points.get(i + 1).getY();
			GLine line = new GLine(x1, y1, x2, y2);
			line.setColor(colorGraph(c));
			add(line);
		}
	}

	private ArrayList<NameSurferEntry> entryList;

}


