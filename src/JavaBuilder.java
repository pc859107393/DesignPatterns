import java.io.Serializable;

/**
 * Java建造者模式bean
 */
public class JavaBuilder implements Serializable {
    private String name;
    private String tag;
    private int age;
    private boolean sex;
    private String words;

    //在Java中我们很多时候会有Java bean存在，一般来讲当bean参数较多时候，推荐使用建造者模式

    public JavaBuilder() {
    }

    public JavaBuilder(String name, String tag, int age, boolean sex, String words) {
        this.name = name;
        this.tag = tag;
        this.age = age;
        this.sex = sex;
        this.words = words;
    }

    public static class Builder {
        private String name;
        private String tag;
        private int age;
        private boolean sex;
        private String words;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder tag(String tag) {
            this.tag = tag;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder sex(boolean sex) {
            this.sex = sex;
            return this;
        }

        public Builder words(String words) {
            this.words = words;
            return this;
        }

        public JavaBuilder build(){
            return new JavaBuilder(name,tag,age,sex,words);
        }
    }
}
