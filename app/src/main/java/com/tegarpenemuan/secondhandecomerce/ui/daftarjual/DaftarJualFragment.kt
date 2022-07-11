package com.tegarpenemuan.secondhandecomerce.ui.daftarjual

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.tegarpenemuan.secondhandecomerce.data.api.getNotification.GetNotifResponseItem
import com.tegarpenemuan.secondhandecomerce.data.api.getProduct.GetProductResponse
import com.tegarpenemuan.secondhandecomerce.databinding.FragmentDaftarJualBinding
import com.tegarpenemuan.secondhandecomerce.databinding.FragmentHomeBinding
import com.tegarpenemuan.secondhandecomerce.databinding.FragmentNotificationsBinding
import com.tegarpenemuan.secondhandecomerce.ui.daftarjual.adapter.DaftarJualAdapter
import com.tegarpenemuan.secondhandecomerce.ui.home.adapter.CategoryAdapter
import com.tegarpenemuan.secondhandecomerce.ui.notifications.NotificationsViewModel
import com.tegarpenemuan.secondhandecomerce.ui.notifications.adapter.NotificationsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DaftarJualFragment : Fragment() {

    private var _binding: FragmentDaftarJualBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DaftarJualViewModel by viewModels()

    lateinit var productSellerAdapter: DaftarJualAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDaftarJualBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewModel.getProductSeller()

        bindview()
        bindviewModel()
        return root
    }

    private fun bindview() {
        productSellerAdapter =
            DaftarJualAdapter(listener = object : DaftarJualAdapter.EventListener {
                override fun onClick(item: GetProductResponse) {
                    Toast.makeText(requireContext(),item.image_name, Toast.LENGTH_SHORT).show()
                }

            }, emptyList())
        binding.rvProduct.adapter =  productSellerAdapter
    }

    private fun bindviewModel() {
        viewModel.shouldShowGetProductSeller.observe(viewLifecycleOwner){
            productSellerAdapter.updateList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}