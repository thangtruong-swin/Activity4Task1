package au.edu.swin.sdmd.activity4task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var operator = "plus"
    var opResult: Int = 0

    override fun onStart() {
        super.onStart()
        Log.i("LIFECYCLE", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("LIFECYCLE", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("LIFECYCLE", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("LIFECYCLE", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LIFECYCLE", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("LIFECYCLE", "onRestart")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Log.i("LIFECYCLE", "onCreated")

        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)
        val answer = findViewById<TextView>(R.id.answer)

        savedInstanceState?.let {
            opResult = savedInstanceState.getInt("ANSWER")
            answer.text = opResult.toString()
        }

        val equals = findViewById<Button>(R.id.equals)
        equals.setOnClickListener {
             opResult = when (operator) {
                "plus" -> add(number1.text.toString(), number2.text.toString())
                "multiple" -> multiple(number1.text.toString(), number2.text.toString())
                else -> add(number1.text.toString(), number2.text.toString())
//                else -> "Please select a method"
            }
            // TODO: show result on the screen
            answer.text = opResult.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("ANSWER", opResult)
        Log.i("LIFECYCLE", "saveInstanceState $opResult")
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked
            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radioPlus ->
                    if (checked) {
                        operator = "plus"
                    }
                R.id.radioMultiple ->
                    if (checked) {
                        operator = "multiple"
                    }
            }
        }
    }
    // adds two numbers together
//    private fun add(number1: String, number2: String) = number1 + number2
    private fun add(number1: String, number2: String) = number1.toInt() + number2.toInt()
    private fun multiple(number1: String, number2: String) = number1.toInt() * number2.toInt()
}
