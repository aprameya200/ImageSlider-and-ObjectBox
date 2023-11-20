package com.example.objectbox

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0 ->  return FragmentA()
            1 ->  return FragmentB()
            2 ->  return FragmentC()
            else -> return FragmentA()
//                imge_url ["ghv","hgj"];
        }
    }


    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "Fragment A"
            }
            1 -> {
                return "Fragment B"
            }
            2 -> {
                return "Fragment C"
            }
        }
        return super.getPageTitle(position)
    }

}