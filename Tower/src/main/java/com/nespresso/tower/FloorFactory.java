package com.nespresso.tower;

/**
 * 
 * This is the factory class used to generate the Floor types
 * @author Avinash
 *
 */
public class FloorFactory {

	/**
	 * This method returns the Floor type without windows
	 * 
	 * @param floorSize.
	 * @return Floor
	 */ 
	public static Floor getFloor(final int floorSize) {
		Floor basicFloor = new BasicFloor(floorSize);
		return basicFloor;
	}

	/**
	 * This method returns the Floor type with windows
	 * 
	 * @param floorSize.
	 * @param windowCount
	 * @return Floor
	 */ 
	public static Floor getFloor(final int floorSize, final int windowCount) {
		Floor windowFloor = new WindowFloor(floorSize, windowCount);
		return windowFloor;
	}

}
