package com.example.toolbox

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

//   result variable to save it anywhere is needed
    private var text = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator_layout)

        // Objects created to work with the views
        val calcTextView: TextView = findViewById(R.id.calc_display)
        val calcTextResult: TextView = findViewById(R.id.calc_result)

//      ---------CHECK IF A BUTTON IS PRESSED-----------------------------
//    ____________________________________________________________________
//      NUMBER BUTTONS PROCESS---------------------
        val button1: Button = findViewById(R.id.button_1)
        button1.setOnClickListener { stringConstructor("1",true, calcTextResult, calcTextView)}

        val button2: Button = findViewById(R.id.button_2)
        button2.setOnClickListener { stringConstructor("2",true, calcTextResult, calcTextView)}

        val button3: Button = findViewById(R.id.button_3)
        button3.setOnClickListener { stringConstructor("3",true, calcTextResult, calcTextView)}

        val button4: Button = findViewById(R.id.button_4)
        button4.setOnClickListener { stringConstructor("4",true, calcTextResult, calcTextView)}

        val button5: Button = findViewById(R.id.button_5)
        button5.setOnClickListener { stringConstructor("5",true, calcTextResult, calcTextView)}

        val button6: Button = findViewById(R.id.button_6)
        button6.setOnClickListener { stringConstructor("6",true, calcTextResult, calcTextView)}

        val button7: Button = findViewById(R.id.button_7)
        button7.setOnClickListener { stringConstructor("7",true, calcTextResult, calcTextView)}

        val button8: Button = findViewById(R.id.button_8)
        button8.setOnClickListener { stringConstructor("8",true, calcTextResult, calcTextView)}

        val button9: Button = findViewById(R.id.button_9)
        button9.setOnClickListener { stringConstructor("9",true, calcTextResult, calcTextView)}

        val button0: Button = findViewById(R.id.button_0)
        button0.setOnClickListener { stringConstructor("0",true, calcTextResult, calcTextView)}

//        OPERATOR BUTTONS PROCESS-----------------------------------------
        val buttonPlus: Button = findViewById(R.id.button_plus)
        buttonPlus.setOnClickListener { stringConstructor("+",false, calcTextResult, calcTextView)}

        val buttonMinus: Button = findViewById(R.id.button_minus)
        buttonMinus.setOnClickListener { stringConstructor("-",false, calcTextResult, calcTextView)}

        val buttonTimes: Button = findViewById(R.id.button_times)
        buttonTimes.setOnClickListener { stringConstructor("*",false, calcTextResult, calcTextView)}

        val buttonDivision: Button = findViewById(R.id.button_divide)
        buttonDivision.setOnClickListener { stringConstructor("/",false, calcTextResult, calcTextView)}

        val buttonDelete: Button = findViewById(R.id.button_delete)
        buttonDelete.setOnClickListener {
            text = calcTextView.text.toString()
            if(text.isNotEmpty()){
                calcTextView.text = text.substring(0,text.length-1)
            }
            calcTextResult.text = ""
        }

        val buttonEqual: Button = findViewById(R.id.button_equal)
        buttonEqual.setOnClickListener {
            text = calcTextView.text.toString()
            val expression = ExpressionBuilder(text).build()
            val result = expression.evaluate()
            val longResult = result.toLong()
            if(result == longResult.toDouble()){
                calcTextResult.text = longResult.toString()
            }else {
                calcTextResult.text = result.toString()
            }
        }
    }
// Function to create a result, new result, and restart the result view
    private fun stringConstructor(string: String, clear: Boolean, result: TextView, expression: TextView){
        if(result.text.isNotEmpty()){
            result.text = ""
        }
        if(clear){
            result.text = ""
            expression.append(string)
        }else {
            expression.append(result.text)
            expression.append(string)
            result.text = ""
        }
    }
}