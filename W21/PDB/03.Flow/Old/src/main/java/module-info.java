module de.hawh.hajs {
    requires javafx.controls;
    requires javafx.fxml;
    requires gs.core;
    requires gs.ui.javafx;

    opens de.hawh.hajs.gka03 to javafx.fxml;
    opens de.hawh.hajs.gka03.controllers to javafx.fxml;
    opens de.hawh.hajs.gka03.util to javafx.fxml;

    exports de.hawh.hajs.gka03;

}