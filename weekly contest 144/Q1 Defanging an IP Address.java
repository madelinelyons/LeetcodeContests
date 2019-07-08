/*
Given a valid (IPv4) IP address, return a defanged version of that IP address.

A defanged IP address replaces every period "." with "[.]".
*/

class Solution {
    public String defangIPaddr(String address) {
        String output = "";
        for (int i = 0; i < address.length(); i++){
            if(address.charAt(i) == '.'){
                output = output + "[.]";
            }
            else{
                output = output + address.charAt(i);
            }
        }
        return output;
    }
}

// result: Accepted