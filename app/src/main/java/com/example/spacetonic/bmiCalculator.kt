package com.example.spacetonic

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun bmiCalculator()
{
    var btnEnableState = false
    var height by rememberSaveable {
        mutableStateOf("")
    }

    var weight by rememberSaveable {
        mutableStateOf("")
    }

    var bmi by rememberSaveable {
        mutableStateOf("")
    }

    var bmiRange: String by rememberSaveable {
        mutableStateOf("")
    }

    val rangeColor=when(bmiRange){
        "Underweight" -> Color.Red
        "Healthy Weight" -> Color.Green
        "OverWeight" -> Color.Magenta
        "Obese" -> Color.Yellow

        else -> {
            MaterialTheme.colorScheme.primary}
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 4.dp, vertical = 8.dp)
    )
    {



        OutlinedTextField(
            value = weight,
            onValueChange = {weight=it},
            label = { Text("Weight") },
            placeholder={Text("Enter your weight in kg")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = height,
            onValueChange = {height=it},
            label = { Text("Height")},
            placeholder={Text("Enter your height in cm")},
            modifier = Modifier.fillMaxWidth()

        )


        Text(text = bmi.toString(),modifier=Modifier.padding(16.dp))

        Text(text=bmiRange.toString(), Modifier.padding(16.dp),color=rangeColor)


        FilledTonalButton(onClick = {
            var bmiVal=(weight.toFloat()/((height.toFloat())/100*(height.toFloat()/100)))
            bmi=bmiVal.toString()
            weight=""
            height=""
            if(bmiVal<18.5){
                bmiRange="Underweight"
            }else if(bmiVal in 18.5..24.9){
                bmiRange="Healthy Weight"
            }else if(bmiVal in 25.0..29.9){
                bmiRange="Overweight"
            }else{
                bmiRange="Obese"
            }
        },
            enabled= weight!="" && height!=""
        ) {

            Text(text = "Calculate BMI")

        }





    }

}