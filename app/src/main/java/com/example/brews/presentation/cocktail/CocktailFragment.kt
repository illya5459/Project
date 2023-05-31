package com.example.brews.presentation.cocktail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.brews.databinding.FragmentCocktailBinding

class CocktailFragment : Fragment() {

    private var _binding: FragmentCocktailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CocktailViewModel by viewModels()
    private val args: CocktailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCocktailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            viewModel.getFullCocktail(args.cocktailId)
        }

        viewModel.cocktailLiveData.observe(viewLifecycleOwner) {
            if (it == null) {
                binding.errorTextView.visibility = View.VISIBLE
            } else {
                binding.errorTextView.visibility = View.GONE
                binding.cocktailNameTextView.text = it.drinks?.first()?.strDrink
                binding.cocktailTagsTextView.text = (it.drinks?.first()?.strTags ?: it.drinks?.first()?.strIBA ?: it.drinks?.first()?.strCategory).toString()
                binding.instructionsTextView.text = it.drinks?.first()?.strInstructions

                Glide.with(requireContext()).load(it.drinks?.first()?.strDrinkThumb)
                    .into(binding.cocktailImageView)
            }
        }
    }

}