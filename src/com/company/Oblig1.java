package com.company;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;


class Oblig1 {

    ///// Oppgave 1 //////////////////////////////////////
    static int maks(int[] a) {
        if (a.length == 0) {
            throw new NoSuchElementException("Arrayet er heelt tomt");
        }
        int i = 0;
        while (i < a.length - 1) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
            ++i;
        }
        return a[a.length - 1];
    }

    static int ombyttinger(int[] a) {
        if (a.length == 0) {
            throw new NoSuchElementException("Arrayet er fortsatt heelt tomt");
        }
        int count = 0;
        for (int j = 0; j < a.length - 1; ++j) {
            if (a[j] > a[j + 1]) {
                int temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
                count++;
            }
        }
        return count;
    }

    /*
    Når blir det flest ombyttinger?
     - Når det største tallet står først blir det flest ombyttinger, siden den da må gå gjennom hele tabellen.
    Når blir det færrest?
     - Det blir færrest om arrayet er sortert stigende. Da blir det ingen.
     Hvor mange blir det i gjennomsnitt?
      - n-1 ganger siden den sammeligner i linje 35 og det blir den dominerende operasjonen.
      -  For eksempel med arraylengde 3 så blir gjennomsnittet 7/6

      Kan du på grunnlag av dette si om metoden maks er bedre ( eller dårligere ) enn
      de maks-metodene vi har sett på tidligere?
       -


     */

    ///// Oppgave 2 //////////////////////////////////////
    static int antallUlikeSortert(int[] a) {
        if (a.length == 0) {
            return 0;
        }
        int count = 1;
        int begin = 0;
        int end = a.length - 1;
        for (int i = begin; i < end; i++) {
            if (a[i] < a[i + 1]) {
                count++;
            } else if (a[i] == a[i + 1]) {
                a[i] = a[i + 1];
                //Ingen forandring hvis lik.
            } else {
                throw new IllegalStateException("Arrayet er ikke sortert");
            }
        }
        return count;
    }

    ///// Oppgave 3 //////////////////////////////////////
    static int antallUlikeUsortert(int[] a) {
        int antallUlike;

        ArrayList<Integer> ulikeTall = new ArrayList<>();

        for (int value : a) {
            if (!ulikeTall.contains(value)) {
                ulikeTall.add(value);
            }
        }

        if (ulikeTall.size() == 1) {
            antallUlike = 1;
        } else {
            antallUlike = ulikeTall.size();
        }
        return antallUlike;


    }

    ///// Oppgave 4 //////////////////////////////////////

    // Lager en sortering type quicksort for å sortere arrayet
    private static void sorter(int[] a, int start, int slutt) {
        if (start < slutt) {
            int pivot_indeks = partisjon(a, start, slutt);
            sorter(a, start, pivot_indeks - 1);
            sorter(a, pivot_indeks + 1, slutt);
        }
    }

    private static int partisjon(int[] a, int start, int slutt) {
        int pivot = a[slutt];
        int pivot_indeks = start;
        for (int i = start; i < slutt; ++i) {
            if (a[i] <= pivot) {
                bytt(a, i, pivot_indeks);
                pivot_indeks++;
            }
        }
        bytt(a, pivot_indeks, slutt);
        return pivot_indeks;
    }

    private static void bytt(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }


    static void delsortering(int[] a) {
        int venstre = 0;
        int n = a.length - 1;
        int hoyre = n;
        int tellerOdd = 0;
        int tellerPar = 0;

        while (venstre < hoyre) {
            while (a[venstre] % 2 != 0 && venstre < hoyre) {
                venstre++;
                tellerOdd++;
            }
            while (a[hoyre] % 2 == 0 && venstre < hoyre) {
                hoyre--;
                tellerPar++;
            }
            if (venstre < hoyre) {
                int temp = a[venstre];
                a[venstre] = a[hoyre];
                a[hoyre] = temp;
            }
        }
        if (tellerPar == 0) {
            sorter(a, 0, n);
        }
        sorter(a, 0, tellerOdd - 1);
        sorter(a, tellerOdd, n);
    }

    ///// Oppgave 5 //////////////////////////////////////
    // Endretd denne til void, for å unngå warnings
    static void rotasjon(char[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            char temp = a[i];
            a[i] = a[i - 1];
            a[i - 1] = temp;
        }
    }

    ///// Oppgave 6 //////////////////////////////////////
    private static void bytt(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void rotasjon(char[] a, int k) {
        int n = a.length;
        if (n < 2) return;
        if ((k %= n) < 0) k += n;

        for (int v = 0, h = n - 1; v < h; ) {
            Oblig1.bytt(a, v++, h--);
        }
        for (int v = 0, h = k - 1; v < h; ) {
            Oblig1.bytt(a, v++, h--);
        }
        for (int v = k, h = n - 1; v < h; ) {
            Oblig1.bytt(a, v++, h--);
        }

    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    static String flett(String s, String t) {
        StringBuilder flett = new StringBuilder();
        int lengdePaaArray = Math.max(s.length(), t.length());

        for (int i = 0; i < lengdePaaArray; i++) {
            if (i < s.length()) {
                flett.append(s.charAt(i));
            }
            if (i < t.length()) {
                flett.append(t.charAt(i));
            }
        }
        return flett.toString();
    }

    /// 7b)
    static String flett(String... s) {
        StringBuilder flett = new StringBuilder();

        if (s.length != 0) {
            int lengde = s[0].length();

            for (int i = 0; i < s.length - 1; i++) {
                if (s[i].length() <= s[i + 1].length()) {
                    lengde += s[i + 1].length();
                }
            }
            for (int i = 0; i < lengde; ++i) {
                for (String value : s) {
                    if (value.length() > i) {
                        flett.append(value.charAt(i));
                    }
                }
            }
        }
        return flett.toString();
    }

    ///// Oppgave 8 //////////////////////////////////////
    static int[] indekssortering(int[] a) {
        int[] arrayMedLengdeSomA = new int[a.length];

        int[] kopiAvA = Arrays.copyOf(a, a.length);

        for (int i = 0; i < kopiAvA.length; ++i) {
            for (int j = 0; j < kopiAvA.length - 1; ++j) {
                if (kopiAvA[j] > kopiAvA[j + 1]) {
                    int temp = kopiAvA[j];
                    kopiAvA[j] = kopiAvA[j + 1];
                    kopiAvA[j + 1] = temp;
                }
            }
        }
        int i = 0;
        while (i < kopiAvA.length) {
            for (int j = 0; j < kopiAvA.length; ++j) {
                if (kopiAvA[i] == a[j]) {
                    arrayMedLengdeSomA[i] = j;
                    i++;
                    if (i == kopiAvA.length) {
                        break;
                    }
                }
            }
        }
        return arrayMedLengdeSomA;
    }


    ///// Oppgave 9 //////////////////////////////////////
    static int[] tredjeMin(int[] a) {
        int n = a.length;
        if (n < 3) {
            throw new NoSuchElementException("Arrayet har ikke 3 elementer");
        }
        int[] indeks = indekssortering(new int[]{a[0], a[1], a[2]});

        int m = indeks[0];
        int nm = indeks[1];
        int tm = indeks[2];


        int minstverdi = a[m];
        int nestminstverdi = a[nm];
        int tredjminstverdi = a[tm];


        for (int i = 3; i < n; ++i) {

            int verdi = a[i];
            if (verdi < tredjminstverdi) {
                if (verdi < nestminstverdi) {
                    if (verdi < minstverdi) {
                        tm = nm;
                        tredjminstverdi = nestminstverdi;

                        nm = m;
                        nestminstverdi = minstverdi;

                        m = i;
                        minstverdi = verdi;
                    } else {
                        tm = nm;
                        tredjminstverdi = nestminstverdi;

                        nm = i;
                        nestminstverdi = verdi;
                    }
                } else {
                    tm = i;
                    tredjminstverdi = verdi;
                }
            }
        }
        return new int[]{m, nm, tm};
    }

    ///// Oppgave 10 //////////////////////////////////////
    /*static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }
    Ser ikke ut til å trenge dette.
     */

    static boolean inneholdt(String a, String b) {

        char[] aStringen = a.toCharArray();
        char[] bStringen = b.toCharArray();

        int[] aString = new int[256], bString = new int[256];

        for (char c : aStringen) {
            aString[c]++;
        }
        for (char c : bStringen) {
            bString[c]++;
        }
        for (int i = 0; i < 256; ++i) {
            if (aString[i] > bString[i]) {
                return false;
            }
        }
        return true;
    }

}  // Oblig1
