package com.amit.code.peer.ineuron;

// Working program with FastReader

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1 {

    public static void main(String[] args) {

        FastReader fs = new FastReader();
        System.out.println("INEURON");
    }

    private static void print(int[][] arr) {
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }

    private static void comparatorSort(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
    }

    private static void lambdaSort(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
    }

    private static int lowerBound(int[] arr, int val) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= val) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        low += low >= arr.length ? -1 : 0;
        low += arr[low] > val ? -1 : 0;

        return low;
    }

    private static int upperBound(int[] arr, int val) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= val) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        low += low >= arr.length ? -1 : 0;
        low += arr[low] < val ? 1 : 0;

        return low;
    }

    private static boolean isPrime(long num) {
        if (num == 2L) {
            return true;
        }
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static long getGcd(long a, long b) {
        if (b == 0) return a;
        return getGcd(b, a % b);
    }

    private static long binaryExponentiation(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a;
            a = a * a;
            b >>= 1;
        }
        return res;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        long[] readArrayLong(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) arr[i] = Long.parseLong(next());
            return arr;
        }

        int[] readArrayInt(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(next());
            return arr;
        }
    }
}

