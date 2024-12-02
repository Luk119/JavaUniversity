package laboratory9.Task1;

import java.util.Objects;

public class Przedzial {
    private final Double min;    // dolny kraniec
    private final Double max;    // górny kraniec
    private final boolean minInclusive; // czy dolny kraniec jest domknięty
    private final boolean maxInclusive; // czy górny kraniec jest domknięty
    private static final Double NEG_INF = Double.NEGATIVE_INFINITY;
    private static final Double POS_INF = Double.POSITIVE_INFINITY;

    // Konstruktor
    public Przedzial(Double min, boolean minInclusive, Double max, boolean maxInclusive) {
        if (min > max || (min.equals(max) && (!minInclusive || !maxInclusive))) {
            throw new IllegalArgumentException("Niepoprawny przedział");
        }
        this.min = min;
        this.max = max;
        this.minInclusive = minInclusive;
        this.maxInclusive = maxInclusive;
    }

    // Reprezentacja pustego przedziału
    public static Przedzial pusty() {
        return new Przedzial(0.0, false, 0.0, false);
    }

    // Suma dwóch przedziałów
    public Przedzial suma(Przedzial inny) {
        if (this.czyRozlaczne(inny)) {
            return pusty();
        }
        double nowyMin = Math.min(this.min, inny.min);
        double nowyMax = Math.max(this.max, inny.max);
        boolean nowyMinInclusive = (this.min < inny.min) ? this.minInclusive : inny.minInclusive;
        boolean nowyMaxInclusive = (this.max > inny.max) ? this.maxInclusive : inny.maxInclusive;
        return new Przedzial(nowyMin, nowyMinInclusive, nowyMax, nowyMaxInclusive);
    }

    // Iloczyn dwóch przedziałów
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

    // Różnica dwóch przedziałów
    public Przedzial roznica(Przedzial inny) {
        if (this.czyRozlaczne(inny) || this.equals(inny)) {
            return this;
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

    // Dopelnienie
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

    // Czy przedziały są rozłączne
    private boolean czyRozlaczne(Przedzial inny) {
        return (this.max < inny.min || (this.max.equals(inny.min) && (!this.maxInclusive || !inny.minInclusive)))
                || (inny.max < this.min || (inny.max.equals(this.min) && (!inny.maxInclusive || !this.minInclusive)));
    }

    // Reprezentacja tekstowa
    @Override
    public String toString() {
        if (this.equals(pusty())) {
            return "{}";
        }
        String lewyNawias = minInclusive ? "[" : "(";
        String prawyNawias = maxInclusive ? "]" : ")";
        return lewyNawias + (min.equals(NEG_INF) ? "-INF" : min) + ", " + (max.equals(POS_INF) ? "INF" : max) + prawyNawias;
    }

    // Równość przedziałów
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Przedzial)) return false;
        Przedzial przedzial = (Przedzial) o;
        return Objects.equals(min, przedzial.min) && Objects.equals(max, przedzial.max)
                && minInclusive == przedzial.minInclusive && maxInclusive == przedzial.maxInclusive;
    }
}
