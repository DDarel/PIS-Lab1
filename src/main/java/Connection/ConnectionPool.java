package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private static final String URL = "jdbc:mysql://localhost:3306/cinema";
    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static final int INITIAL_POOL_SIZE = 10;

    private List<Connection> connectionPool;

    public ConnectionPool() throws SQLException {
        connectionPool = new ArrayList<>();
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            connectionPool.add(createConnection());
        }
    }

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public synchronized Connection getConnection() throws SQLException {
        if (connectionPool.isEmpty()) {
            connectionPool.add(createConnection());
        }
        return connectionPool.remove(0);
    }

    public synchronized void releaseConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connectionPool.add(connection);
        }
    }

    public synchronized void closeAllConnections() throws SQLException {
        for (Connection connection : connectionPool) {
            connection.close();
        }
        connectionPool.clear();
    }
}