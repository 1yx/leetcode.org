class Solution {
    double x, y;
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        int x1 = start1[0], x2 = end1[0], x3 = start2[0], x4 = end2[0];
        int y1 = start1[1], y2 = end1[1], y3 = start2[1], y4 = end2[1];
        boolean intersect = false;
        if ((y4 - y3) * (x2 - x1) == (y2 - y1) * (x4 - x3)) { // slope
            if ((y2 - y1) * (x3 - x1) == (y3 - y1) * (x2 - x1)) {
                if (inside(new int[][]{start1, end1}, start2))
                    intersect = update(start2, intersect);
                if (inside(new int[][]{start1, end1}, end2))
                    intersect = update(end2, intersect);
                if (inside(new int[][]{start2, end2}, start1))
                    intersect = update(start1, intersect);
                if (inside(new int[][]{start2, end2}, end1))
                    intersect = update(end1, intersect);
            }
        } else {
            double t1 = (double) (x3 * (y4 - y3) + y1 * (x4 - x3) - y3 * (x4 - x3) - x1 * (y4 - y3)) 
                / ((x2 - x1) * (y4 - y3) - (x4 - x3) * (y2 - y1));
            double t2 = (double) (x1 * (y2 - y1) + y3 * (x2 - x1) - y1 * (x2 - x1) - x3 * (y2 - y1)) 
                / ((x4 - x3) * (y2 - y1) - (x2 - x1) * (y4 - y3));
            if (t1 >= 0.0 && t2 >= 0.0 && t1 <= 1.0 && t2 <= 1.0) {
                x = x1 + t1 * (x2 - x1);
                y = y1 + t1 * (y2 - y1);
                intersect = true;
            }
        }
        return intersect ? new double[]{x, y} : new double[0];
    }
    boolean inside(int[][] segment, int[] point ) {
        int x1 = segment[0][0], x2 = segment[1][0], xk = point[0];
        int y1 = segment[0][1], y2 = segment[1][1], yk = point[1];
        return (x1 == x2 || (Math.min(x1, x2) <= xk && xk <= Math.max(x1, x2))) && (y1 == y2 || (Math.min(y1, y2) <= yk && yk <= Math.max(y1, y2)));
    }

    boolean update(int[] point, boolean intersect) {
        int xk = point[0], yk = point[1];
        if (!intersect || xk < x || (xk == x && yk < y)){
            x = xk;
            y = yk;
            return true;
        }
        return intersect;
    }
}