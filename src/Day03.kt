import kotlin.math.roundToInt

fun main() {
    fun part1(input: List<String>): Int {
        var gamma = ""
        var epsilon = ""
        for (i in input[0].indices) {
            val bit = ((input.map { digit -> digit[i].digitToInt() }.average().roundToInt()))
            gamma += bit
            epsilon += (1 - bit)
        }
        return gamma.toInt(2) * epsilon.toInt(2)
    }

    fun part2(input: List<String>): Int {
        var o2Rating = 0
        var o2RatingCandidates = input.toMutableList()
        var co2ScrubberRating = 0
        var co2ScrubberRatingCandidates = input.toMutableList()

        for (i in input[0].indices) {
            val mostCommonOr1: Int = if (o2RatingCandidates.map { digit -> digit[i].digitToInt() }.average() >= 0.5) 1 else 0
            o2RatingCandidates = o2RatingCandidates.filter { it[i].digitToInt() == mostCommonOr1 }.toMutableList()

            val leastCommonOr0: Int = if (co2ScrubberRatingCandidates.map { digit -> digit[i].digitToInt() }.average() >= 0.5) 0 else 1
            co2ScrubberRatingCandidates = co2ScrubberRatingCandidates.filter { it[i].digitToInt() == leastCommonOr0 }.toMutableList()

            if (o2RatingCandidates.size == 1) {
                o2Rating = o2RatingCandidates.first().toInt(2)
            }
            if (co2ScrubberRatingCandidates.size == 1) {
                co2ScrubberRating = co2ScrubberRatingCandidates.first().toInt(2)
            }
        }
        return o2Rating * co2ScrubberRating
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputAsStrs("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInputAsStrs("Day03")
    println(part1(input))
    println(part2(input))
}
