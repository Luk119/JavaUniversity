package laboratory9.Task1;

import java.util.Objects;

//Łukasz Kundzicz
public class Przedzial {
    private final Double min;//lewy kraniec przedziału
    private final Double max;//prawy kraniec przedziału
    private final boolean minInclusive;//czy lewy kraniec jest domknięty
    private final boolean maxInclusive;//czy prawy kraniec jest domknięty
    private static final Double NEG_INF = Double.NEGATIVE_INFINITY;//- nieskończoność
    private static final Double POS_INF = Double.POSITIVE_INFINITY;//+ nieskończoność

    //konstruktor
    public Przedzial(Double min, boolean minInclusive, Double max, boolean maxInclusive) {
        if ((min > max) || (min.equals(max) && !minInclusive && !maxInclusive)) {
            if (min.equals(POS_INF) && max.equals(NEG_INF)) {
                //gdy przedział pusty
                this.min = POS_INF;
                this.max = NEG_INF;
                this.minInclusive = false;
                this.maxInclusive = false;
                return;
            }
            throw new IllegalArgumentException("Niepoprawny przedział: " + min + ", " + max);
        }
        this.min = min;
        this.max = max;
        this.minInclusive = minInclusive;
        this.maxInclusive = maxInclusive;
    }

    //metoda zwracająca pusty przedział
    public static Przedzial pusty() {
        return new Przedzial(POS_INF, false, NEG_INF, false);
    }

    //oblicza sumę dwóch przedziałów
    public Przedzial suma(Przedzial inny) {
        double nowyMin = Math.min(this.min, inny.min);
        double nowyMax = Math.max(this.max, inny.max);
        boolean nowyMinInclusive = (this.min < inny.min) ? this.minInclusive : inny.minInclusive;
        boolean nowyMaxInclusive = (this.max > inny.max) ? this.maxInclusive : inny.maxInclusive;
        return new Przedzial(nowyMin, nowyMinInclusive, nowyMax, nowyMaxInclusive);
    }

    //suma rozłącznych przedziałów (nie łączy ich w jeden)
    public Przedzial[] sumaRozlaczna(Przedzial inny) {
        Przedzial p1 = new Przedzial(this.min, this.minInclusive, this.max, this.maxInclusive);
        Przedzial p2 = new Przedzial(inny.min, inny.minInclusive, inny.max, inny.maxInclusive);
        return new Przedzial[]{p1, p2};
    }

    //oblicza iloczyn dwóch przedziałów
    public Przedzial iloczyn(Przedzial inny) {
        if (this.czyRozlaczne(inny)) {
            return pusty();
        }
        double nowyMin = Math.max(this.min, inny.min);
        double nowyMax = Math.min(this.max, inny.max);
        boolean nowyMinInclusive = (this.min > inny.min) ? this.minInclusive : inny.minInclusive;
        boolean nowyMaxInclusive = (this.max < inny.max) ? this.maxInclusive : inny.maxInclusive;
        return new Przedzial(nowyMin, nowyMinInclusive, nowyMax, nowyMaxInclusive);
    }

    //oblicza różnicę dwóch przedziałów
    public Przedzial roznica(Przedzial inny) {
        if (this.equals(inny)) {
            return pusty();
        }
        if (inny.min <= this.min && inny.max >= this.max) {
            return pusty();
        }
        if (inny.min > this.min && inny.max < this.max) {
            throw new UnsupportedOperationException("Rozdzielenie na dwa przedziały nieobsługiwane");
        }
        if (inny.min > this.min) {
            return new Przedzial(this.min, this.minInclusive, inny.min, !inny.minInclusive);
        }
        return new Przedzial(inny.max, !inny.maxInclusive, this.max, this.maxInclusive);
    }

    //oblicza dopełnienie przedziału
    public Przedzial dopelnienie() {
        if (this.min.equals(NEG_INF) && this.max.equals(POS_INF)) {
            return pusty();
        }
        if (this.min.equals(NEG_INF)) {
            return new Przedzial(this.max, !this.maxInclusive, POS_INF, false);
        }
        if (this.max.equals(POS_INF)) {
            return new Przedzial(NEG_INF, false, this.min, !this.minInclusive);
        }
        throw new UnsupportedOperationException("Wiele przedziałów w dopełnieniu nieobsługiwane");
    }

    //sprawdza czy przedziały są rozłączne
    private boolean czyRozlaczne(Przedzial inny) {
        return this.max < inny.min || (this.max.equals(inny.min) && (!this.maxInclusive || !inny.minInclusive))
                || inny.max < this.min || (inny.max.equals(this.min) && (!inny.maxInclusive || !this.minInclusive));
    }

    //nadpisanie toStringa - reprezentacja tekstowa
    @Override
    public String toString() {
        if (this.equals(pusty())) {
            return "{}";
        }
        String lewyNawias = minInclusive ? "[" : "(";
        String prawyNawias = maxInclusive ? "]" : ")";
        return lewyNawias + (min.equals(NEG_INF) ? "-INF" : min) + ", " + (max.equals(POS_INF) ? "INF" : max) + prawyNawias;
    }

    //nadpisanie equals pod pracę z przedziałami
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Przedzial)) return false;
        Przedzial przedzial = (Przedzial) o;
        return Objects.equals(min, przedzial.min) && Objects.equals(max, przedzial.max)
                && minInclusive == przedzial.minInclusive && maxInclusive == przedzial.maxInclusive;
    }
}
