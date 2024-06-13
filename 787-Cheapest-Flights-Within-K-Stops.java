class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        LinkedList<int[]> adj[]= new LinkedList[n];
        for (int i=0;i<adj.length;i++) adj[i] = new LinkedList<int[]>();
        int[] curr = new int[n];
        int[] prev = new int[n];
        for(int i=0;i<n;i++) curr[i]=prev[i]=Integer.MAX_VALUE;
        curr[src]=prev[src]=0;

        for (int i=0;i<flights.length;i++){
            int toAndCost[] = {flights[i][1],flights[i][2]};
            adj[flights[i][0]].add(toAndCost);
        }

        k++;
        while(k-->0){
            for (int i=0;i<n;i++){
                if (prev[i]==Integer.MAX_VALUE) continue;
                for (int j=0;j<adj[i].size();j++){
                    int des=adj[i].get(j)[0],cost=adj[i].get(j)[1];
                    curr[des] = Math.min(curr[des],prev[des]);
                    curr[des] = Math.min(curr[des],prev[i]+cost);
                }
            }
            prev = curr;
            curr = new int[n];
            Arrays.fill(curr,Integer.MAX_VALUE);
            curr[src]=0;
        }
        if (prev[dst]==0||prev[dst]==Integer.MAX_VALUE) return -1;
        return prev[dst];

    }
}