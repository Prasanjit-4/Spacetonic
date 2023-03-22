package com.example.spacetonic

sealed class Screens(val route:String){
    object SplashScreen:Screens("main_screen")
    object calcScreen:Screens("calc_Screen")

}