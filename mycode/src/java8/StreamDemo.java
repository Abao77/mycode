package java8;

import java.util.Arrays;
import java.util.List;

/**
 * 请按照给出数据，找出
 * 偶数ID
 * 年龄大于24
 * 用户名转为大写
 * 用户名字母倒排序
 * 只输出一个
 * 用户名字
 */
class Stream {

    public static void main(String[] args) {

        User u1 = new User(11, "a", 23);
        User u2 = new User(12, "b", 24);
        User u3 = new User(13, "c", 22);
        User u4 = new User(14, "d", 28);
        User u5 = new User(16, "e", 26);


        List<User> userList = Arrays.asList(u1, u2, u3, u4, u5);

        //userList.forEach(System.out::println);

        userList.stream().filter((p) -> {
            return p.getId() % 2 == 0;
        }).filter(p -> {
            return p.getAge() > 24;
        }).map((f) -> {
            return f.getName().toUpperCase();
        }).sorted((o1, o2) -> {
            return o2.compareTo(o1);
        }).limit(1).forEach(System.out::println);


    }


}


class User {

    private int id;
    private String name;
    private int age;

    public User() {

    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
