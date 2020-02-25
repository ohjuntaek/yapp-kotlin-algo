import java.util.*

fun main() {
    println(Solution_ohjuntaek().solution(5, 24))
}

class Solution_ohjuntaek {
    fun solution(a: Int, b: Int): String {
        var answer = ""

        var daysOfMonth = intArrayOf(0, 31, 29, 31, 30, 31, 30, 31,31, 30, 31, 30, 31)
        var dayOfWeek = arrayOf("FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU")

        var s = 0
        for (i in 1..a-1) s += daysOfMonth[i]
        s += b - 1

        return dayOfWeek[s%7]
    }
}

/*
1. 문제 이해
(1) 2016년 1월 1일 금요일, a월 b일은 무슨 요일일까요??

2. 예시
5월 24일
- 0, 1    2   3  4   5    6   7   8  9   10  11  12
- 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31

- 1월 2일이면 1차이니깐
- ["FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"]
- "SAT"

- 1월 8일, 7차이 => 7%7 = 0=> 금요일
- 1월 31일이면 30일 차이 => 30%7 = 2 => 일요일
- 2월 1일이면 31일 차이
- 5월 24일이면 31+29+31+30 + 23 =
오케이

 */