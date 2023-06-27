package com.jacgr.ejerciciosmodulo4.tarearegistro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.util.PatternsCompat
import com.jacgr.ejerciciosmodulo4.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnRegister = findViewById<AppCompatButton>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            //Toast.makeText(this, "Se van a verificar los datos", Toast.LENGTH_SHORT).show()
            verifyData()
        }

    }

    private fun verifyData(){
        val etName = findViewById<EditText>(R.id.etRegisterName)
        val etLastName = findViewById<EditText>(R.id.etRegisterLastName)
        val etEmail = findViewById<EditText>(R.id.etRegisterEmail)
        val rgRegister = findViewById<RadioGroup>(R.id.rgRegister)
        val etPassword = findViewById<EditText>(R.id.etRegisterPassword)

        var flag = true
        var name = ""
        var lastName = ""
        var email = ""
        var gender = ""
        var password = ""
        val selectedRbSex = when(rgRegister.checkedRadioButtonId){
            R.id.rbRegMan -> "Hombre"
            R.id.rbRegWoman -> "Mujer"
            R.id.rbRegOther -> "Otro"
            else -> "Desconocido"
        }
        
        if(etName.text.isNotEmpty()){
            name = etName.text.toString()
        }else{
            etName.error = "Porfavor ingresa un nombre"
            flag = false
        }
        if(etLastName.text.isNotEmpty()){
            lastName = etLastName.text.toString()
        }else{
            etLastName.error = "Porfavor ingresa un apellido"
            flag = false
        }
        if(etEmail.text.isNotEmpty()){
            email = etEmail.text.toString()
            if(!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()){
                etEmail.error = "Porfavor ingresa un correo válido"
                flag = false
            }
        }else{
            etEmail.error = "Porfavor ingresa un correo"
            flag = false
        }
        if(selectedRbSex != "Desconocido"){
            gender = selectedRbSex
        }else{
            Toast.makeText(this, "Selecciona tu sexo", Toast.LENGTH_SHORT).show()
            flag = false
        }
        if(etPassword.text.isNotEmpty()){
            password = etPassword.text.toString()
        }else{
            etPassword.error = "Porfavor ingresa una contraseña"
            flag = false
        }

        if(flag){
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }


    }

}