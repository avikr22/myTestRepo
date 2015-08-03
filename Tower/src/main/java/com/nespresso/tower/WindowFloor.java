package com.nespresso.tower;


/**
* This is the the class of Floor type which has windows
*
* @author Avinash Kumar
* @version 1.0
*/
public class WindowFloor implements Floor {
	int floorSize;
	int windowCount;
	int windowSequence;

	public WindowFloor(int floorSize, int windowCount) {
		this.floorSize = floorSize;
		this.windowCount = windowCount;
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

		if (Tower.totalFloorsonTop > 3) {
			windowSequence = 1;
		} else {
			windowSequence = 4 - Tower.totalFloorsonTop;
		}

		StringBuilder floorBuilder = new StringBuilder();
		int floorSizeToPrint = floorSize;
		int windowCountToPrint = windowCount;
		int windowFloorDiff = floorSizeToPrint - windowCountToPrint;
		if (windowFloorDiff == 0) {
			floorBuilder.append('X');
			windowCountToPrint = windowCountToPrint - 2;
			while (windowCountToPrint > 0) {
				floorBuilder.append('0');
				windowCountToPrint--;
			}
			floorBuilder.append('X');
		} else {
			int windowPrinted = 0;
			int leftWall = windowFloorDiff / 2;
			int rightWall = windowFloorDiff - leftWall;
			while (leftWall > 0) {
				floorBuilder.append('X');
				leftWall--;
			}
			if (windowSequence < 4 && windowSequence >= 1) {
				while (windowCountToPrint > 0) {
					if (windowPrinted == windowSequence) {

						floorBuilder.append('X');
						windowPrinted = 0;
						rightWall--;
						floorSizeToPrint--;

					} else {
						if (floorSizeToPrint == 1) {
							break;
						}
						floorBuilder.append('0');
						windowCountToPrint--;
						windowPrinted++;
						floorSizeToPrint--;
					}

				}
				while (rightWall > 0) {
					floorBuilder.append('X');
					rightWall--;
				}
			} else {
				while (windowCountToPrint > 0) {
					floorBuilder.append('0');
					windowCountToPrint--;
				}
				while (rightWall > 0) {
					floorBuilder.append('X');
					rightWall--;
				}
			}

		}
		return floorBuilder.toString();
	}

}
