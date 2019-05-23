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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.projectcarl.portfolio.data.ProjectPart
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_main_display.*
import kotlinx.android.synthetic.main.fragment_main_display.view.*
import kotlinx.android.synthetic.main.fragment_tubeddit.*
import kotlinx.android.synthetic.main.list_item_project.*


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        project_rv.layoutManager = LinearLayoutManager(context)
        project_rv.setAdapter(RecyclerViewAdapter())
    }

    override fun onResume() {
        super.onResume()
        Log.d("onResume", "TubedditFragment")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //val window = activity!!.window
            //window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            //window.setStatusBarColor(Color.BLUE)
        }
        /*
        val color = ColorDrawable(ContextCompat.getColor(context as Context, R.color.Tubeddit_Blue))
        (activity as AppCompatActivity).supportActionBar!!.setBackgroundDrawable(color)
        (activity as AppCompatActivity).supportActionBar!!.setTitle("Tubeddit")
        */
    }

    inner class RecyclerViewAdapter() : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
        var mData: ArrayList<ProjectPart> = ArrayList();

        init {
            var ProjectPart1 = ProjectPart( 0, "Index Zero", R.drawable.test_gif)
            var ProjectPart2 = ProjectPart(1,"Index One", R.drawable.test_gif)
            var ProjectPart3 = ProjectPart(2,"Index Three", R.drawable.test_gif)

            mData.add(ProjectPart1)
            mData.add(ProjectPart2)
            mData.add(ProjectPart3)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val vh: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_project, parent, false)
            return RecyclerViewAdapter().ViewHolder(vh)
        }

        override fun getItemCount(): Int {
            return mData.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bindItems(mData.get(position))
            //project_part_description_tv.setText(mData.get(position).mDescription)
            //project_part_image_iv.setImageResource(mData.get(position).mGifDrawable)
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {
            override val containerView: View?
                get() = itemView

            fun bindItems(item: ProjectPart) {
                project_part_description_tv.setText(item.mDescription)
                Glide.with(this@TubedditFragment).asGif().load(R.drawable.test_gif).into(project_part_image_iv)
            }

        }
    }
}
