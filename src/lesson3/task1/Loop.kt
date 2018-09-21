@file:Suppress("UNUSED_PARAMETER", "UNUSED_EXPRESSION")
package lesson3.task1

import lesson1.task1.sqr
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

const val ten = 10.0

fun pow(num: Double,y: Int): Double {
    var z: Double = 1.0
    var r = num
    for(i in 1..y)
        z *= r
    return z
}
fun kol(num: Int): Int {
    var k = 0
    var n = abs(num)
    if(n == 0) return 1
    while(n > 0) {
        k ++
        n /=10
    }
    return k
}
fun del(m: Int, n: Int): Int {
    var k: Int
    var nok: Int
    var M = m
    var N = n
    nok = M * N
    while (M != N) { //проверяем числа на неравенство

        if (M > N)// выбираем большее число
            M -= N //находим наибольший общий делитель
        else
            N -= M
    }
    k = nok / M
    return k
}

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n/2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int = kol(n)


/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
 fun fib(n: Int): Int {
    var result: Int = 0
    var n2: Int = 1 // на 2 меньше заданного
    var n1: Int = 1 // на 1 меньше заданного

    if (n == 1 || n == 2)
        return 1
    else for (i in 3..n) {
        result = n1 + n2
        n2 = n1
        n1 = result
    }
    return result

}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int  = del(m,n)



/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var del = 2
    while (n % del != 0) {
        del++
    }
    return del
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var del: Int
    var maxdel: Int = 1
    for (del in 2 until n)
        if (n % del == 0 && del > maxdel )
            maxdel = del
    return maxdel


}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    var end: Int // число, до которого мы будем считать
    if (m > n)
        end = n
    else
        end = m
    for (i in 2..end) {
        if (n % i == 0 && m % i == 0)
            return false
    }
    return true

}



/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    var k: Int
    var N: Int
    var bool: Boolean = false
    for (k in m..n) {
        if (sqrt(k.toDouble()) % 1 == 0.0)
            return true
    }
    return false
}

/**
 * Средняя
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var number = x
    var k = 0
    while (number != 1) {
        if (number % 2 == 0) {
            number /= 2
            k++
        } else {
            number = 3 * number + 1
            k++
        }
    }
    return k
}


/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */


fun sin(x: Double, eps: Double): Double {
    var p = 0.0
    var s = 1 // Помогает определить, вычитать или суммировать
    var n = 1 //
    var num = x % (2 * PI)
    while (abs((pow(num, n) / factorial(n))) >= eps) {

        if (s % 2 == 1) {
            p += (pow(num, n) / factorial(n))
            n += 2
            s++
        }
        if(s % 2 == 0) {
            p -= (pow(num,n) / factorial(n))
            n +=2
            s++
        }
    }
   return p.toDouble()

}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double {
    var p = 0.0
    var s = 1
    var n = 0
    var num = x % (2 * PI)
    while (abs((pow(num, n) / factorial(n))) >= eps) {
        if (s % 2 == 1) {
            p += (pow(num, n) / factorial(n))
            n += 2
            s++
        }
        if(s % 2 == 0) {
            p -= (pow(num, n) / factorial(n))
            n +=2
            s++
        }
    }
    return p
}



/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var number = n
    var finalnumber = 0
    while (number > 0) {
        finalnumber = finalnumber * 10 + number % 10
        number /= 10
    }
        return finalnumber

    }

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    var number = n
    var palindrom = 0
    while (number > 0) {
        palindrom = palindrom * 10 + number % 10
        number /=10
    }
    return palindrom == n
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    if (n == 0) false

    var number: Int = n
    var chislo: Int = n % 10
    while (number >0) {
        if (number % 10 == chislo)
            number /=10
        else
            return true
    }
    return false
}


/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    var k = 1 // количество цифр в чисел
    var p = 1.0 // последовательность
    var num = 2

    while (n !=k) {
        p = pow(ten, kol(sqr(num))) + sqr(num)
        k += kol(sqr(num))
        while (k > n) {
            k--
            p /= 10
        }
        num++

    }
    p %=10
    return p.toInt()


}



/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {

    var k = 1 // количество цифр в чисел
    var p = 1.0 // последовательность
    var num = 2

    while (n != k) {
        p = pow(ten, kol(fib(num)))  + fib(num)
        println(p)
        k += kol(fib(num))
        while(k > n) {
            k--
            p /= 10
        }
        num++
    }
        p %= 10
        return p.toInt()
}


