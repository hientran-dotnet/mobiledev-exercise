package com.example.navdataflow

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ForgotPasswordViewModel : ViewModel(){
    var _email by mutableStateOf("")
        private set
    var _password by mutableStateOf("")
        private set

    var _confirmPassword by mutableStateOf("")
        private set
    var _verifyCode by mutableStateOf("")
        private set

    fun setEmail(value: String) {
        _email = value
    }

    fun setPassword(value: String) {
        _password = value
    }

    fun setConfirmPassword(value: String) {
        _confirmPassword = value
    }

    fun setVerifyCode(value: String) {
        _verifyCode = value
    }
}