package com.bounce.snapstore.presentation.ui.failure

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bounce.snapstore.R
import com.bounce.snapstore.databinding.FragmentFailureBinding
import com.bounce.snapstore.domain.NetworkHelper
import com.google.android.material.snackbar.Snackbar

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FailureFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private var binding: FragmentFailureBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFailureBinding.inflate(inflater, container, false)

        binding?.buttonTryAgain?.setOnClickListener {
            if (NetworkHelper.isConnected(requireContext())) {
                findNavController().popBackStack()
            } else {
                Snackbar.make(binding!!.root, "No Internet Connection", Snackbar.LENGTH_SHORT)
                    .show()
            }
        }

        return binding!!.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }


}