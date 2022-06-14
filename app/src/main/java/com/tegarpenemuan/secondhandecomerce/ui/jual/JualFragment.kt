package com.tegarpenemuan.secondhandecomerce.ui.jual

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tegarpenemuan.secondhandecomerce.databinding.FragmentJualBinding

class JualFragment : Fragment() {

    private var _binding: FragmentJualBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(JualViewModel::class.java)

        _binding = FragmentJualBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textJual
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}