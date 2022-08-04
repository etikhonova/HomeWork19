package DB;

public class Curator {
    private String fio;
    private int idcurator;

    public Curator(String fio, int idcurator) {
        this.fio = fio;
        this.idcurator = idcurator;
    }

    public String getFio() {
        return fio;
    }

    public int getIdcurator() {
        return idcurator;
    }

    @Override
    public String toString() {
        return "Curator{" +
                "fio='" + fio + '\'' +
                ", idcurator=" + idcurator +
                '}';
    }
}
