package com.liorapp.wardrobe


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.liorapp.wardrobe.models.Shirt
import com.liorapp.wardrobe.recyclerAdapter.ShirtListAdapter
import kotlinx.android.synthetic.main.fragment_shirt_list.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FragmentShirtList : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shirt_list, container, false)
    }

    @SuppressLint("WrongConstant")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = arrayListOf<Shirt>()
        for (i in 0 until 10)
            list.add(Shirt("", i.toDouble(), "blue", ""))

        with(shirtList_recycler){
            adapter = ShirtListAdapter(activity!!, list)
            layoutManager = LinearLayoutManager(activity!!, LinearLayout.VERTICAL, false)
        }
    }


    companion object{
//        @JvmStatic
        fun newInstance(): FragmentShirtList{
            val fragment = FragmentShirtList()
            return fragment
        }
    }


}
