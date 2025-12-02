package com.example.nexosmobile.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.example.nexosmobile.ui.auth.EsqueciSenhaActivity
import com.example.nexosmobile.HomeActivity
import com.example.nexosmobile.R
import com.example.nexosmobile.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val slideUpAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.move_upp)

        binding.linearLayout2.startAnimation(slideUpAnimation)

        binding.btnEntrar.setOnClickListener {
            Intent(requireContext(), HomeActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.tvEsqueceuSenha.setOnClickListener {
            Intent(requireContext(), EsqueciSenhaActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}