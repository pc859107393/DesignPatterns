/**
 * 适配器模式
 */
public class AdapterDesign {
    public static void main(String[] args) {
        System.out.println("拿到适配器，插入插座后：\n");
        PowerInterface powerInterface = new NotepadPowerAdapter();
        powerInterface.inputPower();
    }
}

/**
 * 首先产生拥有一个220v的电源
 */
class PowerSrc {
    private int defPower = 220;

    public int outputPower() {
        return defPower;
    }
}

/**
 * 接着我们需要给笔记本电脑一个圆孔的直流电输入接口
 */
interface PowerInterface {
    int inputPower();
}

class NotepadPowerAdapter extends PowerSrc implements PowerInterface {

    @Override
    public int inputPower() {
        //拿到默认的交流电220v
        int exchangePower = outputPower();
        System.out.println("适配器启动了，接入交流电：" + exchangePower);
        int inputPower = exchangePower / 10;
        System.out.println("适配器工作ing，经过一番骚操作转出直流电：" + inputPower);
        return inputPower;
    }
}