fun main() {
    fun part1(input: List<String>): Int = input.size

    fun part2(input: List<String>): Int = input.size

    // test if implementation meets criteria from the description, like:
    val testInput = readInputAsStrs("")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInputAsStrs("")
    println(part1(input))
    println(part2(input))
}
