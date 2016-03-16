package ibatis.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by qiao on 2015/9/8.
 *
 * 业务实例类
 */
public class Business {
    private Long id;
    private int busiType;
    private String bisiName;
    private BigDecimal yearamt;
    private Date sdate;
    private Date edate;
    private int period;
    private int unit;
    private String link;
    private String unitDict;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBusiType() {
        return busiType;
    }

    public void setBusiType(int busiType) {
        this.busiType = busiType;
    }

    public String getBisiName() {
        return bisiName;
    }

    public void setBisiName(String bisiName) {
        this.bisiName = bisiName;
    }

    public BigDecimal getYearamt() {
        return yearamt;
    }

    public void setYearamt(BigDecimal yearamt) {
        this.yearamt = yearamt;
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUnitDict(){
        if(0 != unit) {
            switch (unit) {
                case 1:
                    return "天";
                case 2:
                    return "月";
                case 3:
                    return "年";
            }
        }
        return "";
    }

    @Override
    public String toString() {
        return "Business{" +
                "id=" + id +
                ", busiType=" + busiType +
                ", bisiName='" + bisiName + '\'' +
                ", yearamt=" + yearamt +
                ", sdate=" + sdate +
                ", edate=" + edate +
                ", period=" + period +
                ", unit=" + unit +
                ", link='" + link + '\'' +
                ", unitDict='" + unitDict + '\'' +
                '}';
    }
}
