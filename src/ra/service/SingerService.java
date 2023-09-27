package ra.service;

import ra.model.Singer;

public class SingerService {
    private Singer[] arrSinger = new Singer[100];
    private int curIndex = 0;

    public Singer[] findAll() {
        return arrSinger;
    }

    public int getCurIndex() {
        return curIndex;
    }
    public int getNewId(){
        int maxId=0;
        for (int i = 0; i < curIndex; i++) {
            if (arrSinger[i].getSingerId() > maxId) {
                maxId = arrSinger[i].getSingerId();
            }
        }
        return maxId + 1;
    }
    public void addNewSinger(Singer singer){
        arrSinger[curIndex] = singer;
        curIndex++;
        System.out.println("Thêm mới thành công");
    }

    public void updateSinger(Singer singer){
        for (int i = 0; i < curIndex; i++) {
            if (arrSinger[i].getSingerId() == singer.getSingerId()) {
                arrSinger[i] = singer;
                System.out.println("Cập nhật thành công");
                return;
            }
        }
    }

    public Singer findById(int id) {
        for (int i = 0; i < curIndex; i++) {
            if (arrSinger[i].getSingerId() == id) {
                return arrSinger[i];
            }
        }
        return null;
    }

    public void removeSinger(int id) {
        for (int i = 0; i < curIndex - 1; i++) {
            if (arrSinger[i].getSingerId() == id) {
                arrSinger[i] = arrSinger[i + 1];
            }
        }
        arrSinger[curIndex] = null;
        curIndex--;
        System.err.println("Đã xoá ca sĩ");
    }
}
