fun peasantMultiplyRec(x: Int, y: Int): Int {
    return if (x == 0) 0
    else {
        val x1 = x / 2
        val y1 = y + y
        var prod = peasantMultiplyRec(x1, y1)
        if (x % 2 != 0) prod += y
        return prod
    }
}

fun main() = assert(peasantMultiplyRec(256, 789) == 256 * 789)