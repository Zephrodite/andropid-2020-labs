package com.example.fragmenttutorial2


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment


public final class MainFragment :Fragment() {
    var curView:View? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        curView = inflater?.inflate(
                R.layout.main_fragment,
                container,false
        )
        val view:View? = curView
        val button:Button? = view?.findViewById<Button>(R.id.button)
        button?.setOnClickListener {
            val editText = view?.findViewById<EditText>(R.id.editText)
            val resultText = view?.findViewById<TextView>(R.id.textView)
            resultText.text = editText.text.toString()
            Toast.makeText(this.context, editText.text.toString(), Toast.LENGTH_LONG).show()
        }
        getValues()
        return curView
    }

    private fun getValues() {
        val key: String? = arguments?.getString("EXTRA_KEY")
        Toast.makeText(this.context, key,
                Toast.LENGTH_LONG).show()
        var resultText = curView?.findViewById<TextView>(R.id.textView)
        if (resultText != null) {
            resultText.text = key
        }
    }
}
//public final class MainFragment : Fragment() {
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        val view = inflater?.inflate(
//            R.layout.main_fragment,
//            container, false
//        )
//
//        fun Context.toast(message: CharSequence) =
//                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
//
//        val kkutxt: String = getString(R.string.kku_text)
//        val button = view.findViewById<Button>(R.id.button)
//        context?.toast(kkutxt)
//
//        button.setOnClickListener {
//            val editText = view.findViewById<EditText>(R.id.editText)
//            val resultText = view.findViewById<TextView>(R.id.textView)
//
//            val message = editText.text.toString()
//            resultText.text = message
//
//
//            if (message.trim().length==0) {
//                context?.toast(kkutxt)
//            } else {
//                context?.toast(message)
//            }
//
//
//        }
//
//        return view
//    }
//
//}