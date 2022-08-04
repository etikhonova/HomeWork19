import DB.Curator;
import DB.Group;
import DB.Sex;
import DB.Student;
import tables.*;
import tables.commands.Commands;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String... args) {

        boolean isExit = true;
        String[] predicates = new String[]{};
        while (isExit) {
            System.out.println("Select command");
            Commands[] commands = Commands.values();
            for (Commands c: commands) {System.out.println(c);}
            System.out.println("Enter command");
            Scanner sc = new Scanner(System.in);
            String choice = sc.next().trim().toUpperCase();
            try {
                switch (Commands.valueOf(choice)) {
                    case SELECT:
                        System.out.println("Select table");
                        TableNames [] tablenames = TableNames.values();
                        for (TableNames t: tablenames) {System.out.println(t);}
                        System.out.println("Enter tablename");
                        Scanner tn = new Scanner(System.in);
                        String tablename = tn.next().trim().toUpperCase();
                        try {
                            switch (TableNames.valueOf(tablename)) {
                                case STUDENT:
                                    ITable studentTable = new StudentTable();
                                    List<Student> students = studentTable.list(predicates);
                                    System.out.println(students);
                                    break;
                                case SEX:
                                    ITable sexTable = new SexTable();
                                    List<Sex> sex = sexTable.list(predicates);
                                    System.out.println(sex);
                                    break;
                                case STUDENTGROUP:
                                    ITable groupTable = new GroupTable();
                                    List<Group> group = groupTable.list(predicates);
                                    System.out.println(group);
                                    break;
                                case CURATOR:
                                    ITable curatorTable = new CuratorTable();
                                    List<Curator> curator = curatorTable.list(predicates);
                                    System.out.println(curator);
                                    break;

                            }
                        }
                        catch (IllegalArgumentException e){
                            System.out.println("Unknown Table");
                        }
                        break;
                    case UPDATE:
                        System.out.println("Enter tableForUpdate");
                        System.out.println("Enter atributeForUpdate");
                        System.out.println("Enter atributeForWhere");
                        System.out.println("Enter symbolForWhere");
                        break;
                    case INSERT:
                        System.out.println("Enter tableForInsert");
                        System.out.println("Enter dataForInsert");
                        break;
                    case EXIT:
                        System.out.println("EXIT");
                        isExit = false;
                        break;
                }
            }
            catch (IllegalArgumentException e){
                System.out.println("Unknown Command");
            }


        }
    }
}
