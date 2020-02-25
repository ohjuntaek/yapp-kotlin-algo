class Solution_ohjuntaek {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 1

        var truckArrayIdx = 0
        var finishTruckIdx = 0

        var bridge = mutableListOf<Int>()
        var bridgeTime = mutableListOf<Int>()
        var weightSum = 0
        while(true) {
            // 맨앞에꺼랑 weightSum이랑 합친게 weight보다 작으면
            // weightSum을 증가시키고 bridge에 아이템을 넣고, bridgeTime에도 넣는다.
            if (truckArrayIdx < truck_weights.size && truck_weights[truckArrayIdx] + weightSum <= weight) {
                weightSum += truck_weights[truckArrayIdx]
                bridge.add(truck_weights[truckArrayIdx])
                truckArrayIdx++
                bridgeTime.add(0)
            }

            // bridgeTime의 원소들을 1씩 증가시킨다.
            for (i in 0..bridgeTime.size-1) {
                bridgeTime[i] += 1
            }
//            println("truck :" + bridge.toString())
//            println("time : " + bridgeTime.toString())

            // 맨앞의 원소가 bridge_length가 되면, 맨 앞에껄 빼고 weightSum을 뺀다.
            if (bridgeTime.size > 0 && bridgeTime[0] >= bridge_length) {
                weightSum -= bridge.removeAt(0)
                bridgeTime.removeAt(0)
                finishTruckIdx++
            }

            // 1초 증가
            answer++
            // idx가 length
            if (finishTruckIdx >= truck_weights.size) {
                break
            }


        } // end of while

        return answer
    }
}