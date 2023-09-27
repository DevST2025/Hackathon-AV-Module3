package ra.service;

import ra.model.Singer;
import ra.model.Song;

public class SongService {
    private Song[] arrSong = new Song[100];
    private int curIndex = 0;

    public Song[] findAll() {
        return arrSong;
    }

    public int getCurIndex() {
        return curIndex;
    }

    public void addNewSong(Song song){
        arrSong[curIndex] = song;
        curIndex++;
        System.out.println("Thêm mới thành công");
    }

    public void updateSong(Song song){
        for (int i = 0; i < curIndex; i++) {
            if (arrSong[i].getSongId() == song.getSongId()) {
                arrSong[i] = song;
                System.out.println("Cập nhật thành công");
                return;
            }
        }
    }

    public Song findById(String id) {
        for (int i = 0; i < curIndex; i++) {
            if (arrSong[i].getSongId().equals(id)) {
                return arrSong[i];
            }
        }
        return null;
    }

    public void removeSong(String id) {
        for (int i = 0; i < curIndex - 1; i++) {
            if (arrSong[i].getSongId().equals(id)) {
                arrSong[i] = arrSong[i + 1];
            }
        }
        arrSong[curIndex] = null;
        curIndex--;
        System.err.println("Đã xoá ca sĩ");
    }
}
