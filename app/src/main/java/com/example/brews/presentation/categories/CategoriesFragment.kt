package com.example.brews.presentation.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.brews.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment() {

    private var _binding: FragmentCategoriesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CategoriesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(requireContext())
        binding.categoriesRecyclerView.layoutManager = layoutManager
        val dividerItemDecoration = DividerItemDecoration(requireContext(), layoutManager.orientation)
        binding.categoriesRecyclerView.addItemDecoration(dividerItemDecoration)

        viewModel.categoriesLiveData.observe(viewLifecycleOwner) {
            if (it == null) {
                binding.errorTextView.visibility = View.VISIBLE
            } else {
                binding.errorTextView.visibility = View.GONE
                binding.categoriesRecyclerView.adapter = CategoriesAdapter(it, findNavController())
            }
        }

    }
}