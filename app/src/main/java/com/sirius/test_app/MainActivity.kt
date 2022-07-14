package com.sirius.test_app

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private val INTERNET_PERMISSION_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkPermission(android.Manifest.permission.INTERNET, INTERNET_PERMISSION_CODE)

        val nameView: TextView = this.findViewById(R.id.nameText)
        val descriptionView:TextView = this.findViewById(R.id.descriptionText)
        val ratingText: TextView = this.findViewById(R.id.ratingText)
        val reviewCountText: TextView = this.findViewById(R.id.reviewsCountText)
        val gradeCnt: TextView = this.findViewById(R.id.gradeCntView)
        val ratingBar: RatingBar = this.findViewById(R.id.ratingBar)
        val banner: ImageView = this.findViewById(R.id.banner)
        val logo: ImageView = this.findViewById(R.id.logo)

        var dataModel = DataModel()
        nameView.text = dataModel.name
        descriptionView.text = dataModel.description
        ratingText.text = dataModel.rating.toString()
        reviewCountText.text = "${dataModel.gradeCnt} Reviews"
        gradeCnt.text = dataModel.gradeCnt
        ratingBar.rating = dataModel.rating
        Picasso.with(this).load(dataModel.image).into(banner)
        Picasso.with(this).load(dataModel.logo).into(logo)
    }

    private fun checkPermission(permission: String, requestCode: Int) {
        if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_DENIED) {
            // Requesting the permission
            ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
        } else {
            Toast.makeText(this, "Permission already granted", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>,
                                            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == INTERNET_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Internet Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Internet Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

