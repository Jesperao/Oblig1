package com.company;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.ArrayList;


public class Oblig1 {
    public static void main(String[] args) {
        System.out.println("Jalla");

        int a[] = {1,3,2,1,31,2,5};
        int a[] = {0};

        System.out.println(maks(a));
        System.out.println(antallUlikeUsortert(a));

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
        throw new UnsupportedOperationException();
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
