package DAO;

import Model.Film;
import Connection.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FilmDAOImpl implements FilmDAO{

    ConnectionPool connection = new ConnectionPool();

    public FilmDAOImpl() throws SQLException {
    }

    @Override
    public Film get(int id) throws SQLException {
        Connection con = connection.getConnection();
        Film film = null;
        String sql = "SELECT film_id, film_name, film_year, film_duration FROM cinema.films WHERE film_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            int film_id = rs.getInt("film_id");
            String film_name = rs.getString("film_name");
            int film_year = rs.getInt("film_year");
            int film_duration = rs.getInt("film_duration");

            film = new Film(film_id, film_name, film_year, film_duration);
        }
        return film;
    }

    @Override
    public List<Film> getAll() throws SQLException {
        return null;
    }

    @Override
    public int save(Film film) throws SQLException {
        return 0;
    }

    @Override
    public int insert(Film film) throws SQLException {
        Connection con = connection.getConnection();
        String sql = "INSERT INTO films (film_name, film_year, film_duration) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, film.getName());
        ps.setInt(2, film.getYear());
        ps.setInt(3, film.getDuration());
        int result = ps.executeUpdate();
        return result;
    }

    @Override
    public int update(Film film) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Film film) {
        return 0;
    }
}
