package DB;

public class Group {
    private String groupname;
    private int idcurator;
    private int idGroup;

    public Group(String groupname, int idcurator, int idGroup) {
        this.groupname = groupname;
        this.idcurator = idcurator;
        this.idGroup = idGroup;
    }

    public String getGroupname() {
        return groupname;
    }

    public int getIdcurator() {
        return idcurator;
    }

    public int getIdGroup() {
        return idGroup;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupname='" + groupname + '\'' +
                ", idcurator=" + idcurator +
                ", idGroup=" + idGroup +
                '}';
    }
}
