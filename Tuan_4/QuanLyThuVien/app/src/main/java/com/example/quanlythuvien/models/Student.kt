package com.example.quanlythuvien.models

class Student (
    override var id: String,
    override var name: String,
    private var email: String
) : Person(id, name) {
    override fun showInfo(): List<String> {
        val info: List<String> = listOf(
            "ID: $id",
            "Name: $name",
            "Class: $email"
        )
        return info
    }
}