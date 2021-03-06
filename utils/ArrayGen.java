package com.bucaojit.utils;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Changed methods to static, for ease of use
// Only drawback is loss of Logging capabilities,
//   which is no longer necessary as tested correct
public class ArrayGen {
	Trace LOG;
	public ArrayGen() {
		LOG = new Trace(this.getClass().toString());
	}
	
	public static void swap(List<Integer> list, int indexA, int indexB) {
		//LOG.logEntry();
		int temp = list.get(indexA);
		list.set(indexA, list.get(indexB));
		list.set(indexB, temp);
		//LOG.logExit();
	}
	
	public static ArrayList<Integer> generate(int size) {
		return generate(size, true);		
	}
	
	public static ArrayList<Integer> generate(int size, boolean randomize) {
		//LOG.logEntry();
		// Create list
		ArrayList<Integer> list = new ArrayList<Integer>(size);
		for (int i = 0; i < size; i++) {
			list.add(i);
		}
		
		if (randomize) {
			// Fisher-Yates shuffle
			for (int j = size-1; j >= 0; j--) {
				// swap the values
				Random rand = new Random();
				Integer swapIndex = rand.nextInt(size-1);
				//LOG.logTrace(swapIndex.toString());
				swap(list, j, swapIndex);			
			}
		}
		//LOG.logDebug(list.toString());
		//LOG.logExit();
		return list;
	}
}

