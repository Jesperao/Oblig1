package com.company;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;


public class Oblig1 {
    public static void main(String[] args) {
        System.out.println("Jalla");
        /*int a[] = {2, 4, 6, 10, 8};

        int a[] = {1, 2, 3};
        int a[] = {1, 3, 2};
        int a[] = {2, 1, 3};
        int a[] = {2, 3, 1};
        int a[] = {3, 1, 2};
        int a[] = {3, 2, 1};

        int a[] = {5, 2, 2, 2, 2, 2};

         */
        //System.out.println(antallUlikeSortert(a));

        //System.out.println(ombyttinger(a));
        //int a[] = {1, 3, 2, 1, 31, 2, 5};
       // int a[] = {0};

        //System.out.println(maks(a));
        //System.out.println(antallUlikeUsortert(a));

        String a = flett("ABC", "DEFGH");
        String b = flett("IJKLMN", "OPQ");
        String c = flett("", "AB");

        System.out.println(a + " " + b + " " + c);
    }

    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////

    public static int maks(int[] a) {
        if (a.length == 0) {
            throw new UnsupportedOperationException("Arrayet er heelt tomt");
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
        throw new UnsupportedOperationException();
    }


    //Når blir det flest ombyttinger?
    // - Når det største tallet står først blir det flest ombyttinger
    // Når blir det færrest?
    //  - Det blir færrest om arrayet er sortert stigende. Da blir det ingen.
    //Hvor mange blir det i gjennomsnitt?
    //  -  For eksempel med arraylengde 3 så blir gjennomsnittet 7/6

    //  Kan du på grunnlag av dette si om metoden maks er bedre ( eller dårligere ) enn
    //  de maks-metodene vi har sett på tidligere?



    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        throw new UnsupportedOperationException();
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
            antallUlike = 0;
        } else {
            antallUlike = ulikeTall.size();
        }
        return antallUlike;


    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        int venstre = 0;
        int hoyre = a.length - 1;
        //int teller = 0;
        while (venstre < hoyre) {
            while (a[venstre] % 2 != 0) {
                venstre++;
                //    teller++;
            }
            while (a[hoyre] % 2 == 0 && venstre < hoyre) {
                hoyre--;
            }
            if (venstre < hoyre) {
                int temp = a[venstre];
                a[venstre] = a[hoyre];
                a[hoyre] = temp;
            }
        }
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        String flette = "";
        int lengdePaaArray;

        if (s.length() < t.length()) {
            lengdePaaArray = t.length();
        } else {
            lengdePaaArray = s.length();
        }

        for (int i = 0; i < lengdePaaArray; i++) {
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
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new UnsupportedOperationException();
    }

}  // Oblig1
