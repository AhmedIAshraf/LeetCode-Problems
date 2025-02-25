class Solution {
    public int numOfSubarrays(int[] arr) {
        
        int n=arr.length;
        int odds=0, evens=0;
        int total = 0;

        for (int i=0; i<n; i++){
            if (i>0){
                arr[i] += arr[i-1];
            }

            if (arr[i]%2 == 1){
                odds++;
                total += 1 + evens;
            }
            else{
                evens++;
                total += odds;
            }

            if (total > Integer.MAX_VALUE / 2){
                total %= 1000000007;
            } 
        }

        return total;
    }
}