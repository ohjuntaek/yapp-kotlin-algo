class Solution {
    fun solution(answers: IntArray): IntArray {
        var math1 : IntArray = intArrayOf(1,2,3,4,5)
        var math2 : IntArray = intArrayOf(2,1,2,3,2,4,2,5)
        var math3 : IntArray = intArrayOf(3,3,1,1,2,2,4,4,5,5)

        lateinit var answer : IntArray

        var person : IntArray = intArrayOf(1,2,3)

        var success : IntArray = intArrayOf(0, 0 ,0)

        for(i in answer) {
            if(answer[i] == math1[i%math1.size])success[0]++
            if(answer[i] == math2[i%math2.size])success[1]++
            if(answer[i] == math3[i%math3.size])success[2]++
        }

        if(success[0]==success[1] && success[0]==success[2])
            return person

        var maxNumber : Int = success.max()
        var personNumber : Int = 0

        for(i in success.size){
            if (success[i] == maxNumber) person = i+1
        }

        return person[personNumber]

}