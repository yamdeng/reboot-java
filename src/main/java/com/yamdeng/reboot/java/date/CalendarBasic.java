package com.yamdeng.reboot.java.date;

import java.util.Calendar;
import java.util.Date;

// 년도, 월, 일, 요일, 년 기준으로 몇 째 주인지, 달 기준으로 몇 째 주인지, 년 기준으로 몇일 인지
// AM/PM 여부, 시간(0~11), 시간(0~23), 분, 초, m초, 이달의 마지막 날, 윤달 여부

public class CalendarBasic {

    public static void main(String[] args) {
        System.out.println("========== 래퍼 클래스 ==========");
        System.out.println();

        // Calendar Basic 1
        calendar1();
        System.out.println();

        //Calendar Basic 2
        calendar2();
        System.out.println();

        // Calendar Basic 3
        calendar3();
        System.out.println();

        // Calendar Basic 4
        calendar4();
        System.out.println();

        // Calendar Basic 5
        calendar5();
        System.out.println();

        // calendar, date간 변환
        calendarConvertToDate();
        System.out.println();

        System.out.println("========== CalendarBasic End ==========");
    }

    private static void calendar1() {
        System.out.println("Calendar Basic 1");
        Calendar today = Calendar.getInstance();
        System.out.println("이 해의 년도 : " + today.get(Calendar.YEAR));
        System.out.println("월(0~11, 0:1월): " + today.get(Calendar.MONTH));
        System.out.println("이 해의 몇 째 주: "
                + today.get(Calendar.WEEK_OF_YEAR));
        System.out.println("이 달의 몇 째 주: "
                + today.get(Calendar.WEEK_OF_MONTH));
        // DATE와 DAY_OF_MONTH는 같다.
        System.out.println("이 달의 몇 일: " + today.get(Calendar.DATE));
        System.out.println("이 달의 몇 일: " + today.get(Calendar.DAY_OF_MONTH));
        System.out.println("이 해의 몇 일: " + today.get(Calendar.DAY_OF_YEAR));
        System.out.println("요일(1~7, 1:일요일): "
                + today.get(Calendar.DAY_OF_WEEK)); // 1:일요일, 2:월요일, ... 7:토요일
        System.out.println("이 달의 몇 째 요일: "
                + today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("오전_오후(0:오전, 1:오후): "
                + today.get(Calendar.AM_PM));
        System.out.println("시간(0~11): " + today.get(Calendar.HOUR));
        System.out.println("시간(0~23): " + today.get(Calendar.HOUR_OF_DAY));
        System.out.println("분(0~59): " + today.get(Calendar.MINUTE));
        System.out.println("초(0~59): " + today.get(Calendar.SECOND));
        System.out.println("1000분의 1초(0~999): "
                + today.get(Calendar.MILLISECOND));
        // 천분의 1초를 시간으로 표시하기 위해 3600000으로 나누었다.(1시간 = 60 * 60초)
        System.out.println("TimeZone(-12~+12): "
                + (today.get(Calendar.ZONE_OFFSET)/(60*60*1000)));
        System.out.println("이 달의 마지막 날: "
                + today.getActualMaximum(Calendar.DATE) ); // 이 달의 마지막 일을 찾는다.
    }

    private static void calendar2() {
        System.out.println("Calendar Basic 2");
        // 요일은 1부터 시작하기 때문에, DAY_OF_WEEK[0]은 비워두었다.
        final String[] DAY_OF_WEEK = {"","일","월","화","수","목","금","토"};

        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();

        // month의 경우 0부터 시작하기 때문에 4월인 경우, 3로 지정해야한다.
        // date1.set(2019, Calendar.APRIL, 29);와 같이 할 수도 있다.
        date1.set(2019, 3, 29); // 2019년 4월 29일로 날짜를 설정한다.
        System.out.println("date1은 "+ toString(date1)
                + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)]+"요일이고,");
        System.out.println("오늘(date2)은 " + toString(date2)
                + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)]+"요일입니다.");

        // 두 날짜간의 차이를 얻으려면, getTimeInMillis() 천분의 일초 단위로 변환해야한다.
        long difference =
                (date2.getTimeInMillis() - date1.getTimeInMillis())/1000;
        System.out.println("그 날(date1)부터 지금(date2)까지 "
                + difference +"초가 지났습니다.");
        System.out.println("일(day)로 계산하면 "+ difference/(24*60*60)
                +"일입니다."); // 1일 = 24 * 60 * 60
    }

    private static void calendar3() {
        System.out.println("Calendar Basic 3");

        final int[] TIME_UNIT = {3600, 60, 1}; // 큰 단위를 앞에 놓는다.
        final String[] TIME_UNIT_NAME = {"시간 ", "분 ", "초 "};

        Calendar time1 = Calendar.getInstance();
        Calendar time2 = Calendar.getInstance();

        time1.set(Calendar.HOUR_OF_DAY, 10); // time1을 10시 20분 30초로 설정
        time1.set(Calendar.MINUTE, 20);
        time1.set(Calendar.SECOND, 30);

        time2.set(Calendar.HOUR_OF_DAY, 20); // time2을 20시 30분 10초로 설정
        time2.set(Calendar.MINUTE, 30);
        time2.set(Calendar.SECOND, 10);

        System.out.println("time1 :"+time1.get(Calendar.HOUR_OF_DAY)+"시 "
                +time1.get(Calendar.MINUTE)+"분 "+time1.get(Calendar.SECOND)+"초");
        System.out.println("time2 :"+time2.get(Calendar.HOUR_OF_DAY)+"시 "
                +time2.get(Calendar.MINUTE)+"분 "+time2.get(Calendar.SECOND)+"초");

        long difference =
                Math.abs(time2.getTimeInMillis() - time1.getTimeInMillis())/1000;
        System.out.println("time1과 time2의 차이는 "+ difference +"초 입니다.");

        String tmp = "";
        for(int i=0; i < TIME_UNIT.length;i++) {
            tmp += difference/TIME_UNIT[i] + TIME_UNIT_NAME[i];
            difference %= TIME_UNIT[i];
        }
        System.out.println("시분초로 변환하면 " + tmp + "입니다.");
    }

    private static void calendar4() {
        System.out.println("Calendar Basic 4");
        Calendar date = Calendar.getInstance();
        date.set(2019, 7, 31);	// 2019년 8월 31일

        System.out.println(toString(date));
        System.out.println("= 1일 후 =");
        date.add(Calendar.DATE, 1);
        System.out.println(toString(date));

        System.out.println("= 6달 전 =");
        date.add(Calendar.MONTH, -6);
        System.out.println(toString(date));

        System.out.println("= 31일 후(roll) =");
        date.roll(Calendar.DATE, 31);
        System.out.println(toString(date));

        System.out.println("= 31일 후(add) =");
        date.add(Calendar.DATE, 31);
        System.out.println(toString(date));
    }

    private static void calendar5() {
        System.out.println("Calendar Basic 5");
        int year  = 2021;
        int month = 6;
        int START_DAY_OF_WEEK = 0;
        int END_DAY = 0;

        Calendar sDay = Calendar.getInstance(); // 시작일
        Calendar eDay = Calendar.getInstance(); // 끝일

        // 월의 경우 0부터 11까지의 값을 가지므로 1을 빼주어야 한다.
        // 예를 들어, 2019년 11월 1일은 sDay.set(2019, 10, 1);과 같이 해줘야 한다.
        sDay.set(year, month-1, 1);
        eDay.set(year, month, 1);

        // 다음달의 첫날(12월 1일)에서 하루를 빼면 현재달의 마지막 날(11월 30일)이 된다.
        eDay.add(Calendar.DATE, -1);

        // 첫 번째 요일이 무슨 요일인지 알아낸다.
        START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);

        // eDay에 지정된 날짜를 얻어온다.
        END_DAY = eDay.get(Calendar.DATE);

        System.out.println("      " + year +"년 " + month +"월");
        System.out.println(" SU MO TU WE TH FR SA");

        // 해당 월의 1일이 어느 요일인지에 따라서 공백을 출력한다.
        // 만일 1일이 수요일이라면 공백을 세 번 찍는다.(일요일부터 시작)
        for(int i=1; i < START_DAY_OF_WEEK; i++)
            System.out.print("   ");

        for(int i=1, n=START_DAY_OF_WEEK ; i <= END_DAY; i++, n++) {
            System.out.print((i < 10)? "  "+i : " "+i );
            if(n%7==0) System.out.println();
        }
    }

    private static void calendarConvertToDate() {
        System.out.println("calendar, date간 변환");
        Calendar car = Calendar.getInstance();

        // Calendar를 Date로 변환
        Date date = new Date(car.getTimeInMillis());

        // Date를 Calendar로 변환
        car.setTime(date);
    }

    public static String toString(Calendar date) {
        return date.get(Calendar.YEAR)+"년 "+ (date.get(Calendar.MONTH)+1)
                +"월 " + date.get(Calendar.DATE) + "일 ";
    }

}
