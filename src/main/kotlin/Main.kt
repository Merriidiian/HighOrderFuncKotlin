fun main() {
    //1
    val newSumReverseList = reverseList(mutableListOf(1, 2, 3, 4, 5), mutableListOf(6, 7, 8, 9, 10), ::sumList)
    println(newSumReverseList)
    //2
    val newSumAndReverseList = checkFlagReverse(true)(mutableListOf(1, 2, 3, 4, 5), mutableListOf(6, 7, 8, 9, 10))
    println(newSumAndReverseList)
    val newSumAndNoReverseList = checkFlagReverse(false)(mutableListOf(1, 2, 3, 4, 5), mutableListOf(6, 7, 8, 9, 10))
    println(newSumAndNoReverseList)
}

fun sumList(a: List<Int>, b: List<Int>): MutableList<Int> {
    val newList: MutableList<Int> = mutableListOf()
    for (i in 0 until a.count()) {
        newList.add(a[i] + b[i])
    }
    return newList
}

//Первая функция 2-ого порядка (п. 1)
fun reverseList(
    a: List<Int>,
    b: List<Int>,
    operationList: (List<Int>, List<Int>) -> MutableList<Int>
): MutableList<Int> {
    return operationList(a, b).reversed() as MutableList<Int>
}

//Вторая функция 2-ого порядка (п. 2)
fun checkFlagReverse(
    flag: Boolean
): (List<Int>, List<Int>) -> MutableList<Int> {
    return if (flag)
        ::sumAndReverseList
    else
        ::sumAndNoReverseList
}

fun sumAndReverseList(a: List<Int>, b: List<Int>): MutableList<Int> {
    val newList: MutableList<Int> = mutableListOf()
    for (i in 0 until a.count()) {
        newList.add(a[i] + b[i])
    }
    return newList.reversed() as MutableList<Int>
}

fun sumAndNoReverseList(a: List<Int>, b: List<Int>): MutableList<Int> {
    val newList: MutableList<Int> = mutableListOf()
    for (i in 0 until a.count()) {
        newList.add(a[i] + b[i])
    }
    return newList
}


