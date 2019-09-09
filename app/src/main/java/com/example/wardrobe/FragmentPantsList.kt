package com.example.wardrobe


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wardrobe.models.Pants
import com.example.wardrobe.recyclerAdapter.PantsListAdapter
import kotlinx.android.synthetic.main.fragment_pants_list.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FragmentPantsList : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pants_list, container, false)
    }

    @SuppressLint("WrongConstant")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = arrayListOf<Pants>()
        for(i in 0 until 10){
            list.add(Pants("", i.toDouble(), "",""))
        }

        with(pantsList_recycler){
            adapter = PantsListAdapter(activity!!, list)
            layoutManager = LinearLayoutManager(activity!!, LinearLayout.VERTICAL, false)
        }
    }



     companion object{
         @JvmStatic
         fun newInstance(): FragmentPantsList{
             val fragment = FragmentPantsList()
             return fragment
         }

     }

}
