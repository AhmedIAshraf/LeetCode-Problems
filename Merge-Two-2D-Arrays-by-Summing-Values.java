class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        
        int n = nums1.length;
        int m = nums2.length;
        List<int[]> merged = new ArrayList<>();

        int i=0, j=0;
        while(i<n && j<m){
            if (nums1[i][0] > nums2[j][0]){
                merged.add(new int[] {nums2[j][0], nums2[j][1]});
                j++;
            }
            else if (nums1[i][0] < nums2[j][0]){
                merged.add(new int[] {nums1[i][0], nums1[i][1]});
                i++;
            }
            else{
                merged.add(new int[] {nums1[i][0], nums1[i][1]+nums2[j][1]});
                i++;
                j++;
            }
        }

        while(i<n){
            merged.add(new int[] {nums1[i][0], nums1[i][1]});
            i++;
        }
        while(j<m){
            merged.add(new int[] {nums2[j][0], nums2[j][1]});
            j++;
        }

        int l = merged.size();
        int[][] mergedArray = new int[l][2];
        for (int k=0; k<l; k++){
            mergedArray[k][0] = merged.get(k)[0];
            mergedArray[k][1] = merged.get(k)[1];
        }

        return mergedArray;
    }
}