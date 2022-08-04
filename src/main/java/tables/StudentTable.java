package tables;

import DB.Student;
import dbConnect.IDBExecutor;
import dbConnect.SqlExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentTable extends AbsTable {
    private IDBExecutor idbExecutor = new SqlExecutor (new ArrayList<>(){{
        add("studentfio");
        add("id_sex");
        add("id_group");
    }});

    private final String tableName = "student";

    @Override
    public List list(String[] predicates) {
        String listStudentsQuery = String.format("select * from %s", tableName);

        List<Student> students = new ArrayList<>();

        List<Map<String, String>> result = idbExecutor.execute(listStudentsQuery);

        for(Map<String, String> res: result) {
            students.add(
                    new Student(
                            res.get("studentfio"),
                            Integer.parseInt(res.get("id_sex")),
                            Integer.parseInt(res.get("id_group"))
                    )
            );
        }

        return students;

    }
}
