package com.cc.jungleeitaguayo.Data

open class Animal {

    var energy:Int = 10
    set(value) {
        var newValue = value
        if (newValue < 0) {
            newValue = 0
        }
        field = newValue
    }

    open fun makeSound() {
        energy -= 3
    }

    fun eatFood () {
        energy += 5
    }

    fun sleep () {
        energy += 10
    }

    fun howManyOfMyKind () : Int {

        return 0
    }



}