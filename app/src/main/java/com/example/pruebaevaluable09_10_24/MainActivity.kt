package com.example.pruebaevaluable09_10_24

import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    fun main() {
        val resultado = f1(1.0, -3.0, 2.0) { x1, x2, _ ->
            kotlin.math.abs(x1) + kotlin.math.abs(x2)
        }
        println("Resultado de la ecuación: $resultado")
    }
    fun ecuacionSegundoGrado(a:Double, b:Double, c:Double): Array<Double>{
        val discriminante = b * b - 4 * a * c
        return when {
            discriminante > 0 -> {
                val x1 = (-b + Math.sqrt(discriminante)) / (2 * a)
                val x2 = (-b - Math.sqrt(discriminante)) / (2 * a)
                arrayOf(1.0, x1, x2)
            }
            discriminante == 0.0 -> {
                val x1 = -b / (2 * a)
                arrayOf(2.0, x1, 0.0)
            }
            else -> {
                arrayOf(0.0, 0.0, 0.0)
            }
        }
    }
    fun f1(a: Double, b: Double, c: Double, operacion: (Double, Double, Double) -> Double): Double {
        val resultado = ecuacionSegundoGrado(a, b, c)
        return when (resultado[0].toInt()) {
            0 -> 0.0
            2 -> resultado[1]
            else -> operacion(resultado[1], resultado[2], 0.0)
        }
    }
}