package processing

import streams.Gender
import streams.Grade
import streams.GradeType
import streams.Student
import java.util.*
import java.util.function.Consumer
import kotlin.collections.ArrayList


fun atLeastOneGradeA(student: Student): Boolean {
    val grades = student.grades
    val gradeAs = grades.filter { grade -> grade.type == GradeType.A }
    return gradeAs.isNotEmpty()
}


fun getStudentAges(students: List<Student>): List<Int> {
    val ages = ArrayList<Int>()
    students.forEach(Consumer { student: Student -> ages.add(student.age) })
    return ages
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
    return (sum / ages.size).toDouble()
}

fun getProductOfStudentAges(students: List<Student>): Int {
    val ages = ArrayList<Int>()
    students.forEach { student -> ages.add(student.age) }
    var product = 1
    ages.forEach { age -> product *= age }
    return product
}

// ignore F Grades
fun productOfStudentGrades(student: Student): Int {
    val grades = ArrayList<Int>()
    student.grades.forEach { grade -> grades.add(grade.type.value) }
    var product = 1
    grades.forEach { grade -> product *= grade }
    return product
}

// region BONUS

// use maxByOrNull on grades
fun getBestMathGradeFromStudent(student: Student): Grade? {
    TODO()
}

fun getSortedAges(students: List<Student>): List<Int> {
    TODO()
}

// endregion
