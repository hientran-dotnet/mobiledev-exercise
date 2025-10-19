package com.example.quanlythuvien.viewmodels

import androidx.lifecycle.ViewModel
import com.example.quanlythuvien.models.Student

class StudentViewModel : ViewModel(){
    private val _students = mutableListOf<Student>()
    val student: List<Student> = _students

    fun addStudent(student: Student) {
        _students.add(student)
    }
}