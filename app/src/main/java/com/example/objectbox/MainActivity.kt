package com.example.objectbox

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager>(R.id.pager)
        viewPager.adapter = PageAdapter(supportFragmentManager)

        val tabLayout = findViewById<TabLayout>(R.id.tab)
        tabLayout.setupWithViewPager(viewPager)

        ObjectBox.init(this)

        val myEntityBox = ObjectBox.store.boxFor(User::class.java)

        myEntityBox.removeAll()

        val newData = User(1, "Noice")
        val qwe = User(2, "Good")
        val asd = User(3, "Bad")

// put inserts a new object or updates an existing one (with the same ID)
        myEntityBox.put(newData)
        myEntityBox.put(qwe)
        myEntityBox.put(asd)

        val query = myEntityBox.all
        val results = myEntityBox.all
//        query.close()


        for (user in results) {
            Log.d("Printer", user.name.toString())  // Adjust the property names accordingly
        }
    }
}