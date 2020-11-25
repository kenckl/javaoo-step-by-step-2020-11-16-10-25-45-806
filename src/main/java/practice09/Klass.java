package practice09;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int number;
    private Student leader;
    private List<Student> students = new ArrayList<Student>();

    public Klass(int number){
        this.number = number;
    }

    public int getNumber(){
        return number;
    }

    public String getDisplayName() {
        return "Class " + this.number;
    }

    public Student getLeader(){
        return leader;
    }

    public void assignLeader(Student leader) {
        if (students.contains(leader))
            this.leader = leader;
        else
            System.out.print("It is not one of us.\n");
    }

    public void appendMember(Student s){
        if (!students.contains(s))
            students.add(s);
    }

    public boolean isIn(Student s){
        return s.getKlass().equals(this);
    }
}
