

public class Median{


    public static void main(String...args){

        int[] arrA = {1,2,3,4,84};
        int[] arrB = {5,6,7,7,91};
        double median = findMedian(arrA, arrB);
        System.out.println(median);
    }
    public static double findMedian(int[] arrayA, int[] arrayB) {
        if (arrayA.length > arrayB.length) {
            return findMedian(arrayA, arrayB);
        }
        int m = arrayA.length;
        int n = arrayB.length;
        int lo = 0;
        int hi = m;
        
        while (lo <= hi) {
            int parX = (lo + hi) / 2;
            int parY = (m + n + 1) / 2 - parX;
            
            int maxX = (parX == 0) ? Integer.MIN_VALUE : arrayA[parX - 1];
            int maxY = (parY == 0) ? Integer.MIN_VALUE : arrayB[parY - 1];
            
            int minX = (parX == m) ? Integer.MAX_VALUE : arrayA[parX];
            int minY = (parY == n) ? Integer.MAX_VALUE : arrayB[parY];
            
            if (maxX <= minY && maxY <= minX) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxX, maxY) + Math.min(minX, minY)) / 2.0;
                } else {
                    return Math.max(maxX, maxY);
                }
            } else if (maxX > minY) {
                hi = parX - 1;
            } else {
                lo = parX + 1;
            }
        } 
        throw new IllegalArgumentException("Input arrays are unsorted.");
    }

}