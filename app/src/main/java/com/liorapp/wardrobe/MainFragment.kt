package com.liorapp.wardrobe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.liorapp.wardrobe.models.Pants
import com.liorapp.wardrobe.models.Shirt
import com.liorapp.wardrobe.models.Shoes
import com.liorapp.wardrobe.viewPager.PantsPagerAdapter
import com.liorapp.wardrobe.viewPager.ShirtPagerAdapter
import com.liorapp.wardrobe.viewPager.ShoesPagerAdapter
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




    private lateinit var viewPager: ViewPager
    private lateinit var pagerAdapterShirt: ShirtPagerAdapter
    private lateinit var pagerAdapterPants: PantsPagerAdapter
    private lateinit var pagerAdapterShoes: ShoesPagerAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //adapters
        val listShirt = arrayListOf<Shirt>()
        for (i in 0 until 10) {
            listShirt.add(Shirt("", i.toDouble(), "green", ""))
        }
        with(shirt_pager) {
            viewPager = view.findViewById(R.id.shirt_pager)
            pagerAdapterShirt = ShirtPagerAdapter(fragmentManager!!, listShirt)
            viewPager.adapter = pagerAdapterShirt
        }

        val listPants = arrayListOf<Pants>()
        for (i in 0 until 10){
            listPants.add(Pants("", i.toDouble(), "", ""))
        }

        with(pants_pager){
            viewPager = view.findViewById(R.id.pants_pager)
            pagerAdapterPants = PantsPagerAdapter(fragmentManager!!, listPants)
            viewPager.adapter = pagerAdapterPants
        }

        val listShoes = arrayListOf<Shoes>()
        for (i in 0 until 10 ){
            listShoes.add(Shoes("", i.toDouble(), "", ""))
        }

        with(shoes_pager){
            viewPager = view.findViewById(R.id.shoes_pager)
            pagerAdapterShoes = ShoesPagerAdapter(fragmentManager!!, listShoes)
            viewPager.adapter = pagerAdapterShoes

        }
    }

    companion object{
        fun newInstance(): MainFragment {
            val fragment = MainFragment()
            return fragment
        }
    }
}