package com.ignrmos.restaurnt

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ignrmos.restaurnt.evaluacion1.CuentaMesa
import com.ignrmos.restaurnt.evaluacion1.ItemMenu
import com.ignrmos.restaurnt.evaluacion1.ItemMesa

class MainActivity() : AppCompatActivity() {

    var etcazuela : EditText? = null
    var etpastel : EditText? = null
    var tvTotalCazuela : TextView? = null
    var tvTotalPastel : TextView? = null
    var tvTotalComida : TextView? = null
    lateinit var swPropina : Switch
    var tvPropina : TextView? = null
    var tvTotalCuenta : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        etcazuela = findViewById<EditText>(R.id.etcazuela)
        etpastel = findViewById<EditText>(R.id.etpastel)
        tvTotalCazuela = findViewById<TextView>(R.id.tvTotalCazuela)
        tvTotalPastel = findViewById<TextView>(R.id.tvTotalPastel)
        tvTotalComida = findViewById<TextView>(R.id.tvTotalComida)
        swPropina = findViewById<Switch>(R.id.swpropina)
        tvPropina = findViewById<TextView>(R.id.tvPropina)
        tvTotalCuenta = findViewById<TextView>(R.id.tvTotalCuenta)

        val plato1 = ItemMenu("Cazuela" , 10000)
        val plato2 = ItemMenu("Pastel de choclo", 12000)

        val cuentamesa = CuentaMesa(1)

        val mesa1 = ItemMesa(plato1, 1)



        etcazuela?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                mostrarSubtotal()
            }

        })

        etpastel?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                mostrarSubtotal()
            }

        })

        swPropina.setOnCheckedChangeListener { buttonView, isChecked ->
            val totalComida = tvTotalComida?.text.toString().toIntOrNull() ?: 0
            val totalConPropina = if (isChecked){
                val propina = (totalComida * 0.1)
                totalComida + propina

            }

            else{totalComida}

            tvTotalCuenta?.text = "$totalConPropina"

        }
    }



private fun mostrarSubtotal(){
    val cuentamesa = CuentaMesa(1)
    val cantCazuela = etcazuela?.text.toString().toIntOrNull() ?: 0
    val cantPastel = etpastel?.text.toString().toIntOrNull() ?:0
    val totalCazuela = cantCazuela * 10000
    val totalPastel = cantPastel * 12000
    val totalComida = totalCazuela + totalPastel
    tvTotalCazuela?.text = "$totalCazuela"
    tvTotalPastel?.text = "$totalPastel"
    tvTotalComida?.text = "$totalComida"

}}







