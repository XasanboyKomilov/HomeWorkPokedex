package com.example.pokedex

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pokedex.databinding.ItemPokemonBinding

class PokemonAdapter(val list: ArrayList<PokemonModel>, val listener: ItemListener) :
    RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class PokemonViewHolder(val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: PokemonModel) {
            binding.pokemonName.text = model.name
            binding.pokemonNumber.text = model.number
            itemView.setOnClickListener {
                listener.itemclick(model)
            }

            when (model.name) {
                pikachu -> {
                    val color = itemView.context.getColor(R.color.pikachu_clr)
                    updateColor(color)
                    binding.pokemonImg.load(R.drawable.pikachu)
                }
                charmander -> {
                    val color = itemView.context.getColor(R.color.charmander)
                    updateColor(color)
                    binding.pokemonImg.load(R.drawable.charmander)
                }
                mew -> {
                    val color = itemView.context.getColor(R.color.mew)
                    updateColor(color)
                    binding.pokemonImg.load(R.drawable.mew)
                }
                squirtle -> {
                    val color = itemView.context.getColor(R.color.squirtle)
                    updateColor(color)
                    binding.pokemonImg.load(R.drawable.squirtle)
                }
                bulbasaur -> {
                    val color = itemView.context.getColor(R.color.bulbasaur)
                    updateColor(color)
                    binding.pokemonImg.load(R.drawable.bulbasaur)
                }
                aron -> {
                    val color = itemView.context.getColor(R.color.aron)
                    updateColor(color)
                    binding.pokemonImg.load(R.drawable.aron)
                }
                ditto -> {
                    val color = itemView.context.getColor(R.color.ditto)
                    updateColor(color)
                    binding.pokemonImg.load(R.drawable.ditto)
                }
                butterfree -> {
                    val color = itemView.context.getColor(R.color.butterfree)
                    updateColor(color)
                    binding.pokemonImg.load(R.drawable.butterfree)
                }
                gastly -> {
                    val color = itemView.context.getColor(R.color.gastly)
                    updateColor(color)
                    binding.pokemonImg.load(R.drawable.gastly)
                }
            }
        }

        private fun updateColor(@ColorInt color: Int) {
            val drawable = itemView.background as GradientDrawable
            drawable.mutate()
            drawable.setStroke(2, color)

            val textDrawable = binding.pokemonName.background as GradientDrawable
            textDrawable.mutate()
            textDrawable.setTint(color)

            val textNumber = binding.pokemonNumber
            textNumber.setTextColor(color)
        }
    }
}


