package src.ch09;

import java.util.List;

public class Permute {

    public static void main(String[] args) {
//        int N = 3; // 처리 할 개수?
//        List<Integer> permutations = new ArrayList<>(); // 생성된 순열의 리스트
//
//        System.out.println("생성된 순열: ");
//
//        permute(permutations, 0, N);

        Permute p = new Permute();

        int N = 4;
        int[] A = new int[N];

        System.out.println("생성된 순열\n");

        // <A[0], A[1], . . . , A[N-1]>의 모든 순열을 생성한 후 출력한다
        p.perm(A, 0, N);
    }

    public void perm(int[] A, int k, int N) {

        if (k == N) {
            for (int i = 0; i < N; i++) {    // 생성된 순열을 출력한다
                System.out.print(A[i] + " ");
            }
            System.out.println();
            return;
        }

        // A[k]를 i로 정하기 전에 가능한지 확인한다
        for (int i = 1; i <= N; i++) {
            if (promising(A, k, i))            // A[k]를 i로 정하는 것이 가능한 경우
            {
                A[k] = i;
                perm(A, k + 1, N);            // <A[k+1], A[k+2], . . . , A[N-1]>의 모든 순열을 생성한다
            }
        }
    }

    public boolean promising(int[] A, int k, int i) {
        boolean flag = true;
        int j = 0;

        // i가 A[0..k-1]내의 한 요소와 같으면 A[k]를 i로 정할 수 없다고 알려 준다.
        // 그렇지 않으면 A[k]를 i로 정할 수 있다고 알려 준다.
        while (j < k) {
            if (i == A[j]) {
                return false;
            }
            j++;
        }

        return flag;
    }

    public static void permute(List<Integer> permutations, int index, int n) {
        if (index == n) {
            for (int i : permutations) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (promising(permutations, index, i)) {
                permutations.add(i);
                permute(permutations, index + 1, n);
            }
        }
    }

    public static boolean promising(List<Integer> permutations, int index, int i) {
        boolean flag = true;
        int j = 0;

        // i가 A[0..k-1]내의 한 요소와 같으면 A[k]를 i로 정할 수 없다고 알려 준다.
        // 그렇지 않으면 A[k]를 i로 정할 수 있다고 알려 준다.
        while (j < index) {
            if (i == permutations.get(j)) {
                return false;
            }
            j++;
        }
        return flag;
    }
}
