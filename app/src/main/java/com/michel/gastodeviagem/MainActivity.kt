package com.michel.gastodeviagem

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonCalculate) {
            calculate();
        }
    }

    private fun calculate() {
        if (validationOk()) {
            try {
                val distance = editDistance.text.toString().toFloat();
                val price = editPrice.text.toString().toFloat();
                val autonomia = editAutonomia.text.toString().toFloat();
                val totalValue = (distance * price) / autonomia
                textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
            }catch (nfe: NumberFormatException){
                Toast.makeText(this, getString(R.string.Por_favor_informe_valores_validos), Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(this, getString(R.string.preencha_todos_campos), Toast.LENGTH_LONG).show()
        }
    }

    private fun validationOk(): Boolean {
        return (editDistance.text.toString() != "" && editPrice.text.toString() != "" && editAutonomia.text.toString() != "")
    }
}