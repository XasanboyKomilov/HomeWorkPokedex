package com.example.pokedex

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pokedex.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), ItemListener {

    private lateinit var pokemonAdapter: PokemonAdapter
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        val list = arrayListOf<PokemonModel>()
        list.add(PokemonModel("#004", charmander, 39))
        list.add(PokemonModel("#025", pikachu, 35))
        list.add(PokemonModel("#152", mew, 100))
        list.add(PokemonModel("#001", bulbasaur, 45))
        list.add(PokemonModel("#012", butterfree, 60))
        list.add(PokemonModel("#007", squirtle, 44))
        list.add(PokemonModel("#304", aron, 50))
        list.add(PokemonModel("#132", ditto, 48))
        list.add(PokemonModel("#092", gastly, 30))

        pokemonAdapter = PokemonAdapter(list, this)
        binding.recyclerView.adapter = pokemonAdapter
    }

    override fun itemclick(model: PokemonModel) {
        val bundle = Bundle()
        bundle.putSerializable("key", model)
        requireContext().showToast("Details")
        findNavController().navigate(R.id.action_homeFragment_to_detailsFragment, bundle)
    }

}