package com.example.hetfi.test


import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_setting.*

class Setting:AppCompatActivity(){
    private val filename ="setting_items"
    private val sex_list = listOf<String>("男性","女性")

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        initItems()
    }

    private fun buildDialog(sex: Int):Dialog{
        val radioGroup = RadioGroup(this)
        val radioButton1 =RadioButton(this)
        radioButton1.text = sex_list[0]
        val radioButton2 = RadioButton(this)
        radioButton2.text = sex_list[1]

        radioGroup.addView(radioButton1)
        radioGroup.addView(radioButton2)

        if(sex ==0){
            radioGroup.check(radioButton1.id)
        }
        else{
            radioGroup.check(radioButton2.id)
        }

        val builder = AlertDialog.Builder(this)
        builder.setTitle("性別")
        builder.setPositiveButton("設定") { dialog, which ->
            val key = "sex"

            if (radioGroup.checkedRadioButtonId == radioButton1.id) {
                AppUtil.storeInfo(filename, key, 0, this)
                sex_text.text = sex_list[0]
            } eilse {
                AppUtile.storeInfo(filename, key, 1, this)
                sex_text.text = sex_list[1]
            }
        }

        builder.setView(radioGroup)

        return builder.create()

    }

    private fun setListeners(sex: Int){
        //seekbarの設定
        km.setOnSeekBarChangeListener(object: SeekBar.onSeekBarChangeListener{
           override fun onProgressChanged(seekbar: SeekBar?,progress:Int, fromUser:Boolean)
        })

    }
}



