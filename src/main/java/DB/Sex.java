package DB;

public class Sex {
    private String sex_name;
    private int idsex;

    public Sex(String sex_name, int idsex) {
        this.sex_name = sex_name;
        this.idsex = idsex;
    }

    public String getSex_name() {
        return sex_name;
    }

    public int getIdsex() {
        return idsex;
    }

    @Override
    public String toString() {
        return "Sex{" +
                "sex_name='" + sex_name + '\'' +
                ", idsex=" + idsex +
                '}';
    }
}
