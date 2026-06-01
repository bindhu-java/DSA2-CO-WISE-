import java.util.*;

class Kruskal {

    static class Edge implements Comparable<Edge> {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        public int compareTo(Edge e) {
            return this.w - e.w;
        }
    }

    static int find(int[] parent, int x) {
        while (parent[x] != x)
            x = parent[x];
        return x;
    }

    static boolean union(int[] parent, int x, int y) {
        int px = find(parent, x);
        int py = find(parent, y);

        if (px == py)
            return false; // same root = cycle

        parent[px] = py;
        return true;
    }

    static int kruskal(int n, List<Edge> edges) {
        Collections.sort(edges);

        int[] parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        int totalCost = 0, edgeCount = 0;

        for (Edge e : edges) {
            if (union(parent, e.u, e.v)) {
                totalCost += e.w;

                if (++edgeCount == n - 1)
                    break;
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 12));
        edges.add(new Edge(1, 2, 5));
        edges.add(new Edge(1, 3, 12));
        edges.add(new Edge(2, 3, 12));

        int cost = kruskal(4, edges);
        System.out.println("Minimum Cost of MST = " + cost);
    }
}