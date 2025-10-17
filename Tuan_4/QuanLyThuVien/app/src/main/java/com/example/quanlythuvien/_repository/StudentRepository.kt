package com.example.quanlythuvien._repository

import com.example.quanlythuvien._interface.IStudentRepository
import com.example.quanlythuvien.models.Student

class StudentRepository : IStudentRepository {
    override fun addStudent( student: Student
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun getAllStudents(): List<Map<String, String>> {
        TODO("Not yet implemented")
    }

    override fun studentIdExits(studentId: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun studentEmailExits(studentEmail: String): Boolean {
        TODO("Not yet implemented")
    }

}