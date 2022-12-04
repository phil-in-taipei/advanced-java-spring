package platform.codingnomads.co.springdata.example.mybatis.mapperslesson;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class MyBatisDemoApplication {

    /* Before running this app, be sure to:

        * create a new empty schema in the mysql database named "mybatis"

        * execute the SQL found "songs_table.sql" on the mybatis schema

        * update the "spring.datasource.url" property in your application.properties file to
          jdbc:mysql://localhost:3306/mybatis?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC

     */

    public static void main(String[] args) {
        SpringApplication.run(MyBatisDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData(SongMapper songMapper) {
        return (args) -> {
            Song song1 = new Song();
            song1.setName("Minnesota, WI");
            song1.setAlbum_name("Bon Iver");
            song1.setArtist_name("Bon Iver");
            song1.setSong_length(232);

            Song song2 = new Song();
            song2.setName("Post Humorous");
            song2.setAlbum_name("Orca");
            song2.setArtist_name("Gus Dapperton");
            song2.setSong_length(279);

            Song song4 = new Song();
            song4.setName("Long Song");
            song4.setAlbum_name("More Songs");
            song4.setArtist_name("Song Smith");
            song4.setSong_length(500);

            Song song5 = new Song();
            song5.setName("Short Song");
            song5.setAlbum_name("Even More Songs");
            song5.setArtist_name("Song Smith");
            song5.setSong_length(30);

            songMapper.insertNewSong(song1);
            songMapper.insertNewSong(song2);
            songMapper.insertNewSong(song4);
            songMapper.insertNewSong(song5);

            Song song3 = songMapper.getSongById(17L); // just manually update (by 2)

            int rowsDeleted =   songMapper.deleteSongById(23L);
            System.out.println("Rows deleted: " + rowsDeleted);

            song5.setName("Short Short Song");
            songMapper.updateSong(song5);


            ArrayList<Song> longSongs = songMapper.getSongsWithLengthGreaterThan(250);

            System.out.println("These are some long songs:");

            longSongs.forEach(System.out::println);

            System.out.println(song3.toString());

            ArrayList<Song> bonIverSongs = songMapper.getSongsByArtist("Song Smith");

            System.out.println("These are some Song Smith songs:");

            bonIverSongs.forEach(System.out::println);

            ArrayList<Song> songSmithSongs = songMapper.getSongsByArtistWithLengthGreaterThan(
                    "Bon Iver", 200);
            System.out.println("These are some Bong Iver songs longer than 200:");

            songSmithSongs.forEach(System.out::println);
        };
    }
}
