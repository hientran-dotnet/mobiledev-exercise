package com.example.quanlythuvien.models

open class Person (
    open var id: String,
    open var name: String
){
    open fun showInfo(): List<String> {
        val info: List<String> = listOf(
            "ID: $id",
            "Name: $name"
        )
        return info
    }


}