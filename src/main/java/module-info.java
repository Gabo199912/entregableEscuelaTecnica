    module org.escuela.escuelacompleto {
        requires javafx.controls;
        requires javafx.fxml;
        requires javafx.web;

        requires org.controlsfx.controls;
        requires com.dlsc.formsfx;
        requires net.synedra.validatorfx;
        requires org.kordamp.ikonli.javafx;
        requires org.kordamp.bootstrapfx.core;
        requires eu.hansolo.tilesfx;
        requires javafx.graphics;
        requires java.desktop;
            requires java.sql;

            opens org.escuela.escuelacompleto.Modelo to javafx.base;
            opens org.escuela.escuelacompleto.Controlador to javafx.fxml;
        opens org.escuela.escuelacompleto to javafx.fxml;
        exports org.escuela.escuelacompleto;
    }