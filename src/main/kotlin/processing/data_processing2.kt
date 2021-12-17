package processing

import streams.*

fun sumOfAgesOfAllStudents(school: School): Int {
    val students: List<Student> = school.classes.flatMap { it.students } //get students
    return students.map { student -> student.age }.sum() //return sum of student grades
}

fun allStudentsWithAgeGreaterThan(school: School, minAge: Int): List<Student> {
    val students: List<Student> = school.classes.flatMap { it.students } //get students
    return students.filter { student -> student.age > minAge } //return filtered students
}

fun avgMathGradeForAllFemaleStudents(school: School): Double {
    val students: List<Student> = school.classes.flatMap { it.students } //get students
    val femaleStudents = students.filter { student -> student.gender == Gender.FEMALE } // get filtered students
    val grades: List<Grade> = femaleStudents.flatMap { student -> student.grades } //get grades of filtered students
    val mathGrades = grades.filter { grade -> grade.subject == Subject.MATH } //get filtered grades
    return mathGrades.map { grade -> grade.type.value }.average() //return average of filtered grades
}

