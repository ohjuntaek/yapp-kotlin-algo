import java.util.*

fun main() {
    println(Arrays.toString(Solution_2_ohjuntaek().solution(intArrayOf(1,3,2,4,2))))
}

class Solution_2_ohjuntaek {
    val firstPicking = intArrayOf(1,2,3,4,5)
    val secondPicking = intArrayOf(2,1,2,3,2,4,2,5)
    val thirdPicking = intArrayOf(3,3,1,1,2,2,4,4,5,5)

    fun solution(answers: IntArray): IntArray {
        val nums = intArrayOf(0, 0, 0)

        val personOneAnswers = Array<Int>(answers.size, {0})
        var personOneIdx = 0
        while (true) {
            personOneAnswers[personOneIdx] = firstPicking[personOneIdx%firstPicking.size]
            personOneIdx++
            if (personOneIdx == answers.size) break
        }

        val personTwoAnswers = Array<Int>(answers.size, {0})
        var personTwoIdx = 0
        while (true) {
            personTwoAnswers[personTwoIdx] = secondPicking[personTwoIdx%secondPicking.size]
            personTwoIdx++
            if (personTwoIdx == answers.size) break
        }

        val personThreeAnswers = Array<Int>(answers.size, {0})
        var personThreeIdx = 0
        while (true) {
            personThreeAnswers[personThreeIdx] = thirdPicking[personThreeIdx%thirdPicking.size]
            personThreeIdx++
            if (personThreeIdx == answers.size) break
        }


        for(idx in answers.indices) {
            if (answers[idx] == personOneAnswers[idx]) nums[0]++
            if (answers[idx] == personTwoAnswers[idx]) nums[1]++
            if (answers[idx] == personThreeAnswers[idx]) nums[2]++
        }

        var answer = arrayListOf<Int>()
        var size = 0
        for (i in nums.indices) {
            if (nums.max() == nums[i]) {
                answer.add(i+1)
            }
        }


        return answer.toIntArray()
    }

}