package com.example.calculator_updated

import android.app.Activity
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {

    //private var isChecked = false

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        val checkable = menu?.findItem(R.id.dialogue_box);

        inflater.inflate(R.menu.item_from_menu, menu)
        //checkable?.setChecked(isChecked);
        return true
    }
    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.checkable_menu -> {
                isChecked = !item.isChecked
                item.isChecked = isChecked
                true
            }
            else -> false
        }
    }*/

    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        when (item.itemId) {
            R.id.dialogue_box-> {

                val dialog = Dialog(this@MainActivity)

                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                dialog.setCancelable(true)

                dialog.setContentView(R.layout.dialogue_box)
                dialog.show()

                dialog.apply {
                    val btn_cancel = findViewById<Button>(R.id.btn_cancel)
                    val btn_okay = findViewById<Button>(R.id.btn_okay)
                    val radioLight = findViewById<RadioButton>(R.id.radioLight)
                    val radioDark = findViewById<RadioButton>(R.id.radioDark)
                    btn_okay.setOnClickListener{
                        /*AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)*/

                        if(radioDark.isChecked){
                            Toast.makeText(getApplicationContext(),"Dark Mode Selected",
                                Toast.LENGTH_SHORT).show()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        }
                        else if(radioLight.isChecked){
                            Toast.makeText(getApplicationContext(),"Light Mode Selected",
                                Toast.LENGTH_SHORT).show()
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                        }
                        dialog.dismiss()
                    }
                    btn_cancel.setOnClickListener{
                        dialog.dismiss()
                    }
                }


                /*val btn_cancel = findViewById<Button>(R.id.btn_cancel)
                val btn_okay = findViewById<Button>(R.id.btn_okay)

                val radioLight = findViewById<RadioButton>(R.id.radioLight)
                val radioDark = findViewById<RadioButton>(R.id.radioDark)

                btn_cancel.setOnClickListener{
                    dialog.dismiss()
                }
                btn_okay.setOnClickListener{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    dialog.dismiss()
                }*/


                /*isChecked = !item.isChecked()
                item.setChecked(isChecked)
                if(item.isChecked()){
                    Toast.makeText(getApplicationContext(),"Dark Mode Selected",
                    Toast.LENGTH_SHORT).show()
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
                else{
                    Toast.makeText(getApplicationContext(),"Dark Mode Deselected",
                    Toast.LENGTH_SHORT).show()
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }*/
                return true
            }
            R.id.about-> {
                val intent = Intent(this, About::class.java)
                startActivity(intent)
                Toast.makeText(getApplicationContext(),"Info",
                Toast.LENGTH_SHORT).show();
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayShowTitleEnabled(false)


        val display = findViewById<TextView>(R.id.input)
        display.showSoftInputOnFocus = false

        display.setOnClickListener {
            if(getString(R.string.display).equals(display.getText().toString())){
                display.setText("")
            }
        }
        /**/

    }


    private fun updatetext(strToAdd: String) {

        val display = findViewById<TextView>(R.id.input) as EditText

        var oldStr = display.getText().toString()
        var cursorPos = display.selectionStart
        var leftStr = oldStr.substring(0, cursorPos)
        var rightStr = oldStr.substring(cursorPos)
        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd)
            display.setSelection(cursorPos + 1)

        }
        else{
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr))
            display.setSelection(cursorPos + 1)

        }

    }

    public fun AC(view: View) {
        val display = findViewById<TextView>(R.id.input) as EditText
        display.setText("")

    }
    public fun OpenBracket(view: View) {
        updatetext(strToAdd = "(")

    }
    public fun CloseBracket(view: View) {
        updatetext(strToAdd = ")")

    }
    public fun Multiply(view: View) {
        updatetext(strToAdd = "×")

    }
    public fun seven(view: View) {
        updatetext(strToAdd = "7")

    }
    public fun eight(view: View) {
        updatetext(strToAdd = "8")

    }
    public fun nine(view: View) {
        updatetext(strToAdd = "9")

    }
    public fun Divide(view: View) {
        updatetext(strToAdd = "÷")

    }
    public fun four(view: View) {
        updatetext(strToAdd = "4")

    }
    public fun five(view: View) {
        updatetext(strToAdd = "5")

    }
    public fun six(view: View) {
        updatetext(strToAdd = "6")

    }
    public fun Plus(view: View) {
        updatetext(strToAdd = "+")

    }
    public fun one(view: View) {
        updatetext(strToAdd = "1")

    }
    public fun two(view: View) {
        updatetext(strToAdd = "2")

    }
    public fun three(view: View) {
        updatetext(strToAdd = "3")

    }
    public fun Minus(view: View) {
        updatetext(strToAdd = "-")

    }
    public fun zero(view: View) {
        updatetext(strToAdd = "0")

    }
    public fun Dot(view: View) {
        updatetext(strToAdd = ".")

    }
    public fun up(view: View) {
        updatetext(strToAdd = "^")

    }
    public fun factorial(view: View) {
        updatetext(strToAdd = "!")

    }
    public fun pi(view: View) {
        updatetext(strToAdd = "π")

    }
    public fun root(view: View) {
        updatetext(strToAdd = "√")

    }
    public fun percentage(view: View) {
        updatetext(strToAdd = "%")

    }
    public fun DEL(view: View) {
        val display = findViewById<TextView>(R.id.input) as EditText
        var cursorPos = display.getSelectionStart()
        var textLen = display.getText().length

        if (cursorPos != 0 && textLen != 0){
            var selection = SpannableStringBuilder(display.getText())
            SpannableStringBuilder(selection )
            selection.replace(cursorPos - 1, cursorPos, "")
            display.setText(selection)
            display.setSelection(cursorPos - 1)
        }

    }
    public fun Equal(view: View) {
        val display = findViewById<TextView>(R.id.input) as EditText
        var userExp = display.getText().toString()
        userExp = userExp.replace("÷", "/")
        userExp = userExp.replace("×", "*")

        var exp = Expression(userExp)

        var result = (exp.calculate().toString())
        display.setText(result)

        display.setSelection(result.length)

    }

}







