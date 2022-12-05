package platform.codingnomads.co.springdata.example.mybatis.resultsandresult;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class ResultsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResultsDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData(SongMapper songMapper, InstrumentMapper instrumentMapper) {
        return (args) -> {
            //notice the setter names have changed to match Java naming conventions
            Song song1 = new Song();
            song1.setName("Minnesota, WI");
            song1.setAlbumName("Bon Iver");
            song1.setArtistName("Bon Iver");
            song1.setSongLength(232);

            Song song2 = new Song();
            song2.setName("Post Humorous");
            song2.setAlbumName("Orca");
            song2.setArtistName("Gus Dapperton");
            song2.setSongLength(279);

            songMapper.insertNewSong(song1);
            songMapper.insertNewSong(song2);

            Song song3 = songMapper.getSongById(1L);
            System.out.println(song3.toString());

            Instrument instrument1 = new Instrument();
            instrument1.setInstrumentName("guitar");
            instrument1.setInstrumentType("string");
            instrumentMapper.insertNewInstrument(instrument1);

            Instrument instrument2 = new Instrument();
            instrument2.setInstrumentName("drum");
            instrument2.setInstrumentType("percussion");
            instrumentMapper.insertNewInstrument(instrument2);

            Instrument instrument3 = new Instrument();
            instrument3.setInstrumentName("cow bell");
            instrument3.setInstrumentType("percussion");
            instrumentMapper.insertNewInstrument(instrument3);

            System.out.println();
            System.out.println("This is the first instrument:");
            System.out.println("-------------------------------------------------------------------------------------");
            Instrument instrument4 = instrumentMapper.getInstrumentById(1L);
            System.out.println(instrument4.toString());
            System.out.println("-------------------------------------------------------------------------------------");

            System.out.println("These are all of the instruments:");
            System.out.println("-------------------------------------------------------------------------------------");
            ArrayList<Instrument> instruments = instrumentMapper.getAllInstruments();
            for (Instrument i : instruments) {
                System.out.println(i.toString());
            }
            System.out.println("-------------------------------------------------------------------------------------");

            System.out.println("These are all of the percussion instruments:");
            System.out.println("-------------------------------------------------------------------------------------");

            ArrayList<Instrument> percussionInstruments = instrumentMapper.getInstrumentByType(
                    "percussion");
            for (Instrument i : percussionInstruments) {
                System.out.println(i.toString());
            }
            System.out.println("-------------------------------------------------------------------------------------");
        };
    }
}
