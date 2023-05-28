
import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.core.PostgresDatabase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.DirectoryResourceAccessor;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.lifecycle.Startables;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Testcontainers
public class IntegrationEnvironment {
    static final JdbcDatabaseContainer<?> DB_CONTRAINER;

    static {
        DB_CONTRAINER = new PostgreSQLContainer<>("postgres:15-alpine")
                .withDatabaseName("scrapper")
                .withUsername("postgres_test")
                .withPassword("testdb");
        DB_CONTRAINER.start();

        Startables.deepStart(DB_CONTRAINER).thenAccept((none) -> migrateLiquibase(DB_CONTRAINER));
    }

    private static void migrateLiquibase(JdbcDatabaseContainer<?> container){
        Path masterMigration = new File(".").toPath()
                .toAbsolutePath()
                .getParent()
                .getParent()
                .resolve("migrations");

        try {
            Connection connection = DriverManager.getConnection(container.getJdbcUrl(),
                    container.getUsername(), container.getPassword());

            PostgresDatabase pgDb = new PostgresDatabase();
            pgDb.setConnection(new JdbcConnection(connection));

            Liquibase liquibase = new Liquibase("master.xml", new DirectoryResourceAccessor(masterMigration), pgDb);
            liquibase.update(new Contexts(), new LabelExpression());
        } catch (SQLException | FileNotFoundException | LiquibaseException e) {
            throw new RuntimeException(e);
        }

    }

    
}