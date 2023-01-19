package com.geektechkb.android7.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.geektechkb.android7.R
import com.geektechkb.android7.TextRepository
import com.geektechkb.android7.`interface`.OnItemTextListener
import com.geektechkb.android7.adapter.TextAdapter
import com.geektechkb.android7.data.TextModel
import com.geektechkb.android7.databinding.FragmentFirstBinding


class FirstFragment : Fragment(), OnItemTextListener{

    private var binding: FragmentFirstBinding? = null
    private val textList = ArrayList<TextModel>()
    private val adapter = TextAdapter(textList, this,)
    private var repo = TextRepository()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        getData()
    }

    private fun initialize() {
        binding?.recycler?.layoutManager = LinearLayoutManager(
            context, RecyclerView.VERTICAL, false
        )
        textList.addAll(repo.getListOfText())
        binding?.recycler?.adapter = adapter

    }

    private fun getData() {
        val bundle = arguments
        if (arguments != null) {
            val text = bundle?.getString("cat2")
            textList.add(TextModel(text.toString()))
        }
    }

    override fun onClick(model: TextModel) {
        val bundle = Bundle()
        bundle.putString("cat", model.text)
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, SecondFragment::class.java, bundle)
            .addToBackStack("FirstFragment")
            .commit()
    }

    override fun onLongClick(model: TextModel) {
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}