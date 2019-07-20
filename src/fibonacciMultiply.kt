import kotlin.math.pow

fun fibonacciMultiply(x: Int, y: Int): Int {
    fun convertToIntList(n: Int): List<Int> =
        n.toString()
            .reversed()
            .toCharArray()
            .map { c -> c.toString().toInt() }

    val a = convertToIntList(x)
    val b = convertToIntList(y)

    val c: MutableList<Int> = mutableListOf()

    var hold = 0
    for (k in 0 until a.size + b.size) {
        for (i in 0 until a.size) {
            for (j in 0 until b.size) {
                if (i + j == k) {
                    hold += a[i] * b[j]
                }
            }
        }
        c.add(hold % 10)
        hold /= 10
    }

    return c.reduceIndexed { index, acc, i ->
        (10.0.pow(index) * i).toInt() + acc
    }
}

fun main() = assert(fibonacciMultiply(240, 564) == 240 * 564)