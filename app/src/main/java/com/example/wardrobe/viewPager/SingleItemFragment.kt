package com.example.wardrobe.viewPager


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.wardrobe.GlideApp
import com.example.wardrobe.R
import com.example.wardrobe.models.Cloth
import com.example.wardrobe.models.Shirt

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SingleItemFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.single_item_layout, container, false)
        val imageShirt = view.findViewById<ImageView>(R.id.picItem)

        val args = arguments
        GlideApp.with(imageShirt.context).load(R.mipmap.ic_launcher_image).into(imageShirt)






        return view

        }


    companion object{
        fun newInstance (item: Cloth): SingleItemFragment{
            val args = Bundle()
            args.putString("itemImagePath", item.imagePath)

            val fragment = SingleItemFragment()
            fragment.arguments = args
            return fragment



        }



    }
    }



