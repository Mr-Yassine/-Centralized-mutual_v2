module com.example.mutuelle_centralisee_v2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires json.simple;
    requires mysql.connector.java;

    opens com.example.mutuelle_centralisee_v2 to javafx.fxml;
    exports com.example.mutuelle_centralisee_v2;
    exports com.example.mutuelle_centralisee_v2.Controllers;
    opens com.example.mutuelle_centralisee_v2.Controllers to javafx.fxml;
    exports com.example.mutuelle_centralisee_v2.Models;

}