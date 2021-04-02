package com.cmk.compose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.DraggableState
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.material.bottomsheet.BottomSheetBehavior


class MainActivity1 : AppCompatActivity() {

    @Stable
    val RectangleImageShapes: Shape = object : Shape {
        override fun createOutline(
            size: Size,
            layoutDirection: LayoutDirection,
            density: Density
        ): Outline {
            val path = Path()
            path.moveTo(0f, 0f)
            path.relativeLineTo(20f, 20f)
            path.relativeCubicTo(40f, 40f, 60f, 60f, -20f, 130f)
            path.relativeCubicTo(40f, 40f, 60f, 60f, -20f, 130f)
            path.relativeCubicTo(40f, 40f, 60f, 60f, -20f, 130f)
            path.relativeCubicTo(40f, 40f, 60f, 60f, -20f, 130f)
            path.relativeCubicTo(40f, 40f, 60f, 60f, -20f, 130f)
            path.relativeCubicTo(40f, 40f, 60f, 60f, -20f, 130f)
            path.lineTo(size.width, size.height)
            path.lineTo(size.width, 0f)
            path.close()
            return Outline.Generic(path)
        }
    }

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                TextUi("hello")
//                ImageUi()
                StudyImageView()
            }
        }
    }

    @ExperimentalFoundationApi
    @Composable
    fun TextUi(text: String) {
        val nameState: MutableState<Color> = remember { mutableStateOf(Color.Green) }
        var color = Color.Gray
        Text(
            text = text,
            modifier = Modifier
                .border(
                    border = BorderStroke(
                        width = 3.dp,
                        color = Color.Blue
                    ),
                    shape = RoundedCornerShape(20f, 60f, 20f, 160f)
                )
                .combinedClickable(onClick = { nameState.value = Color.Yellow },
                    onDoubleClick = { nameState.value = Color.Red }),
            color = nameState.value,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Default,
            letterSpacing = 2.sp,
            textDecoration = TextDecoration.LineThrough
        )
    }

    @Composable
    fun ImageUi() {
        val imageResource = ImageBitmap.imageResource(id = R.mipmap.ic_show)
        Image(
            bitmap = imageResource, contentDescription = "图片",
            modifier = Modifier
                .height(260.dp)
                .width(260.dp)
                .padding(horizontal = 30.dp, vertical = 30.dp)
                .clip(
//                    RoundedCornerShape(
//                        topEnd = 20.dp,
//                        topStart = 20.dp,
//                        bottomEnd = 20.dp,
//                        bottomStart = 20.dp
//                    )
                    RectangleImageShapes
                )
        )
    }

    @Preview(name = "studyImage")
    @Composable
    fun StudyImageView() {
        val draggerOffset:MutableState<Float> = remember{ mutableStateOf(0f) }
        val imageBitmap: ImageBitmap = ImageBitmap.imageResource(R.mipmap.ic_show)
        Image(
            bitmap = imageBitmap,
            contentScale = ContentScale.FillBounds,
            contentDescription = resources.getString(R.string.app_name),
            modifier = Modifier.ImageModifier(draggerOffset)
        )
    }

    private fun Modifier.ImageModifier(draggerOffset: MutableState<Float>):Modifier =
        composed { Modifier
            .height(260.dp)
            .width(200.dp)
            .padding(horizontal = 30.dp, vertical = 30.dp)
            .clip(
                RectangleImageShapes
            )
            .rotate(10f)
            .draggable(state = DraggableState(onDelta = {
                draggerOffset.value = +it
                Log.e("ondelta", "StudyImageView: " + draggerOffset.value)
            }), orientation = Orientation.Horizontal)
            .offset(x = draggerOffset.value.dp)
        }
}