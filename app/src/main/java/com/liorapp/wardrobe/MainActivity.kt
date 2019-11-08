package com.liorapp.wardrobe

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.app_bar_main.*

@Suppress("PLUGIN_WARNING")
class MainActivity(storage: Any) : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    private var transaction = supportFragmentManager.beginTransaction()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // FirebaseStorage
        includesForUploadFiles()
        includesForDownloadFiles()

        val toolBar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolBar)


        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            val fragmentAddItem = FragmentAddItem.newInstance()
            supportFragmentManager.beginTransaction().add(R.id.container, fragmentAddItem).addToBackStack("").commit()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()



        navView.setNavigationItemSelectedListener(this)

        val mainFragment = MainFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.container, mainFragment).commit()
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
               val fragmentMain = MainFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.container,fragmentMain).commit()
            }
            R.id.nav_shirt ->{
                val fragmentShirtList = FragmentShirtList.newInstance()
                supportFragmentManager.beginTransaction().add(R.id.container, fragmentShirtList).addToBackStack("").commit()
            }
            R.id.nav_pants -> {
                val fragmentPantsList = FragmentPantsList.newInstance()
                supportFragmentManager.beginTransaction().add(R.id.container, fragmentPantsList).addToBackStack("").commit()

            }
            R.id.nav_shoes -> {
                val fragmentShoesList = FragmentShoesList.newInstance()
                supportFragmentManager.beginTransaction().add(R.id.container, fragmentShoesList).addToBackStack("").commit()

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {
                val fragmentAddItem = FragmentAddItem.newInstance()
                supportFragmentManager.beginTransaction().add(R.id.container, fragmentAddItem).addToBackStack("").commit()

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return false
    }
    fun includesForUploadFiles() {
        val storage = FirebaseStorage.getInstance()
        val storageRef = storage.reference

        val itemRef = storageRef.child("item.jpg")
        val itemImagesRef = storageRef.child("images/item.jpg")

        itemRef.name == itemImagesRef.name // true
        itemRef.path == itemImagesRef.path // false

    }

    fun includesForDownloadFiles() {
        val storage = FirebaseStorage.getInstance()

        // [START download_create_reference]
        // Create a storage reference from our app
        val storageRef = storage.reference

        // Create a reference with an initial file path and name
        val pathReference = storageRef.child("images/stars.jpg")

        // Create a reference to a file from a Google Cloud Storage URI
        val gsReference = storage.getReferenceFromUrl("gs://bucket/images/stars.jpg")

        // Create a reference from an HTTPS URL
        // Note that in the URL, characters are URL escaped!
        val httpsReference = storage.getReferenceFromUrl(
            "https://firebasestorage.googleapis.com/b/bucket/o/images%20stars.jpg"
        )

    }


}
