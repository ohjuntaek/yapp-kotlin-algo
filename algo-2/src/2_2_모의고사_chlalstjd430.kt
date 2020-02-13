class Solution {
    fun solution(answers: IntArray): IntArray {
        var answer = intArrayOf()
        var one = intArrayOf(1,2,3,4,5)
        var two = intArrayOf(2,1,2,3,2,4,2,5)
        var three = intArrayOf(3,3,1,1,2,2,4,4,5,5)
        var people = intArrayOf(0,0,0)


        for(i in 0 until answers.size){
            if(answers[i] == one[i%one.size]) people[0]++
            if(answers[i] == two[i%two.size]) people[1]++
            if(answers[i] == three[i%three.size]) people[2]++
        }

        var maxCnt = people.max()
        var answerList = mutableListOf<Int>()

        for(i in 0 until people.size){
            if(people[i] == maxCnt)  answerList.add(i+1)
        }

        answer = answerList.toIntArray()

        return answer
    }
}

