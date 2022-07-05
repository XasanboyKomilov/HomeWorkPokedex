package com.example.pokedex

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Interpolator
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.pokedex.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        initiClicker()
    }

    private fun initiClicker() {
        with(binding) {
            pokemonBigImg.setOnClickListener {
                InfoFragment().show(requireActivity().supportFragmentManager, "hello")
                doBounceAnimation(it)
            }
        }
    }

    private fun doBounceAnimation(targetView: View) {
        val interpolator =
            Interpolator { v ->
                getPowOut(v, 2.0) //Add getPowOut(v,3); for more up animation
            }
        val animator = ObjectAnimator.ofFloat(targetView, "translationY", 0f, 25f, 0f)
        animator.interpolator = interpolator
        animator.startDelay = 200
        animator.duration = 800
        animator.repeatCount = 5
        animator.start()
    }

    private fun getPowOut(elapsedTimeRate: Float, pow: Double): Float {
        return (1f - Math.pow((1 - elapsedTimeRate).toDouble(), pow)).toFloat()
    }

    @SuppressLint("ResourceAsColor")
    private fun initUI() {
        val model: PokemonModel = arguments?.getSerializable("key") as PokemonModel
        with(binding) {
            nameTv.text = model.name
            numberTv.text = model.number
            hpTv.text = model.hp.toString()
            progressHp.progress = model.hp
            when (model.name) {
                com.example.pokedex.pikachu -> {
                    pokemonBigImg.load(com.example.pokedex.R.drawable.pikachu_big)
                    root.setBackgroundColor(getResources().getColor(com.example.pokedex.R.color.pikachu_clr))
                    typeTv.text = "Electric"
                    typeTv.setBackgroundColor(getResources().getColor(R.color.pikachu_clr))
                    with(aboutTv) { setTextColor(R.color.pikachu_clr) }
                    weightTv.text = "6,0 kg"
                    heightTv.text = "0,4 m"
                    descriptionTv.text =
                        "Pikacu"
                    ability1.text = "Punch"
                    ability2.text = "Day"
                    atkTv.text = "55"
                    defTv.text = "40"
                    satkTv.text = "50"
                    sdefTv.text = "50"
                    spdTv.text = "90"
                    progressAtk.progress = 55
                    progressDef.progress = 40
                    progressSatk.progress = 50
                    progressSdef.progress = 50
                    progressSpd.progress = 90
                }
                com.example.pokedex.charmander -> {
                    pokemonBigImg.load(com.example.pokedex.R.drawable.charmander_big)
                    weightTv.text = "8,6 kg"
                    heightTv.text = "0,6 m"
                    descriptionTv.text =
                        "Pikscu"
                    ability1.text = "Mega-Punch"
                    ability2.text = "Fire-Punch"
                    atkTv.text = "52"
                    defTv.text = "43"
                    satkTv.text = "60"
                    sdefTv.text = "50"
                    spdTv.text = "65"
                    progressAtk.progress = 52
                    progressDef.progress = 43
                    progressSatk.progress = 60
                    progressSdef.progress = 50
                    progressSpd.progress = 65
                }
                com.example.pokedex.mew -> {
                    pokemonBigImg.load(com.example.pokedex.R.drawable.mew_big)
                    root.setBackgroundColor(getResources().getColor(com.example.pokedex.R.color.mew))
                    weightTv.text = "4 kg"
                    heightTv.text = "0,4 m"
                    typeTv.text = "Electric"
                    typeTv.setBackgroundColor(getResources().getColor(R.color.mew))
                    with(aboutTv) { setTextColor(R.color.mew) }
                    descriptionTv.text =
                        "Pikscu"
                    ability1.text = "Synchronize"
                    atkTv.text = "100"
                    defTv.text = "100"
                    satkTv.text = "100"
                    sdefTv.text = "100"
                    spdTv.text = "100"
                    progressAtk.progress = 100
                    progressDef.progress = 100
                    progressSatk.progress = 100
                    progressSdef.progress = 100
                    progressSpd.progress = 100
                }
                else -> {
                    nameTv.text = "Empty"
                }
            }
        }
        when (model.name) {
            pikachu -> {
                activity?.let {
                    activity?.window?.setStatusBarColor(it.getColor(R.color.pikachu_clr))
                }
            }
            charmander -> {
                activity?.let {
                    activity?.window?.setStatusBarColor(it.getColor(R.color.charmander))
                }
            }
            mew -> {
                activity?.let {
                    activity?.window
                        ?.setStatusBarColor(it.getColor(R.color.mew))
                }
            }
        }
        binding.backBtn.setOnClickListener {
            requireContext().showToast("Back")
            findNavController().popBackStack()
        }
    }
}



