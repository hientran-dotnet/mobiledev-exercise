package com.example.agechecker

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var nameEdtText: EditText
    private lateinit var ageEdtText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        nameEdtText = findViewById<EditText>(R.id.editTextText)
        ageEdtText = findViewById<EditText>(R.id.editTextText2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun ageChecker(view: View) {
        val name = nameEdtText.text.toString()
        val age = ageEdtText.text.toString()

        if(name.isEmpty() || age.isEmpty()){
            Toast.makeText(this, "Vui lòng nhập đầy đủ dữ liệu", Toast.LENGTH_SHORT).show()
        }

        if(age.toInt() <= 0){
            Toast.makeText(this, "Số tuổi không được nhỏ hơn 0", Toast.LENGTH_SHORT).show()
        }

        if(age.toInt() > 0 && age.toInt() < 2){
            Toast.makeText(this, "Em bé", Toast.LENGTH_SHORT).show()
        }

        if(age.toInt() >= 2 && age.toInt() < 6){
            Toast.makeText(this, "Trẻ em", Toast.LENGTH_SHORT).show()
        }

        if(age.toInt() >= 6 && age.toInt() < 65){
            Toast.makeText(this, "Người lớn", Toast.LENGTH_SHORT).show()
        }

        if(age.toInt() >= 65){
            Toast.makeText(this, "Người già", Toast.LENGTH_SHORT).show()
        }
    }
}