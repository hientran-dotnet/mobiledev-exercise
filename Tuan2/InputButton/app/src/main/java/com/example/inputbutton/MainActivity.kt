package com.example.inputbutton

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inputbutton.R.*

class MainActivity : AppCompatActivity() {
    private lateinit var edtNumber: EditText
    private lateinit var container: LinearLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(layout.activity_main)

        edtNumber = findViewById<EditText>(id.editTextText2)
        container = findViewById<LinearLayout>(id.LinearLayout22)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    fun onButtonClick(view: View) {
        container.removeAllViews()

        val nText = edtNumber.text.toString()
        if(nText.isEmpty()){
            Toast.makeText(this, "Vui lòng nhập số", Toast.LENGTH_SHORT).show()
            return
        }

        val regex = Regex("^[0-9]+$")

        if (!regex.matches(nText)) {
            Toast.makeText(this, "Dữ liệu bạn nhập không hợp lệ", Toast.LENGTH_SHORT).show()
            return
        }

        val n = nText.toInt()
        for(i in 1..n){

            val btn = Button(this)
            btn.text = i.toString()
            btn.setBackgroundColor(resources.getColor(android.R.color.holo_red_light, null))

            btn.setOnClickListener {
                Toast.makeText(this, "Nút $i", Toast.LENGTH_SHORT).show()
            }

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(0, 16, 0, 0)
            btn.layoutParams = params

            container.addView(btn)
        }
    }


}