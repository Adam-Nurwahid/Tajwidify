package com.kuliah.pkm.tajwidify.fragment

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kuliah.pkm.tajwidify.AdapterReycile
import com.kuliah.pkm.tajwidify.MateriDataClass
import com.kuliah.pkm.tajwidify.R
import androidx.recyclerview.widget.LinearLayoutManager

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<MateriDataClass>()


    private fun getListHeroes(): ArrayList<MateriDataClass> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listHero = ArrayList<MateriDataClass>()
        for (i in dataName.indices) {
            val hero = MateriDataClass(dataName[i], dataPhoto.getResourceId(i, -1))
            listHero.add(hero)
        }
        return listHero
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        rvHeroes = view.findViewById(R.id.reycle_bab) // Gantilah 'R.id.recyclerView' dengan ID yang sesuai
        list.addAll(getListHeroes())
        showRecyclerList()
        return view
    }
    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(requireContext())
        val listHeroAdapter = AdapterReycile(list)
        rvHeroes.adapter = listHeroAdapter
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}