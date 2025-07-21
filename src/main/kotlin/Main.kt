package org.example

fun main() {
    val students = listOf("Ahmed", "Laila", "Nour", "Omar", "Mona")
    val scores = mapOf("Ahmed" to 85, "Laila" to 72, "Nour" to 95, "Omar" to 60, "Mona" to 40)
    val graduated = setOf("Mona")

    println("\n--- Initial Data ---")
    println("Students: $students")
    println("Scores: $scores")
    println("Graduated: $graduated")

    println("\n--- Looping and Filtering ---")
    students.filterNot { it in graduated }
        .forEach { println("Student: $it") }

    val search = "Nour"
    println("\nScore for $search: ${scores[search] ?: "Not Found"}")

    println("\n--- Transform and Filter ---")
    println("Uppercased Names: ${students.map { it.uppercase() }}")
    println("Top Scorers (>80): ${scores.filter { it.value > 80 }.keys}")

    println("\n--- Reduce and Fold ---")
    println("Total Score: ${scores.values.reduce(Int::plus)}")
    println("Formatted: ${scores.entries.joinToString(" | ") { "${it.key}: ${it.value}" }}")

    println("\n--- Student Report ---")
    printStudentReport(scores)
}

fun printStudentReport(scores: Map<String, Int>) {
    if (scores.isEmpty()) return println("No student records available.")
    scores.filterValues { it >= 60 }
        .forEach { println("${it.key}: ${it.value}") }
}
