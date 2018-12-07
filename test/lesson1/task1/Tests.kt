package lesson1.task1

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import kotlin.math.PI

class Tests {
    @Test
    @Tag("Example")
    fun sqr() {
        assertEquals(0, sqr(0))
        assertEquals(4, sqr(2))
        assertEquals(9, sqr(-3))
    }

    @Test
    @Tag("Example")
    fun sqrDouble() {
        assertEquals(0.0, sqr(0.0), 1e-13)
        assertEquals(4.0, sqr(2.0), 1e-13)
        assertEquals(9.0, sqr(-3.0), 1e-13)
    }

    @Test
    @Tag("Example")
    fun discriminant() {
        assertEquals(0.0, discriminant(0.0, 0.0, 0.0), 1e-13)
        assertEquals(0.0, discriminant(1.0, -2.0, 1.0), 1e-13)
        assertEquals(1.0, discriminant(1.0, 3.0, 2.0), 1e-13)
    }

    @Test
    @Tag("Example")
    fun quadraticEquationRoot() {
        assertEquals(2.0, quadraticEquationRoot(1.0, -3.0, 2.0), 1e-13)
        assertEquals(1.0, quadraticEquationRoot(1.0, -2.0, 1.0), 1e-13)
        assertEquals(-3.0, quadraticEquationRoot(1.0, 6.0, 9.0), 1e-13)
    }

    @Test
    @Tag("Example")
    fun quadraticRootProduct() {
        assertEquals(1.0, quadraticRootProduct(1.0, -2.0, 1.0), 1e-13)
        assertEquals(9.0, quadraticRootProduct(1.0, 6.0, 9.0), 1e-13)
        assertEquals(2.0, quadraticRootProduct(1.0, 3.0, 2.0), 1e-13)
    }

    @Test
    @Tag("Trivial")
    fun seconds() {
        assertEquals(30035, seconds(8, 20, 35))
        assertEquals(86400, seconds(24, 0, 0))
        assertEquals(13, seconds(0, 0, 13))
    }

    @Test
    @Tag("Trivial")
    fun lengthInMeters() {
        assertEquals(18.98, lengthInMeters(8, 2, 11), 1e-2)
        assertEquals(2.13, lengthInMeters(1, 0, 0), 1e-2)
    }

    @Test
    @Tag("Trivial")
    fun angleInRadian() {
        assertEquals(0.63256, angleInRadian(36, 14, 35), 1e-5)
        assertEquals(PI / 2.0, angleInRadian(90, 0, 0), 1e-5)
    }

    @Test
    @Tag("Trivial")
    fun trackLength() {
        assertEquals(5.0, trackLength(3.0, 0.0, 0.0, 4.0), 1e-5)
        assertEquals(1.0, trackLength(0.0, 1.0, -1.0, 1.0), 1e-5)
        assertEquals(1.41, trackLength(1.0, 1.0, 2.0, 2.0), 1e-2)
    }

    @Test
    @Tag("Easy")
    fun thirdDigit() {
        assertEquals(8, thirdDigit(3801))
        assertEquals(1, thirdDigit(100))
        assertEquals(0, thirdDigit(1000))
    }

    @Test
    @Tag("Easy")
    fun travelMinutes() {
        assertEquals(216, travelMinutes(9, 25, 13, 1))
        assertEquals(1, travelMinutes(21, 59, 22, 0))
    }

    @Test
    @Tag("Easy")
    fun accountInThreeYears() {
        assertEquals(133.1, accountInThreeYears(100, 10), 1e-2)
        assertEquals(1.0, accountInThreeYears(1, 0), 1e-2)
        assertEquals(104.0, accountInThreeYears(13, 100), 1e-2)
    }

    @Test
    @Tag("Easy")
    fun numberRevert() {
        assertEquals(874, numberRevert(478))
        assertEquals(201, numberRevert(102))
    }

    fun myFun(input: String) : Any {
        var file = input
        var result = ""
        var kol = 1
        var j = 1


        for (i in 0 until file.length) {
            if (file[i] == file[i + 1])
                kol++
            else {
                kol = 1
                if (kol != 1)
                    result += kol.toString()
                result += file[i].toString()
            }
        }
//        var pair = mutableListOf<Pair<String, String>>()
//        pair.add(j, Pair("", file[0].toString()))
//        for (i in 1..file.length) {
//            if (file[i] == file[i - 1])
//                kol++
//            else {
//                pair[j].first += kol.toString()
//                kol = 1
//                j++
//                pair.add(j, Pair("", file[i].toString()))
//            }
//            print(pair)
//        }
//
//
//        var pair = mutableListOf<String>()
//        pair[j] = file[0].toString()
//
//        for (i in 1..file.length) {
//            if (file[i] == file[i - 1])
//                kol++
//            else {
//                if (kol != 1)
//                pair[j] = kol.toString() + pair[j]
//            }
//                kol = 1
//                j++
//                pair[j] = file[i].toString()
//            }
//        print(pair.joinToString())
//        return pair.joinToString("")
//
       // while
//        while (file != "") {
//            i = 1
//            while (file[0] == file[i] && file.length > i)
//                i++
//            println(i)
//            result += file[0]
//            file.droifp(i)
//            if (i != 1)
//                result += i.toString()
//
//        }


//        for (i in 0 until file.length) {
//            if (i != file.length && file[i] == file[i + 1])
//                kol++
//            else {
//                result += file[i].toString()
//                if (kol != 1)
//                    result += kol.toString()
//                kol = 1
//            }
//        }
//        while (file != "") {
//
//        }

//        file.forEachIndexed { index, c ->
//            if (c == file[index + 1])
//                kol++
//            else {
//                result+= c.toString()
//                if (kol != 1)
//                    result+= index.toString()
//                kol = 0
//            }
//        }
//        for (i in 0..file.length) {
//            if (file[i] == file[i + 1] && i != file.length)
//                kol++
//            else {
//
//            }
//
//        }
        return result
    }

    @Test
    fun myFun () {
        Assertions.assertEquals("a3bab2cb3", myFun("aaababbcbbb"))
    }
}