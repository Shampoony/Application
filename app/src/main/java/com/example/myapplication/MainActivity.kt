package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import net.objecthunter.exp4j.ExpressionBuilder
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var sol: TextView
    private lateinit var res: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var button_0 = findViewById<MaterialButton>(R.id.button_0)
        var button_1 = findViewById<MaterialButton>(R.id.button_1)
        var button_2 = findViewById<MaterialButton>(R.id.button_2)
        var button_3 = findViewById<MaterialButton>(R.id.button_3)
        var button_4 = findViewById<MaterialButton>(R.id.button_4)
        var button_5 = findViewById<MaterialButton>(R.id.button_5)
        var button_6 = findViewById<MaterialButton>(R.id.button_6)
        var button_7 = findViewById<MaterialButton>(R.id.button_7)
        var button_8 = findViewById<MaterialButton>(R.id.button_8)
        var button_9 = findViewById<MaterialButton>(R.id.button_9)
        var button_open_bracket= findViewById<MaterialButton>(R.id.button_open_bracket)
        var button_close_bracket = findViewById<MaterialButton>(R.id.button_close_bracket)
        var button_multiply = findViewById<MaterialButton>(R.id.button_multiply)
        var button_c = findViewById<MaterialButton>(R.id.button_c)
        var button_AC = findViewById<MaterialButton>(R.id.button_AC)
        var button_divide = findViewById<MaterialButton>(R.id.button_divide)
        var button_plus = findViewById<MaterialButton>(R.id.button_plus)
        var button_minus = findViewById<MaterialButton>(R.id.button_minus)
        var button_dot = findViewById<MaterialButton>(R.id.button_dot)
        var button_equals = findViewById<MaterialButton>(R.id.button_equals)


        sol = findViewById<TextView>(R.id.sol)
        res = findViewById<TextView>(R.id.result)

        button_0.setOnClickListener { SetTextFields ("0")}
        button_1.setOnClickListener { SetTextFields ("1")}
        button_2.setOnClickListener { SetTextFields ("2")}
        button_3.setOnClickListener { SetTextFields ("3")}
        button_4.setOnClickListener { SetTextFields ("4")}
        button_5.setOnClickListener { SetTextFields ("5")}
        button_6.setOnClickListener { SetTextFields ("6")}
        button_7.setOnClickListener { SetTextFields ("7")}
        button_8.setOnClickListener { SetTextFields ("8")}
        button_9.setOnClickListener { SetTextFields ("9")}

        button_minus.setOnClickListener { SetTextFields ("-")}
        button_dot.setOnClickListener { SetTextFields (".")}
        button_plus.setOnClickListener { SetTextFields ("+")}
        button_multiply.setOnClickListener { SetTextFields ("*")}
        button_divide.setOnClickListener { SetTextFields ("/")}


        button_open_bracket.setOnClickListener { SetTextFields ("(")}
        button_close_bracket.setOnClickListener { SetTextFields (")")}
        button_equals.setOnClickListener {
            try {
                val ex = ExpressionBuilder(sol.text.toString()).build()
                val math_equals = ex.evaluate()

                val longRes = math_equals.toLong()
                if(math_equals == longRes.toDouble())
                    res.text = longRes.toString()
                else
                    res.text = math_equals.toString()
            } catch (e: Exception) {
                Log.d("Ошибка", "сообщение: ${e.message}")
            }
        }

        button_AC.setOnClickListener {
            sol.text = ""
            res.text = ""
        }

        button_c.setOnClickListener {
            val str = sol.text.toString()
            if(str.isNotEmpty()){
                sol.text = str.substring(0, str.length - 1)
            }
            res.text = ""
        }
    }

    fun SetTextFields(str:String){
        if(res.text != "") {
            sol.text = res.text
            res.text = ""
        }
        sol.append(str)
    }
}