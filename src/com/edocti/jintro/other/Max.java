package com.edocti.jintro.other;

class Max {

    private static int max(int[] arr) {
        int M = Integer.MIN_VALUE;
        for (int e : arr) {
            if (e > M) {
                M = e;
            }
        }
        return M;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 0, 4, 15, 24};
        int M = max(arr);
        System.out.format("Max = %d\n", M);
    }
}
