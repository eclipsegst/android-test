package com.zhaolongzhong.android_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val helloTextView = findViewById<TextView>(R.id.text_to_be_changed_text_view_id)
        val editText = findViewById<TextView>(R.id.user_input_edit_text_id)
        val buttonTextView = findViewById<Button>(R.id.change_text_button_id)

        buttonTextView.setOnClickListener {
            helloTextView.text = editText.text
        }
    }
}
