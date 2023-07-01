package com.jacgr.ejerciciosmodulo4.Ejercicio2.componentesgraficos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import com.jacgr.ejerciciosmodulo4.R
import com.jacgr.ejerciciosmodulo4.databinding.ActivitySelectionComponentBinding

class SelectionComponentActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectionComponentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectionComponentBinding.inflate(layoutInflater)
        setContentView(binding.root)



//        val cbCreditCard = findViewById<CheckBox>(R.id.cbCreditCard)
//        val btnSend = findViewById<ImageButton>(R.id.btnSend)
//        val rgSex = findViewById<RadioGroup>(R.id.rgSex)
        //val btnRecycler = findViewById<Button>(R.id.btnRecyclerView)

        /*cbCreditCard.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, "isChecked = $isChecked", Toast.LENGTH_SHORT).show()
        }

        rgSex.setOnCheckedChangeListener { _, checkedId ->
            val idName = when(checkedId){
                R.id.rbMan -> "Hombre"
                R.id.rbWoman -> "Mujer"
                else -> "Desconocido"
            }
            Toast.makeText(this, "isCheckedId = $idName", Toast.LENGTH_SHORT).show()
        }*/

        // SPINNER

        //val spinner = findViewById<Spinner>(R.id.spinner)
        val datos = arrayListOf("México", "España", "Dinamarca", "Estados Unidos", "Venezuela", "Colombia", "Japón", "Corea del Norte", "Russia", "India")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, datos)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinner.adapter = adapter

        /*spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val itemSelected = datos[position]

                Toast.makeText(this@SelectionComponentActivity, "Item seleccionado: $itemSelected", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@SelectionComponentActivity, "Nada seleccionado", Toast.LENGTH_SHORT).show()
            }

        }*/

        /*btnSend.setOnClickListener {
            val cbStatus = cbCreditCard.isChecked
            val selectedRbSex = when(rgSex.checkedRadioButtonId){
                R.id.rbMan -> "H"
                R.id.rbWoman -> "M"
                else -> "Desconocido"
            }

            Toast.makeText(this, "value = $selectedRbSex", Toast.LENGTH_SHORT).show()
        }*/

        binding.btnRecyclerView.setOnClickListener {
            val intent = Intent(this, RecyclerActivity::class.java)
            startActivity(intent)
        }

    }
}