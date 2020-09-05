package com.company;

////// Løsningsforslag Oblig 1 ////////////////////////

import javax.swing.text.Element;
import java.lang.UnsupportedOperationException;
import java.util.*;


public class Oblig1 {
    public static void main(String[] args) {
        System.out.println("Jalla");
        int [] a  = {1,3,5,7,7,6,2,5,9};
        System.out.println(tredjeMin(a));
    }

    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        if (a.length == 0) {
            throw new NoSuchElementException("Arrayet er heelt tomt");
        }
        for (int i = 0; i < a.length - 1; ++i) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }
        return a[a.length - 1];
    }

    public static int ombyttinger(int[] a) {
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
     - Når det største tallet står først blir det flest ombyttinger
    Når blir det færrest?
     - Det blir færrest om arrayet er sortert stigende. Da blir det ingen.
     Hvor mange blir det i gjennomsnitt?
      -  For eksempel med arraylengde 3 så blir gjennomsnittet 7/6

      Kan du på grunnlag av dette si om metoden maks er bedre ( eller dårligere ) enn
      de maks-metodene vi har sett på tidligere?
       -


     */

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
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
                //Ingen forandring hvis lik.
            } else {
                throw new IllegalStateException("Arrayet er ikke sortert");
            }
        }
        return count;
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        int n = a.length;
        int antallUlike = 0;

        ArrayList<Integer> ulikeTall = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!ulikeTall.contains(a[i])) {
                ulikeTall.add(a[i]);
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
    static void sorter(int[] a, int start, int slutt) {
        if (start < slutt) {
            int pivot_indeks = partisjon(a, start, slutt);
            sorter(a, start, pivot_indeks - 1);
            sorter(a, pivot_indeks + 1, slutt);
        }
    }

    static int partisjon(int[] a, int start, int slutt) {
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

    static void bytt(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }


    public static void delsortering(int[] a) {
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
    public static char[] rotasjon(char[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            char temp = a[i];
            a[i] = a[i - 1];
            a[i - 1] = temp;
        }
        return a;
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void bytt(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static char[] rotasjon(char[] a, int k) {
        int n = a.length;
        if (n < 2) return a;
        if ((k %= n) < 0) k += n;

        for (int v = 0, h = n - 1; v < h; Oblig1.bytt(a, v++, h--)) ;
        for (int v = 0, h = k - 1; v < h; Oblig1.bytt(a, v++, h--)) ;
        for (int v = k, h = n - 1; v < h; Oblig1.bytt(a, v++, h--)) ;

        return a;
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        String flette = "";
        int lengdePåString = 0;

        if (s.length() < t.length()) {
            lengdePåString = t.length();
        } else {
            lengdePåString = s.length();
        }

        for (int i = 0; i < lengdePåString; ++i) {
            if (i < s.length()) {
                flette += s.charAt(i);
            }
            if (i < t.length()) {
                flette += t.charAt(i);
            }
        }
        return flette;
    }

    /// 7b)
    public static String flett(String... s) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        int arrayMedLengdeSomA[] = new int[a.length];

        int kopiAvA[] = Arrays.copyOf(a, a.length);

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
    public static int[] tredjeMin(int[] a) {
        int n = a.length;
        if (n < 3) {
            throw new NoSuchElementException("Arrayet har ikke 3 elementer");
        }


        int b[] = a;
        sorter(b, 0, 2);
        indekssortering(b);

        int m = b[0];
        int nm = b[1];
        int tm = b[2];

        int minstverdi = b[m];
        int nestminstverdi = b[nm];
        int tredjminstverdi = b[tm];

        for (int i = 3; i < n; i++) {
            if (a[i] < tredjminstverdi) {
                if (a[i] < nestminstverdi) {
                    if (a[i] < minstverdi) {
                        tm = nm;
                        tredjminstverdi = nestminstverdi;

                        nm = m;
                        nestminstverdi = minstverdi;

                        m = i;
                        minstverdi = a[m];
                    }
                    tm = nm;
                    tredjminstverdi = nestminstverdi;

                    nm = i;
                    nestminstverdi =a[nm];
                }
                else {
                    tm = i;
                    tredjminstverdi = a[tm];
                }
            }
        }
        return new int[] {m, nm, tm};
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new UnsupportedOperationException();
    }

}  // Oblig1
