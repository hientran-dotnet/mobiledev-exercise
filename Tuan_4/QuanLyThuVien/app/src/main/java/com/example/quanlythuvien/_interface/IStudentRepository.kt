package com.example.quanlythuvien._interface

import com.example.quanlythuvien.models.Student

interface IStudentRepository {
    fun addStudent(student: Student): Boolean
    fun getAllStudents(): List<Map<String, String>>

    fun studentIdExits(studentId: String): Boolean

    fun studentEmailExits(studentEmail: String): Boolean
}