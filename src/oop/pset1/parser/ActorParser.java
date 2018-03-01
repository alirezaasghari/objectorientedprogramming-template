package oop.pset1.parser;

import oop.pset1.model.Actor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ActorParser {

    public List<Actor> getActors() {
        String filePath = "src/oop/pset1/data/actors.csv";
        try {
            Stream<String> lines = Files.lines(Paths.get(filePath));
            return lines.skip(1)
                    .map(line -> line.split(";"))
                    .map(columns -> columns[0])
                    .map(jsonObjects -> jsonObjects.split("},"))
                    .flatMap(jsonObjects -> Stream.of(jsonObjects))
                    .filter(json -> json.contains("name") && json.contains("gender"))
                    .map(toActor())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private Function<String, Actor> toActor() {
        return jsonObject -> {
            String[] fields = jsonObject.split(", ");
            String name = Stream.of(fields)
                    .filter(field -> field.contains("'name': "))
                    .map(e -> e.replaceAll("'name': ", ""))
                    .map(e -> e.replaceAll("'", ""))
                    .map(e -> e.trim())
                    .findFirst().get();
            String gender = Stream.of(fields)
                    .filter(field -> field.contains("'gender': "))
                    .map(e -> e.replaceAll("'gender': ", ""))
                    .map(e -> e.replaceAll("'", ""))
                    .map(e -> e.trim())
                    .map(e -> e.equals("2") ? "MALE" : "FEMALE")
                    .findFirst().get();

            Actor actor = new Actor();
            actor.setName(name);
            actor.setGender(gender);
            return actor;
        };
    }
}
