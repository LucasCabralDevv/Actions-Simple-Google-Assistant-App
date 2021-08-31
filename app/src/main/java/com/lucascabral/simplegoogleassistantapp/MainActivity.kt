package com.lucascabral.simplegoogleassistantapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intent.handleIntent()
    }

    private fun Intent.handleIntent() {

        when(action) {
            Intent.ACTION_VIEW -> handleDeepLink(data)
            else -> goToDefaultView()
        }
    }

    private fun handleDeepLink(data: Uri?) {

        when(data?.path) {
            "/open" -> {
                val featureType = data.getQueryParameter("featureName").orEmpty()
                navigateToActivity(featureType)
            }
        }
    }

    private fun navigateToActivity(featureType: String) {
        when(featureType) {
            "profile" -> {
                val profileIntent = Intent(this, ProfileActivity::class.java)
                startActivity(profileIntent)
            }
            "settings" -> {
                val settingsIntent = Intent(this, SettingsActivity::class.java)
                startActivity(settingsIntent)
            }
        }
    }

    private fun goToDefaultView() {

    }
}