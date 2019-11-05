package enums;

public enum MyEnum {


    ONE(1,"齐"),
    TWO(2,"楚"),
    THREE(3,"燕"),
    FOUR(4,"韩"),
    FIVE(5,"赵"),
    SIX(6,"魏");



    private Integer code;
    private String name;

    MyEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }

    public static String get(Integer index){

        MyEnum[] myEnums = MyEnum.values();

        for (MyEnum myEnum : myEnums) {

            if(index == myEnum.code){

                return myEnum.name;
            }
        }

        return null;
    }


}
