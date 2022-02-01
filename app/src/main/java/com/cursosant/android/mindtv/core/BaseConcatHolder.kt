package com.cursosant.android.mindtv.core

import android.view.View
import androidx.recyclerview.widget.RecyclerView
//Mismo codigo que BaseViewHolder pero con adapter
abstract class BaseConcatHolder<T>(itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun bind(adapter: T)
}