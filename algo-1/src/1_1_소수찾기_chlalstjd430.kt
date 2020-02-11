class Solution {
    var answerList = mutableListOf<Int>()
    var cnt : Int = 0

    fun isPrimeNumber(number: Int): Boolean {
        if(number == 0 || number == 1) return false
        for(i in 2 until number){
            if(number%i == 0){
                return false
            }
        }
        for(i in answerList){
            if(number == i) {
                return false
            }
        }

        answerList.add(number)

        return true
    }

    fun makePermutation(numbers: String, result: String, visit: Array<Boolean>){
        if(result != "" ){
            if(isPrimeNumber(result.toInt())){
                cnt++
            }
        }

        val numbersLength = numbers.length
        for(i in 0 until numbersLength){
            if (!visit[i]){
                visit[i] = true
                makePermutation(numbers,result+numbers[i], visit)
                visit[i] = false
            }
        }
    }

    fun solution(numbers: String): Int {
        var answer = 0
        var numberLength = numbers.length
        var visited = Array(numberLength) {false}

        makePermutation(numbers, "", visited)
        answer = cnt

        return answer
    }


}
