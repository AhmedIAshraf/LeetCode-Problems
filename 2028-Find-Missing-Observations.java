class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        
        int m = rolls.length;
        int remainingWeight = (m+n)*mean;
        for (int i=0; i<m; i++){
            remainingWeight -= rolls[i];
        }

        int[] answer = new int[n];
        if (remainingWeight/n < 1 || remainingWeight > 6*n){
            return new int[0];
        }

        for (int i=0; i<n-1; i++){
            int avg = remainingWeight/(n-i);
            answer[i] = avg;
            remainingWeight -= avg;
        }
        answer[n-1] = remainingWeight;

        return answer;
    }
}