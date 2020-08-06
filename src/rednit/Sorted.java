package rednit;

public class Sorted {
    private String name,gender,hobby,interest,location;
   private byte[] img;

    public Sorted(String name, String gender, String interest,String hobby,String distance, byte[] img) {
        this.name = name;
        this.gender = gender;
        this.hobby = hobby;
        this.img=img;
        this.interest= interest;
        this.location = distance;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
