package com.example.brews.presentation.by_category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.brews.R
import com.example.brews.data.model.cocktail.by_category.CocktailsByCategory
import com.example.brews.presentation.categories.CategoriesFragmentDirections

class CocktailAdapter(
    private val cocktailsByCategory: CocktailsByCategory,
    private val navController: NavController
) : RecyclerView.Adapter<CocktailAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cocktailImageView: ImageView = itemView.findViewById(R.id.cocktailImageView)
        val cocktailNameTextView: TextView = itemView.findViewById(R.id.cocktailNameTextView)
        val cocktailLayout: LinearLayout = itemView.findViewById(R.id.cocktailLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.cocktail_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cocktail = cocktailsByCategory.drinks?.get(position)
        holder.cocktailNameTextView.text = cocktail?.strDrink
        Glide.with(holder.cocktailImageView).load(cocktail?.strDrinkThumb)
            .into(holder.cocktailImageView)

        holder.cocktailLayout.setOnClickListener {
            navController.navigate(ByCategoryFragmentDirections.actionByCategoryFragmentToCocktailFragment(cocktail?.idDrink!!.toInt()))
        }
    }

    override fun getItemCount(): Int {
        return cocktailsByCategory.drinks?.size ?: 0
    }

}