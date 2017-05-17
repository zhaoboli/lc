public class Solution {
    /**
     * @param x a double
     * @return the square root of x
     */
    public double sqrt(double x) {
        double left = 0.0;
        double right = x;
        if (x < 1.0) {
            right = 1.0;
        }
        double eps = 1e-10;
        while (right - left > eps) {
            double mid = left + (right - left) / 2;
            if ( mid * mid < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
