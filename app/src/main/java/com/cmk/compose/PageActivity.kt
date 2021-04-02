package com.cmk.compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import com.cmk.compose.compose_ui.LoginPageBodyEdit
import com.cmk.compose.compose_ui.LoginPageBodyText
import com.cmk.compose.compose_ui.LoginPageBottom
import com.cmk.compose.compose_ui.LoginPageHead

class PageActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                LoginPageHead()
                LoginPageBodyText()
                LoginPageBodyEdit()
                LoginPageBottom()
            }
        }
    }
}