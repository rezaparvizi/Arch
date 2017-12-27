import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {

    public static ArrayList<Movie> generateMovieNames(String path) throws IOException {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Scanner scanner = new Scanner(bufferedReader);
        scanner.useDelimiter("\\|");
        while (scanner.hasNext()) {
            String data[] = scanner.nextLine().toString().split("\\|");
            Movie movie = new Movie(Integer.parseInt(data[0]), data[1].toString());
            movies.add(movie);
        }

        fileReader.close();
        bufferedReader.close();
        scanner.close();

        return movies;
    }


    public static void moveFiles(String path) {
        File file = new File(path);
        File[] files = file.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().startsWith("part");
            }
        });

        if (path.endsWith("output1")) {
            for (File f : files)
                f.renameTo(new File("/Users/user/Documents/MovieRecommender/MovieRecommenderData/CIdAndMratings.txt"));
        } else {
            for (File f : files)
                f.renameTo(new File("/Users/user/Documents/MovieRecommender/MovieRecommenderData/Similarity.txt"));
        }
    }
}
