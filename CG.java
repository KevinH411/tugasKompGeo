public class CG {

    /**
     * Memeriksa apakah dari p ke q ke r berlawanan arah jarum jam atau tidak
     * 
     * @return >0 jika berlawanan arah jarum jam (belok kiri),
     *         <0 jika searah jarum jam (belok kanan), dan 0 jika lurus (kolinear)
     */
    public static double ccw(MyPoint p, MyPoint q, MyPoint r) {
        MyPoint pq = new MyPoint((q.x - p.x), (q.y - p.y));
        MyPoint pr = new MyPoint((r.x - p.x), (r.y - p.y));
        double res = ((pq.x * pr.y) - (pq.y * pr.x));
        if (Math.abs(res) <= 0.00000001)
            res = 0;
        // else res = res/Math.abs(res);
        return res;
    }

    private static MyPoint convertToVector(MyLineSegment line) {
        // konversi vektor ke origin 0,0
        return new MyPoint(line.end.x - line.start.x, line.end.y - line.start.y);
    }

    /**
     * jika perlu
     * 
     * @return
     */
    public static double dot(MyLineSegment line1, MyLineSegment line2) {
        MyPoint vectorP = convertToVector(line1);
        MyPoint vectorQ = convertToVector(line2);
        return (vectorP.x * vectorQ.x) + (vectorP.y * vectorQ.y);
    }

    public static double dot(MyPoint p, MyPoint q) {
        return (p.x * q.x) + (p.y * q.y);
    }

    /**
     * jika perlu
     * 
     * @return
     */
    public static MyPoint cross(MyPoint p, MyPoint q) {
        return new MyPoint(0, 0);
    }

    public static double cross(MyLineSegment line1, MyLineSegment line2) {
        MyPoint vectorP = convertToVector(line1);
        MyPoint vectorQ = convertToVector(line2);
        return (vectorP.x * vectorQ.y) - (vectorP.y * vectorQ.x);
    }
}
