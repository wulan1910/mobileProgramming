package com.example.mobileprogramming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // deklarasi variabel
    private lateinit var inputPanjang: EditText
    private lateinit var inputLebar: EditText
    private lateinit var inputTinggi: EditText
    private lateinit var btn: Button
    private lateinit var Result: TextView

    companion object{
        private const val STATE_RESULT ="state_result"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       //  inisialisasi variable
        inputPanjang= findViewById(R.id.edt_length)
        inputLebar= findViewById(R.id.edt_width)
        inputTinggi= findViewById(R.id.edt_height)
        btn = findViewById(R.id.btn_result)
        Result = findViewById(R.id.result)


        btn.setOnClickListener(this)

        //menampilkan value yang ada di budle
        if (savedInstanceState !=null) {
            Result.text =savedInstanceState.getString(STATE_RESULT)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT,Result.text.toString())
    }


    override fun onClick(v: View?) {
        if (v?.id==R.id.btn_result){
            var Panjang = inputPanjang.text.toString().trim()
            var Lebar = inputLebar.text.toString().trim()
            var Tinggi = inputTinggi.text.toString().trim()
            var volume = Panjang.toDouble() * Lebar.toDouble()
            Result.text = volume.toString()
        }
    }


}