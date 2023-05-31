package com.example.brews.presentation.by_category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.brews.databinding.FragmentByCategoryBinding

class ByCategoryFragment : Fragment() {
    private var _binding: FragmentByCategoryBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ByCategoryViewModel by viewModels()
    private val args: ByCategoryFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentByCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            viewModel.getCocktailsByCategory(args.categoryName)
        }

        val layoutManager = LinearLayoutManager(requireContext())
        binding.cocktailsRecyclerView.layoutManager = layoutManager
        val dividerItemDecoration = DividerItemDecoration(requireContext(), layoutManager.orientation)
        binding.cocktailsRecyclerView.addItemDecoration(dividerItemDecoration)

        viewModel.cocktailsByCategoryLiveData.observe(viewLifecycleOwner) {
            if (it == null) {
                binding.errorTextView.visibility = View.VISIBLE
            } else {
                binding.errorTextView.visibility = View.GONE
                binding.cocktailsRecyclerView.adapter = CocktailAdapter(it, findNavController())
            }
        }

    }
}