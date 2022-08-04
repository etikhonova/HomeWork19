package dbConnect;

import PropReader.IPropReader;
import PropReader.PropReader;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlExecutor implements IDBExecutor{
    private List<String> columnNames;

    public  SqlExecutor (List<String> columnNames) {
        this.columnNames = columnNames;
    }

    private IPropReader confReader = new PropReader();

    @Override
    public List<Map<String, String>> execute(String query) {
        Connection connection = null;
        Statement statement = null;

        Map<String, String> confData = confReader.read();

        List<Map<String, String>> result = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(
                    String.format("%s/%s", confData.get("url"), confData.get("db_name")),
                    confData.get("username"),
                    confData.get("password"));

            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                Map<String, String> resultData = new HashMap<>();
                for(String columnName: columnNames) {
                    String data = resultSet.getString(columnName);
                    resultData.put(columnName, data);
                }

                result.add(resultData);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
