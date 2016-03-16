package ibatis.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by tancw on 2015/9/29.
 */
public class CompActive {
    private String id;
    private String compName;
    private String level;
    private String activeName;
    private Date sdate;
    private Date eDate;
    private int period;
    private BigDecimal income;
    private String extIncome;
    private String remark;

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getActiveName() {
        return activeName;
    }

    public void setActiveName(String activeName) {
        this.activeName = activeName;
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public Date geteDate() {
        return eDate;
    }

    public void seteDate(Date eDate) {
        this.eDate = eDate;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public String getExtIncome() {
        return extIncome;
    }

    public void setExtIncome(String extIncome) {
        this.extIncome = extIncome;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
