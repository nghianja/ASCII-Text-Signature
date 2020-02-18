package signature

import java.util.Scanner

val top = mapOf('A' to "____", 'B' to "___ ", 'C' to "____", 'D' to "___ ", 'E' to "____",
                'F' to "____", 'G' to "____", 'H' to "_  _", 'I' to "_", 'J' to " _", 'K' to "_  _",
                'L' to "_   ", 'M' to "_  _", 'N' to "_  _", 'O' to "____", 'P' to "___ ",
                'Q' to "____", 'R' to "____", 'S' to "____", 'T' to "___", 'U' to "_  _",
                'V' to "_  _", 'W' to "_ _ _", 'X' to "_  _", 'Y' to "_   _", 'Z' to "___ ")
val middle = mapOf('A' to "|__|", 'B' to "|__]", 'C' to "|   ", 'D' to "|  \\", 'E' to "|___",
                    'F' to "|___", 'G' to "| __", 'H' to "|__|", 'I' to "|", 'J' to " |", 'K' to "|_/ ",
                    'L' to "|   ", 'M' to "|\\/|", 'N' to "|\\ |", 'O' to "|  |", 'P' to "|__]",
                    'Q' to "|  |", 'R' to "|__/", 'S' to "[__ ", 'T' to " | ", 'U' to "|  |",
                    'V' to "|  |", 'W' to "| | |", 'X' to " \\/ ", 'Y' to " \\_/ ", 'Z' to "  / ")
val bottom = mapOf('A' to "|  |", 'B' to "|__]", 'C' to "|___", 'D' to "|__/", 'E' to "|___",
                    'F' to "|   ", 'G' to "|__]", 'H' to "|  |", 'I' to "|", 'J' to "_|", 'K' to "| \\_",
                    'L' to "|___", 'M' to "|  |", 'N' to "| \\|", 'O' to "|__|", 'P' to "|   ",
                    'Q' to "|_\\|", 'R' to "|  \\", 'S' to "___]", 'T' to " | ", 'U' to "|__|",
                    'V' to " \\/ ", 'W' to "|_|_|", 'X' to "_/\\_", 'Y' to "  |  ", 'Z' to " /__")

fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter name and surname: ")
    val name = scanner.nextLine().toUpperCase()
    print("Enter person's status: ")
    val status = scanner.nextLine()
    var topLine = ""
    var middleLine = ""
    var bottomLine = ""
    for (i in name.indices) {
        when (name[i]) {
            in 'A'..'Z' -> {
                if (i > 0) {
                    topLine += " ${top.get(name[i])}"
                    middleLine += " ${middle.get(name[i])}"
                    bottomLine += " ${bottom.get(name[i])}"
                } else {
                    topLine += "${top.get(name[i])}"
                    middleLine += "${middle.get(name[i])}"
                    bottomLine += "${bottom.get(name[i])}"
                }
            }
            else -> {
                topLine += "     "
                middleLine += "     "
                bottomLine += "     "
            }
        }
    }
    if (status.length > topLine.length) {
        val padNumber = (status.length - topLine.length) / 2
        topLine = topLine.padStart(topLine.length + padNumber)
        topLine = topLine.padEnd(status.length)
        middleLine = middleLine.padStart(middleLine.length + padNumber)
        middleLine = middleLine.padEnd(status.length)
        bottomLine = bottomLine.padStart(bottomLine.length + padNumber)
        bottomLine = bottomLine.padEnd(status.length)
    }
    val statusModulo = status.length % 2
    val bottomModulo = bottomLine.length % 2
    val leftNumbers = (bottomLine.length - status.length) / 2
    val leftSpacing = " ".repeat(leftNumbers)
    val rightSpacing = if (statusModulo != bottomModulo) {
        " ".repeat(leftNumbers + 1)
    } else {
        " ".repeat(leftNumbers)
    }
    topLine = "*  $topLine  *"
    middleLine = "*  $middleLine  *"
    bottomLine = "*  $bottomLine  *"
    println("*".repeat(topLine.length))
    println(topLine)
    println(middleLine)
    println(bottomLine)
    println("*  $leftSpacing$status$rightSpacing  *")
    println("*".repeat(bottomLine.length))
}
