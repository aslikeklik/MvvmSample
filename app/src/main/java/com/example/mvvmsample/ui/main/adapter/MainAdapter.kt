package com.example.mvvmsample.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmsample.R
import com.example.mvvmsample.data.model.BookModel
import kotlinx.android.synthetic.main.book_item.view.*

class MainAdapter(
    private val books: ArrayList<BookModel>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(book: BookModel) {
            itemView.textViewBookName.text = book.title

            if (!book.completed){
                itemView.completedIcon.setImageResource(R.drawable.ic_baseline_wrong_24)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.book_item, parent,
                false
            )
        )

    override fun getItemCount(): Int = books.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(books[position])

    fun addData(list: List<BookModel>) {
        books.addAll(list)
    }

}