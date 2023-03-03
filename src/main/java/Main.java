import java.sql.SQLException;

import DAO.UserDAO;
import DAO.UserDAOImpl;
import Model.User;

public class Main {
    public static void main(String args[]) throws SQLException {
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.get(1);
        System.out.println();

        User useradd = new User(0,"Alex", "Simple");
        int result = userDAO.insert(useradd);
        System.out.println(result);
    }

}
