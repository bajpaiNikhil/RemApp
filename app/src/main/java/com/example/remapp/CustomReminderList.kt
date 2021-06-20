package com.example.remapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


val  eventList = mutableListOf<Events>()

class CustomReminderList : AppCompatActivity() {

    lateinit var evtAdapter : EventAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        evtAdapter = EventAdapter(this,R.layout.custom_event_view, eventList)
        eventL.adapter = evtAdapter

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val item1 = menu?.add(0,1,0,"Add More")
        item1?.setIcon(R.drawable.ic_launcher_foreground)
        item1?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)

        return super.onCreateOptionsMenu(menu)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id  = item.itemId
        when(id){
            1 ->{
                val i = Intent(this,FormActivity::class.java)
                startActivity(i)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

data class Events(val evt : String , val date : String , val time : String)

class EventAdapter(context: Context, layoutId : Int, data : List<Events>):
    ArrayAdapter<Events>(context , layoutId, data){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = LayoutInflater.from(context).inflate(R.layout.custom_event_view , null)

        val evnt = getItem(position)

        val nameTextView = view.findViewById<TextView>(R.id.eventT)
        val dateTextview = view.findViewById<TextView>(R.id.dateT)
        val timeTextView = view.findViewById<TextView>(R.id.timeT)


        nameTextView.text = evnt?.evt
        dateTextview.text = "${evnt?.date}"
        timeTextView.text = "${evnt?.time}"

        return view

    }


}

