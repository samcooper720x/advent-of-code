fun main() {
    fun part1(input: List<String>): Int {
        var x = 0
        var y = 0
        input.map {
            val command = it.split(" ")
            val direction = command.first()
            val distance = command.last().toInt()
            when (direction) {
                "forward" -> x += distance
                "down" -> y += distance
                "up" -> y -= distance
                else -> println("incompatible direction received")
            }
        }
        return x * y
    }

    fun part2(input: List<String>): Int {
        var aim = 0
        var x = 0
        var y = 0
        input.map {
            val command = it.split(" ")
            val direction = command.first()
            val distance = command.last().toInt()
            when (direction) {
                "forward" -> {
                    x += distance
                    y += aim * distance
                }
                "down" -> aim += distance
                "up" -> aim -= distance
                else -> println("incompatible direction received")
            }
        }
        return x * y
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputAsStrs("Day02_test")
    println(part1(testInput))
    check(part1(testInput) == 150)
    println(part2(testInput))
    check(part2(testInput) == 900)

    val input = readInputAsStrs("Day02")
    println(part1(input))
    println(part2(input))
}
