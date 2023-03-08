package eus.ehu.pokemonapi.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pokemon {

    class AbilityWrapper {
        class Ability {
            String name;
            String url;

            @Override
            public String toString() {
                return "Ability{" +
                        "name='" + name + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }
        }
        Ability ability;
        boolean is_hidden;
        int slot;

        @Override
        public String toString() {
            return "AbilityWrapper{" +
                    "ability=" + ability +
                    ", is_hidden=" + is_hidden +
                    ", slot=" + slot +
                    '}';
        }
    }

    class Sprite {
        class Other {
            class Official {
                String front_shiny;

                @Override
                public String toString() {
                    return "Official{" +
                            "front_shiny='" + front_shiny + '\'' +
                            '}';
                }
            }
            @SerializedName("official-artwork")
            Official officialArtwork;

            @Override
            public String toString() {
                return "Other{" +
                        "officialArtwork=" + officialArtwork +
                        '}';
            }
        }
        Other other;

        @Override
        public String toString() {
            return "Sprite{" +
                    "other=" + other +
                    '}';
        }
    }

    Integer id;
    String name;
    Integer weight;
    Integer base_experience;
    Integer height;

    List<AbilityWrapper> abilities;

    Sprite sprites;

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", base_experience=" + base_experience +
                ", height=" + height +
                ", abilities=" + abilities +
                ", sprites=" + sprites +
                '}';
    }

    public String getSprite() {
        return sprites.other.officialArtwork.front_shiny;
    }
}
