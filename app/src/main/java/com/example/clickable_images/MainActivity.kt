package com.example.clickable_images

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var donutImage: ImageView
    lateinit var iceCreamImage: ImageView
    lateinit var froyoImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val mOrderMessage: String = getString(R.string.donut_order_message)
        fab.setOnClickListener {
            val intent: Intent = Intent(this, OrderActivity::class.java)
            intent.putExtra("ORDER", mOrderMessage)
            startActivity(intent)
        }

        donutImage = findViewById(R.id.donut)

        iceCreamImage = findViewById(R.id.icecream)

        froyoImage = findViewById(R.id.froyo)

        donutImage.setOnClickListener {
            showDonutOrder()
        }

        iceCreamImage.setOnClickListener {
            showIceCreamOrder()
        }

        froyoImage.setOnClickListener {
            showFroyoOrder()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun displayToast(message: String){
        Toast.makeText(applicationContext,message,Toast.LENGTH_SHORT).show()
    }

    fun showDonutOrder(){
        displayToast(getString(R.string.donut_order_message))
    }

    fun showIceCreamOrder(){
        displayToast(getString(R.string.ice_cream_order_message))
    }

    fun showFroyoOrder(){
        displayToast(getString(R.string.froyo_order_message))
    }
}
