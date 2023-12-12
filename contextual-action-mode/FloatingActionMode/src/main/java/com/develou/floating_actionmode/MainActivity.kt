package com.develou.floating_actionmode

import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

@RequiresApi(Build.VERSION_CODES.M)
class MainActivity : AppCompatActivity() {
    private var actionMode: ActionMode? = null
    private lateinit var image: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(android.R.id.content).setOnClickListener {
            actionMode?.finish()
        }

        image = findViewById(R.id.image_container)
        image.setOnLongClickListener { view ->
            when (actionMode) {
                null -> {
                    actionMode = view.startActionMode(floatingActionMode, ActionMode.TYPE_FLOATING)
                    view.isActivated = true
                    true
                }
                else -> false
            }
        }
    }

    private val floatingActionMode = object : ActionMode.Callback2() {
        override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
            menuInflater.inflate(R.menu.floating_cab_menu, menu)
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
            return false
        }

        override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.upload, R.id.scale, R.id.resize, R.id.crop -> {
                    Toast.makeText(this@MainActivity, "Acción: ${item.title}", Toast.LENGTH_SHORT)
                        .show()
                    mode.finish()
                    true
                }
                else -> false
            }
        }

        override fun onDestroyActionMode(mode: ActionMode) {
            actionMode = null
            image.isActivated = false
        }

        override fun onGetContentRect(mode: ActionMode?, view: View?, outRect: Rect?) {
            super.onGetContentRect(mode, view, outRect)
            // TODO: aquí usarías tus coordenadas con outRect
            // ej: outRect.set(16,16,16,16)
        }
    }
}