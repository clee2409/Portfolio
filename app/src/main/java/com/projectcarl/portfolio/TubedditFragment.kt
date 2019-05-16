package com.projectcarl.portfolio


import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.fragment_main_display.*
import kotlinx.android.synthetic.main.fragment_main_display.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class TubedditFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tubeddit, container, false)
    }

    override fun onResume() {
        super.onResume()
        Log.d("onResume", "TubedditFragment")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //val window = activity!!.window
            //window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            //window.setStatusBarColor(Color.BLUE)
        }
        val color = ColorDrawable(ContextCompat.getColor(context as Context, R.color.Tubeddit_Blue))
        (activity as AppCompatActivity).supportActionBar!!.setBackgroundDrawable(color)
        (activity as AppCompatActivity).supportActionBar!!.setTitle("Tubeddit")
    }
}
