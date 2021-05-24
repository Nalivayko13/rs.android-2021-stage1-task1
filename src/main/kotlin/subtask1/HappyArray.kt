package subtask1
import kotlin.collections.*

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        val lol = sadArray.toMutableList()
        var att = 0
        var isHappy = true
        while (isHappy) {
            isHappy = false
            att = 0
            for (i in 1..lol.size - 2) {
                if (lol[i - att] > (lol[i - 1 - att] + lol[i + 1 - att])) {
                    isHappy = true
                    lol.removeAt(i - att)
                    att++
                }
            }
        }
        val HappyArray = lol.toIntArray()
        return HappyArray
    }
}


