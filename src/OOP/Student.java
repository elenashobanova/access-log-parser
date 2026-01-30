package OOP;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String name;
    private final List<Integer> grades = new ArrayList<>();
    public Student(String name){
        this.name = name;
    }
    public Student(String name, int [] grades){
        this(name);
        if (grades != null){
            for (int i = 0; i < grades.length; i++){
                addGrade(grades[i]);
            }
        }
    }
    public void addGrade(int grade){
        if (grade >= 2 && grade <=5){
            grades.add(grade);
        } else {
            System.out.println("Оценка должна быть в диапазоне от 2 до 5");
        }
    }
    public int[] getGrades(){
        int [] res = new int[grades.size()];
        for (int i = 0; i < grades.size(); i++){
            res[i] = grades.get(i);
        }
        return res;
    }

    @Override
    public String toString() {
        return  name + ": " + grades.toString();
    }
}

