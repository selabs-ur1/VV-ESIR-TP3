package fr.istic.vv;

import java.util.Comparator;

/**
 * Compare to Integers
 *
 */
public class ComparatorSuperior implements Comparator<Integer>{

	@Override
	public int compare(Integer int1, Integer int2) {
		return int1-int2;
	}

	
}
