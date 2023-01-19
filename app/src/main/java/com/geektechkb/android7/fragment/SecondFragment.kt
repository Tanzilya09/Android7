package com.geektechkb.android7.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.geektechkb.android7.R
import com.geektechkb.android7.data.TextModel
import com.geektechkb.android7.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private var binding: FragmentSecondBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickListener()
        getData()
    }

    @SuppressLint("SuspiciousIndentation")
    private fun getData() {
        val bundle = arguments
        if (arguments != null) {
            val text = bundle?.getString("cat")
            binding?.etText?.setText(text)
        }
    }

    private fun onClickListener() {
        binding?.btn?.setOnClickListener(View.OnClickListener {
            val bundle2 = Bundle()
            bundle2.putString("cat2", binding?.etText?.text.toString())
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, FirstFragment::class.java, bundle2)
                .addToBackStack("SecondFragment")
                .commit()
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}