class KotlinFactory {


    /**
     * 现在客户量上来了，然后就有了专门的工厂来接单生产，客户只关心他们所要的
     */
    internal inner class BaoNiu : CarFactory() {
        override fun createCar() {
            println("我生产了一个宝牛汽车！")
        }
    }

    internal inner class HanNiu : CarFactory() {
        override fun createCar() {
            println("我生产了一个汗牛汽车！")
        }
    }

    internal fun initFactory(clazz: Class<*>): CarFactory? {
        return when (clazz.name) {
            BaoNiu::class.java.name -> BaoNiu()
            HanNiu::class.java.name -> HanNiu()
            else -> null
        }
    }

    /**
     * 生产汽车的人或者机构随着需求的变大，就产生了，所以我们有个进一步的工厂了<br></br>
     * 我们工厂下面有一些工作车间，但是对外他们都是工厂，所以我们不管内部，只需要指明是什么汽车
     */
    internal abstract inner class CarFactory {
        abstract fun createCar()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val factory = KotlinFactory().initFactory(BaoNiu::class.java)
            //因为这个工厂可能找不到你要生产的类型，所以必须判断不能为空
            factory?.createCar()
        }
    }
}