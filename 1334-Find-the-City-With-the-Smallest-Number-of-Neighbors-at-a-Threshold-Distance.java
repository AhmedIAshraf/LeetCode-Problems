class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] dp = new int[n][n];
        for (int i=0;i<edges.length;i++){
            int ii=edges[i][0], jj=edges[i][1], cost=edges[i][2];
            dp[ii][jj]=dp[jj][ii]=cost;
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<i;j++){
                if (dp[i][j]==0)dp[i][j]=dp[j][i]=Integer.MAX_VALUE;
            }
        }

        for (int k=0;k<n;k++){
            for (int i=0;i<n;i++){
                for (int j=0;j<i;j++){
                    if (dp[i][k]==Integer.MAX_VALUE||dp[k][j]==Integer.MAX_VALUE) dp[i][j]=dp[j][i]=dp[i][j];
                    else dp[i][j]=dp[j][i]=Math.min(dp[i][k]+dp[k][j],dp[i][j]);
                }
            }
        }
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if (a[0]>b[0] || (a[0]==b[0] && a[1]<b[1])) return 1;
                else return -1;
            }
        });

        int counts[] = new int[n];
        for (int i=0;i<n;i++){
            for (int j=0;j<i;j++){
                if(dp[i][j]<=distanceThreshold) {counts[i]++; counts[j]++;}
            }
        }
        for (int i=0;i<n;i++){
            int arr[] = {counts[i],i};
            heap.add(arr);
        }
        return heap.poll()[1];

    }
}