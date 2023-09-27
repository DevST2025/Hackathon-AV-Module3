package ra.run;

import ra.controller.SingerController;
import ra.controller.SongController;
import ra.model.Singer;
import ra.model.Song;
import ra.util.InputMethods;

import java.util.Scanner;

public class MusicManagement {
    private final static SingerController singerController = new SingerController();
    private final static SongController songController = new SongController();

//    private final static SearchController searchController = new SearchController();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {


        do {
            System.out.println("******************MUSIC MANAGEMENT******************\n" +
                    "1. Quản lý ca sĩ\n" +
                    "2. Quản lý bài hát\n" +
                    "3. Tìm kiếm bài hát\n" +
                    "4. Thoát ");
            System.out.print("Nhập vào  lựa chọn của bạn: ");
            int choice = InputMethods.getInteger();
            switch (choice) {
                case 1:
                    menuSinger();
                    break;
                case 2:
                    menuSong();
                    break;
                case 3:
                    menuSearch();
                    break;
                case 4:
                    System.out.println("******************END******************");
                    scanner.close();
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn 1 trong 4 option trên");
            }
        } while (true);
    }

    public static void menuSinger() {
        do {
            System.out.println("**********************SINGER MANAGEMENT*************************\n" +
                    "1.Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới\n" +
                    "2.Hiển thị danh sách tất cả ca sĩ đã lưu trữ\n" +
                    "3.Thay đổi thông tin ca sĩ theo mã id\n" +
                    "4.Xóa ca sĩ theo mã id (kiểm tra xem nếu ca sĩ có bài hát thì không xóa được)\n" +
                    "5.Thoát\n");
            System.out.print("Nhập vào  lựa chọn của bạn: ");
            int choice = InputMethods.getInteger();
            switch (choice) {
                case 1:
                    inputDataSingle();
                    break;
                case 2:
                    displayListSingle();
                    break;
                case 3:
                    updateDataSingle();
                    break;
                case 4:
                    removeSingle();
                    break;
                case 5:
                    break;
                default:
                    System.err.println("Vui lòng chọn 1 trong 5 option trên");
                    break;
            }
            if (choice == 5) {
                break;
            }
        } while (true);
    }

    //1.Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới
    public static void inputDataSingle() {
        int curIndex = singerController.getCurIndex();
        int maxInput = singerController.findAll().length - curIndex;
        System.out.print("Nhập vào số lượng ca sĩ cần thêm mới: ");
        int size;
        while (true) {
            size = InputMethods.getPositiveInteger();
            if (size > maxInput) {
                System.err.println("Số lượng phần tử quá lớn vui lòng nhập lại");
            } else {
                break;
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.println("Nhập thông tin cho ca sĩ thứ " + (i + 1));
            Singer singer = new Singer();
            singer.setSingerId(singerController.getNewId());
            System.out.println("Mã: " + singer.getSingerId());
            singer.inputData();
            singerController.addNewSinger(singer);
        }
        System.out.println("Thêm " + size + " ca sĩ thành công");
    }

    //2.Hiển thị danh sách tất cả ca sĩ đã lưu trữ
    public static void displayListSingle() {
        int curIndex = singerController.getCurIndex();
        if (curIndex == 0) {
            System.out.println("Chưa có ca sĩ nào đang hoạt động");
            return;
        }
        System.out.println("Danh sách sách ca sĩ đang hoạt động");
        for (int i = 0; i < curIndex; i++) {
            System.out.printf("Thông tin ca sĩ thứ %d\n", i + 1);
            singerController.findAll()[i].displayData();
            System.out.println("------------------");
        }
    }

    //3.Thay đổi thông tin ca sĩ theo mã id
    public static void updateDataSingle() {
        int curIndex = singerController.getCurIndex();
        System.out.print("Nhập mã số ca sĩ muốn cập nhật: ");
        int inputId = InputMethods.getInteger();
        if (inputId < 1 || inputId > curIndex) {
            System.err.printf("Không tìm thấy ca sĩ nào có mã %d\n", inputId);
            return;
        }

        Singer editSinger = singerController.findById(inputId);
        editSinger.inputData();
        singerController.updateSinger(editSinger);
    }
    //4.Xóa ca sĩ theo mã id
    public static void removeSingle() {
        int cntSong = 0;
        int curIndex = singerController.getCurIndex();
        System.out.print("Nhập mã số ca sĩ muốn xoá: ");
        int inputId = InputMethods.getInteger();
        if (inputId < 1 || inputId > curIndex) {
            System.err.printf("Không tìm thấy ca sĩ nào có mã %d\n", inputId);
            return;
        }

        for (int i = 0; i < songController.getCurIndex(); i++) {
            if (songController.findAll()[i].getSinger().getSingerId() == inputId) {
                cntSong++;
            }
        }
        if (cntSong == 0) {
            //Xoá thực hiện ở đây
            singerController.removeSinger(inputId);
        } else {
            System.err.printf("Ca sĩ này có %d sản phẩm, không thể xoá ca sĩ\n", cntSong);
        }
    }
    public static void menuSong() {
        do {
            System.out.println("**********************SONG MANAGEMENT*************************\n" +
                    "1.Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới\n" +
                    "2.Hiển thị danh sách tất cả bài hát đã lưu trữ\n" +
                    "3.Thay đổi thông tin bài hát theo mã id\n" +
                    "4.Xóa bài hát theo mã id\n" +
                    "5.Thoát");
            System.out.print("Nhập vào  lựa chọn của bạn: ");
            int choice = InputMethods.getInteger();
            switch (choice) {
                case 1:
                    inputDataSong();
                    break;
                case 2:
                    displayListSong();
                    break;
                case 3:
                    updateDataSong();
                    break;
                case 4:
                    removeSong();
                    break;
                case 5:
                    break;
                default:
                    System.err.println("Vui lòng chọn 1 trong 5 option trên");
                    break;
            }
            if (choice == 5) {
                break;
            }
        } while (true);
    }

    //1.Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới
    public static void inputDataSong() {
        boolean isExist = true;
        int curIndex = songController.getCurIndex();
        int maxInput = songController.findAll().length - curIndex;
        System.out.print("Nhập vào số lượng bài hát cần thêm mới: ");
        int size;
        while (true) {
            size = InputMethods.getPositiveInteger();
            if (size > maxInput) {
                System.err.println("Số lượng bài hát quá lớn vui lòng nhập lại");
            } else {
                break;
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.println("Nhập thông tin cho bài hát thứ " + (i + 1));
            Song song = new Song();
            System.out.print("Nhập mã bài hát: ");
            String inputId = InputMethods.getSongId();

            song.setSongId(inputId);
            song.inputData(songController.findAll(), singerController.findAll(), singerController.getCurIndex());
            songController.addNewSong(song);
        }
        System.out.println("Thêm " + size + " bài hát thành công");
    }

    //2.Hiển thị danh sách tất cả bài hát đã lưu trữ
    public static void displayListSong() {
        int curIndex = songController.getCurIndex();
        if (curIndex == 0) {
            System.out.println("Chưa có bài hát nào được thực hiện");
            return;
        }
        System.out.println("Danh sách bài hát đã thực hiện");
        for (int i = 0; i < curIndex; i++) {
            System.out.printf("Thông tin ca sĩ thứ %d\n", i + 1);
            songController.findAll()[i].displayData();
            System.out.println("------------------");
        }
    }

    //3.Thay đổi thông tin bài hát theo mã id
    public static void updateDataSong() {
        int curIndex = songController.getCurIndex();
        System.out.print("Nhập mã số bài hát muốn cập nhật: ");
        String inputId = InputMethods.getString();

        if (songController.findById(inputId) == null) {
            System.err.printf("Không tìm thấy bài hát nào có mã %d\n", inputId);
            return;
        }

        Song editSong = songController.findById(inputId);
        editSong.inputData(songController.findAll(), singerController.findAll(), singerController.getCurIndex());
        songController.updateSong(editSong);
    }
    //4.Xóa bài hát theo mã id
    public static void removeSong() {
        int curIndex = songController.getCurIndex();
        System.out.print("Nhập mã số bài hát muốn cập nhật: ");
        String inputId = InputMethods.getString();

        if (songController.findById(inputId) == null) {
            System.err.printf("Không tìm thấy bài hát nào có mã %d\n", inputId);
            return;
        }
        songController.removeSong(inputId);
    }


    public static void menuSearch() {

    }

}
