package com.example.quanlythuvien._repository

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import com.example.quanlythuvien._interface.IHelperRepository
import java.io.File


class HelpeRepository(
    private val context: Context
) : IHelperRepository {
    override fun getStudentFilePath(): String {
        TODO("Not yet implemented")
    }

    override fun getStudentIdFromJsonFile(): String {
        TODO("Not yet implemented")
    }

    override fun getStudentEmailFromJsonFile(): String {
        TODO("Not yet implemented")
    }


}