package cn.com.yves.enumeration.api1;

public class Test {

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        /**
         * 1.获取枚举的-实例:
         *
         * 获取单个实例 ,获取所有实例
         *
         * 获取了枚举的实例就可以调用父类Enum中的方法
         */
        Car[] instances = Car.values();// 获取所有实例
        Car instance1 = Car.BAOMA;// 获取单个实例
        Car instance2 = Car.valueOf(Car.class, "BAOMA");
        Car instance3 = Car.valueOf("BAOMA");// 根据 枚举实例的名称获取枚举实例(区分大小写)
        //Car instance = Car.valueOf("baoma");//这里名填写的是不存在的名句的名称,运行会抛出异常IllegalArgumentException:  "No enum const " + enumType +"." + name

        /**
         * 2.调用父类Enum中的-静态方法
         *
         * 具体解释可以看获取枚举实例部分.
         *
         */
        Car[] values = Car.values();
        Car car = Car.valueOf("BAOMA");
        Car valueOf = Car.valueOf(Car.class, "BAOMA");//参数:Class<Car> enumType, String name

        /**
         * 3.调用父类Enum中的-实例方法(Enum中已经重写的方法:比如 compareTo,toString,equals...)
         */
        Car ins = Car.BAOMA;
        boolean equ = ins.equals(Car.BAOMA);// true
        String name = ins.toString();// 放回name 也就是定义实例的名称,比如BAOMA
        int result = Car.BAOMA.compareTo(Car.BENCI);// 比较此枚举与指定对象的顺序,也就是枚举的声明的顺序  >0 代表benci在baoma后面.
        System.out.println(Car.BAOMA == instance3);//true

        /**
         * 4.调用父类Enum中特有的方法: name, ordinal
         * 
         * 
         */
        Car ins2 = Car.BAOMA;
        String name2 = ins2.name();// 获取枚举实例的生命的 名称,如BAOMA
        int ordina2 = ins2.ordinal();// 获取枚举实例 声明的位置,从0开始计算

        System.out.println();
    }

}
