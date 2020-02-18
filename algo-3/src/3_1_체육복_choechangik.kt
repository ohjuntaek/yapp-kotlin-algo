/*
문제이해
전체 학생수 n
도난당한 학생 번호 배열 lost
여벌의 체육복을 가져온 학생 번호가 담긴 배열 reserve
체육 수업를 들을 수 있는 학생수 최댓값을 return

근데 번호 앞뒤로만 여벌 넘겨줄수있음 사이즈때매

여벌은 반드시 한벌만 있음

입력 -> 학생수, 도난당한 학생 번호, 여벌 체육복가진애 번호
출력 -> 체육복 가진애들 최댓값

도난당했는데 양옆에 여벌 가진애가 있는지만 체크하면 될듯

근데 여벌 양옆으로 도둑맞은 애들이 있는경우는? (예외 처리)

전체 n에서 도둑맞은애 양옆 체크하고 결과값 반환


*/

class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = n-lost.size
        for (number in lost) {
            var right = number+1
            var left = number-1
            if (right in reserve) {
                answer+=1
                reserve.get(right)
            }
            else if (left in reserve){
                answer+=1
                reserve.get(left)
            }
            else if (number in reserve) {
                answer+=1
                reserve.get(number)
            }
        }
        return answer
    }
}
