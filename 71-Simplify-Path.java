class Solution {
    public String simplifyPath(String path) {
        
        String[] splittedPath = path.split(\/\);
        int n = splittedPath.length;
        Stack<String> dirs = new Stack<>();

        for (int i=0; i<n; i++){
            if (splittedPath[i].equals(\\) || splittedPath[i].equals(\.\)){
                continue;
            }
            else if (splittedPath[i].equals(\..\)){
                if (!dirs.isEmpty()){
                    dirs.pop();
                }
            }
            else{
                dirs.push(\/\+splittedPath[i]);
            }

        } 

        if (dirs.isEmpty()){
            return \/\;
        }
        else{
            String simplified = \\;
            while (!dirs.isEmpty()){
                simplified = dirs.pop() + simplified;
            }
            return simplified;
        }
    }
}