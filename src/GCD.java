/**
 * Author Name: Marissa Crevecoeur
 * Project Name: GCD
 */

public class GCD {

    /**
     * @param m
     * @param n
     * @return  the greatest common divisor between the two params
     *
     * it contains three local variables representing the different parts needed to
     * complete the process, numr meaning the numerator, denom being the denominator,
     * and the remainder
     */

    public static int iterativeGcd(int m, int n) {
        if (m == 0 || n == 0) { if (m == 0) return n; return m; }

        int numr = Math.abs(Math.max(m,n));
        int denom = Math.abs(Math.min(m,n));
        int remainder = numr % denom;

        while (remainder > 0) {
            numr = denom;
            denom = remainder;
            remainder = numr % denom;
        }
        return denom;
    }

    /**
     *
     * @param m
     * @param n
     * @return  the greatest common divisor between the two params
     *
     * similarly to above, this method takes two arguments (both ints)
     * and returns the common divisor of both
     * it uses recursion (within a ternary operator) to find the greatest common divisor
     */

    public static int recursiveGcd(int m, int n){
        if (m == 0 || n == 0) { if (m == 0) return n; return m; }

        int numr = Math.abs(Math.max(m,n));
        int denom = Math.abs(Math.min(m,n));
        int remainder = numr % denom;

        int answer = (remainder == 0) ? denom : recursiveGcd(denom,remainder);
        return answer;

        /*  if (numr%denom == 0 ) return denom;
            recursiveGcd(denom, numr%denom);
         */
    }

    /**
     * @param args
     *
     * It's a main method so the arguments are whatever that is inputted into the terminal.
     * It should print the various errors, or if the code succeeds (or is undefined)
     * print the output from the above methods iterativeGCD and recursiveGCD
     */

    public static void main(String[] args) {
        int one = 0, two = 0;
        try {
            one = Integer.parseInt(args[0]);
            if(args.length != 2) throw new RuntimeException();
        }
        catch(IllegalArgumentException eOne){
            System.err.println("Error: The first argument is not a valid integer.");
            System.exit(1);
        }
        catch(RuntimeException last){
            System.err.println("Usage: java GCD <integer m> <integer n>");
            System.exit(1);
        }

        try {
            two = Integer.parseInt(args[1]);
            if (one == 0 && two == 0) throw new RuntimeException();
        }

        catch(IllegalArgumentException ike){
            System.err.println("Error: The second argument is not a valid integer.");
            System.exit(1);
        }
        catch(RuntimeException iae){
            System.err.println("gcd(0, 0) = undefined");
            System.exit(0);
        }

        System.out.println("Iterative: gcd(" + one + ", " + two + ") = " + iterativeGcd(one, two));
        System.out.println("Recursive: gcd(" + one + ", " + two + ") = " + recursiveGcd(one, two));
        System.exit(0);
    }
}