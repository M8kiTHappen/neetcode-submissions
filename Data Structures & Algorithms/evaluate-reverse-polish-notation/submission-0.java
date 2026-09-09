class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();
        int runningSum = 0;

        for(String token : tokens){

            if(token.equals("+")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            }
            else if(token.equals("-")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            }else if(token.equals("*")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            }else if(token.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
}
