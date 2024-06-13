class Solution {
    boolean visited[][];
    int efforts[][];
    PriorityQueue<int[]> costs = new PriorityQueue<int[]>(new Comparator<int[]>(){
        public int compare(int[]a , int[]b){
            if (a[2]>b[2]) return 1;
            else if (a[2]<b[2]) return -1;
            else return 0;
        }
    });

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length*heights[0].length;
        visited = new boolean[heights.length][heights[0].length];
        efforts = new int[heights.length][heights[0].length];
        for (int[] a : efforts) Arrays.fill(a,Integer.MAX_VALUE);
        efforts[0][0]=0;

        while(n-1>0){
            int result[] = costs.poll();
            int i=0,j=0,curr=efforts[i][j];
            if (result!=null) {
                i=result[0]; j=result[1]; curr=result[2];
                while(visited[i][j]){
                    result=costs.poll();
                    i=result[0]; j=result[1]; curr=result[2];
                }
            }

            if (i-1 >= 0) dikjestra(i-1,j,curr,heights[i][j]-heights[i-1][j]);
            if (i+1 < efforts.length) dikjestra(i+1,j,curr,heights[i][j]-heights[i+1][j]);
            if (j-1 >= 0) dikjestra(i,j-1,curr,heights[i][j]-heights[i][j-1]);
            if (j+1 < efforts[0].length) dikjestra(i,j+1,curr,heights[i][j]-heights[i][j+1]);
            visited[i][j] = true;
            n--;
        }
        return efforts[heights.length-1][heights[0].length-1];
    }
    void dikjestra(int i, int j, int curr, int diff){
        if (visited[i][j]) return;
        int maxDiff = Math.max(curr,Math.abs(diff));
        efforts[i][j] = Math.min(efforts[i][j],maxDiff);
        int pos[] = {i,j,efforts[i][j]};
        costs.add(pos);
    }
}