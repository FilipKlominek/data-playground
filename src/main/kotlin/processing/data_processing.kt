package processing

import streams.Gender
import streams.Grade
import streams.GradeType
import streams.Student


fun atLeastOneGradeA(student: Student): Boolean {
    return student.grades.any { grade -> grade.type == GradeType.A }
}


fun getStudentAges(students: List<Student>): List<Int> {
    return students.map { student -> student.age }
}

fun getStudentsWithMinimumAge(students: List<Student>, minAge: Int): List<Student> {
    return students.filter { student -> student.age >= minAge }
}


// gender == Gender.MALE
// or gender.name == "MALE"
fun countMaleStudents(students: List<Student>): Int {
    return students.filter { student -> student.gender == Gender.MALE }.size
}


// gender == Gender.FEMALE
// or gender.name == "FEMALE"
fun avgAgeOfFemaleStudent(students: List<Student>): Double {
    val ages = students.filter { student -> student.gender == Gender.FEMALE }.map { femaleStudent -> femaleStudent.age }
    return (ages.fold(0) { acc, i -> acc + i }.toDouble() / ages.size.toDouble())
}

fun getProductOfStudentAges(students: List<Student>): Int {
    return students.map { student -> student.age }.fold(1) { acc, i -> acc * i }
}

// ignore F Grades
fun productOfStudentGrades(student: Student): Int {
    val grades = student.grades.filter { grade -> grade.type.value != 0 }.map { grade -> grade.type.value }
    return grades.fold(1) {acc, i -> acc * i }
}

// region BONUS

// use maxByOrNull on grades
fun getBestMathGradeFromStudent(student: Student): Grade? {
    TODO()
}

fun getSortedAges(students: List<Student>): List<Int> {
    return students.map { student -> student.age }.asSequence().sorted().toList()
}

// endregion
