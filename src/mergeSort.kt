fun mergeSort(arr: IntArray): IntArray {
    val n = arr.size - 1
    if (n > 0) {
        val m = n / 2
        val left = mergeSort(arr.sliceArray(0..m))
        val right = mergeSort(arr.sliceArray(m + 1..n))
        return merge(left + right, m)
    }
    return arr
}

fun merge(arr: IntArray, m: Int): IntArray {
    val n = arr.size - 1
    val res = IntArray(arr.size)
    var i = 0
    var j = m + 1

    for (k in 0..n) {
        when {
            j > n -> {
                res[k] = arr[i]
                i++
            }
            i > m -> {
                res[k] = arr[j]
                j++
            }
            arr[i] < arr[j] -> {
                res[k] = arr[i]
                i++
            }
            else -> {
                res[k] = arr[j]
                j++
            }
        }
    }
    return res
}

fun main() {
    assert(
        mergeSort(intArrayOf(1, 4, 5, 7, 2, 6, 3, 8)).contentEquals(
            (1..8).toList().toIntArray()
        )
    )
}