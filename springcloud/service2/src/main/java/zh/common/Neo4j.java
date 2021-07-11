package zh.common;

import org.neo4j.driver.v1.Session;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class Neo4j {

    private String username;

    private String password;

    public Connection getNeo4jConnection() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:neo4j:bolt://localhost:7474/",username,password);
        return con;
    }
}
