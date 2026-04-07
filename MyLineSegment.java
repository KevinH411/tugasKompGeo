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
    * [4] cek segmen berpotongan dengan segmen lain.
    * * @param other Segmen garis lain yang akan diperiksa
    * @return true jika berpotongan, false jika tidak
    */

    boolean isIntersect(MyLineSegment other) {
    boolean potong = false;

    // Hitung orientasi untuk setiap kombinasi titik ujung
    // d1 dan d2 memeriksa posisi start dan end segmen ini terhadap segmen 'other'
    double d1 = CG.ccw(other.start, other.end, this.start);
    double d2 = CG.ccw(other.start, other.end, this.end);
    
    // d3 dan d4 memeriksa posisi start dan end segmen 'other' terhadap segmen ini
    double d3 = CG.ccw(this.start, this.end, other.start);
    double d4 = CG.ccw(this.start, this.end, other.end);

    // Menghandle titik-titik ujung berada pada sisi yang berbeda
    // (d1 * d2 < 0) satu di kiri dan satu di kanan
    // jika menyentuh (res == 0) dianggap "Ya"
    if (((d1 > 0 && d2 < 0) || (d1 < 0 && d2 > 0) || d1 == 0 || d2 == 0) &&
        ((d3 > 0 && d4 < 0) || (d3 < 0 && d4 > 0) || d3 == 0 || d4 == 0)) {
        
        // Jika kedua garis berada pada satu garis lurus yang sama, 
        // perlu dipastikan mereka benar-benar overlap
        if (d1 == 0 && d2 == 0 && d3 == 0 && d4 == 0) {
            // Cek overlap pada sumbu X atau Y
            if (Math.max(this.start.x, this.end.x) >= Math.min(other.start.x, other.end.x) &&
                Math.max(other.start.x, other.end.x) >= Math.min(this.start.x, this.end.x) &&
                Math.max(this.start.y, this.end.y) >= Math.min(other.start.y, other.end.y) &&
                Math.max(other.start.y, other.end.y) >= Math.min(this.start.y, this.end.y)) {
                potong = true;
            }
        } else {
            potong = true;
        }
    }

    return potong;
}

}