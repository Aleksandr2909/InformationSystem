package View;

import Controller.FileController;
import Model.Playlist;
import Model.Style;
import Model.Track;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class TestRun {
    public static void main(String[] args) {
        Style rock = new Style("Rock");
        Style pop = new Style("Pop");
        Style rap = new Style("Rap");
        Style classic = new Style("classic");

        Track rockTrack1 = new Track("Rape me", "Nirvana", "Nirvana", 180L, rock);
        Track popTrack = new Track("Umbrella", "Rihanna", "Album1", 200L, pop);
        Track rapTrack = new Track("Как дела", "АК-47", "Какой-то альбом", 100L, rap);

        ArrayList<UUID> tracksID = new ArrayList<>();
        tracksID.add(rockTrack1.getTrackId());
        tracksID.add(popTrack.getTrackId());
        tracksID.add(rapTrack.getTrackId());

        Playlist playlist = new Playlist(tracksID, "Очень веселый плейлист");

        HashMap<UUID, Track> tracksIdAndNames = new HashMap<>();
        tracksIdAndNames.put(rockTrack1.getTrackId(), rockTrack1);
        tracksIdAndNames.put(popTrack.getTrackId(), popTrack);
        tracksIdAndNames.put(rapTrack.getTrackId(), rapTrack);

        System.out.println(rockTrack1.toString() + "\nID: " + rockTrack1.getTrackId());
        System.out.println(popTrack.toString() + "\nID: " + popTrack.getTrackId());
        System.out.println(rapTrack.toString() + "\nID: " + rapTrack.getTrackId());

        System.out.println(playlist.getPlaylistId() + " " + playlist.getPlaylistName());

        for (int i = 0; i < playlist.size(); i++) {
            System.out.println("song id from playlist " + playlist.getUUID(i));
        }

        System.out.println();
        System.out.println(FileController.TrackToJSON(rockTrack1));


        String styleStr = FileController.StyleToJSON(rock).toString();
        String trackStr = FileController.TrackToJSON(rockTrack1).toString();

        FileController.StyleToFile(pop, "style.json");
        FileController.TrackToFile(popTrack, "track.json");
        Style style1 = FileController.styleFromFile("style.json");
        Track track1 = FileController.trackFromFile("track.json");

        System.out.println(trackStr);

        System.out.println(rockTrack1.getTrackId());



            Scanner in = new Scanner(System.in);
            System.out.print("Input nameOfTrack: ");
            String nameOfTrack = in.nextLine();
            System.out.print("Input artist: ");
            String artist = in.nextLine();
            System.out.print("Input album: ");
            String album = in.nextLine();
            System.out.print("Input time: ");
            long time = in.nextLong();
            System.out.print("Input nameOfStyle: ");
            String nameOfStyle = in.nextLine();
            System.out.printf("nameOfTrack: %s  artist: %s  album: %s time: %l nameOfStyle: %s \n", nameOfTrack, artist, album, time, nameOfTrack);
            in.close();


        FileController.saveObjToFile(rapTrack, "saveTrack.txt");
        Track getTrack = FileController.getTrackFromFile("saveTrack.txt");
        System.out.println("Deserialized track: ");
        System.out.println(FileController.TrackToJSON(getTrack));
    }
}
