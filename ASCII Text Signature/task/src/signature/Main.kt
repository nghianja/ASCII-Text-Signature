package signature

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val name = scanner.nextLine()
    for (i in 0 until name.length + 4) {
        print("*")
    }
    println()
    println("* $name *")
    for (i in 0 until name.length + 4) {
        print("*")
    }
}
