package com.example.pruebaevaluable09_10_24

import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    fun main() {
        val array = Array(10) { it.toDouble() }

        val sumatorio = f2(array) { arr ->
            arr.sum()
        }

        println("Sumatorio del array: $sumatorio")
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
    fun f2(array: Array<Double>, sumOperation: (Array<Double>) -> Double): Double {
        return sumOperation(array)
    }



}