fun main() {
    fun part1(input: List<Int>): Int {
        return input.zipWithNext().filter { it.first < it.second }.size
    }

    fun part2(input: List<Int>): Int {
        return input.windowed(3).zipWithNext().filter { (it.first.sum()) < (it.second.sum()) }.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputAsInts("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInputAsInts("Day01")
    println(part1(input))
    println(part2(input))
}
