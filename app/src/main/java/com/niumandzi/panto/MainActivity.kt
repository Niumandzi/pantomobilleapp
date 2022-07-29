package com.niumandzi.panto

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.niumandzi.panto.databinding.ActivityMainBinding
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


class MainActivity : AppCompatActivity() {

    //btn_about

    //btn_main

    //camera
    private lateinit var cameraExecutor: ExecutorService
    private lateinit var bindingClass: ActivityMainBinding

    companion object {
        private const val TAG = "CameraX" //log
        private const val PERMISSION_CODE = 10
        private val PERMISSION = arrayOf(Manifest.permission.CAMERA)
    }

    private fun allPermissionGranted() = PERMISSION.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        if (allPermissionGranted()){
            startCamera()
        }else{
            ActivityCompat.requestPermissions(
                this,
                PERMISSION,
                PERMISSION_CODE
            )
        }

        cameraExecutor = Executors.newSingleThreadExecutor()
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraExecutor.shutdown()
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == PERMISSION_CODE) {
             if(allPermissionGranted()){
                 startCamera()
             }else{
                 Toast.makeText(this, "Permisson error", Toast.LENGTH_SHORT).show()
                 finish()
             }
        }
    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)
        cameraProviderFuture.addListener(Runnable
                        {
                        val cameraProvider = cameraProviderFuture.get()
                        val preview = Preview.Builder().build()
                            .also {
                                it.setSurfaceProvider(bindingClass.pvCamera.surfaceProvider)
                            }
                        val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

                        try {
                            cameraProvider.unbindAll()
                            cameraProvider.bindToLifecycle(
                                this,
                                cameraSelector,
                                preview
                            )
                        }catch (e: Exception){
                            Log.e(TAG, "Bind error", e)
                        }
        },
        ContextCompat.getMainExecutor(this))
    }

    fun AboutActivityBtn(view: View) {
        val intent = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(intent)
    }

    fun TextActivityBtn(view: View?) {
        val intent = Intent(this@MainActivity, TextActivity::class.java)
        startActivity(intent)
    }
}

