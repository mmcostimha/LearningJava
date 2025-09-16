import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    boolean isPlaying;
    int currentSong = 0;
    ArrayList<Disco> discos= new ArrayList<>();

    Player(){
        isPlaying = false;
    }

    Player(String folderPath){
        isPlaying = false;
        File folder =  new File(folderPath);
        File[] files = folder.listFiles();
        if(files != null){
            for(File file: files){
                Disco disco = new Disco(file.getName(), file.getPath());
                this.discos.add(disco);
            }
        }
    }

    Disco getSong(String name){

        for (Disco disco : this.discos) {
            if (disco.getName().equals(name)) {
                return disco;
            }
        }
        System.out.println("Song not found");
        return null;
    }

    Disco getSong(int id){
        for (Disco disco : this.discos) {
            if (disco.getId() == id) {
                return disco;
            }
        }
        System.out.println("Song not found");

        return null;
    }

    void playPlayer(Scanner scanner){
        boolean next;
        isPlaying = true;
        while (isPlaying) {
            next = false;
            File file = new File(discos.get(currentSong).getPath());

            try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(file); Clip clip = AudioSystem.getClip()) {
                clip.open(audioStream);
                clip.start();
                String responce;
                while (isPlaying && !next) {
                    System.out.println("P - Play");
                    System.out.println("S - Stop");
                    System.out.println("R - Reset");
                    System.out.println("Q - Quit");
                    System.out.println("N - Next Song");
                    System.out.println("B - Previous Song");
                    System.out.print("Enter your choice: ");

                    responce = scanner.nextLine().toUpperCase();

                    switch (responce) {
                        case "Q" -> {
                            isPlaying = false;
                            clip.close();
                        }
                        case "P" -> clip.start();
                        case "S" -> clip.stop();
                        case "R" -> clip.setMicrosecondPosition(0);
                        case "N" -> {
                            if (this.currentSong == discos.size() - 1)
                                this.currentSong = 0;
                            this.currentSong++;System.out.println("Next!" + this.currentSong);
                            next = true;
                            clip.stop();
                        }
                        case "B" -> {
                            if (this.currentSong == 0)
                                this.currentSong = discos.size() - 1;
                            this.currentSong--;System.out.println("Previous!" + this.currentSong);
                            next = true;
                            clip.stop();
                        }
                        default -> System.out.println("Invalid choice!");
                    }
                }
            } catch (IOException e) {
                System.out.println("Something went wrong!!!");
            } catch (UnsupportedAudioFileException e) {
                System.out.println("Unsupported Audio File!");
            } catch (LineUnavailableException e) {
                System.out.println("Unable to access audio source!");
                throw new RuntimeException(e);
            }
        }
    }
}
