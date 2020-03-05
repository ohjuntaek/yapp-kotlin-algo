/**
 * 정확성 66점으로 테스트의 일부만 성공한 케이스입니다.
 */

fun main() {
    println(Solution().solution(5, intArrayOf(2, 4), intArrayOf(1, 3, 5)))
}

class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = n-lost.size

        //여분의 체육복을 가진 사람이 도난 당했을 때
        for (person in reserve) {
            if (lost.contains(person)){
                reserve.drop(person)
            }
        }

        for (person in lost) {
            val right = person+1
            val left = person-1

            if (reserve.contains(right)) {
                answer++
                reserve.set(reserve.indexOf(right),-100)
            }
            else if (reserve.contains(left)){
                answer++
                reserve.set(reserve.indexOf(left),-100)
            }
        }

        return answer
    }
}