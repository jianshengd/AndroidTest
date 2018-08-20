package com.example.jianshengd.kotline

/**
 * Created by jianshengd on 2018/8/20
 */
class KotlinTest {
    //定义常量
    val name:String="123"
    //定力list
    private val score= arrayListOf(50)
    //定义数组。值内容1到10
    private var  arr=1 .. 10
    //不初始化变量
    lateinit var noInit:String
    //变量允许为空
    var age:String? = null
    //抛出空指针异常
//    var age1=age!!
    //不做处理，返回null
    var age2=age?.toInt()
    //为空返回-1
    val age3 = age?.toInt() ?: -1

    val man =true
    //定义变量，值由get()得到
    val sex:String
        get() = if (man)"男人" else "女人"

    var birth:String="1991"
        get() = field.toUpperCase()
        set
    //可边长函数
    fun varLen(vararg args:Int){
        args.forEach { print(it) }
    }

    fun lambdaFun(){
        //lambda匿名函数
        val lambda:(Int,Int)->Int={x,y->x+y}
        print(lambda(1,3))
    }

    fun stringTemplate(){
        //字符串模板1
        var a = 1
        val s1 = "a is $a"
        println(s1)
        //字符串模板2
        a = 2
        val s2 = "${s1.replace("is", "was")}, but now is $a"
        println(s1)
        println(s2)
    }
    //允许返回null
    fun enableNull(str:String?):Int?{
        return str?.toInt()
    }
    //区间的使用
    fun interval(){
        //输出1-4
        for(i in 1..4) print(i)
        println()
        //没有输出
        for (i in 4..1) print(i)
        println()
        //step,表示一次执行几个步骤/ 等同于步骤 +=n
        for (i in 1..4 step 2) print(i)
        println()
        //输出4-1,跳过几个步骤
        for (i in 4 downTo 1 step 2) print(i)
        println()
        //输出1-3，排除最后一个。 相当于 [1,4），左闭右开
        for (i in 1 until 4) print(i)
    }
    //比较变量
    fun compare(){
        val a: Int = 128
        val b: Int? = a
        val c: Int? = a
        //比较地址
        if (b===c){
            println("b和c地址相同")
        }else{
            println("b和c地址不同")
        }
        //比较值
        if (b==c){
            println("b和c值相同")
        }else{
            println("b和c值不同")
        }
    }
    //条件判断
    fun condition(any:Any){
        //if结果直接赋值
        var a = if (any is Int) "any是Int" else "any不是Int"
        println(a)
        //when(x) 方式使用
        when(any){
            1-> println("any== 1")
            2-> println("any== 2")
            3,4-> println("any==3或4")
            in 5..9-> println("any==5-9")
            !in 100..109-> println("any不在100-109")
            is String-> println("any是String")
            else->
                println("any==其他")
        }
        //when{}方式使用
        when{
            any is Long-> println("any是Long")
            else -> println("any是其他类型")
        }
    }
    //标签处返回
    fun labelReturn(){
        var arr= listOf(1,2,3,4,5)
        arr.forEach(){
            if (it == 4) return@forEach
            println(it)
        }

    }

    fun test() {
        //        f.invoke()
//        for (i in arr) {
//            println(i)
//        }
//        arr.forEach { print(it) }
//        score.add(60)
//        varLen(1,2,3,4)
//        lambdaFun()
//        stringTemplate()
//        println(enableNull(null))
//        interval()
//        compare()
//        condition(101)
        labelReturn()
    }
    fun main()=1

    fun max(a:Int,b:Int)=if (a>b)a else b
}