public class CorelCo {
	
//		  Code Reference
//		  Title: Calculate correlation
//	      Author: dmitry-bychenko
//	      Date: 2016
//	      Availability: http://stackoverflow.com/questions/28428365/how-to-find-correlation-between-two-integer-arrays-in-java
	
	
	public static double Correlation(double[] xs, double[] ys) {
	    
		// declarations
	    double sx = 0.0;
	    double sy = 0.0;
	    double sxx = 0.0;
	    double syy = 0.0;
	    double sxy = 0.0;

	    int n = xs.length;

	    for(int i = 0; i < n; ++i) {
	      double x = xs[i];
	      double y = ys[i];

	      sx += x;
	      sy += y;
	      sxx += x * x;
	      syy += y * y;
	      sxy += x * y;
	    }

	    // covariation
	    double cov = sxy / n - sx * sy / n / n;
	    // standard error of x
	    double sigmax = Math.sqrt(sxx / n -  sx * sx / n / n);
	    // standard error of y
	    double sigmay = Math.sqrt(syy / n -  sy * sy / n / n);

	    // correlation normalized
	    double z = cov / sigmax / sigmay;
	    
	    // result
	    return z;
	    
	    
	  }
	
}	