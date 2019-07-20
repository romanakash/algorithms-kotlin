fun quickSelect(arr: IntArray, k: Int): Int {
    val n = arr.size - 1

    return if (n == 0) arr[0]
    else {
        val p = (0..n).random()
        val (res, r) = part(arr, p)

        return when {
            k < r -> quickSelect(res.sliceArray(0 until r), k)
            k > r -> quickSelect(res.sliceArray(r + 1..n), k - r - 1)
            else -> res[r]
        }
    }
}

fun main() = print(quickSelect(intArrayOf(1, 4, 5, 7, 2, 6, 3, 8), 3))
