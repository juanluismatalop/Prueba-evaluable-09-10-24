package com.example.pruebaevaluable09_10_24

import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    fun main() {
        f1(1.0, -3.0, 2.0, { x1, x2, _ -> kotlin.math.abs(x1) + kotlin.math.abs(x2) }) { a, b, c ->
            if (a == 0.0 && b == 0.0 && c == 0.0) 1.0 else a * b * c
        }
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
    fun f1(a: Double, b: Double, c: Double, operacion: (Double, Double, Double) -> Double, lambda: (Double, Double, Double) -> Double): Double {
        val resultado = ecuacionSegundoGrado(a, b, c)
        val operacionResultado = when (resultado[0].toInt()) {
            0 -> 0.0
            2 -> resultado[1]
            else -> operacion(resultado[1], resultado[2], 0.0)
        }

        val lambdaResultado = lambda(a, b, c)

        println("Resultado de la ecuación: $operacionResultado")
        println("Resultado de la lambda: $lambdaResultado")

        return operacionResultado
    }



}