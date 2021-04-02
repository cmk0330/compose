package com.cmk.compose

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyList()
//            StudyLayoutViews()
        }
    }

    val boxClipShape: Shape = object : Shape {
        override fun createOutline(
            size: Size,
            layoutDirection: LayoutDirection,
            density: Density
        ): Outline {
            val path = Path()
            path.moveTo(20f, 0f)
            path.relativeLineTo(-20f, 20f)
            path.relativeLineTo(0f, size.height - 40f)
            path.relativeLineTo(20f, 20f)
            path.relativeLineTo(size.width / 3f - 20, 0f)
            path.relativeLineTo(15f, -10f)
            path.relativeLineTo(size.width / 3f - 30, 0f)
            path.relativeLineTo(15f, 10f)
            path.relativeLineTo(size.width / 3f - 20, 0f)
            path.relativeLineTo(20f, -20f)
            path.relativeLineTo(0f, -(size.height - 40f))
            path.relativeLineTo(-20f, -20f)
            path.relativeLineTo(-(size.width / 3f - 20), 0f)
            path.relativeLineTo(-15f, 20f)
            path.relativeLineTo(-(size.width / 3f - 30), 0f)
            path.relativeLineTo(-15f, -20f)
            path.close()
            return Outline.Generic(path)
        }

    }

    @Preview
    @Composable
    fun StudyLayoutViews() {
        val imageResource = ImageBitmap.imageResource(id = R.mipmap.ic_show)
        val imageDelete = ImageVector.vectorResource(id = R.drawable.ic_delete)
        val imageCircle = ImageVector.vectorResource(id = R.drawable.ic_circle)
        Box(
            modifier = Modifier
                .padding(0.dp)
                .clip(boxClipShape)
                .border(width = 1.dp, color = Color(89, 199, 249), shape = boxClipShape)
                .background(Color(206, 235, 250))
                .clickable { startActivity(Intent(this, PageActivity::class.java)) }
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    imageVector = imageCircle, contentDescription = "圆",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .padding(4.dp)
                        .background(Color.White, shape = CircleShape)
                        .clip(CircleShape)
                        .shadow(elevation = 150.dp, clip = true),
                )
                Column(modifier = Modifier.padding(start = 4.dp)) {
                    Text("Container", fontSize = 14.sp, color = Color.Black)
                    Text(
                        "容器",
                        Modifier.padding(top = 4.dp, bottom = 2.dp),
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                    Text(
                        "123W阅读", fontSize = 8.sp, color = Color.Red,
                        modifier = Modifier.padding(bottom = 2.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .padding(start = 30.dp)
                        .height(60.dp), contentAlignment = Alignment.BottomCenter
                ) {

                    Column() {
                        Image(
                            imageVector = imageDelete, contentDescription = "删除",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .height(20.dp)
                                .width(20.dp)
                                .shadow(elevation = 150.dp, clip = true)
                        )
//                        Text(
//                            "delete",
//                            modifier = Modifier.padding(top = 4.dp),
//                            fontSize = 8.sp,
//                            color = Color.Black
//                        )
                    }
                }
            }
        }
    }

    @Composable
    fun StudyLine() {

    }

    @Composable
    fun StudyList() {
        val rememberScrollState = rememberScrollState()
        val rememberLazyListState = rememberLazyListState()
        LazyColumn(state = rememberLazyListState) {
            items(100) {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    StudyLayoutViews()
                    Spacer(modifier = Modifier.padding(horizontal = 1.dp))
                    StudyLayoutViews()
                }
            }
        }
//        Column(modifier = Modifier.verticalScroll(rememberScrollState)) {
//            repeat(100) {
//
//            }
//        }
    }
}