package com.example.softwarefun


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_hist_fav.*
import maes.tech.intentanim.CustomIntent


class activity_fav : AppCompatActivity() {

    private var listItems = ArrayList<Item>()  // Should contain all information needed about route

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enter code if (have fav)
        //setContentView(R.layout.activity_no_favourite)

        setContentView(R.layout.activity_hist_fav)


        val navigation = findViewById<BottomNavigationView>(R.id.navigation)

        navigation.getMenu().getItem(3).setChecked(true);
        navigation?.setOnNavigationItemSelectedListener OnNavigationItemSelectedListener@{ item: MenuItem ->
            //            item.isChecked = true
//            navigation.itemIconTintList = null
            when (item.itemId) {
                R.id.navigation_search -> {
//                    navigation.itemIconTintList = null;
                    val b = Intent(this@activity_fav, activity_p1::class.java)
                    startActivity(b)
                    CustomIntent.customType(this, "fadein-to-fadeout");
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigation_currentroute -> {
//                    navigation.itemIconTintList = null;
                    val a = Intent(this@activity_fav, MainActivity::class.java)
                    startActivity(a)
                    CustomIntent.customType(this, "fadein-to-fadeout");
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_favourite -> {

                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_history -> {
//                    navigation.itemIconTintList = null;
                    val c = Intent(this@activity_fav, activity_hist::class.java)
                    startActivity(c)
                    CustomIntent.customType(this, "fadein-to-fadeout");
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

        listItems.add(
            Item(
                1, "From NTU to Redhill", "NTU", "Redhill",
                true, true, "11:34", "11.58"
            )
        )
        listItems.add(
            Item(
                2, "From NTU to Orchard", "NTU", "Orchard",
                true, true, "13.45", "14.15"
            )
        )
        listItems.add(
            Item(
                3, "From Changi Airport to Bugis", "Changi Airport", "Bugis",
                false, true, "10:23", "11:05"
            )
        )
        listItems.add(
            Item(
                4, "From Somerset to China Town", "Somerset", "China Town",
                true, false, "16:47", "17:16"
            )
        )
        listItems.add(
            Item(
                4, "From Somerset to China Town", "Somerset", "China Town",
                true, false, "16:47", "17:16"
            )
        )
        listItems.add(
            Item(
                4, "From Somerset to China Town", "Somerset", "China Town",
                true, false, "16:47", "17:16"
            )
        )

        //Favorite
        var itemsAdapter = itemsAdapter(this, listItems)
        listViewItems.adapter = itemsAdapter
        listViewItems.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            Toast.makeText(this, "Click on " + listItems[position].title, Toast.LENGTH_SHORT).show()

        }
    }
        inner class itemsAdapter : BaseAdapter {

            private var itemsList = ArrayList<Item>()
            private var context: Context? = null

            constructor(context: Context, itemsList: ArrayList<Item>) : super() {
                this.itemsList = itemsList
                this.context = context
            }

            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

                val view: View?
                val vh: ViewHolder

                if (convertView == null) {
                    view = layoutInflater.inflate(R.layout.activity_item, parent, false)
                    vh = ViewHolder(view)
                    view.tag = vh
                    Log.i("JSA", "set Tag for ViewHolder, position: " + position)
                } else {
                    view = convertView
                    vh = view.tag as ViewHolder
                }

                // Assigning information in view
                vh.tvTitle.text = itemsList[position].title
                vh.tvDepTime.text = itemsList[position].departTime
                vh.tvArrTime.text = itemsList[position].arrTime

                if (itemsList[position].transportBus) {
                    vh.ivBusIcon.visibility = View.VISIBLE
                } else {
                    vh.ivBusIcon.visibility = View.GONE
                }

                if (itemsList[position].transportMRT) {
                    vh.ivMrtIcon.visibility = View.VISIBLE
                } else {
                    vh.ivMrtIcon.visibility = View.GONE
                }


                // Set listener to start route button
                /*
                vh.startRoute.setOnClickListener {
                    Toast.makeText(this@Favorite, "You clicked me.", Toast.LENGTH_SHORT).show()

                    // Call on new activity
                    val intent = Intent(this@Favorite, test::class.java)
                    //intent.putExtra("selectedRoute", itemsList[position] as Serializable) // Pass object to new activity
                    startActivity(intent)
                }*/


                // Handle click on stars
                /*
                vh.starFilled.setOnClickListener {
                Toast.makeText(this@MainActivity, "Deleted route from favorites.", Toast.LENGTH_SHORT).show()
                itemsList.removeAt(position)
                vh.starFilled.visibility = View.GONE
                vh.starEmpty.visibility = View.VISIBLE
                }*/

                return view
            }

            override fun getItem(position: Int): Any {
                return itemsList[position]
            }

            override fun getItemId(position: Int): Long {
                return position.toLong()
            }

            override fun getCount(): Int {
                return itemsList.size
            }
        }

        private class ViewHolder(view: View?) {
            val tvTitle: TextView
            val ivBusIcon: ImageView
            val ivMrtIcon: ImageView
            val tvDepTime: TextView
            val tvArrTime: TextView
            val startRoute: ImageButton
            val starEmpty: ImageButton
            val starFilled: ImageButton


            init {
                this.tvTitle = view?.findViewById(R.id.tvTitle) as TextView
                this.ivBusIcon = view?.findViewById(R.id.ivBusIcon) as ImageView
                this.ivMrtIcon = view?.findViewById(R.id.ivMrtIcon) as ImageView
                this.tvDepTime = view?.findViewById(R.id.tvDepartTime) as TextView
                this.tvArrTime = view?.findViewById(R.id.tvArrivalTime) as TextView
                this.startRoute = view?.findViewById(R.id.startRouteArrow) as ImageButton
                this.starEmpty = view?.findViewById(R.id.starEmpty) as ImageButton
                this.starFilled = view?.findViewById(R.id.starFilled) as ImageButton
            }

            //  if you target API 26, you should change to:
//        init {
//            this.tvTitle = view?.findViewById<TextView>(R.id.tvTitle) as TextView
//            this.tvContent = view?.findViewById<TextView>(R.id.tvContent) as TextView
//        }
        }
}