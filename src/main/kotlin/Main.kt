import java.math.BigInteger

fun main() {
//     1st task
    val numArray = intArrayOf(1, 1, 1, 1, 1, 3, 3, 3, 222, 5, 5, 6, 6, 222, 49)
    val uniqueNumber = singleNumber(numArray)
    println("The unique number is $uniqueNumber.")

    // 2nd task
    val amount = -127
    val minimalCoinCount = minimalSplit(amount)
    println(minimalCoinCount)

//    3rd task
    val longestPrefix = longestPrefix(arrayOf("interstellar", "interstate", "interpol", "international"))
    println(longestPrefix)

//     4th task
    val sumResult = addBinary("1010", "1011")
    println(sumResult)

    // 5th task
    val count = countVariants(5)
    println(count)

    // 6th task
    val myDataStructure = CustomDataStructure<String>()

    // Add items.
    myDataStructure.add("banana")
    myDataStructure.add("pineapple")
    myDataStructure.add("watermelon")

    println(myDataStructure.getItems())

    myDataStructure.remove("watermelon")

    println(myDataStructure.getItems())
}

fun singleNumber(nums: IntArray): Int {
    val frequencyMap = mutableMapOf<Int, Int>()

    for (num in nums) {
        frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
    }

    for ((num, count) in frequencyMap) {
        if (count == 1) {
            return num
        }
    }

    return -1
}

fun minimalSplit(amount: Int) : Int {
    if (amount < 0) {
        throw IllegalArgumentException("Amount cannot be less than zero")
    }

    val coins = arrayOf(50, 20, 10, 5, 1)
    var remainingAmount = amount
    var coinCount = 0

    for (coin in coins) {
        val count = remainingAmount / coin

        if (count > 0) {
            coinCount += count
            remainingAmount -= count * coin
        }
    }

    return coinCount
}

fun longestPrefix(strings: Array<String>): String {
    if (strings.isEmpty()) return ""

    for (i in strings[0].indices) {
        val char = strings[0][i]
        for (j in 1..<strings.size) {
            if (i == strings[j].length || strings[j][i] != char) {
                return strings[0].substring(0, i)
            }
        }
    }
    return strings[0]
}

fun addBinary(a: String, b: String): String {
    val numA = BigInteger(a, 2)
    val numB = BigInteger(b, 2)
    val sum = numA.add(numB)

    return sum.toString(2)
}

fun countVariants(stairsCount: Int): Int {
    if (stairsCount <= 1) {
        return 1
    }

    var prev = 1
    var current = 1

    for (i in 2..stairsCount) {
        val temp = current
        current += prev
        prev = temp
    }

    return current
}
