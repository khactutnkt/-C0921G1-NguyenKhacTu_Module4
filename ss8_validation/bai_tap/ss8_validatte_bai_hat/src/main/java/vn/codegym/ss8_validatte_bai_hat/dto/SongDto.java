package vn.codegym.ss8_validatte_bai_hat.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


public class SongDto {

//    @NotBlank(message = "Name cannot be blank")
    @Pattern(regexp = "^[A-Za-z0-9][a-zA-z\\s]{0,799}$", message = "Name cannot be blank, not long too 800 character, does not contain special characters")
    private String name;

    @Pattern(regexp = "^[A-Za-z0-9][a-zA-z\\s]{0,299}$", message = "Name cannot be blank, not long too 300 character, does not contain special characters")
    private String singer;

    @Pattern(regexp = "^^[A-Za-z0-9][A-Za-z0-9\\s\\,]{0,999}$", message = "Name cannot be blank, not long too 300 character, does not contain special characters")
    private String kindOfMusic;

    public SongDto() {
    }

    public SongDto(String name, String singer, String kindOfMusic) {
        this.name = name;
        this.singer = singer;
        this.kindOfMusic = kindOfMusic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }
}
