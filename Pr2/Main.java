package ru.mirea.java2021.ikbo2019.iskhakov;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int ages  =1;
        List<Name> humans = new ArrayList<>();
        humans.add(new Name(31,"Israel","Adesanya", LocalDate.of(1989,7,22),90));
        humans.add(new Name(29,"Cody","Garbrandt", LocalDate.of(1991,7,7),61));
        humans.add(new Name(34,"Henry","Cejudo", LocalDate.of(1987,2,9),55));
        humans.add(new Name(72,"Haruki","Murakami", LocalDate.of(1949,1,12),70));

        Comparator<Name> nameComparator = new Comparator<Name>(){
            @Override
            public int compare(Name o1, Name o2) {
                char first = o1.getLastName().charAt(o1.getLastName().length()-1);
                char second = o2.getLastName().charAt(o2.getLastName().length()-1);
                return Character.compare(first, second);
            }
        };

        Comparator<Name> dateComparator = new Comparator<Name>() {
            @Override
            public int compare(Name o1, Name o2) {
                LocalDate first = o1.getBirthDate();
                LocalDate second = o2.getBirthDate();
                return first.compareTo(second);
            }
        };

        List<Name> list =  humans.stream().sorted(nameComparator).collect(Collectors.toList());
        list.forEach(e-> System.out.println(e.getAge() + " " + e.getFirstName() + " " + e.getLastName() + " " + e.getWeight()));
        System.out.println();

        list = humans.stream().filter(human -> human.getAge()>human.getWeight()).collect(Collectors.toList());
        list.forEach(e-> System.out.println(e.getAge() + " " + e.getFirstName() + " " + e.getLastName() + " " + e.getWeight()));
        System.out.println();

        list = humans.stream().sorted(dateComparator).collect(Collectors.toList());
        list.forEach(e-> System.out.println(e.getAge() + " " + e.getFirstName() + " " + e.getLastName() + " " + e.getWeight()));
        System.out.println();

        Stream<Name> stream = humans.stream();
        ages *= stream.mapToInt(Name::getAge).reduce(1, (a, b) -> a * b);
        System.out.println(ages);
    }
}