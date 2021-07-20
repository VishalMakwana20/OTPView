package com.example.otpdemo

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.otpdemo.utils.KeyboardUtils
import kotlinx.android.synthetic.main.activity_otp.*

class OTPActivity : AppCompatActivity() {

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)

        pinView.setOnTouchListener { v, event ->
            if (pinView.isOtpFilled) {
                pinView.isOtpFilled = false
                pinView.text?.clear()
                pinView.setLineColor(Color.BLACK)
            }
            return@setOnTouchListener false
        }

        pinView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (pinView.text.toString().trim().length == 4) {
                    pinView.isOtpFilled = true
                    KeyboardUtils.hideKeyboard(pinView)
                    if (pinView.text.toString().trim() == "1234")
                        pinView.setLineColor(Color.GREEN)
                    else
                        pinView.setLineColor(Color.RED)
                }
            }
        })
    }
}