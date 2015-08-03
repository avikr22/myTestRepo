package com.nespresso.tower;



/**
* This is the class of the floor type without windows
*
* @author Avinash Kumar
* @version 1.0
*/
public class BasicFloor implements Floor {
	
	private int floorSize;
	
	
	public BasicFloor(final int floorCount) {
		floorSize = floorCount;
	}

	public int getFloorCount() {
		return floorSize;
	}

	/*
	 * This method returns the printable format for a floor
	 *
	 * @see com.nespresso.tower.Floor#getPrintableFloor()
	 */
	public String getPrintableFloor() {
		int floorSizeToPrint = floorSize;
		StringBuilder floorBuilder = new StringBuilder();
		while (floorSizeToPrint > 0) {
			floorBuilder.append('X');
			floorSizeToPrint--;
		}
		return floorBuilder.toString();
	}

}
