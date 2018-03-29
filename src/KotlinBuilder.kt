class KotlinBuilder {
    //kotlin变量默认非空，所以说我们可以使用延迟加载也可以使用默认值定位可空的变量
    private var name: String? = null
    private var tag: String? = null
    private var age: Int? = null
    private var sex: Boolean? = null
    private var words: String? = null

    //在Java中我们很多时候会有Java bean存在，一般来讲当bean参数较多时候，推荐使用建造者模式
    //当然在kotlin中主要的东西也是类似的，但是要注意的是kotlin的构造函数是constructor关键字


    constructor() {}

    constructor(name: String, tag: String, age: Int, sex: Boolean, words: String) {
        this.name = name
        this.tag = tag
        this.age = age
        this.sex = sex
        this.words = words
    }

    class Builder {
        private var name: String? = null
        private var tag: String? = null
        private var age: Int? = null
        private var sex: Boolean? = null
        private var words: String? = null

        //和Java一样，我们默认返回自身就可以完成构造
        fun name(name: String): Builder {
            this.name = name
            return this
        }

        fun tag(tag: String): Builder {
            this.tag = tag
            return this
        }

        fun age(age: Int): Builder {
            this.age = age
            return this
        }

        fun sex(sex: Boolean): Builder {
            this.sex = sex
            return this
        }

        fun words(words: String): Builder {
            this.words = words
            return this
        }

        fun build(): KotlinBuilder {
            return KotlinBuilder(name!!, tag!!, age!!, sex!!, words!!)
        }
    }
}