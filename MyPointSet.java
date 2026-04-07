import java.util.ArrayList;
import java.util.List;

public class MyPointSet {
    /**  */
    List<MyPoint> Points;

    /**
     * konstruktor
     * 
     * @return
     */
    public MyPointSet() {
        this.Points = new ArrayList<MyPoint>();
    }

    /**
     * [8a] masukin titik
     * 
     * @param p
     * @return
     */
    boolean addPoint(MyPoint p) {
        Points.add(p);
        return true;
    }

    public void sort() {
        /**
         * Step pertama adalah untuk mencari point yang paling kiri dan bawah di set(disebut pivot)
         * pivot lalu akan dipakai seperti 0,0 yang akan digunakan untuk mencompare apakah titik a dan b kiri atau kanan
         * jika hasil ccw kiri(>0) maka b lebih keatas, jika kanan(<0) maka b lebih kebawah
         */
        MyPoint pivot = new MyPoint(Double.MAX_VALUE, Double.MAX_VALUE);
        int idx = 0;
        for (int i = 0; i < Points.size(); i++) {
            MyPoint temp = Points.get(i);
            if (temp.y < pivot.y) {
                pivot = temp;
                idx = i;
            } else if (temp.y == pivot.y && temp.x < pivot.x) {
                pivot = temp;
                idx = i;
            }
        }
        Points.remove(idx);

        MyPoint finalPivot = pivot;
        Points.sort((a, b) -> {
            double compare = CG.ccw(finalPivot, a, b);
            if (compare > 0)
                return -1;
            if (compare < 0)
                return 1;

            double distance1 = finalPivot.distanceToOtherPoints(a);
            double distance2 = finalPivot.distanceToOtherPoints(b);
            if (distance1 > distance2)
                return 1;
            if (distance2 > distance1)
                return -1;

            return 0;
        });

        Points.add(0, pivot);
    }
}