package com.liujun.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

@RestController
@RequestMapping(value = "lambda")
public class LambdaController {

    @RequestMapping(value = "runnable", method = RequestMethod.GET)
    public void runnable() {
        new Thread(() -> System.out.print("12")).start();
    }

    @RequestMapping(value = "event", method = RequestMethod.GET)
    public void event() {
        JButton jButton = new JButton();
        jButton.addActionListener((e) -> {
            System.out.print("时间点击事件");
        });
    }

    @RequestMapping(value = "listOperate", method = RequestMethod.GET)
    public void listOperate() {
        String result = "";
        try {
            List<String> list = Arrays.asList("aa", "BB", "cc");
            list.forEach(a -> System.out.print(a));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @RequestMapping(value = "filterList")
    public void filterList() {
        try {
            List list = Arrays.asList("java", "c#", "jquery", "swing");
            //filter(list,(str)->str.startsWith("J"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void filter(List names, Predicate predicate) {
        for (Object item : names) {
            if (predicate.test(item)) {
                System.out.print(item);
            }
        }
    }

    // 更好的办法
    public static void filter2(List names, Predicate condition) {
        names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
            System.out.println(name + " ");
        });
    }

    /**
     * 使用Foreach操作list
     */
    @RequestMapping(value = "listForEach",method = RequestMethod.GET)
    public void listForEach() {
        List<Person> list = new ArrayList<Person>() {{
            add(new Person("1", "刘俊", "男", 23));
            add(new Person("2","刘敏","女",29));
            add(new Person("3","刘飞","男",30));
        }};
        System.out.print("遍历人员信息\n");
        list.forEach((item)->System.out.print(item.name+"\n"));

        System.out.print("新的一年，每个人的年龄加一岁：");
        Consumer<Person> personConsumer=item->item.age=item.age+1;
        list.forEach(personConsumer);
        list.forEach(item->System.out.print("年龄："+item.age+"\n"));

    }

    public class Person {
        public String number;
        public String name;
        public String sex;
        public Integer age;

        public Person(String number, String name, String sex, Integer age) {
            this.number = number;
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
    }
}
