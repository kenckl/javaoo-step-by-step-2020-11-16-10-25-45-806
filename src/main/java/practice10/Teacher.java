package practice10;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.*;

public class Teacher extends Person {
    private List<Klass> klasses = new ArrayList<Klass>();

    public Teacher(int id, String name, int age){
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, List<Klass> klasses) {
        super(id, name, age);
        this.klasses = klasses;
    }

    public List<Klass> getClasses(){
        return klasses;
    }

    @Override
    public String introduce() {
        if (klasses.size() == 0){
            return super.introduce()+" I am a Teacher. I teach No Class.";
        }else
            return  super.introduce() + " I am a Teacher. I teach Class " + this.klasses.stream().map(klass->String.valueOf(klass.getNumber())).collect(Collectors.joining(", ")) + "." ;
    }

    public String introduceWith(Student student){
        if(this.isTeaching(student)){
            return super.introduce()+" I am a Teacher. I teach "+ student.getName()+".";
        }else{
            return super.introduce()+" I am a Teacher. I don't teach "+ student.getName()+".";
        }
    }

    public boolean isTeaching (Student s){
        List<Klass> isTeach = klasses.stream().filter(item -> item.isIn(s)).collect(Collectors.toList());
        if (isTeach.isEmpty())
            return false;
        return true;
    }
}
