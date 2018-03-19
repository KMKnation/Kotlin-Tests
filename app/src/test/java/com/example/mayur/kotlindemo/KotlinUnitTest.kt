package com.example.mayur.kotlindemo

import org.junit.Test
import kotlin.properties.Delegates

/**
 * CLASS NAME : KotlinUnitTest
 * CREATED BY : MAYUR KANOJIYA
 * DESCRIPTION : TO EVALUATE EACH SECTION OF TUTORIAL STEP BY STEP
 *
 *
 *
 * @link : https://www.tutorialspoint.com/kotlin/:.
 */
class KotlinUnitTest {

    //TODO :#1 ADD @Test HERE TO CHECK DIFFRENCE BEWTWEEN MUTABLE AND IMMUTABLE
    @Test
    fun kotlinDemo() {

        //val immutable
        val immutable: String = "Hello Kotlin"

        //var mutable
        var mutable = "Hii"
        mutable += mutable

        //test += test will throw an error

        println(immutable)
        println(mutable.removeSuffix("i"))

        /* OUTPUT */
        //Hello Kotlin
        //HiiHi
    }


    /*** BASIC TYPES ***/
    //TODO :#2 ADD @Test HERE TO CHECK ARRAY DECLARATIONS
    @Test
    fun arraylistTest() {
        val array: IntArray = intArrayOf(1, 2, 3, 4)
        println("Hey!! I am array member " + array[2])
        //Hey!! I am array member 3
    }

    //mutable and immutable test
    //TODO :#3 ADD @Test HERE TO CHECK DIFFRENCE BEWTWEEN MUTABLE AND IMMUTABLE IN LIST
    @Test
    fun testMutableListAndImmutable() {
        val numbers: MutableList<Int> = mutableListOf(1, 2, 3, 4)
        val readOnlyList: List<Int> = numbers

        println("immutable list" + numbers)

        numbers.add(5)
        println("immutable list after addition" + numbers)

        numbers.add(5)
        println("immutable list after adding same value again" + numbers)

        println("mutable list" + readOnlyList)

        /*
        notice that even assigning readOnlyList to numbers before adding new elements to numbers
        its adding in readOnlyList also

        also defining readOnlyList without dataType also works

        OUTPUT :
        immutable list[1, 2, 3, 4]
        immutable list after addition[1, 2, 3, 4, 5]
        immutable list after adding same value again[1, 2, 3, 4, 5, 5]
        mutable list[1, 2, 3, 4, 5, 5]

        */

        //mutable objects can't be modified .add .clear like ops not allowed
        //        readOnlyList.clear()
        //        numbers.clear()

    }

    //TODO :#4 ADD @Test HERE TO CHECK first() last() filter() HashMap and HasSet declarations
    @Test
    fun testHashMapAndHashSet() {

        val list = listOf(1, 2, 3, 4)

        println("First elements of list " + list.first())
        println("First elements of list using dollar ${list.first()}")
        println("Last element of list ${list.last()}")
        println("Get set method like java for 1st element ${list.get(0)}")
        println("for last element ${list.get(list.size - 1)}")

        //it is already defined int O.o
        println("filter in list ${list.filter { it % 2 == 0 }}")

        //seems like it is iterator in filter :P
        println("filtering specific element ${list.filter { it == 3 }}")

        //will return empty list
        println("filtering element that not in list ${list.filter { it == 10 }}")

        //standard declaration
        val readWriteMap = hashMapOf("foo" to 1, "bar" to 2)
        println("printing foo's value ${readWriteMap["foo"]}")

        val rwMap: HashMap<String, Int> = hashMapOf("daru" to 3, "wine" to 4)
        println("printing wine's value ${rwMap["wine"]}")

        val CONST = "wine2"
        rwMap.put(CONST, 5)
        println("printing $CONST's value ${rwMap[CONST]}")

        val constMap = hashMapOf(CONST to "stringvalue")
        println("const map directly print $constMap")

        val hashSetTemp = hashSetOf<String>("a", "b", "c", "mayur", "paresh", "mayur", "paresh", "c")
        println("hash set which never contain duplicates $hashSetTemp")

        /*  OUTPUT  */

        //First elements of list 1
        //First elements of list using dollar 1
        //Last element of list 4
        //Get set method like java for 1st element 1
        //for last element 4
        //filter in list [2, 4]
        //filtering specific element [3]
        //filtering element that not in list []
        //printing foo's value 1
        //printing wine's value 4
        //printing wine2's value 5
        //const map directly print {wine2=stringvalue}
        //hash set which never contain duplicates [a, b, paresh, c, mayur]

    }


    /***    Kotlin - Control Flow   ***/
    //TODO :#5 ADD @Test HERE TO CHECK CONTROL FLOW IN KOTLIN
    @Test
    fun testControlFlow() {

        val a = 5
        val b = 8

        val max: Int

        if (a > b) {
            max = a
        } else {
            max = b
        }

        println("value of max is $max")

        // As expression
        val exp = if (a > b) a else b
        println("value of exp is ${exp}")


        when (a) {
            1 -> println("a is equal to 1")
            2 -> println("a is equal to 2")
            3 -> {
                //3rd block code

            }

            4, 5 -> {
                println("if a = 4 or 5 will execute this block")
            }

            else -> { //block can be add like this
                println("goes into default block")
            }

        }



        println("Executing for loop ...")
        val list = listOf<String>("banana", "apple", "orange", "tamato")
        for (i in list) {
            //  following line will fail cause it returns object like python instead of index
            // println("list item at $i is ${list.get(i)}")

            println("list item " + i)
        }


        //item with index
        println("Executing item with index...")
        for ((counter, item) in list.withIndex()) {
            println("list item at $counter is $item")
        }


        println("Example of while loop")
        var x = 0
        while (x < 5) {
            println("x $x")
            x += 1
        }

        println("Example of do while loop")
        x = 0
        do {
            println("x $x")
            x += 1
        } while (x <= 5)


        /*     OUTPUT    */
        //        value of max is 8
        //        value of exp is 8
        //        if a = 4 or 5 will execute this block
        //        Executing for loop ...
        //        list item banana
        //        list item apple
        //        list item orange
        //        list item tamato
        //        Executing item with index...
        //        list item at 0 is banana
        //        list item at 1 is apple
        //        list item at 2 is orange
        //        list item at 3 is tamato
        //        Example of while loop
        //        x 0
        //        x 1
        //        x 2
        //        x 3
        //        x 4
        //        Example of do while loop
        //        x 0
        //        x 1
        //        x 2
        //        x 3
        //        x 4
        //        x 5


    }

    //TODO :#6 ADD @Test HERE TO CHECK return, break, continue
    @Test
    fun testReturnBreakContinue() {
        val x: Int = 10
        println("value of x is ${doubleMe(x)}")

        exampleOfBreakAndContinue()
    }

    //function to double value
    fun doubleMe(x: Int): Int {
        return 2 * x
    }

    fun exampleOfBreakAndContinue() {

        myLabel@ for (i in 0..10) {
            if (i == 5) {
                println(" i is at 5 hence closing the operation")
                break@myLabel
            } else {
                println(" i is $i")
                continue@myLabel
            }
        }

    }


/***     CLASS INHERITANCE INTERFACE    ***/

    class Animal {

        private val name: String = "Animal"

        fun speak() {
            println(name + " can speak")
        }

    }


    //TODO :#7 ADD @Test HERE TO CHECK Class Implementation
    @Test
    fun testClass() {
        val animal = Animal()
        animal.speak()

        /* OUTPUT */
        //Animal can speak
    }

    //Nested Class
    class Outer {
        private val name: String = "Outer variable"

        class Nested {

            fun nestedMethod() {
                //uncomment to see error that user is not able to use outer class var directly in Nested class
                //println("nestedMethod able to use outer class var ${name}")
                println("nested method called")
            }
        }
    }

    //TODO :#8 ADD @Test HERE TO CHECK Outer Class Implementation
    @Test
    fun testOuter() {
        println("Executing method diretly through object")
        //check syntax of object
        val outer = Outer.Nested().nestedMethod()

        val nestedObj = Outer.Nested()
        println("Using Nested Object")
        println(nestedObj.nestedMethod())

        //uncomment to see error that using object Nested class in not usable
        //val outerObj = Outer()
        //val nested = outerObj.Nested()

        /* OUTPUT */
        //        Executing method diretly through object
        //        nested method called
        //        Using Nested Object
        //        nested method called

    }


    //Inner Classs
    class IOuter {
        val name: String = "IOuter Variable"

        fun finalName() = "This is final and can't be changed"

        inner class Inner {
            //able to use outer class variable
            fun innterMethod() = name + " used"

            fun innerMethod1() {
                val name = name + " modified"
                println(name + " used")
            }
        }
    }

    //TODO :#9 ADD @Test HERE TO CHECK Inner Class Implementation
    @Test
    fun testInner() {
        //check syntax of object
        val outer = IOuter().Inner().innterMethod()
        println(outer) //outer function has stored string value directly without return

        IOuter().Inner().innerMethod1()

        println(IOuter().finalName())

        /* OUTPUT */
        //        IOuter Variable used
        //        IOuter Variable modified used
        //        This is final and can't be changed

    }

    /***    STATIC FUNCTIONALITY  also called "Object Extension" in Kotlin  ***/
    class Foo {
        companion object {
            val KEY: Int = 234
            fun firebaseKey(): String = "34sdfkdaklmklmdklklwaemkldmklmakld"
            fun staticMethodCalled(): Int {
                val a = 4;
                val b = 5;

                return a * b
            }
        }
    }

    //TODO :#10 TO CHECK STATIC OR OBJECT EXTENSION
    @Test
    fun testStaticMethod() {
        println(Foo.KEY)
        println(Foo.firebaseKey())
        println(Foo.staticMethodCalled())

        /* OUTPUT */
//        234
//        34sdfkdaklmklmdklklwaemkldmklmakld
//        20

    }


   /*** ANONYMOUS CLASS | Polymorphism ***/
    interface Human {
        fun think();
    }

    //TODO :#11 TO CHECK INTERFACE IMPLEMENTATION
    @Test
    fun interFaceTest() {

        val programmer = object : Human {
            override fun think() {
                println("Programmer think as a variable flow from one object to another")
            }
        }

        val designer = object : Human {
            override fun think() {
                println("Designer think about pixels and aspect ratio ")
            }
        }

        val manager = object : Human {
            override fun think() {
                println("Think about release date -_-")
            }

        }

        programmer.think()
        designer.think()
        manager.think()

        //WILL PRINT OBJECT ALOS
        //        println(programmer.think())
        //        println(designer.think())


                /* OUTPUT */
        //        Programmer think as a variable flow from one object to another
        //        Designer think about pixels and aspect ratio
        //        Think about release date -_-


    }


    /***        CONSTRUCTORS        ***/

    class Person(val firstName: String, val age: Int) {

    }

    class HUman {

        var fname: String = "Default"
        var age: Int = 0

        //DEFAULT CONSTRUTOR
        constructor()

        //PARAMETERIZED CONSTRUCTOR
        constructor(firstName: String, age: Int) {
            this.fname = firstName
            this.age = age
        }


        //this will just initialized and its value not assigned
        //        constructor(firstName: String, age: Int)

        //COPY CONSTRUCTOR
        //        constructor() overload json or person object above to copy value

        fun say() {
            println("$fname age is $age")
        }
    }


    //TODO :#12 TO CHECK DEFAULT, PARAMETERIZED, COPY CONSTRUCTOR IMPLEMENTATION
    @Test
    fun testConstructors() {
        val person = Person("Mayur", 23)
        println("${person.firstName} age is ${person.age}")

        val human = HUman()
        human.say()

        val humanParam = HUman("Paresh", 18)
        humanParam.say()

        /* OUTPUT */
        //        Mayur age is 23
        //        Default age is 0
        //        Paresh age is 18

    }


    /***    INHERITANCE     ***/

    open class Parent {

        fun say() {
            print("Hey !!")
        }
    }

    class Child : Parent() {

    }


    //TODO :#13 TO CHECK INHERITANCE
    @Test
    fun testInheritance() {

        val child = Child()
        print(child.say())

        /* OUTPUT */
        //        Hey !!kotlin.Unit

    }



    open class AniMal {

        //FOR POLYMORPHISM NEED TO MAKE METHOD THATS OVERRIDING ALSO OPEN
        //        fun speak(){
        //            println("Animal Tune")
        //        }

        open fun speak() {
            println("Animal Tune")
        }
    }

    class Cat : AniMal() {
        //CTRL + INSERT -> override methods also works
        override fun speak() {
            println("Meow... Meow..")
            //super will also call AniMal( Super ) class's speak method also
//            super.speak()
        }
    }

    class Dog : AniMal() {

        override fun speak() {
            println("Bhow.. Bhow..")
        }

    }

    //TODO :#14 POLYMORPHISM IN INHERITANCE
    @Test
    fun testPolyMorphismInheritance() {
        val cat = Cat()
        cat.speak()

        val dog = Dog()
        dog.speak()


        /* OUTPUT */
        //        Meow... Meow..
        //        Bhow.. Bhow..
    }


    /***    INTERFACE EXAMPLE   ***/
    interface InterFaceEx {
//        val a : Int = 5 //DEFINATION VALUE IS NOT ALLOWED AS JAVA

        //ABSTRACT VARIABLE
        val a: Int

        fun sayHello() {  //DEFINATION OF METHOD ALLOWED AS DEFAULT IMPLEMENTATION
            println("InterFaceEx : Hello")
        }

        //ABSTRACT METHOD
        fun sayHi()
    }

    class IEx : InterFaceEx {

        //abstract members and methods are mandatory to implement

        override val a: Int = 5

        override fun sayHi() {
            println("IEX : Hii")
        }

        //uncomment this to override method defination (to change default method implementation of interface)
        //        override fun sayHello() {
        //            println("IEX : Hello")
        //            super.sayHello()
        //        }


    }

    //TODO :#15 TO CHECK INTERFACE IMPLEMENTATION
    @Test
    fun testInterFace() {
        val test = IEx()
        test.sayHello() // if not override this method defination then will call interface's default
        test.sayHi()
        println(test.a)


        /* OUTPUT *?
        IEX : Hello
        InterFaceEx : Hello
        IEX : Hii
        5
         */

    }

    //multi level inheritance also allowed which not allowed in java
    //polymorphism can be achieved in multilevel inheritance here as well
    //multilevel inheritance
    //multiple inheritance also allowed but we can not declare same method in both interface
    interface A {
        fun printMe() {
            println("A : print me")
        }
    }

    interface B : A {

        override fun printMe() {
    //            super.printMe() //remove this cmnt to allow call to A's print me
            println("B : print me")
        }

    }

    class Ex : A, B { //try chainging interface position also

        //uncmnt to change method defination
        //        override fun printMe() {
        ////            super<A>.printMe()    //uncmnt to see change
        ////            super<B>.printMe()    //uncmnt to see change
        //            println("Sx : I will print my modiefied method")
        //        }
    }
    //TODO :#16 TO CHECK test multi level inheritance
    @Test
    fun testMutliLevelInheritance() {
        val ex = Ex()
        ex.printMe()

        /* OUTPUT */
        // B : print me
    }


    /***  Visibility Control  ***/

    class InternalEx {

        internal val i = 0
        internal fun doInternal() {
            print(i)
        }

        private val j = 0
        private fun doPrivate() {
            print(j)
        }

        protected val k = 0
        protected fun doProtected() {
            print(k)
        }

        public val l = 0
        public fun doPublic() {
            print(l)
        }


    }

    //TODO :#17 TO CHECK Visibility Control Implementation
    @Test
    fun testInternal() {

        //public can be used everywhere
        val public = InternalEx().doPublic() //ALLOWED
        //internal can be used everywhere only inside this package
        val internal = InternalEx().doInternal() //ALLOWED
//        val private = InternalEx().doPrivate() //NOT ALLOWED
//        val protected = InternalEx().doProtected() //NOT ALLOWED
    }


    /*  FUNCTION EXTENTION    */
    class Programmer {
        var skills = "null"

        fun printMySkills() {
            println(skills)
        }

    }

    //EXTENTION FUNCTION OF PROGRAMMER CLASS
    fun Programmer.addToMySkills(programmer: Programmer): String {
        return this.skills + ", " + programmer.skills
    }

    //TODO :#18 TO CHECK FUNCTION EXTENSION
    @Test
    fun testFunctionExtentions() {

        val androidDeveloper = Programmer()
        androidDeveloper.skills = "Java, Kotlin"
//        androidDeveloper.printMySkills()

        val webDeveloper = Programmer()
        webDeveloper.skills = "PHP, Angular,Html, Css"
//        webDeveloper.printMySkills()

        val iosDeveloper = Programmer()
        iosDeveloper.skills = "Swift, Objective - C"
//        iosDeveloper.printMySkills()

        val fullStackDeveloper = Programmer()
        fullStackDeveloper.skills = androidDeveloper.addToMySkills(webDeveloper)
        fullStackDeveloper.skills = fullStackDeveloper.addToMySkills(iosDeveloper)
        fullStackDeveloper.printMySkills()

        /* OUTPUT */
//        Java, Kotlin, PHP, Angular,Html, Css, Swift, Objective - C

    }


    /* DATA CLASS */

    //The work to build Model class in java can be reduce due to this
    data class Book(var name: String, var publisher: String, var ratings: Int)

    //TODO :#19 TO CHECK DATA CLASS IMPLEMENTATION
    @Test
    fun testDataClass() {
        val book = Book("Ek thi Dayan",
                "Mayur",
                7)
        println("Name : ${book.name}")
        println("Publisher : ${book.publisher}")
        println("Ratings : ${book.ratings}")
        println("Book Info :${book}")
        println("Book HashCode : ${book.hashCode()}")

        book.ratings = 9
        print("Book Info Mod : ${book}")

        /* OUTPUT */
        //        Name : Ek thi Dayan
        //        Publisher : Mayur
        //        Ratings : 7
        //        Book Info :Book(name=Ek thi Dayan, publisher=Mayur, ratings=7)
        //        Book HashCode : 1273449225
        //        Book Info Mod : Book(name=Ek thi Dayan, publisher=Mayur, ratings=9)
    }


    /* SEALED CLASSES */
    sealed class Verna() {

        open val isSunRoofEnabled = false

        class Sx : Verna() {

            override val isSunRoofEnabled: Boolean = true

        }

        class Ex : Verna() {

            //            override var isSunRoofEnabled : Boolean = false
        }

    }

    //TODO :#20 TO CHECK SEALED CLASS IMPLEMENTATION
    @Test
    fun testSealedClasses() {

        if (Verna.Ex().isSunRoofEnabled) {
            println("Sunroof given in Ex Model")
        } else if (Verna.Sx().isSunRoofEnabled) {
            println("Sunroof given in Sx model")
        } else {
            println("Sunroof is not given in any model")
        }

        val car: Verna = Verna.Sx()

        when (car) {
            is Verna.Ex -> {
                print("Ex model taken")
            }
            is Verna.Sx -> {
                print("Sx model taken")
            }
        }

        /* OUTPUT */
        //        Sunroof given in Sx model
        //        Sx model taken

    }


    /* GENERICS */

    fun <T> genralPrint(input: T) {
        println(input)
    }

    //TODO :#21 TO CHECK GENERICS IMPLEMENTATION
    @Test
    fun testGenerics() {
        genralPrint("Hii")
        genralPrint(50)
        genralPrint(1.00)


        /* OUTPUT */
        //        Hii
        //        50
        //        1.0

    }


    /*      DELEGATION      */

    interface Base {
        fun printMe()
    }

    class BaseEx(val x: Int) : Base {

        override fun printMe() {
            println(2 * x)
        }

    }

    class Derived(base: Base) : Base by base


    //TODO :#22 TO CHECK DELEGATION
    @Test
    fun testDelegation() {
        val basex = BaseEx(10)
        val derived = Derived(basex)
        derived.printMe()
    }

    //TODO :#23 TO CHECK lazy IMPLEMENTATION
    @Test
    fun testLazy() {
//        if the initialization of a value throws an exception, it will attempt to reinitialize the value at next access.
        val word: String by lazy {
            "Hello"
        }

        println(word)

        /* OUTPUT */
//        Hello
    }


    //Observable
    class User {

        var name: Int by Delegates.observable(1) { prop, old, new ->
            println("$prop --> $old --> $new")
        }

    }


    //TODO :#24 TO CHECK OBSERVABLE IMPLEMENTATION
    @Test
    fun testObservable() {
        val user: User = User();
        user.name = 2
        user.name = 0
        user.name = 3
        user.name = 4
        user.name = 7

        /* OUT PUT */
        //        property name (Kotlin reflection is not available) --> 1 --> 2
        //        property name (Kotlin reflection is not available) --> 2 --> 0
        //        property name (Kotlin reflection is not available) --> 0 --> 3
        //        property name (Kotlin reflection is not available) --> 3 --> 4
        //        property name (Kotlin reflection is not available) --> 4 --> 7

    }


    /* LAMBDA FUNCTION */

    fun printInline(str: String, action: (String) -> Unit) {
        action(str)
    }

    //TODO :#25 TO CHECK LAMBDA IMPLEMENTATION
    @Test
    fun testLambda() {
        val mylambda: (String) -> Unit = { s: String -> println(s) }
        val myLambda = { i: Int -> println(2 * i) }

        val myFunctionalLambda = { x: Int, y: Int ->
            //{ adding curly brace will not call println
            println("x($x) + y($y) = ${x + y}")
            val ans = x + y
            println("ans doubles as ${2 * ans}")
            //}
        }

        mylambda("Hii")
        myLambda(50)
        myFunctionalLambda(10, 20)


        //INLINE FUNCTION
        printInline("hii", mylambda)


        /* OUTPUT */
        //        Hii
        //        100
        //        x(10) + y(20) = 30
        //        ans doubles as 60
        //        hii
    }


    /*  Destructuring Declarations */

    data class Student(var name: String, var age: Int)

    //TODO :#26 TO CHECK Destructuring Declarations IMPLEMENTATION
    @Test
    fun testDesturcturingDeclaration() {
        val student: Student = Student("Mayur", 23)
        val (name, age) = student

        println("Name is ${name} and age is ${age}")

//        val (name1, age1, marks) = student

        //TRY DECLARING MULTIPLE VARIABLES OF SAME TYPE
//        val ( i, j, k, l, m, n) =

        /* OUTPUT */
//        Name is Mayur and age is 23
    }


    /* Exception Handling */
    //TODO :#27 TO CHECK EXCEPTION HANDLING
    @Test
    fun testExceptionHandling() {
        try {
            val a: Int = 10
            val b: Int = 20 //change
            println("Devide by zero test ${a / b}")
        } catch (ex: Exception) {
            //GOT ArithmeticException instead of DevideByZero
            ex.printStackTrace()
        } finally {
            println("Must executes in any cases")
        }
    }


}
