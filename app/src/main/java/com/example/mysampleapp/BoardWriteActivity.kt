package com.example.mysampleapp

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class BoardWriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_write)

        //val writeBtn:Button=findViewById(R.id.writeUploadBtn)
        val writeBtn = findViewById<Button>(R.id.writeUploadBtn)
        writeBtn.setOnClickListener{

            val writeText = findViewById<EditText>(R.id.writeTextArea)

            val database = Firebase.database
            val myRef = database.getReference("board")

            myRef.push().setValue(
               Model(writeText.text.toString())
            )
        }
    }
}