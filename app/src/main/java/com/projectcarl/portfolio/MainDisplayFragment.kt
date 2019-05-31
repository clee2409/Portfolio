package com.projectcarl.portfolio


import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main_display.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MainDisplayFragment : Fragment() {

    internal lateinit var mViewPager: ViewPager;
    internal lateinit var mAdapter: ViewPagerAdapter;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_display, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar!!.setTitle(getString(R.string.portfolio))
        activity!!.findViewById<Toolbar>(R.id.main_activity_toolbar).visibility = View.GONE
        //activity!!.findViewById<Toolbar>(R.id.main_activity_toolbar).setOnClickListener()
        (activity as AppCompatActivity).setSupportActionBar(custom_toolbar)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_action_hamburger_menu)

        mViewPager = reddit_search_pager
        mAdapter = ViewPagerAdapter(childFragmentManager)
        mViewPager.setAdapter(mAdapter)
        val tabLayout = tabs_layout
        tabLayout.setupWithViewPager(mViewPager)
        mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }
            override fun onPageSelected(position: Int) {
            when (position) {
                0 -> {
                    //val color = ColorDrawable(ContextCompat.getColor(context as Context, R.color.Tubeddit_Blue))
                    //(activity as AppCompatActivity).supportActionBar!!.setBackgroundDrawable(color)
                    //(activity as AppCompatActivity).supportActionBar!!.setTitle("Tubeddit")
                }
                1 -> {
                    //val color = ColorDrawable(ContextCompat.getColor(context as Context, R.color.Iguana_Green))
                    //(activity as AppCompatActivity).supportActionBar!!.setBackgroundDrawable(color)
                    //(activity as AppCompatActivity).supportActionBar!!.setTitle("In Progress")
                }
            }
            }
        })
    }

    inner class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getCount(): Int {
            return 2
        }

        override fun getItem(position: Int): Fragment {
            when (position) {
                0 -> return TubedditFragment()
                1 -> return InProgressFragment()
                else -> {
                    throw NullPointerException("Fragment is null")
                }
            }
        }

        override fun getPageTitle(position: Int): CharSequence? {
            when (position) {
                0 -> return "Tubeddit"
                1 -> return "In Progress"
            }
            return super.getPageTitle(position)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        val mainActivityToolbar: Toolbar = activity!!.findViewById(R.id.main_activity_toolbar)
        mainActivityToolbar.visibility = View.VISIBLE
        (activity as AppCompatActivity).setSupportActionBar(mainActivityToolbar)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_action_hamburger_menu)
    }
}
