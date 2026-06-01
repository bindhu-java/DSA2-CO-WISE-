import java.util.*;

class SegmentTree {
    int[] tree;
    int n;

    SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        build(arr, 1, 0, n - 1);
    }

    void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        build(arr, 2 * node, start, mid);
        build(arr, 2 * node + 1, mid + 1, end);

        tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
    }

    int rangeMax(int node, int start, int end, int L, int R) {

        if (end < L || start > R)
            return Integer.MIN_VALUE;

        if (L <= start && end <= R)
            return tree[node];

        int mid = (start + end) / 2;

        int leftMax = rangeMax(2 * node, start, mid, L, R);
        int rightMax = rangeMax(2 * node + 1, mid + 1, end, L, R);

        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int[] sensors = {45, 50, 48, 60, 55, 62, 58, 65};

        SegmentTree st = new SegmentTree(sensors);

        System.out.println("Range Max (2,6): "
                + st.rangeMax(1, 0, sensors.length - 1, 2, 6));
    }
}