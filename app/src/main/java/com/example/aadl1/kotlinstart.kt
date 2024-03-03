package com.example.aadl1

import android.support.v4.os.IResultReceiver.Default


fun main (){

    val firstName = "Pavels";
    val lastName = "Tuliss";
    var number = 45;
    number = 22;

    print("My name is $firstName $lastName\n");

    val myList = listOf("a", "b");
    val numberList = mutableListOf("c", "b");

    numberList.add("e");

    val myExtendedList = myList + numberList;

    println(myExtendedList);

    var postgraduateTitle : String? = null;

    var form : String = postgraduateTitle ?: "fallback"
    //the same

    if(postgraduateTitle == null){
        form = "fallback"
    }

    greeting("Jamie", null);
    greeting("Andrea", "PhD")
    greetPerson(::helloGreeter, "Jamie");
    greetPerson(::hiGreeter, "Andrea ");

    greetPerson(
        {name, _ -> println("Good morning $name")}
        , "Peter"
    )

}


//Java: public Int greeting (String name, String postTitle
fun greeting (name: String, postTitle: String?) : Int{
    println("Hello $name ${postTitle ?:  "Person"}")

    return 5;
}

fun helloGreeter (name: String, postTitle: String?){
    println("Hello $name ${postTitle ?:  "Person"}")
}

fun hiGreeter (name: String, postTitle: String?){
    println("hi $name ${postTitle ?:  "Person"}")
}

fun greetPerson(greeterFun: (String, String?) -> Unit, name: String){
    greeterFun(name, null);
}