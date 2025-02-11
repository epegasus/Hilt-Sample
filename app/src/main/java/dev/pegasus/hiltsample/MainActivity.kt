package dev.pegasus.hiltsample

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var internetManagerInject: dev.pegasus.hiltsample.constructorInject.InternetManager
    /*@Inject
    lateinit var internetManagerBind: dev.pegasus.hiltsample.bind.InternetManager
    @Inject
    lateinit var internetManagerProvide: dev.pegasus.hiltsample.provide.InternetManager*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fullScreen()
        executeLogs()
    }

    private fun fullScreen() {
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun executeLogs() {
       /* Log.d(TAG, "executeLogs: Constructor Inject: ${internetManagerInject.isInternetConnected()}")
        Log.d(TAG, "executeLogs: Binds: ${internetManagerBind.isInternetConnected()}")
        Log.d(TAG, "executeLogs: Provides: ${internetManagerProvide.isInternetConnected()}")*/
    }

    companion object {
        const val TAG = "MyTag"
    }
}