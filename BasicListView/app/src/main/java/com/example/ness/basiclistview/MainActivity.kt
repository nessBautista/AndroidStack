package com.example.ness.basiclistview

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_listview)
        val redColor = Color.parseColor("#FF0000")
        //listView.setBackgroundColor(redColor)

        listView.adapter =  ListAdapter(this)
    }

    private  class ListAdapter(context: Context): BaseAdapter(){

        private val mContext:Context
        private val names = arrayListOf<String> (
            "person 1", "person 2","person 3","person 4","person 5"
            )
        init {
            mContext = context
        }
        override fun getCount(): Int {
            return names.size
        }
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }
        override fun getItem(position: Int): Any {
            return "test string"
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            //val textView = TextView(mContext)
            //textView.text = "Here is the row for the list view"
            //return textView

            //Inflater
            var layoutInflater = LayoutInflater.from(mContext)
            val cell= layoutInflater.inflate(R.layout.row, parent, false)

            val txtPosition = cell.findViewById<TextView>(R.id.position_textview)
            txtPosition .text = "Row Number: $position"

            val personName = cell.findViewById<TextView>(R.id.name_textview)
            personName.text = names.get(position)

            return cell
        }
    }
}
