/*
A string is a valid parentheses string (denoted VPS) if and only if it consists of "(" and ")" characters only, and:

It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are VPS's, or
It can be written as (A), where A is a VPS.
We can similarly define the nesting depth depth(S) of any VPS S as follows:

depth("") = 0
depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's
depth("(" + A + ")") = 1 + depth(A), where A is a VPS.
For example,  "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.

 

Given a VPS seq, split it into two disjoint subsequences A and B, such that A and B are VPS's (and A.length + B.length = seq.length).

Now choose any such A and B such that max(depth(A), depth(B)) is the minimum possible value.

Return an answer array (of length seq.length) that encodes such a choice of A and B:  answer[i] = 0 if seq[i] is part of A, else answer[i] = 1.  Note that even though multiple answers may exist, you may return any of them.
*/

class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        //check valid VPS first
        boolean valid = checkValidity(seq);
        if(!valid){
            throw new IllegalArgumentException("Non VPS");
        }
        
        int[] depths = new int[seq.length()];
        int currDepth = 0;
        char lastChar = '.';
        for(int i = 0; i < seq.length(); i++){
            if(seq.charAt(i) == lastChar){
                if(seq.charAt(i) == '('){
                    currDepth += 1;
                }
                else{
                    currDepth -= 1;
                }
            }
            
            depths[i] = currDepth;
            lastChar = seq.charAt(i);
        }
        
        return depths;
        
    }
 
    
    public boolean checkValidity(String seq){
        int leftPara = 0;
        int rightPara = 0;
        
        if(seq.charAt(0) != '('){
            System.out.println("1");
            return false;
        }
        
        for (int i = 0; i < seq.length(); i++){
            
            if(seq.charAt(i) != '(' && seq.charAt(i) != ')'){
                System.out.println(seq.charAt(i));
                return false;
            }
            
            if(seq.charAt(i) == '('){
                leftPara++;
            }
            else if(seq.charAt(i) == ')'){
                rightPara++;
            }
            
            if(rightPara > leftPara){
                System.out.println("3");
                return false;
            }
        }
        if(leftPara != rightPara){
            System.out.println("4");
            return false;
        }
        return true;
    }
}

// result: Not Accepted. didn't understand what they actually wanted me to return with the disjoint subsequences part so my code returns the depth of each paranthesis....