package com.example.mytodolist

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var todoEditText: EditText
    private lateinit var addButton: Button
    private lateinit var todoSpinner: Spinner
    private lateinit var todoListView: ListView
    private val tasks = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoEditText = findViewById(R.id.todoEditText)
        addButton = findViewById(R.id.addButton)
        todoSpinner = findViewById(R.id.todoSpinner)
        todoListView = findViewById(R.id.todoListView)

        // Set up spinner
        val categories = arrayOf("Work", "Personal", "Shopping", "Others")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        todoSpinner.adapter = spinnerAdapter

        // Set up ListView
        val listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tasks)
        todoListView.adapter = listAdapter

        // Set listeners
        addButton.setOnClickListener {
            val task = todoEditText.text.toString()
            if (task.isNotEmpty()) {
                tasks.add(task)
                listAdapter.notifyDataSetChanged()
                todoEditText.text.clear()
            }
        }

        todoSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Handle spinner item selection
                val selectedCategory = categories[position]
                // You can filter tasks based on the selected category here
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Handle case when nothing is selected
            }
        }
    }
}
