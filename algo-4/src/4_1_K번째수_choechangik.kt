import java.util.*

class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = IntArray(commands.size)
        var count = 0
        for(i in commands) {
            //i는 i번째 원소, 예시에 의하면 [2,5,3]이겠다
            var first = i.get(0)
            var last = i.get(1)
            val mArray = IntArray(first - last)
            for (i in first..last) {
                mArray.set(i-first, array.get(i))
            }
            mArray.sort()
            answer.set(count, mArray.get(i.get(2)))
            count++
        }
        return answer
    }
}

/*
매개로 받은 배열의 i부터 j까지 자른 배열을 새로 구성한다
새로 구성한 배열을 정렬한다
정렬한 배열의 k번째 숫자를 구한다
결과를 answer에 담아 리턴한다

commands는 2차원 배열이다.
commands의 i번째의 첫번째 원소와 두번째 원소를 꺼내야

 */