package Template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
public class Main extends PrintWriter {
    static BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
    Main() {
        super(System.out);
    }
    public static void main(String[] args) throws IOException {
        Main d1 = new Main();
        d1.main();
        d1.flush();
    }

    void main() throws IOException {
        StringBuilder sb = new StringBuilder();
        int t = 1;
        t = i(s()[0]);
        while (t-- > 0) {
            String[] s1 = s();
            int n = i(s1[0]);
            int k = i(s1[1]);
            int mainnode = i(s1[2]);
            HashMap < Integer, Integer > h = new HashMap < > ();
            int[] a = new int[k];
            arri(a, k);
            HashMap < Integer, Integer > vis = new HashMap < > ();
            PriorityQueue < Pair > q = new PriorityQueue < Pair > (new Comparator < Pair > () {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return o2.dis - o1.dis;
                }
            });
            Queue < Integer > closest = new LinkedList < > ();
            ArrayList < Integer > [] adj = new ArrayList[n + 1];
            for (int i = 0; i < n - 1; i++) {
                String[] s2 = s();
                int u = i(s2[0]);
                int v = i(s2[1]);
                if (adj[u] == null) adj[u] = new ArrayList < > ();
                if (adj[v] == null) adj[v] = new ArrayList < > ();
                adj[u].add(v);
                adj[v].add(u);
            }
            int[] dis = new int[n + 1];
            maxdis = 0;
            vis = new HashMap < > ();
            dfs(mainnode, adj, vis, 0, h, dis);
            vis = new HashMap < > ();
            for (int i = 0; i < k; i++) {
                h.put(a[i], 0);
                q.add(new Pair(a[i], dis[a[i]], a[i]));
                vis.put(a[i], 0);
            }
            //          for(int i=0;i<=n;i++){
            //              System.out.println(i + " " + dis[i]);
            //          }
            int[] close = new int[n + 1];
            while (!q.isEmpty()) {
                Pair p = q.poll();
                int special = p.special;
                if (adj[p.node] != null) {
                    for (Integer j: adj[p.node]) {
                        if (!vis.containsKey(j)) {
                            vis.put(j, 0);
                            dis[j] = p.dis - 1;
                            close[j] = special;
                            q.add(new Pair(j, dis[j], special));
                        }
                    }
                }
            }
            for (int i = 1; i <= n; i++) {
                sb.append(dis[i]);
                sb.append(" ");
            }
            sb.append("\n");
            for (int i = 1; i <= n; i++) {
                if (h.containsKey(i)) {
                    sb.append(i);
                    sb.append(" ");
                } else {
                    sb.append(close[i]);
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static int maxdis;
    public static void dfs(int i, ArrayList < Integer > [] adj, HashMap < Integer, Integer > vis, int d, HashMap < Integer, Integer > h, int[] dis) {
        vis.put(i, 0);
        dis[i] = d;
        if (h.containsKey(i)) {
            maxdis = Math.max(maxdis, d);
        }
        if (adj[i] == null) return;
        for (Integer j: adj[i]) {
            if (!vis.containsKey(j)) {
                dfs(j, adj, vis, d + 1, h, dis);
            }
        }
    }
    static String[] s() throws IOException {
        return s.readLine().trim().split("\\s+");
    }
    static int i(String ss) {
        return Integer.parseInt(ss);
    }
    static long l(String ss) {
        return Long.parseLong(ss);
    }
    public void arr(long[] a, int n) throws IOException {
        String[] s2 = s();
        for (int i = 0; i < n; i++) {
            a[i] = l(s2[i]);
        }
    }
    public void arri(int[] a, int n) throws IOException {
        String[] s2 = s();
        for (int i = 0; i < n; i++) {
            a[i] = i(s2[i]);
        }
    }
}

class Pair {
    int node, dis;
    int special;
    public Pair(int s, int e, int sp) {
        node = s;
        dis = e;
        special = sp;
    }
}