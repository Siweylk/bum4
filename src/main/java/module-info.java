module eus.ehu.pokemonapi {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;
    requires okhttp3;
    requires javafx.web;

    opens eus.ehu.mastodonAPI to javafx.fxml;
    exports eus.ehu.mastodonAPI;

    opens eus.ehu.mastodonAPI.domain to com.google.gson;
}
