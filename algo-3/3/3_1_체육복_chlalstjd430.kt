class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = 0
        var student = IntArray(n+1) {1}

        for (i in 0 until lost.size){
            student[lost[i]]--;
        }
        for (i in 0 until reserve.size){
            student[reserve[i]]++;
        }

        if(student[1] == 2){
            if(student[2] == 0)
                student[2]++;
        }

        for(i in 2 until  n){
            if(student[i] == 2){
                if(student[i-1] == 0)
                    student[i-1]++
                else if(student[i+1] == 0)
                    student[i+1]++
            }
        }
        if(student[n] == 2){
            student[n-1]++
        }
        for(i in 1..n){
            if(student[i] >= 1) answer++
        }
        return answer
    }
}
