package com.cc.jungleeitaguayo.Data

class Monkey:Animal() {

    fun play() {
        //say "Ooo Ooo Ooo"
        //-8 energy
        if (energy < 0) {
            //say "monkey is too tired"
        }
    }

    override fun makeSound() {
        energy -= 4


    }
}