package com.example.calculator_updated

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar

class About : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.item_from_menu_about, menu)
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val toolbar = findViewById<Toolbar>(R.id.toolbar_about)
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayShowTitleEnabled(false)

        val appName = findViewById<TextView>(R.id.appName)
        val verName = findViewById<TextView>(R.id.versionName)
        //val verCode = findViewById<TextView>(R.id.versionCode)

        appName.setText(resources.getString(R.string.app_name))
        appName.setText("Calculator")

        verName.setText(BuildConfig.VERSION_NAME)
        //verCode.setText(BuildConfig.VERSION_CODE.toString())

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        when (item.itemId) {
            R.id.back-> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(getApplicationContext(),"Calculator",
                    Toast.LENGTH_SHORT).show();
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}