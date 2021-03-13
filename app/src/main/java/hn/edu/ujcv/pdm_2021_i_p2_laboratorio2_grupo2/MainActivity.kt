package hn.edu.ujcv.pdm_2021_i_p2_laboratorio2_grupo2

import android.net.Uri
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_registrar_alumno.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity(),
    RegistrarAlumno.OnFragmentInteractionListener,
    RegistrarClase.OnFragmentInteractionListener,
    RealizarMatricula.OnFragmentInteractionListener,
    IngresarNotas.OnFragmentInteractionListener,
    EnviarMatricula.OnFragmentInteractionListener,
    EnviarNotas.OnFragmentInteractionListener{
    var datos: HashMap<Int, String> = hashMapOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        configureTabs()

    }


    

    private fun configureTabs(){
        tab_layout.addTab(tab_layout.newTab().setIcon(android.R.drawable.ic_menu_set_as))
        tab_layout.addTab(tab_layout.newTab().setIcon(android.R.drawable.ic_menu_agenda))
        tab_layout.addTab(tab_layout.newTab().setIcon(android.R.drawable.ic_menu_edit))
        tab_layout.addTab(tab_layout.newTab().setIcon(android.R.drawable.ic_input_get))
        tab_layout.addTab(tab_layout.newTab().setIcon(android.R.drawable.ic_dialog_email))
        tab_layout.addTab(tab_layout.newTab().setIcon(android.R.drawable.ic_menu_send))

        val adapter = PagerAdapter(supportFragmentManager,tab_layout.tabCount)
        pager.adapter =adapter

        pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
        tab_layout.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
                pager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })
    }

    override fun onFragmentInteraction(uri: Uri) {
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}