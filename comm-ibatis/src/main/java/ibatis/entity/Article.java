package ibatis.entity;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by tancw on 2015/11/13.
 */
@Alias("article")
public class Article {
	private Long articleId;// 文章ID
	private Long author;// 作者
	private String title;// 标题
	private String content;// 内容
	private int type;// //类型[0:原创1:转载]
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;// 创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;// 更新时间
	private int status;// 状态[0:不启用1:启用]
	private int isDiscuss;// 是否可以评论

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIsDiscuss() {
        return isDiscuss;
    }

    public void setIsDiscuss(int isDiscuss) {
        this.isDiscuss = isDiscuss;
    }
}
