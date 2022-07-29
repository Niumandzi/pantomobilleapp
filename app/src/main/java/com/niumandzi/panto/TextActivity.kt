package com.niumandzi.panto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)
    }

    fun TextActivityFinishBtn(view: View?) {
        val intent = Intent(this@TextActivity, TextActivity::class.java)
        finish()
    }
}