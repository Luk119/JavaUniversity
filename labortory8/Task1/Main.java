package labortory8.Task1;

public class Main {

    // 1. Palindrom
    public static boolean czyPalindrom(String s) {
        s = s.replaceAll("\\s+", "").toLowerCase(); // Ignorowanie spacji i wielkości liter
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }

    // 2. Suma cyfr
    public static int suma(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += c - '0';
            }
        }
        return sum;
    }

    // 4. Suma binarnie
    public static String sumaBinarna(String s1, String s2) {
        int bin1 = Integer.parseInt(s1, 2);
        int bin2 = Integer.parseInt(s2, 2);
        return Integer.toBinaryString(bin1 + bin2);
    }

    // 5. Zamiana liter
    public static String samogloskiSpolgloski(String s) {
        String result = "";
        for (char c : s.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1) {
                result += Character.toUpperCase(c);
            } else if (Character.isLetter(c)) {
                result += Character.toLowerCase(c);
            } else {
                result += c;
            }
        }
        return result;
    }

    // 6. Wielkie litery
    public static boolean tylkoWielkie(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isUpperCase(c)) {
                return false;
            }
        }
        return true;
    }

    // 7. Największa cyfra
    public static int maxWartosc(String s) {
        int max = -1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                max = Math.max(max, c - '0');
            }
        }
        return max;
    }

    // 8. Szyfr Cezara
    public static String cezar(String s) {
        StringBuilder result = new StringBuilder();
////        for(int i=0; i<300; i++){
////            System.out.print(i);
////            System.out.println((char) i);
//        }
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append((char) ('A' + (c - 'A' + 1) % 26));
            } else if (Character.isLowerCase(c)) {
                result.append((char) ('a' + (c - 'a' + 1) % 26));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }


    // 9. Szyfr harcerski
    public static String harcerski(String s) {
        String pairs = "GADEYROPULKI";
        String map = "AGEDYRPOLUKI";
        String result = "";
        for (char c : s.toCharArray()) {
            int index = pairs.indexOf(Character.toUpperCase(c));
            if (index != -1) {
                char replaced = map.charAt(index);
                result += Character.isLowerCase(c) ? Character.toLowerCase(replaced) : replaced;
            } else {
                result += c;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        // 1. Palindrom
        System.out.println("Anna :" + czyPalindrom("Anna")); // true
        System.out.println("Jacek: " + czyPalindrom("Jacek")); // false

        // 2. Suma cyfr
        System.out.println(suma("1234: " + "1234")); // 10

        // 3. Data i Osoba
        Osoba osoba = new Osoba("Kowalski", "03260201234");
        System.out.println("data(d/m/r): " + osoba.pesel2data());
        System.out.println("plec(K lub M)" + osoba.plec());

        // 4. Suma binarnie
        System.out.println(sumaBinarna("110", "11")); // 1001

        // 5. Zamiana liter
        System.out.println(samogloskiSpolgloski("Kodowanie jest SUPER")); // "kOdOwAnIe jEst sUpEr"

        // 6. Wielkie litery
        System.out.println(tylkoWielkie("CZESC")); // true
        System.out.println(tylkoWielkie("CzeSC")); // false

        // 7. Największa cyfra
        System.out.println(maxWartosc("4829")); // 9

        // 8. Szyfr Cezara
        System.out.println("Cezar:");
        System.out.println("Kodowanie cezarem: " + cezar("Kodowanie cezarem"));
        System.out.println("Ala ma kota: " + cezar("Ala ma kota"));

        // 9. Szyfr harcerski
        System.out.println(harcerski("GADERYPOLUKI"));
        System.out.println(harcerski("Testowanie Harcerskie"));
    }
}

