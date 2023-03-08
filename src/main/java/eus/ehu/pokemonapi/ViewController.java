package eus.ehu.pokemonapi;

import java.lang.reflect.Type;
import java.net.URL;
import java.util.ResourceBundle;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import eus.ehu.pokemonapi.domain.Pokemon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import com.google.gson.Gson;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea content;

    @FXML
    private ImageView pokemonIcon;

    @FXML
    private TextField name;
    private String json;

    @FXML
    void actionGet(ActionEvent event) {
        // String json = Utils.readFile("2023-03-08T111259.200.json");
        json = Utils.request("pokemon/" + name.getText());
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        Type pokemonType = new TypeToken<Pokemon>(){}.getType();
        Pokemon pokemon = gson.fromJson(jsonObject, pokemonType);
        content.setText(pokemon.toString());

        pokemonIcon.setImage(new Image(pokemon.getSprite()));

    }

    @FXML
    void initialize() {


    }

}
