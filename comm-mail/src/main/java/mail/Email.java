package mail;

import java.io.File;
import java.io.Serializable;
import java.util.List;

/**
 * Created by tancw on 2016/1/23.
 */
public class Email implements Serializable {
	private static final long serialVersionUID = 7934840497247727370L;

    //收件人地截址
    private List<String> address;
    /** 暗送 **/
    private String bcc;
    /** 抄送给 **/
    private List<String> cc;
    /** 邮件主题 **/
    private String subject;

    /** 邮件内容 **/
    private String content;

    /** 附件 **/
    private List<File> annexFile;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public List<String> getCc() {
        return cc;
    }

    public void setCc(List<String> cc) {
        this.cc = cc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<File> getAnnexFile() {
        return annexFile;
    }

    public void setAnnexFile(List<File> annexFile) {
        this.annexFile = annexFile;
    }
}
