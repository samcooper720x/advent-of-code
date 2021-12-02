fun main() {
    fun part1(input: List<String>): Int = input
        .fold(mutableMapOf("x" to 0, "y" to 0)) { position, command ->
            val direction = command.split(" ").first()
            val distance = command.split(" ").last().toInt()
            when (direction) {
                "forward" -> position.merge("x", distance, Int::plus)
                "down" -> position.merge("y", distance, Int::plus)
                "up" -> position.merge("y", distance, Int::minus)
            }
            position
        }.values.reduce { product, coordinate -> product * coordinate }

    fun part2(input: List<String>): Int = input
        .fold(mutableMapOf("aim" to 0, "x" to 0, "y" to 0)) { position, command ->
            val direction = command.split(" ").first()
            val distance = command.split(" ").last().toInt()
            when (direction) {
                "forward" -> {
                    position.merge("x", distance, Int::plus)
                    position.merge("y", position.getValue("aim") * distance, Int::plus)
                }
                "down" -> position.merge("aim", distance, Int::plus)
                "up" -> position.merge("aim", distance, Int::minus)
            }
            position
        }.values.drop(1).reduce { product, coordinate -> product * coordinate }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputAsStrs("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInputAsStrs("Day02")
    println(part1(input))
    println(part2(input))
}
