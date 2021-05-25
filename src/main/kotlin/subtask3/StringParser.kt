package subtask3

class StringParser {

    private val brackets = mapOf('(' to ')', '<' to '>', '[' to ']')

    object BracketWithIndex {
        val <X> Pair<X, *>.bracket get() = first
        val <Y> Pair<*, Y>.index get() = second
    }

    fun getResult(inputString: String): Array<String> {
        val openBrackets = ArrayList<Pair<Char, Int>>()
        val result = mutableListOf<Pair<String, Int>>()

        for (index in inputString.indices) {
            val character = inputString[index]

            if (brackets.containsKey(character)) {
                openBrackets.add(character to index)
            }
            else if (brackets.containsValue(character)) {
                with(BracketWithIndex) {
                    for (openBracket in openBrackets.reversed()) {
                        
                        if (brackets[openBracket.bracket] == character) {
                            val substring = inputString.slice(openBracket.index + 1 until index)
                            result.add(substring to openBracket.index)
                            openBrackets.remove(openBracket)
                            break
                        }
                    }
                }
            }
        }
        result.sortBy { it.second }
        return result.map { it.first }.toTypedArray()
    }
}

