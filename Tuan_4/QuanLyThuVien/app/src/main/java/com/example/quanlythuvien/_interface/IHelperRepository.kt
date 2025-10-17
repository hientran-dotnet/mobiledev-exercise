package com.example.quanlythuvien._interface

import android.content.Context

interface IHelperRepository {
    fun getStudentFilePath(): String
    fun getStudentIdFromJsonFile(): String

    fun getStudentEmailFromJsonFile(): String
}