package com.example.cecs453assignment1_tipcalculator
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val tipCalc= tipcalculator(0.0f,0.0f)
    var money = NumberFormat.getCurrencyInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.amountBill.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) { calculate() }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

            }
        })
        binding.amountTipPercent.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) { calculate() }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

            }
        })



    }
    fun calculate() {
        var billAmount: Float =0.0f
        var billTip: Float = 0.0f
        val  amountBill1 = binding.amountBill
        val stringBillAmount = amountBill1.text.toString()
        if (stringBillAmount.isEmpty())
            billAmount = 0.0f
        else
            billAmount = stringBillAmount.toFloat()
        tipCalc.bill=billAmount
        val amountTip1 = binding.amountTipPercent
        //THEM IN THE TEXTBOX
        val stringTipAmount = amountTip1.text.toString()
        if (stringTipAmount.isEmpty())
            billTip =0.0f
        else
            billTip = stringTipAmount.toFloat()

        tipCalc.tip=.01f*billTip

        val amountTip: String = money.format(tipCalc.tipAmount()).toString()
        val amountTotal: String = money.format(tipCalc.totalAmount()).toString()
        binding.amountTip.setText(amountTip)
        binding.amountTotal.setText((amountTotal))








    }
}