fun main() {
    fun part1(input: List<Int>): Int = input
        .zipWithNext()
        .fold(0) { increases, depths -> if (depths.first < depths.second) increases + 1 else increases }

    fun part2(input: List<Int>): Int = input
        .windowed(3)
        .zipWithNext()
        .fold(0) { increases, depths -> if (depths.first.sum() < depths.second.sum()) increases + 1 else increases }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputAsInts("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInputAsInts("Day01")
    println(part1(input))
    println(part2(input))
}
