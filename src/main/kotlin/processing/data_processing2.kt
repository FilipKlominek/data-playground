package processing

import streams.*

fun sumOfAgesOfAllStudents(school: School): Int {
    val students: List<Student> = school.classes.flatMap { it.students }
    return students.map { student -> student.age }.sum()
}

fun allStudentsWithAgeGreaterThan(school: School, minAge: Int): List<Student> {
    val students: List<Student> = school.classes.flatMap { it.students }
    return students.filter { student -> student.age > minAge }
}

fun avgMathGradeForAllFemaleStudents(school: School): Double {
    val students: List<Student> = school.classes.flatMap { it.students }
    val femaleStudents = students.filter { student -> student.gender == Gender.FEMALE }
    val grades: List<Grade> = femaleStudents.flatMap { student -> student.grades }
    val mathGrades = grades.filter { grade -> grade.subject == Subject.MATH }
    return mathGrades.map { grade -> grade.type.value }.average()
}

