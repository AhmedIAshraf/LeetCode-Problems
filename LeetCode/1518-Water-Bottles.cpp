class Solution {
public:
    int numWaterBottles(int numBottles, int numExchange) {
        int total=numBottles;
        while(numBottles>=numExchange){
            int additional=numBottles/numExchange;
            total+=additional;
            numBottles%=numExchange;
            numBottles+=additional;
        }
        return total;

    }
};