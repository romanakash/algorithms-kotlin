fun peasantMultiply(a: Int, b: Int): Int {
    var x = a
    var y = b
    var prod = 0
    while (x > 0) {
        if (x % 2 != 0) prod += y
        x /= 2
        y += y
    }
    return prod
}

fun main() = assert(peasantMultiply(256, 789) == 256 * 789)