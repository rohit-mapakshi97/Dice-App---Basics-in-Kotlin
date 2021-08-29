package com.rmdroid.dice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val imageView: ImageView = findViewById(R.id.imageView)
        val dice = Dice(6)
        val rolledNumber = dice.roll()
        val imageResourceID = when(rolledNumber)
        {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        imageView.setImageResource(imageResourceID)
        imageView.contentDescription = "You rolled a ${rolledNumber}"

    }

    class Dice(private val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}