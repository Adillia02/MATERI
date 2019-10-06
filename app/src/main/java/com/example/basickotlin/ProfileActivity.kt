package com.example.basickotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {

    var tvName: TextView? = null
    var tvGender: TextView? = null
    var tvEmail: TextView? = null
    var tvTelepon: TextView? = null
    var tvAlamat: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        tvName = findViewById(R.id.tv_nama)
        tvGender = findViewById(R.id.tv_gender)
        tvEmail = findViewById(R.id.tv_email)
        tvTelepon = findViewById(R.id.tv_telepon)
        tvAlamat = findViewById(R.id.tv_alamat)

        ambilData()
    }

    private fun  ambilData(){
        tvName?.text = intent.getStringExtra("nama")
        tvGender?.text = intent.getStringExtra("gender")
        tvEmail?.text = intent.getStringExtra("email")
        tvTelepon?.text = intent.getStringExtra("telepon")
        tvAlamat?.text = intent.getStringExtra("alamat")

    }
}
