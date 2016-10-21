package com.edocti.jintro.lab02;

class Fibo {
    private static int fibo(int n) {
        // uncomment this is you want to see how fibo is getting executed
        // System.out.println(n);
        if (n <= 1) {
            return n;
        } else {
            return fibo(n-1) + fibo(n-2);
        }
    }

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int n = fibo(a);
        System.out.printf("fibo(%d) = %d\n", a, n);
    }
}
