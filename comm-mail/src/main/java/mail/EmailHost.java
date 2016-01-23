package mail;

/**
 * Created by tancw on 2016/1/23.
 */
public class EmailHost {
        //邮件主机
        private String smtpHost;
        //发送人账号
        private String user;
        //发送人密码
        private String pwd;
        //发送邮箱
        private String from;
        //回复到
        private String replyTo;

        public String getSmtpHost() {
            return smtpHost;
        }
        public void setSmtpHost(String smtpHost) {
            this.smtpHost = smtpHost;
        }
        public String getUser() {
            return user;
        }
        public void setUser(String user) {
            this.user = user;
        }
        public String getPwd() {
            return pwd;
        }
        public void setPwd(String pwd) {
            this.pwd = pwd;
        }
        public String getFrom() {
            return from;
        }
        public void setFrom(String from) {
            this.from = from;
        }
        public String getReplyTo() {
            return replyTo;
        }
        public void setReplyTo(String replyTo) {
            this.replyTo = replyTo;
        }
}
