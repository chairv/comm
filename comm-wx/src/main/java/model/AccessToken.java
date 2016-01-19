package model;

import java.util.Date;

/**
 * Created by tancw on 2016/1/18.
 */
public class AccessToken {
    private String access_token;
    private Date createDate = new Date();
    private Long expires_in;

    public boolean isAva() {
        return (System.currentTimeMillis() - this.createDate.getTime() < expires_in);
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }

    @Override
    public String toString() {
        return "AccessToken{" +
                "access_token='" + access_token + '\'' +
                ", createDate=" + createDate +
                ", expires_in=" + expires_in +
                '}';
    }
}
