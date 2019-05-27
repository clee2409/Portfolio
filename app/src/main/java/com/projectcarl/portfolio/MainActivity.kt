package com.projectcarl.portfolio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.portfolio -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, MainDisplayFragment()).commit()
                drawer_layout.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.resume -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, ResumeFragment()).commit()
                drawer_layout.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.about_me -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, AboutMeFragment()).commit()
                drawer_layout.closeDrawer(GravityCompat.START)
                return true;
            }
            R.id.about_app -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, AboutThisAppFragment()).commit()
                drawer_layout.closeDrawer(GravityCompat.START)
                return true;
            }
        }
        return false;
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.getItemId()) {
            android.R.id.home -> {
                if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
                    drawer_layout.closeDrawer(GravityCompat.START)
                } else
                    drawer_layout.openDrawer(GravityCompat.START)
                return true
            }
        }
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(main_activity_toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_action_hamburger_menu)
        nav_view.setNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            if (supportFragmentManager.findFragmentById(R.id.fragment_container) == null) {
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, MainDisplayFragment())
                    .commit();
            }
        }
    }
}
