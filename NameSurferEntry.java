/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

import java.util.*;

public class NameSurferEntry implements NameSurferConstants {

/**
 * Creates a new NameSurferEntry from a data line as it appears in the
 * data file.  Each line begins with the name, which is followed by
 * integers giving the rank of that name for each decade.
 */
	public NameSurferEntry(String line) {
		name = line.substring(0, line.indexOf(" "));
		ranks = line.substring(name.length() + 1);
		StringTokenizer tokenizer = new StringTokenizer(ranks);
		int i = 0;
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			int ranking = Integer.parseInt(token);
			rank[i] = ranking;
			i ++;
		}
	}

/**
 * Returns the name associated with this entry.
 */
	public String getName() {
		return name;
	}

/**
 * Returns the rank associated with an entry for a particular decade.
 * The decade value is an integer indicating how many decades have passed
 * since the first year in the database, which is given by the constant
 * START_DECADE.  If a name has a rank below 1000, the rank value is 0.
 */
	public int getRank(int decade) {
		return rank[decade];
	}

/**
 * Returns a string that makes it easy to see the value of a NameSurferEntry.
 */
	public String toString() {
		return name + "[" + ranks + "]";
	}
	
	/* Private instance variables*/
	private String name;							//String for the name contained within the entry
	private String ranks;							//String for the rankings for the name within the entry
	private int[] rank = new int[NDECADES];  		//array for each of the rank values associated with the name
	
}
