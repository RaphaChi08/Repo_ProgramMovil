package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
            }
        }
    }
}

@Preview
@Composable
fun DiceRollerApp(){
    DiceWithButton(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}

@Composable
fun DiceImage(modifier: Modifier = Modifier, result1: Int, result2: Int){
    Row (modifier = modifier, verticalAlignment = Alignment.CenterVertically
    ){
        val imageResource1 = getRandomDiceImage(result1)
        Image(painter = painterResource(id = imageResource1), contentDescription = result1.toString())
        Spacer(modifier = Modifier.height(16.dp))
        val imageResource2 = getRandomDiceImage(result2)
        Image(painter = painterResource(id = imageResource2), contentDescription = result2.toString())
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun DiceWithButton(modifier: Modifier = Modifier){
    var result1 by remember { mutableStateOf(1) }
    var result2 by remember { mutableStateOf(1) }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        DiceImage(modifier = Modifier, result1, result2)
        Button(onClick = { result1 = (1..6).random();
            result2 = (1..6).random()}) {
            Text(stringResource(R.string.roll))
        }
    }
}

private fun getRandomDiceImage(result: Int): Int{
    return when (result){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
}

