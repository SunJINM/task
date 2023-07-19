package homework;

import lombok.*;
import org.junit.Test;

public class HomeWork04 {

    @Test
    public void test01() {
        DayOfWeek dayOfWeek = DayOfWeek.getByCode(8, DayOfWeek.MONDAY);
        switch (dayOfWeek) {
            case MONDAY:
                System.out.println("星期一");
                break;
            case TUESDAY:
                System.out.println("星期二");
                break;
            case WEDNESDAY:
                System.out.println("星期三");
                break;
            case THURSDAY:
                System.out.println("星期四");
                break;
            case FRIDAY:
                System.out.println("星期五");
                break;
            case SATURDAY:
                System.out.println("星期六");
                break;
            case SUNDAY:
                System.out.println("星期日");
                break;
            default:
                break;
        }
        DayOfWeek day1 = DayOfWeek.FRIDAY;
        System.out.println(day1.getCode());
    }

    @Test
    public void test02() {
        DayOfWeekLombok day = DayOfWeekLombok.getByCode(9, DayOfWeekLombok.MONDAY);
        switch (day) {
            case MONDAY:
                System.out.println("星期一");
                break;
            case TUESDAY:
                System.out.println("星期二");
                break;
            case WEDNESDAY:
                System.out.println("星期三");
                break;
            case THURSDAY:
                System.out.println("星期四");
                break;
            case FRIDAY:
                System.out.println("星期五");
                break;
            case SATURDAY:
                System.out.println("星期六");
                break;
            case SUNDAY:
                System.out.println("星期日");
                break;
            default:
                break;
        }

        DayOfWeekLombok day1 = DayOfWeekLombok.FRIDAY;
        System.out.println(day1.getCode());
    }

    @Test
    public void test03() {
        Coordinate point1 = new Coordinate(1, 1);
        Coordinate point2 = new Coordinate(2, 2);

        System.out.println("点 (" + point1.getX() + ", " + point1.getY() + " ) 距离原点的距离："  + point1.distanceToOrigin());
        System.out.println("当前点与point1距离："  + point2.distanceTo(point1));
        System.out.println("point1 与 point2 之间的距离： " + Coordinate.distanceBetween(point1, point2));

    }

    @Test
    public void test04() {
        People people = People.builder().build();

        System.out.println(people.getName());
        System.out.println(people.getAge());
        System.out.println(people.getAddress());
    }
}


/**
 * 作业1：依据总结定义一个枚举
 */
enum DayOfWeek {
    MONDAY(1, "星期一"),
    TUESDAY(2, "星期二"),
    WEDNESDAY(3, "星期三"),
    THURSDAY(4, "星期四"),
    FRIDAY(5, "星期五"),
    SATURDAY(6, "星期六"),
    SUNDAY(7, "星期日");

    private final int code;
    private final String desc;

    DayOfWeek(int value, String desc) {
        this.code = value;
        this.desc = desc;
    }

    /**
     * 根据编码获取信息描述
     * @param code
     * @param defaultIfNull
     * @return DayOfWeek
     */
    public static DayOfWeek getByCode(int code, final DayOfWeek defaultIfNull) {
        for (DayOfWeek day : DayOfWeek.values()) {
            if (day.code == code) {
                return day;
            }
        }
        return defaultIfNull;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

/**
 * 作业3：使用Lombok重写作业1的枚举
 */
@Getter
@ToString
@AllArgsConstructor
enum DayOfWeekLombok {
    MONDAY(1, "星期一"),
    TUESDAY(2, "星期二"),
    WEDNESDAY(3, "星期三"),
    THURSDAY(4, "星期四"),
    FRIDAY(5, "星期五"),
    SATURDAY(6, "星期六"),
    SUNDAY(7, "星期日");

    private final int code;
    private final String desc;

    /**
     * 根据编码获取信息描述
     * @param code
     * @param defaultIfNull
     * @return
     */
    public static DayOfWeekLombok getByCode(int code, final DayOfWeekLombok defaultIfNull) {
        for (DayOfWeekLombok day : DayOfWeekLombok.values()) {
            if (day.code == code) {
                return day;
            }
        }
        return defaultIfNull;
    }
}

/**
 * 作业4：定义坐标点类
 *   + 提供属性：横坐标、纵坐标
 *   + 提供方法：
 *     1. 计算坐标点到原点的距离
 *     2. 计算当前坐标点到另外任意坐标点的距离
 *     3. 计算给定两个坐标点的距离
 */

@Data
@AllArgsConstructor
class Coordinate {
    private double x; //横坐标
    private double y; //纵坐标


    //计算坐标点到原点的距离
    public double distanceToOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    //计算当前坐标点到另外任意坐标点的距离
    public double distanceTo(Coordinate point) {
        double distanceX = x - point.x;
        double distanceY = y - point.y;
        return Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }

    //计算给定两个坐标点的距离
    public static double distanceBetween(Coordinate point1, Coordinate point2) {
        double distanceX = point1.x - point2.x;
        double distanceY = point1.y - point2.y;
        return Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }
}

/**
 * 作业5：验证下原因：对于使用了以上四个注解的 Query、PO、BO、VO 类，
 * 如果属性有默认值，那么需要在属性上增加注解 @Builder.Default
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class People {

    @Builder.Default
    private String name = "Alan";

    @Builder.Default
    private int age = 20;

    private String address = "beijing";
}
