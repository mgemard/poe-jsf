package poe.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import poe.jpa.User;

public class JeuDeTestJdBc {

    public final static String[] QUERIES = { "DROP TABLE USER if exists",
            "CREATE TABLE USER(id int primary key, firstname varchar(255)), lastname varchar(255)), email varchar(255)), password varchar(255))",
            "INSERT INTO USER(id, name) values(0, 'bob', 'doyle', '', '')" };

    public static void main(String[] a) throws Exception {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        Statement stmt = conn.createStatement();
        for (String query : QUERIES) {
            System.out.println(query);
            stmt.executeUpdate(query);
        }

        // conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

        ResultSet result;

        stmt = conn.createStatement();
        result = stmt.executeQuery("\nSELECT * FROM USER");

        System.out.println("id\t\tname");
        while (result.next()) {
            System.out.println(result.getString("id") + "\t" + result.getString("name"));
        }

        stmt.close();
        conn.close();
        // jdbc:hsqldb:hsql://localhost:9001/basejpa", "sa", ""

        

        CriteriaBuilder criteriaBuilder;
        Session session;
        
        SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml")
                .buildSessionFactory();
        session = sessionFactory.openSession();

        criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<User> criteria = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);
        criteria.select(root);
        Query<User> query = session.createQuery(criteria);

        List<User> users = query.getResultList();

        System.out.println();
        System.out.println("* Liste des users :");
        for (User user : users) {
            System.out.println("Pr. " + user.getFirstname() + " " + user.getLastname() + "(" + user.getId() + ")");
        }

        sessionFactory.close();

    }
}