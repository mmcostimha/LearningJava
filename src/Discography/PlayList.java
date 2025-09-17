package Discography;

import java.util.Iterator;

public class PlayList extends Player {

    private String name;
    private final int id;
    static private int numOfPlayLists;


    public PlayList(String name){
        this.name = name;
        this.id = numOfPlayLists;
        numOfPlayLists++;
        System.out.println("n->"+numOfPlayLists);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void addDisco(Disco newDisco){

        if(!discos.contains(newDisco)){
            this.discos.add(newDisco);
            System.out.println("-Songs added successfully-" );
        }
        else
            System.out.println("-Songs already on Playlist-" );

    }

    public void removeDisco(String name){
        Iterator<Disco> it = this.discos.iterator();

        while (it.hasNext()) {
            Disco disco = it.next();
            System.out.println(disco);

            if (disco.getName().equals(name)) {
                it.remove();
            }
        }
    }

    public void removeDisco(int id){
        Iterator<Disco> it = this.discos.iterator();

        while (it.hasNext()) {
            Disco disco = it.next();
            System.out.println(disco);

            if (disco.getId() == this.id) {
                it.remove();
                System.out.println("Disco "+ disco.getName() + " removed from " + this.name);

            }
        }
    }

    public void showPlayList(){
        System.out.println("Songs from playList "+ this.name );
        System.out.println("********************" );
        for (Disco disco: discos){
            System.out.println("Song id: " + disco.getId());
            System.out.println("Song name: " + disco.getName() );
            System.out.println("Song Path: " + disco.getPath() );
            System.out.println("------------------------------");
        }
    }
    public int getId(){
        return this.id;
    }
}

