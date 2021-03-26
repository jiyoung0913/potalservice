package kr.ac.jejunu;

import java.sql.*;

public interface ConnectionMaker {
    public Connection getConnection() throws ClassNotFoundException, SQLException;

}