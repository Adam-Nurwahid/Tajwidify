package com.kuliah.pkm.tajwidify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kuliah.pkm.tajwidify.fragment.DoaFragment
import com.kuliah.pkm.tajwidify.fragment.HomeFragment
import com.kuliah.pkm.tajwidify.fragment.ProfileFragment

class DashboardActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {

                R.id.home -> {
                    replaceFragment(HomeFragment())
                    true
                }

                R.id.Profile -> {
                    replaceFragment(ProfileFragment())
                    true
                }

                R.id.doa_harian -> {
                    replaceFragment(DoaFragment())
                    true
                }

                else -> false
            }
        }
        replaceFragment(HomeFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout_dashboard, fragment).commit()
    }
}
