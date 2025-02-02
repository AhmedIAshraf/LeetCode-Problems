class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        int sz = flowerbed.length;
        for (int i=0; i<sz; i++){
            boolean canPlant = true;
            if (flowerbed[i] == 1)
                continue;
            if (i>0){
                if (flowerbed[i-1] == 1)
                    canPlant = false;
            }
            if (canPlant && i<sz-1){
                if (flowerbed[i+1] == 1)
                    canPlant = false;
            }
            if (canPlant && n>0){
                flowerbed[i] = 1;
                n--;
            }
            if (n==0) break;
        }
        return (n == 0);
    }
}