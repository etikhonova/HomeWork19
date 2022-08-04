package DB;

public class Student {
    @Override
    public String toString() {
        return "Student{" +
                "studentfio='" + studentfio + '\'' +
                ", idsex=" + idsex +
                ", idGroup=" + idGroup +
                '}';
    }

    public Student(String studentfio, int idsex, int idGroup) {
        this.studentfio = studentfio;
        this.idsex = idsex;
        this.idGroup = idGroup;


    }

    private String studentfio;
    private int idsex;
    private int idGroup;

    public String getFio() {
        return studentfio;
    }

    public int getIdSex() {
        return idsex;
    }

    public int getIdGroup() {
        return idGroup;
    }


}
