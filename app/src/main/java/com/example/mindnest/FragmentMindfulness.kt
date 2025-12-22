package com.example.mindnest.ui.mindfulness

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.mindnest.R
import com.example.mindnest.databinding.FragmentMindfulnessBinding

class FragmentMindfulness : Fragment(R.layout.fragment_mindfulness) {

    private var _binding: FragmentMindfulnessBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMindfulnessBinding.bind(view)

        val buttons = listOf(binding.btnMind5Min, binding.btnMind10Min, binding.btnMind15Min)

        val clickListener = View.OnClickListener { v ->
            val minutes = when (v.id) {
                R.id.btnMind5Min -> 5
                R.id.btnMind10Min -> 10
                R.id.btnMind15Min -> 15
                else -> 0
            }
            if (minutes > 0) openMindfulnessSession(minutes)
        }

        buttons.forEach { it.setOnClickListener(clickListener) }
    }

    private fun openMindfulnessSession(minutes: Int) {
        val sessionFragment = MindfulnessSessionFragment().apply {
            arguments = Bundle().apply { putInt("SESSION_MINUTES", minutes) }
        }

        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, sessionFragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
