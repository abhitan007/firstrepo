/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.tiptime


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tiptime.ui.theme.QuizTimeTheme
import com.example.tiptime.viewModel.QuestionViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
    fun FirstScreen(viewModel: QuestionViewModel = viewModel()) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            "Quiz Master",
            modifier = Modifier.padding(10.dp),
            fontSize = 20.sp,
            color = Color.Black
        )

        var i by remember { mutableStateOf(0) }
        var j by remember { mutableStateOf(0) }
        var type by remember { mutableStateOf(0) }
        var difficulty by remember { mutableStateOf("0") }
        val initialButtonColor = Color.Blue
        var score by remember { mutableStateOf(0) }

        val questionListResponse by viewModel.questionListResponse.observeAsState(emptyList())
        val errorMessage by viewModel.errorMessage.observeAsState("")
        LaunchedEffect(j, type, difficulty) {
            if (j == 2 && type != 0 && difficulty != "0") {
                viewModel.getQuestionList(type, difficulty)
            }
        }
        if (j == 0) {
            Column(
                modifier = Modifier.height(200.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .fillMaxHeight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .background(Color.Cyan)
                            .border(1.dp, Color.Blue)
                    ) {
                        Text(
                            text = ("On which topic do you want to take quiz? "),
                            modifier = Modifier.align(Alignment.Center),
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                    }


                }
            }




            Column(
                modifier = Modifier.height(80.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {

                    Button(
                        onClick = {
                            type = 24
                            ++j

                        },
                        colors = ButtonDefaults.buttonColors(containerColor = initialButtonColor)
                    ) {
                        Text(
                            text = ("Politics "),

                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.width(115.dp))
                    Button(
                        onClick = {
                            type = 21;++j

                        },
                        colors = ButtonDefaults.buttonColors(containerColor = initialButtonColor)
                    ) {
                        Text(
                            text = ("Sports "),

                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }


                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                modifier = Modifier.height(80.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {

                    Button(
                        onClick = {
                            type = 11
                            ++j

                        },
                        colors = ButtonDefaults.buttonColors(containerColor = initialButtonColor)
                    ) {
                        Text(
                            text = ("Film"),

                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.width(150.dp))
                    Button(
                        onClick = {
                            type = 25;++j

                        },
                        colors = ButtonDefaults.buttonColors(containerColor = initialButtonColor)
                    ) {
                        Text(
                            text = ("Art"),

                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }


                }
            }


            Spacer(modifier = Modifier.height(30.dp))
            Column(
                modifier = Modifier.height(80.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .fillMaxHeight(1f)
                ) {

                    Button(
                        onClick = {
                            type = 20
                            ++j


                        },
                        colors = ButtonDefaults.buttonColors(containerColor = initialButtonColor)
                    ) {

                        Text(
                            text = ("Mythology"),

                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }




                    Spacer(modifier = Modifier.width(90.dp))





                    Button(
                        onClick = {
                            type = 23
                            ++j

                        },
                        colors = ButtonDefaults.buttonColors(containerColor = initialButtonColor)
                    ) {
                        Text(
                            text = ("History"),

                            fontSize = 20.sp,
                            color = Color.White
                        )


                    }

                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                modifier = Modifier.height(80.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {

                    Button(
                        onClick = {
                            type = 27
                            ++j

                        },
                        colors = ButtonDefaults.buttonColors(containerColor = initialButtonColor)
                    ) {
                        Text(
                            text = ("Animals"),

                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.width(110.dp))
                    Button(
                        onClick = {
                            type = 28;++j

                        },
                        colors = ButtonDefaults.buttonColors(containerColor = initialButtonColor)
                    ) {
                        Text(
                            text = ("Vehicles"),

                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }


                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                modifier = Modifier.height(80.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {

                    Button(
                        onClick = {
                            type = 12
                            ++j

                        },
                        colors = ButtonDefaults.buttonColors(containerColor = initialButtonColor)
                    ) {
                        Text(
                            text = ("Music"),

                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.width(130.dp))
                    Button(
                        onClick = {
                            type = 10;++j

                        },
                        colors = ButtonDefaults.buttonColors(containerColor = initialButtonColor)
                    ) {
                        Text(
                            text = ("Books"),

                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }


                }
            }


        }


        if (j == 1) {
            Column(
                modifier = Modifier.height(200.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .fillMaxHeight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .background(Color.Cyan)
                            .border(1.dp, Color.Blue)
                    ) {
                        Text(
                            text = ("What is the level of difficulty you want to attempt "),
                            modifier = Modifier.align(Alignment.Center),
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                    }

                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                modifier = Modifier.height(80.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .fillMaxHeight(1f)
                ) {

                    Button(
                        onClick = {
                            difficulty = "easy"
                            ++j

                        },
                        colors = ButtonDefaults.buttonColors(containerColor = initialButtonColor)
                    ) {

                        Text(
                            text = ("Easy"),

                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }


                }

            }
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                modifier = Modifier.height(80.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .fillMaxHeight(1f)
                ) {

                    Button(
                        onClick = {
                            difficulty = "medium"
                            ++j

                        },
                        colors = ButtonDefaults.buttonColors(containerColor = initialButtonColor)
                    ) {

                        Text(
                            text = ("Medium "),

                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }


                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            Column(
                modifier = Modifier.height(80.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .fillMaxHeight(1f)
                ) {

                    Button(
                        onClick = {
                            difficulty = "hard"
                            ++j

                        },
                        colors = ButtonDefaults.buttonColors(containerColor = initialButtonColor)
                    ) {

                        Text(
                            text = ("Hard"),

                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }


                }
            }
            Spacer(modifier = Modifier.height(10.dp))


        }
        if (j == 2) {
            Column(
                modifier = Modifier.height(200.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .fillMaxHeight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .background(Color.Cyan)
                            .border(1.dp, Color.Blue)
                    ) {
                        Text(
                            text = ("Instructions For Quiz"),
                            modifier = Modifier.align(Alignment.Center),
                            fontSize = 30.sp,
                            color = Color.Black
                        )
                    }

                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                modifier = Modifier.height(70.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .fillMaxHeight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(1f)
                            .background(Color.Green)
                            .border(1.dp, Color.Blue)
                    ) {
                        Text(
                            text = ("1. There will be 10 questions in this quiz."),
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                    }
                }
                }
                Spacer(modifier=Modifier.height(10.dp))
                Column(
                    modifier = Modifier.height(80.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .fillMaxHeight(1f)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight(1f)
                                .background(Color.Green)
                                .border(1.dp, Color.Blue)
                        ) {
                            Text(
                                text = ("2. There will be 2 types of questions in this quiz: multiple choice questions and True/False."),
                                fontSize = 20.sp,
                                color = Color.Black
                            )
                        }

                    }
                }
            Spacer(modifier=Modifier.height(10.dp))
            Column(
                modifier = Modifier.height(80.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .fillMaxHeight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(1f)
                            .background(Color.Green)
                            .border(1.dp, Color.Blue)
                    ) {
                        Text(
                            text = ("3. The duration of quiz is 600 seconds. Please attempt all the questions within this timelimit."),
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                    }

                }
            }
            Spacer(modifier=Modifier.height(10.dp))
            Column(
                modifier = Modifier.height(80.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .fillMaxHeight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(1f)
                            .background(Color.Green)
                            .border(1.dp, Color.Blue)
                    ) {
                        Text(
                            text = ("4. Each correct answer will fetch you 1 point. Good Luck!!!"),
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                    }

                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            Column(
                modifier = Modifier.height(80.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .fillMaxHeight(1f)
                ) {
                    Button(
                        onClick = { ++j },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                    ) {
                        Text(
                            "Start",
                            fontSize = 30.sp,
                            fontStyle = FontStyle(5),
                            color = Color.White
                        )
                    }
                }
            }

        }
        var remainingTime by remember { mutableStateOf(600) }
        val lifecycleOwner = LocalLifecycleOwner.current
if(j==3) {
    LaunchedEffect(Unit) {
        lifecycleOwner.lifecycleScope.launch {
            while (remainingTime > 0) {
                delay(1000)
                remainingTime--

            }
            j++
        }
    }
}


        if (j == 3) {


            if (questionListResponse.isEmpty() && errorMessage.isEmpty()) {
                Text("Loading...", modifier = Modifier.padding(16.dp))
            } else if (errorMessage.isNotEmpty()) {
                Text(errorMessage, modifier = Modifier.padding(16.dp), color = Color.Red)
            } else {


                val question = questionListResponse.getOrNull(i)


                var buttonClickedOrNot by remember { mutableStateOf(0) }
                if (question != null) {
                    val options = remember(question) {
                        val allOptions = question.incorrect_answers + question.correct_answer
                        allOptions.shuffled()
                    }


                        Column(
                            modifier = Modifier.height(50.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(1/4f)
                                    .fillMaxHeight(1f)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .fillMaxHeight()
                                        .background(Color.Red)
                                        .border(1.dp, Color.Blue)
                                ) {
                                    Text(
                                        text = ("Time left: $remainingTime"),
                                        modifier = Modifier.align(Alignment.Center),
                                        fontSize = 20.sp,
                                        color = Color.Black
                                    )
                                }

                            }
                        }


                        Spacer(modifier = Modifier.height(10.dp))
                        Column(
                            modifier = Modifier.height(150.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(1f)
                                    .fillMaxHeight(1f)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .fillMaxHeight()
                                        .background(Color.Cyan)
                                        .border(1.dp, Color.Blue)
                                ) {
                                    Text(
                                        text = (question.question),
                                        modifier = Modifier.align(Alignment.Center),
                                        fontSize = 20.sp,
                                        color = Color.Black
                                    )
                                }

                            }
                        }


                        Spacer(modifier = Modifier.height(10.dp))

                        Column(
                            modifier = Modifier.height(100.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            var buttonColor by remember { mutableStateOf(initialButtonColor) }

                                Button(
                                    onClick = {
                                        if (buttonClickedOrNot == 0) {
                                            if (buttonColor == initialButtonColor) {
                                                if(options[0]==question.correct_answer){
                                                    buttonColor = Color.Green
                                                        ++score
                                                    }
                                                else{
                                                    buttonColor = Color.Red
                                                }

                                                buttonClickedOrNot = 1
                                                if (i < questionListResponse.size - 1) {

                                                    Handler(Looper.getMainLooper()).postDelayed({
                                                        i++
                                                        buttonClickedOrNot = 0
                                                        buttonColor = initialButtonColor
                                                    }, 2000)
                                                } else if (i == questionListResponse.size - 1) {
                                                    Handler(Looper.getMainLooper()).postDelayed({
                                                        buttonColor = initialButtonColor
                                                        ++j
                                                    }, 2000)
                                                }
                                            } else buttonColor = initialButtonColor
                                        }
                                    },
                                    colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
                                ) {
                                    Text(options[0], color = Color.White)
                                }



                        }
                        Column(
                            modifier = Modifier.height(100.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {


                            var buttonColor by remember { mutableStateOf(initialButtonColor) }

                                Button(
                                    onClick = {
                                        if(buttonClickedOrNot==0){

                                        if (buttonColor == initialButtonColor) {
                                            if(options[0]==question.correct_answer){
                                                buttonColor = Color.Green
                                                ++score
                                            }
                                            else{
                                                buttonColor = Color.Red
                                            }
                                            buttonClickedOrNot = 1
                                            if (i < questionListResponse.size - 1) {

                                                Handler(Looper.getMainLooper()).postDelayed({
                                                    i++
                                                    buttonClickedOrNot = 0
                                                    buttonColor = initialButtonColor
                                                }, 2000)
                                            } else if (i == questionListResponse.size - 1) {
                                                Handler(Looper.getMainLooper()).postDelayed({
                                                    buttonColor = initialButtonColor
                                                    j++
                                                }, 2000)
                                            }
                                        } else buttonColor = initialButtonColor
                                    }
                        },
                                    colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
                                ) {
                                    Text(options[1], color = Color.White)
                                }



                        }
                        Column(
                            modifier = Modifier.height(100.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {


                            var buttonColor by remember { mutableStateOf(initialButtonColor) }
                            if (question.type == "multiple" ) {
                                Button(
                                    onClick = {
                                        if (buttonClickedOrNot == 0) {
                                            if (buttonColor == initialButtonColor) {
                                                if(options[0]==question.correct_answer){
                                                    buttonColor = Color.Green
                                                    ++score
                                                }
                                                else{
                                                    buttonColor = Color.Red
                                                }
                                                buttonClickedOrNot = 1
                                                if (i < questionListResponse.size - 1) {

                                                    Handler(Looper.getMainLooper()).postDelayed(
                                                        {
                                                            i++
                                                            buttonClickedOrNot = 0
                                                            buttonColor = initialButtonColor
                                                        },
                                                        2000
                                                    )
                                                } else if (i == questionListResponse.size - 1) {
                                                    Handler(Looper.getMainLooper()).postDelayed(
                                                        {
                                                            buttonColor = initialButtonColor
                                                            ++j
                                                        },
                                                        2000
                                                    )
                                                }

                                            } else buttonColor = initialButtonColor
                                        }
                                    },
                                    colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
                                ) {
                                    Text(options[2], color = Color.White)
                                }
                            }


                        }
                        Column(
                            modifier = Modifier.height(100.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {


                            var buttonColor by remember { mutableStateOf(initialButtonColor) }
                            if (question.type == "multiple" ) {
                                Button(
                                    onClick = {
                                        if (buttonClickedOrNot == 0) {

                                            if (buttonColor == initialButtonColor) {
                                                if(options[0]==question.correct_answer){
                                                    buttonColor = Color.Green
                                                    ++score
                                                }
                                                else{
                                                    buttonColor = Color.Red
                                                }
                                                buttonClickedOrNot = 1

                                                if (i < questionListResponse.size - 1) {

                                                    Handler(Looper.getMainLooper()).postDelayed(
                                                        {
                                                            i++
                                                            buttonClickedOrNot = 0
                                                            buttonColor = initialButtonColor
                                                        },
                                                        2000
                                                    )
                                                } else if (i == questionListResponse.size - 1) {
                                                    Handler(Looper.getMainLooper()).postDelayed(
                                                        {
                                                            buttonColor = initialButtonColor
                                                            ++j
                                                        },
                                                        2000
                                                    )
                                                }

                                            } else buttonColor = initialButtonColor
                                        }
                                    },
                                    colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
                                ) {
                                    Text(options[3], color = Color.White)
                                }
                            }


                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Column(
                            modifier = Modifier.height(40.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxHeight(1f)
                                    .fillMaxWidth(0.5f)
                                    .background(Color.Blue)
                                    .border(1.dp, Color.Blue)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxHeight(1f)
                                        .fillMaxWidth(1f)
                                ) {
                                    Text(
                                        "Score:",
                                        fontSize = 30.sp,
                                        fontStyle = FontStyle(5),
                                        color = Color.White
                                    )
                                    Text(score.toString(), fontSize = 30.sp, color = Color.White)
                                }
                            }
                        }



                }


            }
        }
        if (j == 4) {
            Column(
                modifier = Modifier.height(150.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .fillMaxHeight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .background(Color.Cyan)
                            .border(1.dp, Color.Blue)
                    ) {
                        Text(
                            text = ("Thanks for taking Quiz." +
                                    "Your Score in this Quiz is $score"),
                            modifier = Modifier.align(Alignment.Center),
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                    }

                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                modifier = Modifier.height(50.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .fillMaxHeight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .background(Color.Cyan)
                            .border(1.dp, Color.Blue)
                    ) {
                        Text(
                            text = ("Do you want to take another quiz?"),
                            modifier = Modifier.align(Alignment.Center),
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                modifier = Modifier.height(80.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .fillMaxHeight(1f)
                ) {
                    Button(
                        onClick = { j = 0 },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                    ) {
                        Text("Yes", fontSize = 30.sp, fontStyle = FontStyle(5), color = Color.White)
                    }
                    Spacer(modifier = Modifier.width(40.dp))
                    Button(
                        onClick = { ++j },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                    ) {
                        Text("No", fontSize = 30.sp, fontStyle = FontStyle(5), color = Color.White)
                    }
                }
            }

        }


        if(j==5){
            Column(
                modifier = Modifier.height(200.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .fillMaxHeight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .background(Color.Cyan)
                            .border(1.dp, Color.Blue)
                    ) {
                        Text(
                            text = ("Thanks for taking Quiz." +
                                    "Come back whenever you want to take another quiz." +
                                    "Send your valuable feedback to us."),
                            modifier = Modifier.align(Alignment.Center),
                            fontSize = 30.sp,
                            color = Color.Black
                        )
                    }

                }
            }
        }
    }
}









class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizTimeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.LightGray
                ) {
                    FirstScreen()
                }
            }
        }
    }
}