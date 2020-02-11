fun main() {
    var solution: Solution = Solution()
    print(solution.solution("17"))
}

class Solution {
    lateinit var isPrime: BooleanArray
    lateinit var arr : IntArray
    lateinit var GN : String
    lateinit var parr : IntArray
    lateinit var parrSelected : BooleanArray
    lateinit var set : MutableSet<Int>

    fun solution(numbers: String): Int {
        var answer = 0

        // 1. 조합 + 순열 결과가 들어갈 전역 배열 : 길이 numbers.length => arr
        GN = numbers

        // prime 만들어 놓기
        isPrime = BooleanArray(5000001, {true})
        isPrime[0] = false
        isPrime[1] = false
        isPrime[2]
        makePrime()

        set = mutableSetOf()

        // 2. 재귀로 조합 고름
        var idx = 0
        var start = 0
        var n = numbers.length
        for (m in 1..n) {
            arr = IntArray(m, {0})
            comb(start, idx, n, m)
        }


        var iter : Iterator<Int> = set.iterator()
        while (iter.hasNext()) {
            var num : Int = iter.next()
            if (isPrime[num]) {
                answer++
            }
        }

        return answer
    }

    private fun makePrime() {
        for (i in 2..1000000) {
            if (!isPrime[i]) continue
            for (j in i*2..1000000 step i) {
                isPrime[j] = false
            }
        }
    }

    private fun comb(start: Int, idx: Int, n: Int, m: Int) {
        if (idx == m) {
            var pidx = 0
            var pstart = 0
            parr = IntArray(m, {0})
            parrSelected = BooleanArray(n, {false})
            perm(pidx, m)
            return
        } else {
            for (i in start..n-1) {
                arr[idx] = GN[i].toInt() - '0'.toInt()
                comb(i+1, idx + 1, n, m)
            }
        } // end of else
    } // end of comb

    private fun perm(idx: Int, n: Int) {
        if (idx == n) {
            var result : StringBuilder = StringBuilder()
            for (i in 0..parr.size-1) {
                result.append(parr[i])
            }
            set.add(result.toString().toInt())
            return
        } else {
            for (i in 0..n-1) {
                if (parrSelected[i]) continue
                parr[idx] = arr[i]
                parrSelected[i] = true
                perm(idx + 1, n)
                parrSelected[i] = false
            }
        }
    } // end of perm

}

/*

1. 문제 이해
(1) 한자리 숫자를 붙여 소수를 몇개 만들 수 있는가?
(2) numbers : 각 종이 조각에 적힌 숫자가 적힌 문자열 (길이 1~7)

2. 예제

(1) "17"

- 7, 17, 71

(2) "011"


3. 구현

- 아니 이건 그냥 소수판별하는게 중요한거 같은데
- 그러니깐 예제에서 만들 수 있는 숫자 만들기
    - 순열 for문으로 돌려서 소수이면 set에 넣어서 개수 반환....


4. 주의사항
- numbers가 뭐 오름차순 그런말은 없다.
-
 */