package com.cyrill.springboot.util;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
/**
 * 结果类：用于存放返回的结果，支持分页
 */
import java.util.ArrayList;
import java.util.List;

@Component
public class Result {
    private Object obj;
    private List<?> list;
    private List<?> rows;
    private int page;
    private int size;
    private int total;
    private long records;
    private Page pager;
    private String errMsg;
    private int errCode;


    public Result() {
    }
    public int getPage() {
        return page;
    }

    public int getTotal() {
        return total;
    }

    public long getRecords() {
        return records;
    }

    /**
     * 支持sql分页
     * @param pager
     */
    public void setPager(Page pager) {
        this.page = pager.getNumber();
        this.total = pager.getTotalPages();
        this.records = pager.getTotalElements();
        this.rows = pager.getContent();
        this.size = pager.getSize();
    }

    /**
     * 支持list分页
     * @param list
     * @param pageIndex
     * @param pageSize
     */
    public void listToPage(List<?> list, String pageIndex, String pageSize) {
        int a = NumberUtil.toInt(pageIndex);
        int b = NumberUtil.toInt(pageSize);
        this.page = a==0?1:a;
        this.size = b==0?10:b;
        this.list = list==null?new ArrayList<>():list;
        this.records = this.list.size();
        this.total = records==0?0:(int) Math.ceil((double) records/this.size);
        int index = (page-1)*size;
        this.rows = new ArrayList<>();
        if(index+size>records){
            this.rows = list.subList(index,(int)records);
        }else{
            this.rows = list.subList(index,index+size);
        }
    }
    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public int getSize() {
        return size;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public List<?> getRows() {
        return rows;
    }
}
