package com.example.clickable_images

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*

class OrderActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var nameEditText: EditText
    lateinit var addressEditText: EditText
    lateinit var phoneEditText: EditText
    lateinit var noteEditText: EditText

    lateinit var sameDayRadioButton: RadioButton
    lateinit var nextDayRadioButton: RadioButton
    lateinit var pickupRadioButton: RadioButton

    lateinit var spinner: Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        var orderMessage: TextView = findViewById(R.id.orderDescTextView)
        orderMessage.text = intent.getStringExtra("ORDER")

        sameDayRadioButton = findViewById(R.id.same_day_rad)
        nextDayRadioButton = findViewById(R.id.next_day_rad)
        pickupRadioButton = findViewById(R.id.pick_up_rad)
        pickupRadioButton.isChecked = true

        spinner = findViewById(R.id.spinner)
        if (spinner != null){
            spinner.onItemSelectedListener = this
        }



        sameDayRadioButton.setOnClickListener {
            onRadioButtonClicked(sameDayRadioButton)
        }

        nextDayRadioButton.setOnClickListener {
            onRadioButtonClicked(nextDayRadioButton)
        }

        pickupRadioButton.setOnClickListener {
            onRadioButtonClicked(pickupRadioButton)
        }

        spinner.adapter = ArrayAdapter(
            this,
            R.layout.support_simple_spinner_dropdown_item,
            resources.getStringArray(R.array.labels_array)
        )
    }


    fun onRadioButtonClicked(view: View){
        var checked: Boolean = (view as RadioButton).isChecked
        when(view.id){
            R.id.same_day_rad -> displayToast(getString(R.string.same_day_messenger_service))
            R.id.next_day_rad -> displayToast(getString(R.string.next_day_ground_delivery))
            R.id.pick_up_rad -> displayToast(getString(R.string.pick_up))
        }
    }

    fun displayToast(message: String){
        Toast.makeText(applicationContext,message, Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        var spinnerLabel: String = parent!!.getItemAtPosition(0).toString()
        displayToast(spinnerLabel)
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var spinnerLabel: String = parent!!.getItemAtPosition(position).toString()
        displayToast(spinnerLabel)
    }

}
