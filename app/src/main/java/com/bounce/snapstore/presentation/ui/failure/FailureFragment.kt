package com.bounce.snapstore.presentation.ui.failure

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bounce.snapstore.databinding.FragmentFailureBinding
import com.bounce.snapstore.utils.NetworkHelper
import com.google.android.material.snackbar.Snackbar

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FailureFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentFailureBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFailureBinding.inflate(inflater, container, false)

        ViewCompat.setOnApplyWindowInsetsListener(binding.failureScreenMainLayout) { view, insets ->

            val systemBarInsets =
                insets.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout())

            view.setPadding(
                systemBarInsets.left,
                systemBarInsets.top,
                systemBarInsets.right,
                systemBarInsets.bottom,
            )
            insets
        }

        binding.buttonTryAgain.setOnClickListener {
            if (NetworkHelper.isNetworkConnected(requireContext())) {
                findNavController().popBackStack()
            } else {
                Snackbar.make(binding.root, "No Internet Connection", Snackbar.LENGTH_SHORT)
                    .show()
            }
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}