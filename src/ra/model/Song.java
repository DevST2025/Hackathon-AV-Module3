package ra.model;

import ra.util.InputMethods;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Song {
    private  String songId;
    private String songName;
    private String descriptions;
    private Singer singer;
    private String  songWriter;
    private Date createdDate;
    private Date date = new Date();
    private boolean songStatus;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Song() {
    }

    public Song(String songId, String songName, String descriptions, Singer singer, String songWriter, Date createdDate, boolean songStatus) {
        this.songId = songId;
        this.songName = songName;
        this.descriptions = descriptions;
        this.singer = singer;
        this.songWriter = songWriter;
        this.createdDate = createdDate;
        this.songStatus = songStatus;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }
    public void inputData(Song[] arrSong, Singer[] arrSinger, int curIndexSinger) {
        boolean isExist = true;
        //Song Name
        System.out.print("Nhập tên bài hát: ");
        this.songName = InputMethods.getString();

        //Descriptions
        System.out.print("Nhập mô tả: ");
        this.descriptions = InputMethods.getInput();

        //Singer
        System.out.println("Danh sách ca sĩ: ");
        for (int i = 0; i < curIndexSinger; i++) {
            System.out.printf("Mã: %d - Tên: %s\n", arrSinger[i].getSingerId(), arrSinger[i].getSingerName());
        }
        System.out.println("Chọn 1 ca sĩ trong danh sách theo ID: ");
        do {
            int choice = InputMethods.getInteger();
            if (choice >= 1 && choice <= curIndexSinger) {
                this.singer = arrSinger[choice - 1];
                System.out.printf("Ca sĩ thực hiện: %s\n", this.singer.getSingerName());
                break;
            } else {
                System.err.printf("Vui lòng chọn 1 trong khoảng %d option trên\n", curIndexSinger);
            }
        } while (isExist);

        //Song Writer
        System.out.println("Nhập tên bài hát");
        this.songWriter = InputMethods.getString();

        //Created Date
        this.createdDate = new Date();

        //Song Status
        isExist = true;
        System.out.println("Chọn trạng thái: ");
        System.out.println("1. Có bản quyền");
        System.out.println("2. Chưa có bản quyền");
        System.out.print("Trạng thái: ");
        do {
            int choise = InputMethods.getInteger();
            switch (choise) {
                case 1:
                    this.songStatus = true;
                    isExist = false;
                    break;
                case 2:
                    this.songStatus = false;
                    isExist = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn 1 trong 2 option trên");
            }
        } while (isExist);

    }
    public void displayData() {
        System.out.println("Mã: "+ songId + " | Tên: "+songName);
        System.out.println("Tên ca sĩ: "+singer.getSingerName() + " |Mô tả: "+ descriptions);
        System.out.println("Nhạc sĩ: "+ songWriter + " | Trạng thái: "+(songStatus?"Có bản quyền":"Chưa có bản quyền"));
        System.out.println("Ngày tạo: "+ createdDate);
    }
}
