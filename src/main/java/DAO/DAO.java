package DAO;

import java.util.List;
import java.sql.SQLException;

public interface DAO<T> {
    T get(int id) throws SQLException;

    List<T> getAll() throws SQLException;

    int save(T t) throws SQLException;

    int insert(T t) throws SQLException;

    int update (T t) throws SQLException;

    int delete (T t);
}
