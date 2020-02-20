class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = intArrayOf()
        var tmpAnswer = mutableListOf<Int>()

        for (i in 0 until commands.size){
            val first = commands[i][0] - 1
            val last = commands[i][1] - 1
            var tmp = mutableListOf<Int>()
            for(j in first..last){
                tmp.add(array[j])
            }
            tmp.sort()
            tmpAnswer.add(tmp[commands[i][2] - 1])
        }
        answer = tmpAnswer.toIntArray()
         return answer
    }
}
