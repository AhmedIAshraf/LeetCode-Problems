class Solution {
    public int[] findOriginalArray(int[] changed) {
        
        int n = changed.length;
        int ptr = 0;
        int inputPtr = 1;
        int[] org = new int[n/2];
        
        if (n % 2 == 1){
            return new int[0];
        }
        Arrays.sort(changed);
        org[0] = changed[0];

        for (int i=1; i<n; i++){
            if (ptr < inputPtr && changed[i] == 2 * org[ptr]){
                ptr++;
            }
            else if (inputPtr == org.length){
                return new int[0];
            }
            else{
                org[inputPtr++] = changed[i];
            }
        }

        return org;
    }
}