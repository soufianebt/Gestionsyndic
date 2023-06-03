module com.example.applicationgestionsyndic {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;
    requires itextpdf;
    requires java.desktop;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;


    opens com.example.applicationgestionsyndic to javafx.fxml;
    opens com.example.applicationgestionsyndic.Metier to javafx.base;
    exports com.example.applicationgestionsyndic;
    exports com.example.applicationgestionsyndic.Controllers;
    opens com.example.applicationgestionsyndic.Controllers to javafx.fxml;
    opens com.example.applicationgestionsyndic.DAL to javafx.base;
}