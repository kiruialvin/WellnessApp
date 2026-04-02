package com.Alvin.chui_wellnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
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



    }
}