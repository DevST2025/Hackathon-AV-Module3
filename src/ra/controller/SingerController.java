package ra.controller;

import ra.model.Singer;
import ra.service.SingerService;

public class SingerController {
    private SingerService singerService = new SingerService();
    public Singer[] findAll(){
        return singerService.findAll();
    }
    public int getCurIndex(){
        return singerService.getCurIndex();
    }
    public int getNewId(){
        return singerService.getNewId();
    }
    public void addNewSinger(Singer singer){
        singerService.addNewSinger(singer);
    }

    public void updateSinger(Singer singer){
        singerService.updateSinger(singer);
    }

    public Singer findById(int id){
        return singerService.findById(id);
    }

    public void removeSinger(int id){
        singerService.removeSinger(id);
    }
}
