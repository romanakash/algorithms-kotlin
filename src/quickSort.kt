fun quickSort(arr: IntArray): IntArray {
    val n = arr.size - 1
    if (n > 0) {
        val p = (0..n).random()
        val (res, r) = part(arr, p)
        val first = quickSort(res.sliceArray(0 until r))
        val second = quickSort(res.sliceArray(r + 1..n))
        return first + res[r] + second
    }
    return arr
}

fun part(arr: IntArray, p: Int): Pair<IntArray, Int> {
    val n = arr.size - 1
    val res = arr.copyOf()
    res[p] = arr[n].also { res[n] = arr[p] }

    var l = 0
    for (i in 0..n) {
        if (arr[i] < arr[n]) {
            res[l] = arr[i].also { res[i] = arr[l] }
            l++
        } else {
            res[i] = arr[i]
        }
    }
    res[n] = res[l].also { res[l] = res[n] }

    return Pair(res, l)
}

fun main() {
    assert(
        quickSort(intArrayOf(1, 4, 5, 7, 2, 6, 3, 8))
            .contentEquals((1..8).toList().toIntArray())
    ) 
}