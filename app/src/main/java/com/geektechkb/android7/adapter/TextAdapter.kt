package com.geektechkb.android7.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.geektechkb.android7.R
import com.geektechkb.android7.`interface`.OnItemTextListener
import com.geektechkb.android7.data.TextModel
import com.geektechkb.android7.databinding.ItemTextBinding

class TextAdapter (
    private val listText: MutableList<TextModel>,
    private val onItemTextListener: OnItemTextListener
) :
    RecyclerView.Adapter<TextAdapter.TextViewHolder>(), OnLongClickListener {

    inner class TextViewHolder(private val binding: ItemTextBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(textModel: TextModel) {
            binding.textMein.setOnLongClickListener(View.OnLongClickListener {
                listText.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
                true
            })
            binding.textMein.text = textModel.text
            itemView.setOnClickListener {
                onItemTextListener.onClick(textModel)
                binding.textMein.text = textModel.text
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        return TextViewHolder(
            ItemTextBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.itemView.setOnLongClickListener(this)
        holder.onBind(listText[position])
        holder.itemView.setOnLongClickListener{
            listText.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
            true
        }
    }

    override fun getItemCount(): Int = listText.size

    override fun onLongClick(v: View?): Boolean {
        onItemTextListener.onLongClick(v?.tag as TextModel)
        return true
    }
}