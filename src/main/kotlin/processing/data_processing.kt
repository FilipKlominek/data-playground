package processing

import streams.Gender
import streams.Grade
import streams.GradeType
import streams.Student


fun atLeastOneGradeA(student: Student): Boolean {
    val grades = student.grades
    val gradeAs = grades.filter { grade -> grade.type == GradeType.A }
    return gradeAs.isNotEmpty()
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
    val femaleStudents = students.filter { student -> student.gender == Gender.FEMALE }
    val ages = femaleStudents.map { femaleStudent -> femaleStudent.age }
    val sum = ages.fold(0) { acc, i -> acc + i }
    return (sum.toDouble() / ages.size.toDouble())
}

fun getProductOfStudentAges(students: List<Student>): Int {
    return students.map { student -> student.age }.fold(1) { acc, i -> acc * i }
}

// ignore F Grades
fun productOfStudentGrades(student: Student): Int {
    val studentGrades = student.grades.filter { grade -> grade.type.value != 0 }
    val grades = studentGrades.map { grade -> grade.type.value }
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
