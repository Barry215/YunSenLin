package cn.maijinta.yunsenlin.model;

/**
 * Created by frank on 17/1/26.
 */

public class BondData {
    private String record;
    private boolean isChecked;

    public BondData(String record) {
        this.record = record;
        isChecked = false;
    }

    public BondData(String record, boolean isChecked) {
        this.record = record;
        this.isChecked = isChecked;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public boolean getChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
