package com.example.number_guessing_game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    private fun generateRandomNumber(): Int {
        return (0..20).random()
    }


    private var randomNumber: Int = generateRandomNumber()

    fun guessButton (view: View) {

        Log.i("Random Number", "Random Number is: $randomNumber")

        var usersGuess: EditText = findViewById(R.id.usersGuessTextBox)
        var usersGuessInt: Int = usersGuess.text.toString().toInt()

        processUsersGuess(usersGuessInt, randomNumber)
    }


    private fun processUsersGuess (usersGuessInt: Int, randomNumber: Int) {

        if (usersGuessInt < randomNumber) {
            higherLowerToast("Higher!")
        } else if (usersGuessInt > randomNumber) {
            higherLowerToast("Lower!")
        } else {
            higherLowerToast("Correct! Try again!")
            this.randomNumber = generateRandomNumber()
        }
    }

    private fun higherLowerToast (message: String) {
        return Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}