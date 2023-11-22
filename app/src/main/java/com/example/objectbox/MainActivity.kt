package com.example.objectbox

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import io.objectbox.BoxStore
import io.objectbox.android.Admin

class MainActivity : AppCompatActivity() {


    object ObjectBox {
        lateinit var store: BoxStore
            private set

        fun init(context: Context) {
            store = MyObjectBox.builder()
                .androidContext(context.applicationContext)
                .build()

            if (BuildConfig.DEBUG) {
                val started = Admin(store).start(context)
                Log.i("ObjectBoxAdmin", "Started: $started")
            }
        }

    }

    lateinit var imageList: List<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager>(R.id.pager)
//
//        val tabLayout = findViewById<TabLayout>(R.id.tab)
//        tabLayout.setupWithViewPager(viewPager)
//
//        ObjectBox.init(this)


        // on below line we are initializing
        // our image list and adding data to it.
        imageList = ArrayList<Int>()
        imageList = imageList + R.drawable.image1
        imageList = imageList + R.drawable.image2
        imageList = imageList + R.drawable.image3
        imageList = imageList + R.drawable.image4
        imageList = imageList + R.drawable.image5

        // on below line we are initializing our view
        // pager adapter and adding image list to it.
        viewPager.adapter = ImagePageAdapter(this, imageList)


        // Start a new activity

// Apply custom animations

        // Inside your activity class

        val btnTransition = findViewById<ImageView>(R.id.btnTransition)


        findViewById<Button>(R.id.pressMe).setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
// Pass data object in the bundle and populate details activity.

            val options = ViewCompat.getTransitionName(btnTransition)?.let { it1 ->
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this@MainActivity,
                    btnTransition,
                    it1
                )
            }

            intent.putExtra(SecondActivity.EXTRA_CONTACT, "Hi")


            if (options != null) {
                startActivity(intent, options.toBundle())
            }

        }


        // on below line we are setting
        // adapter to our view pager.
//        viewPager.adapter = viewPagerAdapter
//
//        val myEntityBox = ObjectBox.store.boxFor(User::class.java)
//
//        myEntityBox.removeAll()
//
//        val newData = User(1, "Noice")
//        val qwe = User(2, "Good")
//        val asd = User(3, "Bad")
//
//// put inserts a new object or updates an existing one (with the same ID)
//        myEntityBox.put(newData)
//        myEntityBox.put(qwe)
//        myEntityBox.put(asd)
//
//        val query = myEntityBox.all
//        val results = myEntityBox.all
////        query.close()
//
//
//        for (user in results) {
//            Log.d("Printer", user.name.toString())  // Adjust the property names accordingly
//        }
    }
}