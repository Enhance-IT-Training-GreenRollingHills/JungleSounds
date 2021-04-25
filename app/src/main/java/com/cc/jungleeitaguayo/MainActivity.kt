package com.cc.jungleeitaguayo

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.cc.jungleeitaguayo.Data.Animal
import com.cc.jungleeitaguayo.Data.Monkey
import com.cc.jungleeitaguayo.Data.Snake
import com.cc.jungleeitaguayo.Data.Tiger
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var tiger = Tiger()
    private var monkey = Monkey()
    private var snake = Snake()

    private var foods = listOf("meat", "fish", "bugs", "grain")

    private var selectedAnimal:Animal? = null


    private var backgrounds = mutableListOf<ConstraintLayout>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        backgrounds.add(tigerBackground)
        backgrounds.add(monkeyBackground)
        backgrounds.add(snakeBackground)

        for (layout in backgrounds) {
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent))

        }

        updateEnergy(tiger)
        updateEnergy(monkey)
        updateEnergy(snake)



        tigerBackground.setOnClickListener {
            toggleSelection(it.id, tiger)
        }

        monkeyBackground.setOnClickListener {
            toggleSelection(it.id, monkey)

        }

        snakeBackground.setOnClickListener {
            toggleSelection(it.id, snake)

        }

        soundButton.setOnClickListener {
            selectedAnimal?.let {
                it.makeSound()
                updateEnergy(it)
            }
        }

    }

    fun updateEnergy(animal: Animal) {

        val energyString = animal.energy.toString()

        if (animal is Tiger) {
            tigerEnergy.text = energyString
        } else if (animal is Monkey) {
            monkeyEnergy.text = energyString
        } else if (animal is Snake) {
            snakeEnergy.text = energyString
        }
    }

    private fun toggleSelection (viewID:Int, animal:Animal) {
        for (layout in backgrounds) {
            if (layout.id == viewID) {
                val background = layout.background as ColorDrawable
                if (background.color == ContextCompat.getColor(this, R.color.transparent)) {
                    layout.setBackgroundColor(ContextCompat.getColor(this, R.color.design_default_color_error))
                    selectedAnimal = animal

                } else {
                    layout.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent))
                    selectedAnimal = null

                }
            } else {
                layout.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent))

            }
        }
    }

    fun soundOff () {
        //Tigers get +5 energy for sleeping
        //Monkeys get 2 energy for eating and -4 energy for making a sound

    }


}