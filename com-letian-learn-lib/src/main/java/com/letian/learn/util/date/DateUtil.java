package com.letian.learn.util.date;



import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.util.Date;

/**
 * : java8操作时间工具类
 *
 * @author : lh
 * @date : 2019-05-07 08:55
 */
public class DateUtil {

    private static final String DATE = "yyyy-MM-dd";
    private static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    /**
     * 根据date 类型 获取LocalDate类型
     *
     * @param date 时间
     * @return LocalDate
     */
    public static LocalDate dateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * 根据date 类型 获取LocalDateTime类型
     *
     * @param date 时间
     * @return LocalDate
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 获得传入时间，天的最小时间
     *
     * @return : 00:00:00
     * @author : lh
     * @date : 时间
     * @date : 2019/5/7
     */
    public static Date getCurrentDayMinTime(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        return Date.from(localDateTime.with(LocalTime.MIN).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获得传入时间，天的最大时间
     *
     * @author : lh
     * @date : 传入时间
     * @date : 2019/5/7
     */
    public static Date getCurrentDayMaxTime(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        return Date.from(localDateTime.with(LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取之前天的最大或者最小时间
     *
     * @param days     天数
     * @param adjuster 最大,最小  (LocalTime.MIN,LocalTime.MAX)
     * @return ：
     * @author : lh
     */
    public static Date getBeforeDayMaxOrMinDateTime(long days, TemporalAdjuster adjuster) {
        LocalDate localDate = LocalDate.now(ZoneId.systemDefault());
        Date from = Date.from(localDate.minusDays(days).atStartOfDay(ZoneId.systemDefault()).toInstant());
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(from.getTime()), ZoneId.systemDefault());
        return Date.from(localDateTime.with(adjuster).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获得当前天数的前几天时间,
     *
     * @param days 天数
     * @return : Date  如:2019-05-07
     * @author : lh
     * @date : 2019/5/7
     */
    public static Date getBeforeDateByDays(long days) {
        LocalDate localDate = LocalDate.now(ZoneId.systemDefault());
        return Date.from(localDate.minusDays(days).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获得传入时间的前几天时间,
     *
     * @param days 几天
     * @param date 时间
     * @return 前几天时间
     */
    public static Date getBeforeDateByDays(long days, Date date) {
        return Date.from(dateToLocalDateTime(date).minusDays(days).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获得当前天数的前几天时间,
     *
     * @param days 天数
     * @return : Date  如:2019-05-07 09:27:11
     * @author : lh
     * @date : 2019/5/7
     */
    public static Date getBeforeDateTimeByDays(long days) {
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.systemDefault());
        return Date.from(localDateTime.minusDays(days).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获得当前天数的前几天时间, (以秒为单位, 包括当前天)
     *
     * @param days 天数
     * @return : Date  如:2019-05-07 09:27:11
     * @author : lh
     * @date : 2019/5/7
     */
    public static Date getAfterDateTimeByDays(long days) {
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.systemDefault());
        return Date.from(localDateTime.plusDays(days).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获得当前天数的前几天时间,
     *
     * @param days 天数
     * @return : Date  如:2019-05-07 09:27:11
     * @author : lh
     * @date : 2019/5/7
     */
    public static Date getAfterDateTimeByDays(long days, Date date) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        return Date.from(localDateTime.minusDays(days).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * : 传入时间是否在[当前时间 - days ,当前时间]之内
     *
     * @param date: 校验的日期
     * @param days  校验天数
     * @return :
     * @author : lh
     * @date : 2019/5/7
     */
    public static Boolean betweenByDateAndDays(Date date, long days) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long sub = localDate.until(LocalDate.now(ZoneId.systemDefault()), ChronoUnit.DAYS);
        return sub < days;
    }

    /**
     * 传入时间是否在[当前时间 - days ,当前时间]之内
     *
     * @param date: 校验的日期
     * @param days  : 校验天数
     * @return :
     * @author : lh
     * @date : 2019/5/7
     */
    public static Boolean betweenByDateTimeAndDays(Date date, long days) {
        LocalDateTime localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        long sub = localDate.until(LocalDateTime.now(ZoneId.systemDefault()), ChronoUnit.DAYS);
        return sub < days;
    }

    /**
     * : 当前时间是否在[date, date + days]之内
     *
     * @param date: 校验的日期    days：校验天数
     * @return :
     * @author : lh
     * @date : 2019/5/7
     */
    public static Boolean betweenCurDateTimeByDateTimeAndDays(Date date, long days) {
        //最小时间
        LocalDateTime minTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime maxTime = minTime.plusDays(days);
        long min = minTime.toEpochSecond(ZoneOffset.of("+8"));
        long cur = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        long max = maxTime.toEpochSecond(ZoneOffset.of("+8"));
        return min <= cur && cur <= max;
    }


    /**
     * : 传入的时间是否在[当前时间- hours,当前时间] 之间
     *
     * @param date：校验时间
     * @param hours     校验的小时
     * @return :
     * @author : lh
     * @date : 2019/5/7
     */
    public static Boolean betweenByDateAndHours(Date date, long hours) {
        LocalDateTime activeTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        long sub = Duration.between(activeTime, LocalDateTime.now(ZoneId.systemDefault())).toHours();
        return sub <= hours;
    }

    /**
     * 获取当前时间的前几个小时
     *
     * @param hours 小时
     * @author : lh
     * @date : 2019/5/7
     */
    public static Date getBeforeDateTimeByHours(int hours) {
        return Date.from(LocalDateTime.now().minusHours(hours).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获得传入时间的年月日字符串
     *
     * @param date 时间
     * @return :
     * @author :lh
     */
    public static String getDateStringByDate(Date date) {
        return DateTimeFormatter.ofPattern(DATE).format(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
    }

    /**
     * 获得传入时间的年月日，时分秒字符串
     *
     * @param date 时间
     * @return yyyy-MM-dd HH:mm:ss
     * @author :lh
     */
    public static String getDateTimeStringByDate(Date date) {
        if (date == null) {
            return "";
        }
        return DateTimeFormatter.ofPattern(DATE_TIME).format(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String currentDateTime() {
        return DateTimeFormatter.ofPattern(DATE_TIME).format(LocalDateTime.now(ZoneId.systemDefault()));
    }


    /**
     * 判断时间是否相等 (判断到天)
     *
     * @param date1 开始时间
     * @param date2 结束时间
     * @return boolean
     * @author : lh
     */
    public static boolean equalsByDay(Date date1, Date date2) {
        return dateToLocalDate(date1).equals(dateToLocalDate(date2));
    }

    /**
     * data1 是不是 小于等于 date2
     *
     * @param date1 时间
     * @param date2 时间
     * @return boolean
     * @author : lh
     */
    public static boolean ltEqualsByDay(Date date1, Date date2) {
        LocalDate d1 = dateToLocalDate(date1);
        LocalDate d2 = dateToLocalDate(date2);
        return d1.equals(d2) || d1.isBefore(d2);
    }

    /**
     * data1 是不是 大于等于 date2
     *
     * @param date1 时间
     * @param date2 时间
     * @return boolean
     * @author :lh
     */
    public static boolean gtEqualsByDay(Date date1, Date date2) {
        LocalDate d1 = dateToLocalDate(date1);
        LocalDate d2 = dateToLocalDate(date2);
        return d1.equals(d2) || d1.isAfter(d2);
    }

    /**
     * 判断 startDate 是不是在endDate 前面 (判断到天)
     *
     * @param date1 开始时间
     * @param date2 结束时间
     * @return boolean
     * @author : lh
     */
    public static boolean isBeforeByDay(Date date1, Date date2) {
        return dateToLocalDate(date1).isBefore(dateToLocalDate(date2));
    }

    /**
     * 判断 startDate 是不是在endDate 后面  (判断到天)
     *
     * @param date1 开始时间
     * @param date2 结束时间
     * @return boolean
     * @author lh
     */
    public static boolean isAfterByDay(Date date1, Date date2) {
        return dateToLocalDate(date1).isAfter(dateToLocalDate(date2));
    }

    /**
     * 判断时间是否相等 (判断到秒)
     *
     * @param date1 开始时间
     * @param date2 结束时间
     * @return boolean
     * @author : lh
     */
    public static boolean equalsBySecond(Date date1, Date date2) {
        return dateToLocalDateTime(date1).equals(dateToLocalDateTime(date2));
    }

    /**
     * 判断 startDate 是不是在endDate 前面 (判断到秒)
     *
     * @param date1 开始时间
     * @param date2 结束时间
     * @return boolean
     * @author : lh
     */
    public static boolean isBeforeBySecond(Date date1, Date date2) {
        return dateToLocalDateTime(date1).isBefore(dateToLocalDateTime(date2));
    }

    /**
     * 判断 date1 是不是在 date2 后面 (判断到秒)
     *
     * @param date1 开始时间
     * @param date2 结束时间
     * @return boolean
     * @author : lh
     */
    public static boolean isAfterBySecond(Date date1, Date date2) {
        return dateToLocalDateTime(date1).isAfter(dateToLocalDateTime(date2));
    }

    /**
     * LocalDateTime to Date
     *
     * @param localDateTime
     * @return boolean
     */
    public static Date local2Date(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
        return date;
    }

    /**
     * Date to LocalDateTime
     *
     * @param date
     * @return
     */
    public static LocalDateTime date2Local(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return localDateTime;
    }

    /**
     * @return String
     * @author Liu Zhen
     * @Description 根据 日期获取周几
     * @Param date
     **/
    public static String getWeekByDate(Date date) {
        if (date == null) {
            return "";
        }
        return WeekEnum.getValueByKey(date2Local(date).getDayOfWeek().getValue());
    }

    /**
     * @param date
     * @return Date
     * @author Liu Zhen
     * @Description String 转 date
     */
    public static Date stringToDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }


    /**
     * @return String
     * @author Liu Zhen
     * @Description
     * @Param date
     * @Description 格式化 data
     **/
    public static String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        return dateToLocalDate(date).format(DateTimeFormatter.ofPattern(DATE));
    }

}
