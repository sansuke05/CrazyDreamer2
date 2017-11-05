package jp.ac.u_aizu.zudai.crazydreamer2;

/**
 * Created by user on 2017/11/05.
 */

public class UserData {
    long id;
    private String userId;
    private String name;
    private String description;
    private String icon;

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getIcon(){
        return icon;
    }

    public void setIcon(String icon){
        this.icon = icon;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
