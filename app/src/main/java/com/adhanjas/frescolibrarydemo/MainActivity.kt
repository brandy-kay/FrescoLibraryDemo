package com.adhanjas.frescolibrarydemo

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adhanjas.frescolibrarydemo.databinding.ActivityMainBinding
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.common.RotationOptions
import com.facebook.imagepipeline.request.ImageRequest
import com.facebook.imagepipeline.request.ImageRequestBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        Fresco.initialize(this)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Animation
        binding.animimage.controller = Fresco.newDraweeControllerBuilder()
            .setImageRequest(ImageRequest.fromUri("https://media.giphy.com/media/YWf50NNii3r4k/giphy.gif"))
            .setAutoPlayAnimations(true)
            .build()

        //Streaming
        val imageRequest= ImageRequestBuilder
            .newBuilderWithSource(Uri.parse("https://image.ec21.com/image/algsorcings/oimg_GC09912344_CA09912371/Fresh-Cut-Flowers-From-Kenya.jpg"))
            .setProgressiveRenderingEnabled(true)
            .build()

        binding.streamingimage.controller=Fresco.newDraweeControllerBuilder()
            .setImageRequest(imageRequest)
            .setOldController(binding.streamingimage.controller)
            .build()

        //Transformation-Rotation
        val imageRequest2= ImageRequestBuilder
            .newBuilderWithSource(Uri.parse("https://www.extremetech.com/wp-content/uploads/2019/12/SONATA-hero-option1-764A5360-edit-640x354.jpg"))
            .setRotationOptions(RotationOptions.forceRotation(RotationOptions.ROTATE_90))
            .build()
        binding.rotationimage.controller=Fresco.newDraweeControllerBuilder()
            .setImageRequest(imageRequest2)
            .build()

        //Image from Network
        binding.networkimage.setImageURI("https://upload.wikimedia.org/wikipedia/commons/7/7c/Mount_Kenya.jpg")


        // Circular Image
        binding.circularimage.setImageURI("https://www.worldatlas.com/r/w1200/upload/79/70/5a/shutterstock-549814942.jpg")

        // Loading
        binding.progressimage.setImageURI("https://upload.wikimedia.org/wikipedia/commons/c/c6/Loxodonta_africana_-Amboseli_National_Park%2C_Kenya-8.jpg")
    }
}