import java.util.Hashtable;

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        
        int n = nums.length;
        Hashtable<String, Boolean> exists = new Hashtable<>();

        for (String s : nums){
            exists.put(s, true);
        }

        return distinctBinary("", n, exists);
    }

    String distinctBinary(String num, int n, Hashtable<String, Boolean> exists){
        if (num.length() == n){
            if (!exists.containsKey(num)){
                return num;
            }
            else{
                return null;
            }
        }

        String addZero = distinctBinary(num+"0", n, exists);
        return addZero == null ? distinctBinary(num+"1", n, exists) : addZero;
    }
}