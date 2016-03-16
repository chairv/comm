package ibatis.entity;

/**
 * Created by qiao on 2015/10/9.
 */
public class Resource {
    private String id;
    private String url;
    private String permission;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }
}
