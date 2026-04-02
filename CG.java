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

    private static MyPoint convertToVector(MyPoint p1, MyPoint p2) {
        // konversi vektor ke origin 0,0
        return new MyPoint(p2.x - p1.x, p2.y - p1.y);
    }

    /**
     * jika perlu
     * 
     * @return
     */
    public static double dot(MyPoint p1, MyPoint p2, MyPoint q1, MyPoint q2) {
        MyPoint vectorP = convertToVector(p1, p2);
        MyPoint vectorQ = convertToVector(q1, q2);
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
}
