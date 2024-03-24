import java.sql.*;

public class ShowEmployees {
    static String url = "jdbc:mysql://localhost:3306/employeedata";
    static String user = "root";
    static String password = "@Asc987654321";

    public static void show() {
        StringBuilder output = new StringBuilder();
        String sqlcommand = "SELECT e.Fname, e.Lname, e.email, jt.job_title, p.pay_date, p.earnings, " +
                            "p.fed_tax, p.fed_med, p.fed_SS, p.state_tax, p.retire_401k, p.health_care " +
                            "FROM employees e " +
                            "JOIN employee_job_titles ejt ON e.empid = ejt.empid " +
                            "JOIN job_titles jt ON ejt.job_title_id = jt.job_title_id " +
                            "LEFT JOIN (SELECT empid, MAX(pay_date) AS pay_date FROM payroll GROUP BY empid) latest_pay ON e.empid = latest_pay.empid " +
                            "LEFT JOIN payroll p ON e.empid = p.empid AND latest_pay.pay_date = p.pay_date " +
                            "ORDER BY p.pay_date DESC;";

        try (Connection myConn = DriverManager.getConnection(url, user, password)) {
            Statement myStmt = myConn.createStatement();
            ResultSet myRS = myStmt.executeQuery(sqlcommand);

            output.append("\nEMPLOYEE REPORT\n\n");
            output.append("NAME\t\t\tEMAIL\t\t\tTITLE\t\t\tPAY DATE\tGROSS\tFederal\tFedMed\tFedSS\tState\t401K\tHealth\n");

            while (myRS.next()) {
                output.append(myRS.getString("Fname")).append(" ").append(myRS.getString("Lname")).append("\t\t");
                output.append(myRS.getString("email")).append("\t").append(myRS.getString("job_title")).append("\t");
                output.append(myRS.getDate("pay_date")).append("\t").append(myRS.getDouble("earnings")).append("\t");
                output.append(myRS.getDouble("fed_tax")).append("\t").append(myRS.getDouble("fed_med")).append("\t");
                output.append(myRS.getDouble("fed_SS")).append("\t").append(myRS.getDouble("state_tax")).append("\t");
                output.append(myRS.getDouble("retire_401k")).append("\t").append(myRS.getDouble("health_care")).append("\n");
            }
            System.out.println(output);
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
