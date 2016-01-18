package model;

import java.util.Date;

/**
 * Created by tancw on 2016/1/18.
 */
public class AccessToken {
    private String code;
    private Date createDate;
    private Long expires;


    public boolean isAva(){
        return (System.currentTimeMillis() - this.createDate.getTime() < expires);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getExpires() {
        return expires;
    }

    public void setExpires(Long expires) {
        this.expires = expires;
    }
}
