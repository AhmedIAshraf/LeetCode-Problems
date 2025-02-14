class Solution {
    public class Activity implements Comparable<Activity>  {
        private int start;
        private int end;
        private int weight;
        public Activity(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        public int getStart() {
            return start;
        }
        public int getEnd() {
            return end;
        }
        public int getWeight() {
            return weight;
        }
        @Override
        public int compareTo(Activity o) {
            if (this.getEnd() != o.getEnd())
                return (this.getEnd()-o.getEnd());
            else if (this.getStart() != o.getStart())
                return (this.getStart() - o.getStart());
            else
                return (this.getWeight() - o.getWeight());
        }
    //    Sorting the activities list based on finish time, start time and profit respectively
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {        
        int n = startTime.length;
        List<Activity> activities = new ArrayList<Activity>();
        activities.add(new Activity(0, 0, 0));
        for (int j = 0; j < n; j++){
            activities.add(new Activity(startTime[j], endTime[j], profit[j]));
        }
        Collections.sort(activities);
        int[] maxUntil = new int[n+1];
        
        int t = 0;
        maxUntil[t++] = 0;

        for (; t <= n; t++){
            int mx = maxUntil[t-1];
            int weight = activities.get(t).getWeight();
            int startsAt = activities.get(t).getStart();
            int idxToAdd = subMaxBinSearch(activities, startsAt, t);
            //System.out.println(\Index is : \+idxToAdd);
            mx = Math.max(mx, weight + maxUntil[idxToAdd]);
            maxUntil[t] = mx;
        }
        return maxUntil[n];
    }

    int subMaxBinSearch(List<Activity> act, int val, int r){
        int l=0;
        int m = (r+l)/2;
        while (l<r){
            m=(r+l)/2;
            if (act.get(m).getEnd() == val){
                while (act.get(m).getEnd() == val){
                    m++;
                }
                return m-1;
            }
            if (act.get(m).getEnd() <= val && act.get(m+1).getEnd() > val)
                return m;
            if (act.get(m).getEnd() > val && act.get(m-1).getEnd() <= val)
                return m-1;
            
            if (act.get(m).getEnd() > val)
                r = m;
            if (act.get(m).getEnd() < val)
                l = m+1;    
        }
        return r;
    }
}