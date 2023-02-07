package com.example.hackerton

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.hackerton.databinding.ActivityNaviBinding

private const val TAG_POST = "Post_activity"
private const val TAG_HOME = "home_fragment"
private const val TAG_PROFILE = "Profile_fragment"

class NaviActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNaviBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNaviBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)


        setFragment(TAG_HOME, HomeFragment())

        binding.navigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.PostFragment -> setFragment(TAG_POST, PostFragment())
                R.id.homeFragment -> setFragment(TAG_HOME, HomeFragment())
                R.id.ProfileFragment -> setFragment(TAG_PROFILE, ProfileFragment())
            }
            true
        }
    }

    private fun setFragment(tag: String, fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()

        if (manager.findFragmentByTag(tag) == null) {
            fragTransaction.add(R.id.mainFrameLayout, fragment, tag)
        }

        val post = manager.findFragmentByTag(TAG_POST)
        val home = manager.findFragmentByTag(TAG_HOME)
        val profile = manager.findFragmentByTag(TAG_PROFILE)

        if (post != null) {
            fragTransaction.hide(post)
        }

        if (home != null) {
            fragTransaction.hide(home)
        }

        if (profile != null) {
            fragTransaction.hide(profile)
        }

        if (tag == TAG_POST) {
            if (post != null) {
                fragTransaction.show(post)
            }
        } else if (tag == TAG_HOME) {
            if (home != null) {
                fragTransaction.show(home)
            }
        } else if (tag == TAG_PROFILE) {
            if (profile != null) {
                fragTransaction.show(profile)
            }
        }

        fragTransaction.commitAllowingStateLoss()
    }
}