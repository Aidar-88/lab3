package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.lab3.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var bindingclass: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingclass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingclass.root)
    }

    fun onClickResult(view: View){
        if(!isFieldEmpty()){
            val result ="Result: " + getResult()
            bindingclass.tvResult1.text = result
        }

    }
    fun onClickResultAreaCuboid(view: View) {
        if (!isFieldEmpty()) {
            val result = "Result: " + getResultAreaCuboid()
            bindingclass.tvResult1.text = result
        }
    }

        fun onClickAreaCube(view: View){
            if(!isFieldEmpty2()){
                val result = "Result: " + getResultAreaCube()
                bindingclass.tvResult2.text = result
            }
        }

        fun onClickVolumeCube(view: View){
            if(!isFieldEmpty2()){
                val result = "Result: " + getResultVolumeCube()
                bindingclass.tvResult2.text = result
            }
        }
    private fun isFieldEmpty(): Boolean{
    bindingclass.apply {
        if(edLength.text.isNullOrEmpty())edLength.error = "Set value"
        if(edWidth.text.isNullOrEmpty())edWidth.error = "Set value"
        if(edHeight.text.isNullOrEmpty())edHeight.error = "Set value"
        return edLength.text.isNullOrEmpty() || edWidth.text.isNullOrEmpty() ||
                edHeight.text.isNullOrEmpty()
    }
    }
    private fun isFieldEmpty2(): Boolean{
            if(bindingclass.edLength2.text.isNullOrEmpty())bindingclass.edLength2.error = "Set value"
            return bindingclass.edLength2.text.isNullOrEmpty()
    }
    private fun getResult():String{
    val a:Double
    val b:Double
    val c:Double
        bindingclass.apply {
            a = edLength.text.toString().toDouble()
            b = edWidth.text.toString().toDouble()
            c = edHeight.text.toString().toDouble()
        }
        return (2*(a*b)+2*(b*c)+2*(a*c)).toString()
    }
    private fun getResultAreaCuboid():String{
        val a:Double
        val b:Double
        val c:Double
        bindingclass.apply {
            a = edLength.text.toString().toDouble()
            b = edWidth.text.toString().toDouble()
            c = edHeight.text.toString().toDouble()
        }
        return (a*b*c).toString()
        // return (a1*b1*c1).toString()
    }
    private fun getResultAreaCube():String{
        val s:Double = bindingclass.edLength2.text.toString().toDouble()
        return (6*s.pow(2)).toString()
    }
    private fun getResultVolumeCube():String{
        val v:Double = bindingclass.edLength2.text.toString().toDouble()
        return (v.pow(3)).toString()
    }
}