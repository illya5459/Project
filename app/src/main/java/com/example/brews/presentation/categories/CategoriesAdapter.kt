package com.example.brews.presentation.categories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.brews.R
import com.example.brews.data.model.categories.Categories

class CategoriesAdapter(
    private val categories: Categories,
    private val navController: NavController
) : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryTextView: TextView = itemView.findViewById(R.id.categoryTextView)
        val categoryLayout: LinearLayout = itemView.findViewById(R.id.categoryLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cocktail = categories.drinks?.get(position)
        holder.categoryTextView.text = cocktail?.strCategory

        holder.categoryLayout.setOnClickListener {
            navController.navigate(CategoriesFragmentDirections.actionCategoriesFragmentToByCategoryFragment(cocktail?.strCategory!!))
        }
    }

    override fun getItemCount(): Int {
        return categories.drinks?.size ?: 0
    }

}