import java.util.*
import kotlin.system.exitProcess

class Solution {
    private var sc : Scanner = Scanner(System.`in`)
    private var cal : Calendar = Calendar.getInstance()
    private var weekday : Int = 0
    private var answer = ""

    fun solution(month : Int, day : Int): String {
        checkNumber(month, day)
        cal.set(Calendar.YEAR, 2016)
        cal.set(Calendar.MONTH, month-1)
        cal.set(Calendar.DAY_OF_MONTH, day)

        weekday = cal.get(Calendar.DAY_OF_WEEK)

        when(weekday){
            1 -> answer = "SUN"
            2 -> answer = "MON"
            3 -> answer = "TUE"
            4 -> answer = "WED"
            5 -> answer = "THU"
            6 -> answer = "FRI"
            7 -> answer = "SAT"
        }
        return answer
    }

    fun checkNumber(month : Int, day : Int){
        if ((month<1 && month>12) && (day<1 && day>31)) {
            println("올바른 수를 입력하세요.")
            exitProcess(0)
        }
    }
}

fun main(){
    print(Solution().solution(1,2))
}