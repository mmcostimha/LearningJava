

public class Discography extends Player {


    Discography(){
        super("C:\\Users\\marci\\Desktop\\Code staff\\java\\Learn_1\\music");
    }

    void showDiscography(){
        for(Disco disco : this.discos){
            System.out.println("Song id: " + disco.getId());
            System.out.println("Song name: " + disco.getName() );
            System.out.println("Song Path: " + disco.getPath() );
            System.out.println("------------------------------");
        }
    }
     Disco getDiscoById(int id){

        for (Disco disco : this.discos){
            if(disco.getId() == id){
                return disco;
            }
        }
        System.out.println("-Disco not founded-");
        return null;
    }

}
