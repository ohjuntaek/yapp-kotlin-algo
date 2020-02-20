import java.util.*

fun main() {
    println(Arrays.toString(Solution_O().solution(intArrayOf(1,5,2,6,3,7,4), arrayOf(intArrayOf(2,5,3), intArrayOf(4,4,1), intArrayOf(1,7,3)))))
}

class Solution_O {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var list = mutableListOf<Int>()
        for (command in commands) {
            var i = command[0] - 1
            var j = command[1] - 1
            var k = command[2] - 1

            var arr = array.slice(i..j)
            var sortedArr = arr.sorted()
            list.add(sortedArr[k])
        }

        var answer = list.toIntArray()

        return answer
    }
}

/*
1. 문제
(1) array,

2. 예시
(1) [1,5,2,6,3,7,4], 2, 5, 3
-

3. 구현
(1) 자르고 정렬
(2) 담아라
 */
