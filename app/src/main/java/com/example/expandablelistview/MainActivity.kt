package com.example.expandablelistview

import Adapter.ExpandableAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.BaseExpandableListAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var map: HashMap<String, List<String>>
    lateinit var titleList: ArrayList<String>
    lateinit var expandableAdapter: ExpandableAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        titleList = ArrayList()
        map = HashMap()

        titleList.add("Mobiles")
        titleList.add("Laptops")
        titleList.add("Computers Accessories")
        titleList.add("Home Entertainment")

        map[titleList[0]] = listOf("Mi", "Realme", "Samsung", "Infinix", "Oppo", "Apple", "Honor")
        map[titleList[1]] = listOf("DEL", "MAC", "HP", "ASUS")
        map[titleList[2]] = listOf("Pendrive", "Bag", "Mous", "Keyboard")
        map[titleList[3]] = listOf("Home Audio Speakers", "Home Theatres", "Bluetooth Speakers", "DTH Set Top Box")

        expandableAdapter = ExpandableAdapter(titleList, map)
        expanded_menu.setAdapter(expandableAdapter)

        expanded_menu.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            Toast.makeText(this, "${map[titleList[groupPosition]]?.get(childPosition)}", Toast.LENGTH_SHORT).show()
            true
        }
    }
}