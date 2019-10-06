package com.example.basickotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

        var etName: EditText? = null
        var spGender: Spinner? = null
        var etEmail: EditText? = null
        var etTelepon: EditText? = null
        var etAlamat: EditText? = null
        var btnSimpan: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.et_nama)
        spGender = findViewById(R.id.sp_gender)
        etEmail = findViewById(R.id.et_email)
        etTelepon = findViewById(R.id.et_telepon)
        etAlamat = findViewById(R.id.et_alamat)
        btnSimpan= findViewById(R.id.btn_submit)

        btnSimpan?.setOnClickListener{
            validasiInput()
        }
        setDataGender()

    }
        private fun validasiInput(){
            val inputName = etName?.text.toString()
            val inputEmail = etEmail?.text.toString()
            val inputTelepon = etTelepon?.text.toString()
            val inputAlamat = etAlamat?.text.toString().toString()
            val inputGender = spGender?.selectedItem.toString()

            when{
                inputName.isEmpty() -> etName?.error = "Nama tidak boleh kosong"
                inputEmail.isEmpty() -> etEmail?.error = "Email tidak boleh kosong"
                inputGender.equals("Pilih Jenis Kelamin") -> tampilkantoast("Jenis kelamin tidak boleh kosong")
                inputTelepon.isEmpty() -> etTelepon?.error = "Telepon tidak boleh kosong"
                inputAlamat.isEmpty() -> etAlamat?.error = "Alamat tidak boleh kosong"

                else -> {
                    tampilkantoast("Navigasi ke halaman profile")

                    val intent = Intent(this, ProfileActivity::class.java)

                    intent.putExtra("nama", inputName)
                    intent.putExtra("gender", inputGender)
                    intent.putExtra("email", inputEmail)
                    intent.putExtra("telepon", inputTelepon)
                    intent.putExtra("alamat", inputAlamat)

                    startActivity(intent)

                }
            }
        }

    private fun tampilkantoast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun setDataGender(){
        val adapter = ArrayAdapter.createFromResource(
            this,R.array.gender_List, android.R.layout.simple_spinner_dropdown_item)

        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spGender?.adapter = adapter
    }
}
