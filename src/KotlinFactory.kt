class KotlinFactory {


    /**
     * 这个宝牛汽车有自己的特性
     */
    internal class BaoNiu : CarModel {
        private var model: String? = null

        override fun say() {
            println(this.model)
        }

        override fun setModel(model: String) {
            this.model = model
        }
    }

    /**
     * 汗牛汽车跟其他的汽车也是不一样
     */
    internal class HanNiu : CarModel {
        private var model: String? = null

        override fun say() {
            println(this.model)
        }

        override fun setModel(model: String) {
            this.model = model
        }
    }

    /**
     * 则是抽象的汽车模型
     */
    internal interface CarModel {
        fun say()

        fun setModel(model: String)
    }

    /**
     * 产生了大规模的工厂，面很有不同的车间，生产不同的汽车
     */
    abstract class AbstractFactory {
        /**
         * 宝牛车间
         *
         * @return
         */
        internal abstract fun createBaoNiuCar(): CarModel

        /**
         * 汗牛车间
         *
         * @return
         */
        internal abstract fun createHanNiuCar(): CarModel
    }

    /**
     * 工厂生产不同的汽车，同样的汽车也有不同的属性
     */
    class CarFactory : AbstractFactory() {

        override fun createBaoNiuCar(): BaoNiu {
            return BaoNiu()
        }

        override fun createHanNiuCar(): HanNiu {
            return HanNiu()
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val factory = CarFactory()
            val car1 = factory.createBaoNiuCar()
            car1.setModel("我是宝牛品牌汽车，产自CarFactory，实现了自己的特性")
            car1.say()

            val car2 = factory.createHanNiuCar()
            car2.setModel("我是汗牛汽车，我和上面的不一样")
            car2.say()
        }
    }
}