package eus.ehu.mastodonAPI;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import eus.ehu.mastodonAPI.domain.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ViewController {
    @FXML
    private Text errortxt;
    @FXML
    private TextField author;
    @FXML
    private CheckBox boosted;
    @FXML
    private TextField date;
    @FXML
    private WebView toot;
    private WebEngine engine;
    private List<Status> list;
    private int pos = 0;

    @FXML
    void show_next(ActionEvent event) {
        if(pos > 0) {
            errortxt.setText("");
            pos--;
            if(list.get(pos).rebloged()){
                boosted.setSelected(true);
                engine.loadContent(list.get(pos).getRebloged().getContent());
                author.setText(list.get(pos).getRebloged().getName());
                date.setText(list.get(pos).getRebloged().getDate());
            }else {
                boosted.setSelected(false);
                engine.loadContent(list.get(pos).getContent());
                author.setText(list.get(pos).getName());
                date.setText(list.get(pos).getDate());
            }
        }
        else{
            errortxt.setText("This is their last toot");
        }
    }
    @FXML
    void show_prev(ActionEvent event) {
        if(pos < list.size()-1) {
            errortxt.setText("");
            pos++;
            if(list.get(pos).rebloged()){
                boosted.setSelected(true);
                boosted.fire();
                engine.loadContent(list.get(pos).getRebloged().getContent());
                author.setText(list.get(pos).getRebloged().getName());
                date.setText(list.get(pos).getRebloged().getDate());
            }else{
                boosted.setSelected(false);
                engine.loadContent(list.get(pos).getContent());
                author.setText(list.get(pos).getName());
                date.setText(list.get(pos).getDate());
            }
        }
        else{
            errortxt.setText("This is their first toot");
        }
    }


    //json = Utils.readFile("pokemon/" + name.getText());
        //Gson gson = new Gson();
        //JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        //Type pokemonType = new TypeToken<Pokemon>(){}.getType();
        // Status status = gson.fromJson(jsonObject, pokemonType);
        // content.setText(pokemon.toString());

        //pokemonIcon.setImage(new Image(pokemon.getSprite()));



    @FXML
    void initialize() {
        boosted.setOpacity(1);
        author.setOpacity(1);
        date.setOpacity(1);

        String id = "109897302617643968";
        String body = Utils.request("accounts/"+id+"/statuses");
        Gson gson = new Gson();
        JsonArray jsonArray = gson.fromJson(body, JsonArray.class);
        Type statusList = new TypeToken<ArrayList<Status>>() {}.getType();
        list = gson.fromJson(jsonArray.getAsJsonArray(), statusList);
        engine = toot.getEngine();
        engine.loadContent(list.get(pos).getContent());
        author.setText(list.get(pos).getName());
        date.setText(list.get(pos).getDate());
    }

}
