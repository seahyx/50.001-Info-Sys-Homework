package ProblemSet2A;

import java.util.ArrayList;

public class GetPath {

	//Fill in your answer for this method
	public static boolean getPath(int r, int c, ArrayList<Point> path, final int [][] grid) {
		return getPath(r, c, 0, 0, path, grid);
	}

	public static boolean getPath(int r, int c, int curR, int curC, ArrayList<Point> path, final int [][] grid) {
		if (curR == r && curC == c) {
			Point pt = new Point(curR, curC);
			path.add(pt);
			return true;
		}
		if (curR >= grid.length || curC >= grid[0].length) return false;
		if (grid[curR][curC] == 0) {
			Point pt = new Point(curR, curC);
			path.add(pt);
			boolean res = getPath(r, c, curR + 1, curC, path, grid) || getPath(r, c, curR, curC + 1, path, grid) ;
			if (!res) path.remove(pt);
			return res;
		}
		return false;
	}
}

//You do not need to change any code below ---------
class Point {
	int x;
	int y;

	Point (int x, int y) {
		this.x=x;
		this.y=y;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
//--------------------------------------------------

/* HINT:
Your solution ought to work with a grid that is not square.
Here is the grid for Test Case 8:

            final int[][] grid = {
                    {0,0,0,1},
                    {0,1,0,0},
                    {0,1,1,1},
                    {0,0,0,1},
                    {1,1,0,0},
                    {1,1,1,0}
            };

If the destination is r = 5, c = 3, then getPath() returns true.
If the destination is r = 2, c = 3, then getPath() returns false.

*/