import java.awt.Point;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Point> stk = new Stack<>();
        for (int i=0; i<n; i++){
            while (!stk.empty() && stk.peek().x < temperatures[i]){
                int idx = stk.pop().y;
                ans[idx] = i - idx;
            }
            stk.push(new Point(temperatures[i], i));
        }
        return ans;
    }
}