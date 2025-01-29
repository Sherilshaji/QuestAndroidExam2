package com.example.exam2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val edtTxtSource=findViewById<EditText>(R.id.edt_txt_source)
        val edtTxtCountry=findViewById<EditText>(R.id.edt_txt_country)

        val btn=findViewById<Button>(R.id.btn_show_news)

        val intent= Intent(this,RecyclerViewMain::class.java)
        btn.setOnClickListener(){
            val source=edtTxtSource.text.toString()
            val country=edtTxtCountry.text.toString()
            intent.putExtra("source",source)
            intent.putExtra("country",country)
            startActivity(intent)
        }

    }
}