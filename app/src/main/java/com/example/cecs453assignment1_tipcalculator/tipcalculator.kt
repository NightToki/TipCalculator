package com.example.cecs453assignment1_tipcalculator

class tipcalculator(newTip: Float=0.0f, newBill: Float=0.0f) {
    var tip: Float = newTip
        get() = field        // getter
        set(value) {         // setter
            field = value
        }
    var bill: Float=newBill


    get() = field        // getter
    set(value) {         // setter
        field = value
    }


    fun tipAmount(): Float {
        return bill * tip
    }

    fun totalAmount(): Float {
        return bill + tipAmount()
    }

}
