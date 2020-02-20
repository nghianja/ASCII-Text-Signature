package signature

import java.io.File
import java.util.Scanner

fun readFile(pathname: String, spaceWidth: Int): List<Map<Char, String>> {
    val scanner = Scanner(File(pathname))
    val size = scanner.nextInt()
    val numChar = scanner.nextInt()
    val list = mutableListOf<MutableMap<Char, String>>()
    for (h in 0..size) {
        list.add(mutableMapOf(' ' to " ".repeat(spaceWidth)))
    }
    for (i in 1..numChar) {
        val char = scanner.next().single()
        val width = scanner.nextInt()
        for (j in 0..size) {
            list[j][char] = scanner.nextLine()
        }
    }
    return list
}

fun printLabel(lineLength: Int, mutableList: MutableList<String>) {
    var leftPad = ""
    var rightPad = ""
    val difference = lineLength - mutableList[0].length
    if (difference > 0) {
        val left = difference / 2
        val right = difference - left
        leftPad = " ".repeat(left)
        rightPad = " ".repeat(right)
    }
    for (i in mutableList.indices) {
        println("88 $leftPad ${mutableList[i]} $rightPad 88")
    }
}

fun main() {
    val medium = readFile("/Users/professional/Downloads/medium.txt", 5)
    val roman = readFile("/Users/professional/Downloads/roman.txt", 10)
    val scanner = Scanner(System.`in`)

    print("Enter name and surname: ")
    val fullName = scanner.nextLine()
    print("Enter person's status: ")
    val status = scanner.nextLine()

    val nameList = mutableListOf<String>()
    val statusList = mutableListOf<String>()

    for (i in roman.indices.drop(1)) {
        val builder = StringBuilder()
        for (c in fullName) {
            builder.append(roman[i][c])
        }
        nameList.add(builder.toString())
    }
    for (i in medium.indices.drop(1)) {
        val builder = StringBuilder()
        for (c in status) {
            builder.append(medium[i][c])
        }
        statusList.add(builder.toString())
    }

    val lineLength = if (nameList[0].length > statusList[0].length) nameList[0].length else statusList[0].length
    println("8".repeat(lineLength + 8))
    printLabel(lineLength, nameList)
    printLabel(lineLength, statusList)
    println("8".repeat(lineLength + 8))
}
