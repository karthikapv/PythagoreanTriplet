import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class PythagoreanTriplet {
    private final int a;
    private final int b;
    private final int c;

    PythagoreanTriplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PythagoreanTriplet)) return false;
        PythagoreanTriplet other = (PythagoreanTriplet) o;
        return a == other.a &&
                b == other.b &&
                c == other.c;
    }
    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    static PythagoreanTripletListBuilder makeTripletsList() {
        return new PythagoreanTripletListBuilder();
    }

    static class PythagoreanTripletListBuilder {
        private int maxFactors;
        private int sum;
        public PythagoreanTripletListBuilder withFactorsLessThanOrEqualTo( final int maxFactors ) {
            this.maxFactors = maxFactors;
            return this;
        }
        public PythagoreanTripletListBuilder thatSumTo( final int sum ) {
            this.sum = sum;
            return this;
        }
        public List<PythagoreanTriplet> build( ) {
            if ( maxFactors <= 0 || sum <= 0 ) {
                throw new IllegalStateException( "maxFactors and/or the sum have not been correctly initialized." );
            }
            final List<PythagoreanTriplet> triplets = new ArrayList<>( );
            for ( int a = 1; a < maxFactors - 4; a++ ) {
                for ( int b = a + 1; b < maxFactors - 3; b++ ) {
                    final int c = sum - a - b;
                    if ( a * a + b * b == c * c ) {
                        triplets.add( new PythagoreanTriplet( a, b, c ) );
                    }
                }
            }
            return triplets;
        }
    }
}