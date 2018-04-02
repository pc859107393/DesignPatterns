class KotlinFactory {

    /**
     * 在有个一些"福特大叔"后，我们做其他事情的人，只有找这些"福特大叔"造车车。
     */
    internal inner class BaoNiu {
        init {
            println("我生产了一个宝牛汽车！")
        }
    }

    internal inner class HanNiu {
        init {
            println("我生产了一个汗牛汽车！")
        }
    }

    fun createCar(clazz: Class<*>): Any? {
        return when {
            clazz.name == BaoNiu::class.java.name -> BaoNiu()
            clazz.name == HanNiu::class.java.name -> HanNiu()
            else -> null
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val factory = KotlinFactory()
            factory.createCar(BaoNiu::class.java)
        }
    }
}