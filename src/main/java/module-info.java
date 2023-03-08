module eus.ehu.pokemonapi {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;
    requires okhttp3;

    opens eus.ehu.pokemonapi to javafx.fxml;
    exports eus.ehu.pokemonapi;

    opens eus.ehu.pokemonapi.domain to com.google.gson;
}
