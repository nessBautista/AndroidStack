package com.example.nestor.notebookapp

import android.app.FragmentManager
import android.opengl.Visibility
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Switch
import android.widget.TextView
import com.example.nestor.notebookapp.Fragments.FragmentOne
import com.example.nestor.notebookapp.extensions.addFragment
import com.example.nestor.notebookapp.extensions.inTransaction
import com.example.nestor.notebookapp.extensions.replaceFragment
import com.example.nestor.notebookapp.models.NavBarItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var basicIntStringLambda:((Int)->(String))

    //region Life Cycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inflateViews()

        basicLambdaExample { number ->
            println("Recevied Number: $number")
            "Sending out number back: $number"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
    //endregion

    //region Load Configs
    private fun inflateViews() {
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        //This is no Loger needed as we are implementing a custom nav menu here
        //nav_view.setNavigationItemSelectedListener(this)

        setNavBarButtons()
    }

    private fun setNavBarButtons() {
        for (item in NavBarItem.values()) {
            val itemView = findViewById<TextView>(item.id)
            itemView.setOnClickListener { v -> Unit
                when(v.id){
                    NavBarItem.GOOGLE_PHOTOS.id -> {println("GOOGLE")
                        supportFragmentManager.popBackStack()
                    }

                    NavBarItem.FACEBOOK.id -> {
                        //supportFragmentManager.inTransaction { add(R.id.main_fragment_container, FragmentOne()) }
                        replaceFragment(FragmentOne(), R.id.main_fragment_container)
                        placeholder_text.visibility = View.GONE
                        //addFragment(FragmentOne(), R.id.main_fragment_container)
                    }
                    NavBarItem.TWITTER.id ->  println("Twitter")
                    NavBarItem.SETTINGS.id ->  println("Settings")
                    else -> {
                        println("Unknown")
                    }
                }
                drawer_layout.closeDrawer(GravityCompat.START)
            }
        }
    }
    //endregion

    //region Activity delegates
    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
    //endregion

    //region Utilities
    fun basicLambdaExample(basicIntStringLambda:(Int)->String){
        println(basicIntStringLambda(314))
    }
    //endregion

}
