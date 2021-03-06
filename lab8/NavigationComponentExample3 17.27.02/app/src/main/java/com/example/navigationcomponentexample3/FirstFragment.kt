package com.example.navigationcomponentexample3

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first.view.*
import timber.log.Timber
import kotlinx.android.synthetic.main.fragment_first.view.toggleButton as toggleButton1


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        Timber.i("onCreate Called")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        view.fragmentFirstButton.setOnClickListener {
            if (view.toggleButton1.isChecked() == true) {
                navigateByDirection(view)
            } else if (view.toggleButton1.isChecked() == false) {
                navigateByActionId2(view)
            }
        }

        setHasOptionsMenu(true)
        Timber.i("onCreateView Called")
        return view
    }

    override fun onStart() {
        super.onStart()
        Timber.i("onStart Called")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.i("onAttach Called")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.i("onViewCreated Called")

    }
    override fun onResume() {
        super.onResume()
        Timber.i("onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop Called")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.i("onDestroyView Called")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.i("onRestart Called")
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater.inflate(R.menu.options_menu, menu)
//    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun navigateByActionId(view: View) {
        view.findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
    }
    private fun navigateByActionId2(view: View) {
        view.findNavController().navigate(R.id.action_firstFragment_to_thirdFragment)
    }

    private fun navigateByDirection(view: View) {
        val direction = FirstFragmentDirections.actionFirstFragmentToSecondFragment(
            message = "Kapow moo sub",
            number = 45
        )
        view.findNavController().navigate(direction)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

