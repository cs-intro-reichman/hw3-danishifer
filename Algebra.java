// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int result = x1;
		if (x2 >= 0) {
			for (int i = 0; i < x2; i++) {
				result++;
			}
		} else {
			for (int i = 0; i > x2; i--) {
				result--;
			}
		}
		return result;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		return plus(x1, negate(x2));
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int a = x1;
		int b = x2;
		boolean negative = false;
		if (a < 0) {
			a = negate(a);
			negative = !negative;
		}
		if (b < 0) {
			b = negate(b);
			negative = !negative;
		}
		int result = 0;
		for (int i = 0; i < b; i++) {
			result = plus(result, a);
		}
		return negative ? negate(result) : result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int result = 1;
		for(int i = 0; i < n; i++) {
			result = times(result, x);
		}
		return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int dividend = x1;
		int divisor = x2;
		boolean negative = false;
		if (dividend < 0) {
			dividend = negate(dividend);
			negative = !negative;
		}
		if (divisor < 0) {
			divisor = negate(divisor);
			negative = !negative;
		}
		int result = 0;
		while (dividend >= divisor) {
			dividend = minus(dividend, divisor);
			result++;
		}
		return negative ? negate(result) : result;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int quotient = div(x1, x2);
		int product = times(quotient, x2);
		return minus(x1, product);
	} 

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int root = 0;
		int odd = 1;
		int remaining = x;
		while (remaining >= 0) {
			remaining = minus(remaining, odd);
			odd = plus(odd, 2);
			root = plus(root, 1);
		}
		return minus(root, 1);
	}

	// Helper that returns -x without using '-'
	private static int negate(int x) {
		int neg = 0;
		if (x >= 0) {
			while (x > 0) {
				x--;
				neg--;
			}
		} else {
			while (x < 0) {
				x++;
				neg++;
			}
		}
		return neg;
	}
}