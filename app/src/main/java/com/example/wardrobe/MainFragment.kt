package com.example.wardrobe

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.HORIZONTAL
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wardrobe.models.Shirt
import com.example.wardrobe.recyclerAdapter.ShirtRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_main.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MainFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //adapters
        val list = arrayListOf<Shirt>()
        for(i in 0 until 10){
          list.add(Shirt("", i.toDouble(), "green", 56))
        }

        with(shirt_recycler){
            adapter = ShirtRecyclerAdapter(activity!!, list)
            layoutManager =LinearLayoutManager(activity!!, HORIZONTAL, false)

        }

    }


    companion object {

        @JvmStatic
        fun newInstance(): MainFragment{
         val nfragment = MainFragment()
            return nfragment
        }

    }
}
