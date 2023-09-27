package ra.controller;

import ra.model.Singer;
import ra.model.Song;
import ra.service.SingerService;
import ra.service.SongService;

public class SongController {
    private SongService songService = new SongService();
    public Song[] findAll(){
        return songService.findAll();
    }
    public int getCurIndex(){
        return songService.getCurIndex();
    }

    public void addNewSong(Song song){
        songService.addNewSong(song);
    }

    public void updateSong(Song song){
        songService.updateSong(song);
    }

    public Song findById(String id){
        return songService.findById(id);
    }

    public void removeSong(String id){
        songService.removeSong(id);
    }

}
