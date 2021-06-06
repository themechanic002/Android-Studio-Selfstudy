package com.example.myrecyclerview

import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val celebList = ArrayList<Celeb>()
        celebList.add(Celeb("BTS", "하이브", 7))
        celebList.add(Celeb("BLACKPINK", "YG", 4))
        celebList.add(Celeb("TWICE", "JYP", 9))
        celebList.add(Celeb("브레이브걸스", "브레이브엔터", 4))
        celebList.add(Celeb("김다미", "앤드마크", 1))
        celebList.add(Celeb("이승기", "후크엔터", 1))
        celebList.add(Celeb("버즈", "인넥스트트렌드", 5))
        celebList.add(Celeb("아스트로", "판타지오", 6))

        val inflater = LayoutInflater.from(this@MainActivity)
        val adapter = RecyclerViewAdapter(celebList, inflater)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this@MainActivity)
        recycler_view.addItemDecoration(DividerItemDecoration(recycler_view.context, RecyclerView.VERTICAL))
    }
}

class Celeb(var name: String, var enter: String, var num: Int){}

class RecyclerViewAdapter(
    val list: ArrayList<Celeb>,
    val inflater: LayoutInflater
): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val h_name: TextView
        val h_enter: TextView
        val h_num: TextView
        init{
            h_name = view.findViewById(R.id.celeb_name)
            h_enter = view.findViewById(R.id.celeb_enter)
            h_num = view.findViewById(R.id.celeb_num)

            view.setOnClickListener {
                val position = adapterPosition
                Toast.makeText(view.context, list.get(position).name, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.celeb_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.h_name.setText(list.get(position).name)
        holder.h_enter.setText(list.get(position).enter)
        holder.h_num.setText(""+list.get(position).num+"명")
    }

    override fun getItemCount(): Int {
        return list.size
    }
}