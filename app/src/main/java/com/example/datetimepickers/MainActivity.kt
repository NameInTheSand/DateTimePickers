package com.example.datetimepickers

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.datetimepickers.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }

    private fun initListeners() {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, 1988)
        binding.apply {
            btnSelectDay.setOnClickListener {
                DatePickerDialog(
                    this@MainActivity,
                    { _, year, month, dayOfMonth ->
                        tvDate.text = getString(
                            R.string.lbl_selected_day, year, month + 1, dayOfMonth
                        )
                    },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            }
            btnSelectTime.setOnClickListener {
                TimePickerDialog(
                    this@MainActivity, { _, hourOfDay, minute ->
                        tvTime.text = getString(R.string.lbl_selected_time, hourOfDay, minute)
                    },
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    true
                ).show()
            }
        }
    }

}