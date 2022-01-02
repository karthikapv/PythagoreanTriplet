public class PythagoreanTriplets {
    public static void main(String[] args){
        PythagoreanTriplets pythagoreanTriplets = new PythagoreanTriplets();
        pythagoreanTriplets.generateTriplets(90);
    }
    public void generateTriplets(int sum){
        for ( int a = 1; a < sum; a++ ) {
            for ( int b = a + 1; b < sum; b++ ) {
                final int c = sum - a - b;
                if ( a * a + b * b == c * c ) {
                    System.out.print(a+" "+b+" "+c+"\n");
                }
            }
        }
    }
}
