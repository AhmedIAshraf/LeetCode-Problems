class Solution {
    public int minOperations(int[] nums, int k) {
        
        PriorityQueue<Long> pq = new PriorityQueue<>();  
        Arrays.sort(nums);
        if (nums[0] >= k)
            return 0;

        int i=2;
        int n=nums.length;
        int counter=1;
        pq.add((long) Math.min(nums[0], nums[1]) * 2 + Math.max(nums[0], nums[1]));

        while (i<n){
            
            long x,y;
            if (pq.peek() >= nums[i]){
                x = nums[i++];
            }
            else{
                x = pq.poll();
            }

            if (x >= k){
                return counter;
            }

            if (i == n || (!pq.isEmpty() && pq.peek() < nums[i])){
                y = pq.poll();
            }
            else{
                y =  nums[i++];
            }

           //System.out.println(x+" "+y);
            pq.add((long) Math.min(x, y) * 2 + Math.max(x, y));
            counter++;
        }

        while(pq.peek() < k){
            long x = pq.poll();
            long y = pq.poll();
            pq.add(Math.min(x, y) * 2 + Math.max(x, y));
            counter++;
        }

        return counter;
    }
}


