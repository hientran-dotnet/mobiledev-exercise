package com.example.validemailinput

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.red
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var edtText: EditText
    private lateinit var txtView: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        edtText = findViewById<EditText>(R.id.editTextText)
        txtView = findViewById<TextView>(R.id.textView2)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun onClickButton(view: View) {
        val content = edtText.text.toString()
        if(content.isEmpty()){
            Toast.makeText(this, "Vui lòng nhập email", Toast.LENGTH_SHORT).show()
            return
        }

        val regex = Regex("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")

        if (!regex.matches(content)) {
            Toast.makeText(this, "Dữ liệu bạn nhập không hợp lệ", Toast.LENGTH_SHORT).show()
            return
        }else{
//            Toast.makeText(this, "Bạn đã nhập email hợp lệ", Toast.LENGTH_SHORT).show()
//            return
            txtView.setText("Bạn đã nhập email hợp lệ")
        }


    }
}