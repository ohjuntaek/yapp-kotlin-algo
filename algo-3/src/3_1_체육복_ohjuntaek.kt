import java.util.*

fun main() {
    println(Solution_juntaek().solution(5, intArrayOf(1, 2), intArrayOf(2, 3)))
}

class Solution_juntaek {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = n - lost.size

        for (item in lost) {
            if (reserve.contains(item)) {
                // 가져온 학생이 도난당한 경우 가져온 넘이 못빌려 주니깐 -100 찍고 잃어버린 넘에서 빼준걸 원상복구 (answer++)
                reserve.set(reserve.indexOf(item), -100)
                lost.set(lost.indexOf(item), -100)
                answer++
                continue
            }
        }

        for (item in lost) {
            if (item == 100) continue
            var left = item - 1
            var right = item + 1
            if (reserve.contains(left)) {
                answer++
                reserve.set(reserve.indexOf(left), -100)
                continue
            }
            if (reserve.contains(right)) {
                answer++
                reserve.set(reserve.indexOf(right), -100)
                continue
            }
        }


        return answer
    }
}

/*
1. 문제 이해
(1) 최대한 많은 학생이 체육복 가져서 체육 수업 들어야함
(2) 학생 수 n, 체육복 없는 넘 lost, 여별 있는넘 reserve
(3) 앞이나 뒤에넘만 빌려줄 수 있다.
(4) 최대값 return 하라

2. 예시
(1) 그냥 없는 넘이 앞에서부터 빌리면 안되나?? 앞에 없으면 뒤에넘꺼 빌리고...
[2, 4]
[1, 3, 5]
- 앞, 뒤 있는지 보고 있으면 빼라

3. 구현
- 걍 구현..
(1) 포문으로 lost를 돈다.
(2) 포문안에서 item 앞뒤에 있으면 reserve에서 빼고 answer를 증가시킨다.
(3) ㅇㅇ

4. 주의
(1) 여별 체육복 가져온 넘이 도난당했을 수 있음. 이러면 체육복 그냥 못빌려주는거... 대신 수업은 들을 수 있음

 */