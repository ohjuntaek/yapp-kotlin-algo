class Solution {
    fun solution(arrangement: String): Int {
        var answer = 0
        var stick = 0
        for(i in arrangement.indices){
            if(arrangement[i] == '(') stick++
            if(arrangement[i] == ')'){
                if(arrangement[i-1] == '('){
                    stick--
                    answer += stick
                }
                else{
                    stick--
                    answer++
                }
            }
        }
        return answer
    }
}
