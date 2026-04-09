package com.Alvin.chui_wellnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback


class MainActivity : AppCompatActivity() {

//    the variable is only accessible inside this class
//    a variable to store the ad once it loads
    private var mInterstitialAd: InterstitialAd? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        MobileAds.initialize(this)
        val adView = findViewById<AdView>(R.id.adView)
        val adRequest=AdRequest.Builder().build()
        adView.loadAd(adRequest)

//        loads the interstitial ad
        loadInterstitialAd()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets



        }
//        healthly recipe intent
//        finding the views from the layout using there Id's
//        create a variable to store the button

        val recipe=findViewById<Button>(R.id.recipes)
//        set on Click Listener
        recipe.setOnClickListener {
//            write your intents
            val recipeIntent= Intent(applicationContext,HealthlyRecipes::class.java)
            startActivity(recipeIntent)

//            display the ad

            showInterstitialAd()
        }
//        nutrition Intent
        val nutrition=findViewById<Button>(R.id.nutrition)
//        click listener
        nutrition.setOnClickListener {
            val nutritionIntent= Intent(applicationContext, NutritionAdvice::class.java)
            startActivity(nutritionIntent)

        }

//        Meditation
        val meditation=findViewById<Button>(R.id.meditation)
//        click listener

        meditation.setOnClickListener {
            val meditationIntent= Intent(applicationContext, Meditation::class.java)
            startActivity(meditationIntent)
        }

        val excercise=findViewById<Button>(R.id.exercise)

//        click listener

        excercise.setOnClickListener {
            val excerciseIntent= Intent(applicationContext,Excercise::class.java)
            startActivity(excerciseIntent)
        }

        val checkProgress=findViewById<Button>(R.id.progress)

        checkProgress.setOnClickListener {
            val checkProgressIntent= Intent(applicationContext,CheckProgress::class.java)
            startActivity(checkProgressIntent)
        }

        val hydration=findViewById<Button>(R.id.hydration)

        hydration.setOnClickListener {
            val hydrationIntent= Intent(applicationContext,Hydration::class.java)
            startActivity(hydrationIntent)

        }

        val Motivation=findViewById<Button>(R.id.motivation)

        Motivation.setOnClickListener {
            val motivationIntent= Intent(applicationContext, Motivation::class.java)
            startActivity(motivationIntent)
        }

        val weeklyGoals=findViewById<Button>(R.id.goals)

        weeklyGoals.setOnClickListener {
            val weeklyGoalsIntent= Intent(applicationContext,WeeklyGoals::class.java)
            startActivity(weeklyGoalsIntent)
        }





    }
    fun loadInterstitialAd() {
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            this,
            "ca-app-pub-3940256099942544/1033173712", // Test ID
            adRequest,
            object : InterstitialAdLoadCallback() {

                override fun onAdLoaded(ad: InterstitialAd) {
                    mInterstitialAd = ad
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    mInterstitialAd = null
                }
            }
        )
    }
    //Show Interstitial ad
    fun showInterstitialAd() {
        if (mInterstitialAd != null) {
            mInterstitialAd?.show(this)
        }
    }


}