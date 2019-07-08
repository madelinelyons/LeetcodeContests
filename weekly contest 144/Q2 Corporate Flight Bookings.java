/*
There are n flights, and they are labeled from 1 to n.

We have a list of flight bookings.  The i-th booking bookings[i] = [i, j, k] means that we booked k seats from flights labeled i to j inclusive.

Return an array answer of length n, representing the number of seats booked on each flight in order of their label.
*/

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++){
            answer[i] = 0;
        }
        
        for (int i = 0; i < bookings.length; i++){
            int j = bookings[i][0];
            while(j <= bookings[i][1]){ //as long as j is less than or equal to the last flight in the booking
                answer[j-1] += bookings[i][2];
                j++;
            }
        }
        return answer;
    }
}

// result: Accepted