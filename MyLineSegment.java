public class MyLineSegment {
    /** ``vektor'' dari start ke end */
    MyPoint start;
    /** komen di sini */
    MyPoint end;

    /**
     * konstruktor
     * 
     * @param start
     * @param end
     */
    MyLineSegment(MyPoint start, MyPoint end) {
        this.start = start;
        this.end = end;
    }

    /**
     * [2a] jarak ke titik
     * 
     * @param p
     * @return
     */
    double distanceToPoint(MyPoint p) {
        double dist = 0.0; // menyimpan jarak
        // Cek apakah end ke point p searah(dot product > 0), yang berarti titik
        // terdekat ke p adalah end
        if (CG.dot(this, new MyLineSegment(this.end, p)) > 0) {
            dist = p.distanceToOtherPoints(this.end);
        }
        // Cek apakah start ke point p searah(dot product > 0), yang berarti titik
        // terdekat ke p adalah start
        else if (CG.dot(new MyLineSegment(this.end, this.start), new MyLineSegment(this.start, p)) > 0) {
            dist = p.distanceToOtherPoints(this.start);
        } else {
            /**
             * Jika 2 point terakhir bukan terdekat dengan start atau end, berarti p
             * diantara line segment dan jarak terdekat dapat dihitung dengan cross product,
             * lalu area tersebut dibagi oleh alas
             */
            double area = Math.abs(CG.cross(this, new MyLineSegment(this.start, p)));
            dist = area / (this.start.distanceToOtherPoints(this.end));
        }
        return dist;
    }

    /**
     * [3] dari start ke end ke target belok kiri, kanan, atao lurus
     * 
     * @param target
     * @return
     */
    double leftTurnToPoint(MyPoint target) {
        double res = 0.0;
        res = CG.ccw(this.start, this.end, target);
        return res; // return 0 jika lurus, plus/minus jika belok kanan/kiri,
    }

    /**
     * [4] motong segmen laen?
     * 
     * @param other
     * @return
     */
    boolean isIntersect(MyLineSegment other) {
        boolean potong = false;

        return potong;
    }

}