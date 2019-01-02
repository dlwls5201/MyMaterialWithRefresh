package com.tistory.black_jin0427.mystickypullrefreshlist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.tistory.black_jin0427.mystickypullrefreshlist.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MaterialAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieHolder(parent)

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val item = items[position]

        with(holder.itemView) {

            Glide.with(context)
                    .load(item.url)
                    .into(ivItemMovie)

            tvItemMovieGenre.text = item.genre
            tvItemMovieTitle.text = item.title
            tvItemMovieContent.text = item.content

        }

    }

    // 아이템 설정
    fun setItems(items: MutableList<Movie>) {
        this.items = items
    }

    class MovieHolder(parent: ViewGroup): RecyclerView.ViewHolder( LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false))
}