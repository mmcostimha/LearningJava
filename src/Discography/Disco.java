package Discography;

public class Disco {

    private final String name;
    private final String path;
    private final int id_num;
    static int numberOfDiscos;

    public Disco(String name, String path){
        this.name = name;
        this.path = path;
        this.id_num = numberOfDiscos;
        numberOfDiscos++;
    }

    public String getName(){
        return this.name;
    }

    public String getPath(){
        return this.path;
    }

    public int getNumberOfDiscos(){
        return numberOfDiscos;
    }

    public int getId(){
        return id_num;
    }
}
