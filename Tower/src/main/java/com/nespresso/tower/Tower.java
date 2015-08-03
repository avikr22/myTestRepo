package com.nespresso.tower;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the main class which keeps the list of all the floors in the tower
 *
 * @author Avinash Kumar
 * @version 1.0
 */
public class Tower {
	private Map<Integer, Floor> floorMap = new HashMap<Integer, Floor>();
	private int floorCount = 0;
	public static int totalFloorsonTop = 0;

	/**
	 * This is the method which adds a new Floor without windows
	 * 
	 * @param floorSize.
	 * @exception IllegalArgumentException
	 */
	public void addFloor(final int floorSize) throws IllegalArgumentException {
		if (floorCount > 0) {
			Floor previousFloor = floorMap.get(floorCount - 1);
			int previousFloorSize = previousFloor.getFloorCount();
			if (floorSize > previousFloorSize) {
				throw new IllegalArgumentException();
			}
		}
		Floor floor = FloorFactory.getFloor(floorSize);
		floorMap.put(floorCount, floor);
		floorCount++;
	}

	/**
	 * This is the method which adds a new Floor with windows
	 * 
	 * @param floorSize.
	 * @param windowCount
	 * 
	 */
	public void addFloorWithWindows(final int floorSize, final int windowCount) {
		Floor floor = FloorFactory.getFloor(floorSize, windowCount);
		floorMap.put(floorCount, floor);
		floorCount++;
	}

	/**
	 * This is the method which is used to print the structure of the floor
	 * 
	 * @param floors.
	 * @return String
	 */
	public String printFloor(final int floors) {
		Floor floorRequired = floorMap.get(floors);
		if (floorRequired != null) {
			totalFloorsonTop = floorCount - (floors + 1);
			return floorRequired.getPrintableFloor();
		}
		return null;
	}

}
