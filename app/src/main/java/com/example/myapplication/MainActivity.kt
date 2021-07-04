package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    lateinit var bu0:Button
    lateinit var bu1:Button
    lateinit var bu2:Button
    lateinit var bu3:Button
    lateinit var bu4:Button
    lateinit var bu5:Button
    lateinit var bu6:Button
    lateinit var bu7:Button
    lateinit var bu8:Button
    lateinit var bu9:Button
    lateinit var buDot:Button
    lateinit var editNumber:EditText
    lateinit var buDiv:Button
    lateinit var buMul:Button
    lateinit var buEql : Button
    lateinit var buSub:Button
    lateinit var buSum:Button
    lateinit var buPercentage:Button
    lateinit var buPlusMins:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        bu0 = findViewById(R.id.bu0)
        bu1 = findViewById(R.id.bu1)
        bu2 = findViewById(R.id.bu2)
        bu3 = findViewById(R.id.bu3)
        bu4 = findViewById(R.id.bu4)
        bu5 = findViewById(R.id.bu5)
        bu6 = findViewById(R.id.bu6)
        bu7 = findViewById(R.id.bu7)
        bu8 = findViewById(R.id.bu8)
        bu9 = findViewById(R.id.bu9)
        buDot = findViewById(R.id.buDot)
        buPlusMins = findViewById(R.id.buPlusMins)
        buMul = findViewById(R.id.buMul)
        buDiv = findViewById(R.id.buDiv)
        buSub = findViewById(R.id.buSub)
        buSum = findViewById(R.id.buSum)
        buEql = findViewById(R.id.bueql)



        editNumber = findViewById(R.id.etShowNumber)

    }




    fun buNumberEvent(view: View) {
        if (isNewOperation){
            editNumber.setText("")
        }
        isNewOperation = false

        var clickValue :String = editNumber.text.toString()

         when(view as Button){
            bu0->clickValue+= 0
            bu1->clickValue+= 1
            bu2->clickValue+= 2
            bu3->clickValue+= 3
            bu4->clickValue+= 4
            bu5->clickValue+=5
            bu6-> clickValue+=6
            bu7-> clickValue+=7
            bu8-> clickValue+=8
            bu9->clickValue+= 9
             buDot->clickValue+="."
             buPlusMins->clickValue= "-$clickValue"
            else->clickValue+= 0

        }
        editNumber.setText(clickValue)



    }
    fun buPercent(view: View) {
        var number = editNumber.text.toString().toDouble()/100
        editNumber.setText(number.toString())
    }
    fun buClean(view: View) {
        editNumber.setText("0")
        isNewOperation = true

    }

    var op = "*"
    fun buOpEevent(view: View) {
        when(view as Button){
            buSum-> op = "+"
            buSub-> op = "-"
            buMul-> op = "*"
            buDiv-> op = "/"

        }
        isNewOperation = true
        oldNum = editNumber.text.toString()
    }

    var isNewOperation = true
    var oldNum = ""


    fun buEqualEvent(view: View) {
       val newNum = editNumber.text.toString()
        isNewOperation =true
        var resultNum:Double = 0.0
        when(op){
            "*"-> resultNum= oldNum.toDouble()*newNum.toDouble()
            "/"-> resultNum= oldNum.toDouble()/newNum.toDouble()
            "+"-> resultNum= oldNum.toDouble()+newNum.toDouble()
            "-"-> resultNum= oldNum.toDouble()-newNum.toDouble()
        }
        editNumber.setText(resultNum.toString())
        isNewOperation = true




    }

}