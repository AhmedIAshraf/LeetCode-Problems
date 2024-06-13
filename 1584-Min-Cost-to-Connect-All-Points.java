class Solution {
    int n,count=0,visited=0;
    int[][] pts;
    //int[] dp;
    boolean[] done;

    PriorityQueue<int[]> heap = new PriorityQueue<int []>(new Comparator<int []>(){
        public int compare(int[] a, int[] b){
            if(a[2]>b[2]) return 1; 
            else if(a[2]<b[2]) return -1;
            else return 0; 
        }
    });

    public int minCostConnectPoints(int[][] points) {
        n=points.length;
        //dp=new int[n];
        pts=points;
        done = new boolean[n];
        
        calcLength(0);
        done[0]=true;
        visited++;

        while(!heap.isEmpty() && visited<n){
            int[] arr = heap.poll();
            if (done[arr[1]]) continue;
            count+=arr[2];
            calcLength(arr[1]);
            done[arr[1]] = true;
            visited++;
        }

        return count;
    }

    public void calcLength(int j){
        for(int i=0;i<n;i++){
            if (i==j) continue;
            int[] arr= new int[3];
            arr[0]=0;
            arr[1]=i;
            arr[2]= Math.abs(pts[j][0]-pts[i][0])+Math.abs(pts[j][1]-pts[i][1]);
            heap.add(arr);
        } 
    }

}