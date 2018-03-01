package oop.pset1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            String filePath = "src/oop/pset1/data/movies.csv";
            Path path = Paths.get(filePath);
            System.out.println(path.toAbsolutePath());
            System.out.println("Most rated films:");

            List<String> lines = Files.readAllLines(path);

            lines.stream()
                    .skip(1)
                    .map(s -> s.split(";"))
                    .filter(s -> s.length == 24)
                    .sorted(
                            (String[] s1, String[] s2) ->
                                    Double.compare(Double.parseDouble(s2[22]), Double.parseDouble(s1[22]))
                    )
                    .limit(5)
                    .forEach(s -> {
                        System.out.print(s[8]);
//                        System.out.print(": ");
                        System.out.println("(" + Double.parseDouble(s[22]) + ")");
                    });

            System.out.println("--------------------");

            Map<String, Integer> collect = lines.stream()
                    .skip(1)
                    .map(s -> s.split(";"))
                    .filter(s -> s.length == 24)
                    .map(s -> s[3])
                    .filter(s -> s.length() > 3)
                    .map(s -> s.replace("[", ""))
                    .map(s -> s.replace("]", ""))
                    .map(s -> s.replace("}, {", "};{"))
                    .map(s -> s.substring(0, 12))
//                    .map(s -> s.split(";"))
//                    .map(s -> {
//                        List<String> ret = new ArrayList<>();
//                        String me;
//                        for (String sub:s) {
//                            me = sub.split(",")[1];
//                            ret.add(me.substring(10, me.length()-2));
//                        }
//                        return ret;
//                    })
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
            collect.forEach((s, b) -> {
                System.out.println(s + " : " + b);
            });

        } catch (IOException e) {
            System.out.println("There is no such file");
            e.printStackTrace();
        }
    }
}
