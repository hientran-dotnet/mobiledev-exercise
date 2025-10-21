package com.example.thuchanh1

import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.text.SpannedString
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var t1: TextView
    private lateinit var t2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        t1 = findViewById<TextView>(R.id.tvInfo)


    }

    fun GreetingOnClick(view: View) {

        var a = "I'm"
        var b = "Tran Minh Hien"

        var sourceString = a + "<br>" +"<b>" + b + "</b>"

        t1.setText(Html.fromHtml(sourceString))

    }
}