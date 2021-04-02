package com.cmk.compose.compose_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.TextFieldDefaults.textFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cmk.compose.R

@Preview
@Composable
fun LoginPageHead() {
    val header = ImageBitmap.imageResource(id = R.mipmap.ic_header)
    val bg = ImageBitmap.imageResource(id = R.mipmap.ic_bg)
    val sky = ImageBitmap.imageResource(id = R.mipmap.ic_sky)
    Box(contentAlignment = Alignment.Center) {
        Image(
            bitmap = bg, contentDescription = "bg", contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .clip(QureytoImageShapes(120f))
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(0.dp)
                .height(120.dp)
                .width(120.dp)
                .clip(CircleShape)
                .background(Color(206, 236, 250, 121))
        ) {
            Image(
                bitmap = header, contentDescription = "h", contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp)
                    .background(color = Color(0XFF0DBEBF), shape = CircleShape)
                    .padding(3.dp)
                    .clip(CircleShape)
                    .shadow(elevation = 150.dp, clip = true)
            )
        }
    }
}

@Preview
@Composable
fun LoginPageBodyText() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "ComposeUnit 登陆", fontSize = 18.sp)
            Text(text = "更多精彩,更多体验 ~", fontSize = 12.sp, color = Color.Gray)
        }
    }
}

@Preview
@Composable
fun LoginPageBodyEdit() {
    val user = ImageVector.vectorResource(id = R.drawable.ic_user)
    val lock = ImageVector.vectorResource(id = R.drawable.ic_lock)
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
    ) {
        TextField(
            value = "   account",
            onValueChange = {},
            shape = RoundedCornerShape(8.dp),
            colors = textFieldColors(
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.White
            ),
            modifier = Modifier.border(
                1.dp,
                Color(111, 111, 111, 66),
                shape = RoundedCornerShape(12.dp)
            ),
            leadingIcon = { Icon(imageVector = user, contentDescription = "账号") }
        )
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        TextField(
            value = "   account",
            onValueChange = {},
            shape = RoundedCornerShape(8.dp),
            colors = textFieldColors(
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.White
            ),
            modifier = Modifier.border(
                1.dp,
                Color(111, 111, 111, 66),
                shape = RoundedCornerShape(12.dp)
            ),
            leadingIcon = { Icon(imageVector = lock, contentDescription = "账号") }
        )
    }
}

@Preview
@Composable
fun LoginPageBottom() {
    val remember = remember { mutableStateOf(false) }
    val LineUndFunction: Shape = object : Shape {
        override fun createOutline(
            size: Size,
            layoutDirection: LayoutDirection,
            density: Density
        ): Outline {
            val path = Path()
            path.moveTo(0f, size.height - 2f)
            path.lineTo(size.width, size.height - 2f)
            path.lineTo(size.width, size.height)
            path.lineTo(0f, size.height)
            path.close()
            return Outline.Generic(path)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp, vertical = 20.dp)
        ) {
            Checkbox(
                checked = remember.value, onCheckedChange = { remember.value = it },
                colors = CheckboxDefaults.colors(checkedColor = Color(0XFF0DBEBF))
            )
            Text(
                "用户注册",
                color = Color(0XFF0DBEBF),
                modifier = Modifier.border(1.dp, color = Color(0XFF0DBEBF), shape = LineUndFunction)
            )
        }
    }
}