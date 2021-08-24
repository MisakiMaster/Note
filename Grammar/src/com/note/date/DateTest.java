package com.note.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

/**
 * @author master
 * @title: DateTest
 * @projectName Note
 * @description: 日期时间类的使用
 * @date 2021/8/6 20:00
 */
public class DateTest {
    /**
     * 　　* @description: SimpleDateFormat格式化解析
     * 　　* @param 无
     * 　　* @return void
     * 　　* @throws ParseException解析异常
     * 　　* @author admin
     * 　　* @date 2021/8/6 21:42
     *
     */
    @Test
    public void method1() throws ParseException {
        Date date = new Date();
        //默认格式化样式
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        System.out.println(date);
        // 格式化: 日期 --> 字符串
        String format = dateFormat.format(date);
        System.out.println(format);
        // 解析: 字符串 --> 日期
        String str = "2021/8/6 下午9:04";
        //格式必须符合样式否则会抛异常
        Date formatDate = dateFormat.parse(str);
        System.out.println(formatDate);
        System.out.println("---------------------------------------------------------------------------");
        //自定义格式化样式
        SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format = myDateFormat.format(date);
        System.out.println(format);
        str = "2021-08-06 09:32:23";
        formatDate = myDateFormat.parse(str);
        System.out.println(formatDate);
    }

    /**
     * 　　* @description: String类型日期转换为java.sql.date类型日期
     * 　　* @param 无
     * 　　* @return void
     * 　　* @throws ParseException解析异常
     * 　　* @author master
     * 　　* @date 2021/8/6 21:46
     *
     */
    @Test
    public void method2() throws ParseException {
        String birth = "2001-01-25";
        SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = myDateFormat.parse(birth);
        java.sql.Date date = new java.sql.Date(birthDate.getTime());
        System.out.println(date);

    }

    /**
     * 　　* @description: Calendar日历类(抽象类)
     * 　　* @param 无
     * 　　* @return void
     * 　　* @throws
     * 　　* @author master
     * 　　* @date 2021/8/6 22:17
     *
     */
    @Test
    public void method3() {
        //方式1: 创建子类(GregorianCalendar)的对象
        //方式2: 调用静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
        //get()
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("---------------------------------------------------------------------------");
        //set()
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("---------------------------------------------------------------------------");
        //add()
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("---------------------------------------------------------------------------");
        //getTime() Calendar类 --> Date类
        Date time = calendar.getTime();
        System.out.println(time);
        System.out.println("---------------------------------------------------------------------------");
        //setTime() Date类 --> Calendar类
        calendar.setTime(new Date());
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }

    /**
     * 　　* @description: Date的偏移量
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author master
     * 　　* @date 2021/8/6 22:49
     *
     */
    @Test
    public void method4() {
        Date date = new Date(2021, 8, 6);
        System.out.println(date);
        // year偏移量1900 month偏移量1
        date = new Date(2021 - 1900, 8 - 1, 6);
        System.out.println(date);


    }

    /**
     * 　　* @description: localDateTime 日期时间
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author master
     * 　　* @date 2021/8/6 22:55
     *
     */
    @Test
    public void method5() {
        //实例化 LocalDateTime.now()获取本地时间 / LocalDateTime.of()手动设置时间
        LocalDateTime timeNow = LocalDateTime.now();
        System.out.println(timeNow);
        //localDateTime设置时间没有偏移量
        LocalDateTime timeOf = LocalDateTime.of(2021, 8, 6, 22, 30, 14);
        System.out.println(timeOf);
        System.out.println("---------------------------------------------------------------------------");
        //getXXX() 获取属性
        System.out.println(timeNow.getDayOfYear());
        System.out.println(timeNow.getDayOfMonth());
        System.out.println(timeNow.getMonth());
        System.out.println(timeNow.getMonthValue());
        System.out.println(timeNow.getDayOfWeek());
        System.out.println("---------------------------------------------------------------------------");
        //withXXX() 设置属性(不可变)
        LocalDateTime time = timeNow.withDayOfYear(1);
        System.out.println(timeNow);
        System.out.println(time);
        System.out.println("---------------------------------------------------------------------------");
        //plusXXX() / minusXXX() 属性增加/减少修改
        LocalDateTime plusYears = timeNow.plusYears(100);
        System.out.println(timeNow);
        System.out.println(plusYears);
        System.out.println("---------------------------------------------------------------------------");
        LocalDateTime minusYears = time.minusYears(100);
        System.out.println(timeNow);
        System.out.println(minusYears);
    }
    /**
    　　* @description: Instant 瞬时
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author master
    　　* @date 2021/8/7 17:28
    　　*/

    @Test
    public void method6(){
        //Instant.now() 默认返回UTC时区的Instant对象,时差+8
        Instant instant = Instant.now();
        System.out.println(instant);
        //atOffset() 添加偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        System.out.println("---------------------------------------------------------------------------");
        //toEpochMilli() 获取时间戳
        long milli = instant.toEpochMilli();
        System.out.println(milli);
        System.out.println("---------------------------------------------------------------------------");
        //Instant.ofEpochMilli() 通过给定的毫秒数实例化对象
        Instant epochMilli = Instant.ofEpochMilli(1628329279683L);
        System.out.println(epochMilli);

    }
    /**
    　　* @description: DateTimeFormatter格式化解析日期或时间
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author master
    　　* @date 2021/8/7 17:49
    　　*/
    @Test
    public void method7(){
        //DateTimeFormatter.ISO_XXX 预定义标准格式
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;
        // 格式化: 日期 --> 字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String formatTime = dateTimeFormatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(formatTime);
        // 解析: 字符串 --> 日期
        TemporalAccessor parseTime = dateTimeFormatter.parse("2021-08-07T17:58:28.549509600");
        System.out.println(parseTime);

        System.out.println("---------------------------------------------------------------------------");
        //DateTimeFormatter.ofLocalizedDateTime(FormatStyle.XXX) 本地化相关格式
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        // 格式化: 日期 --> 字符串
        formatTime = formatter.format(localDateTime);
        System.out.println(formatTime);
        // 解析: 字符串 --> 日期
        parseTime = formatter.parse(formatTime);
        System.out.println(parseTime);

        //自定义格式
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 格式化: 日期 --> 字符串
        formatTime = ofPattern.format(localDateTime);
        System.out.println(formatTime);
        // 解析: 字符串 --> 日期
        parseTime = ofPattern.parse(formatTime);
        System.out.println(parseTime);
    }
    /**
    　　* @description: Date转LocalDateTime
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author master
    　　* @date 2021/8/14 1:40
    　　*/
    @Test
    public void method8(){
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime));
    }
    /**
    　　* @description: LocalDate转Date
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author master
    　　* @date 2021/8/14 1:50
    　　*/
    @Test
    public void method9(){
        LocalDate now = LocalDate.now();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime startOfDay = now.atStartOfDay(zoneId);
        Date date = Date.from(startOfDay.toInstant());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));

    }
}
