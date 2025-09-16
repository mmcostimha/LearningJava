
import java.util.Iterator;

public class PlayList extends Player {

    private String name;
    private final int id;
    static private int numOfPlayLists;


    PlayList(String name){
        this.name = name;
        this.id = numOfPlayLists;
        numOfPlayLists++;
        System.out.println("n->"+numOfPlayLists);
    }

    String getName(){
        return name;
    }

    void setName(String name){
        this.name = name;
    }

    void addDisco(Disco newDisco){

        if(!discos.contains(newDisco)){
            this.discos.add(newDisco);
            System.out.println("-Songs added successfully-" );
        }
        else
            System.out.println("-Songs already on Playlist-" );

    }

    void removeDisco(String name){
        Iterator<Disco> it = this.discos.iterator();

        while (it.hasNext()) {
            Disco disco = it.next();
            System.out.println(disco);

            if (disco.getName().equals(name)) {
                it.remove();
            }
        }
    }

    void removeDisco(int id){
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

    void showPlayList(){
        System.out.println("Songs from playList "+ this.name );
        System.out.println("********************" );
        for (Disco disco: discos){
            System.out.println("Song id: " + disco.getId());
            System.out.println("Song name: " + disco.getName() );
            System.out.println("Song Path: " + disco.getPath() );
            System.out.println("------------------------------");
        }
    }
    int getId(){
        return this.id;
    }
}

