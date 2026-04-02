public class MyPoint {
    /** komen di sini */
    public double x;
    /** komen di sini */
    public double y;

    /**
     * konstruktor
     * @param x
     * @param y
     */
    MyPoint (double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * [1] jarak ke titik laen
     * @param o
     * @return
     */
    double distanceToOtherPoints(MyPoint o) {
		double dist = 0.0;
		
        return dist;
    }
    
    /**
     * [2b] jarak ke segmen garis
     * @param l
     * @return
     */
    double distanceToLineSegment(MyLineSegment l) {
		double res = 0.0;
        //panggil aja dari l, l.distanceToPoint(this);
        return res;
    }
}
