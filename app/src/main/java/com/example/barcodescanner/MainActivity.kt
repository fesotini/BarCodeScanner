package com.example.barcodescanner

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.barcodescanner.databinding.ActivityMainBinding
import com.google.zxing.integration.android.IntentIntegrator

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnScanner.setOnClickListener{ initScanner()}
    }

    private fun initScanner() {
        val integrator = IntentIntegrator(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
        integrator.setPrompt("Colocar el código de barras del producto dentro del rectangulo")
        integrator.setTorchEnabled(true)
        integrator.setBeepEnabled(true)
        integrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Lectura cancelada", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "El valor escaneado es: ${result.contents}", Toast.LENGTH_SHORT).show()
                binding.txtResultado.setText("${result.contents}")
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data)
        }

    }
}