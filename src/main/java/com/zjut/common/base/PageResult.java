package com.zjut.common.base;


import lombok.Data;

@Data
public class PageResult<T> extends BaseResult<T> {

    /**
     * 页大小
     */
    private Integer pageSize=20;
    /**
     * 当前页号
     */
    private Integer pageIndex=0;
    /**
     * 总页数
     */
    private Integer totalPageCount=0;
    /**
     * 记录总数
     */
    private Integer record=0;
    /**
     * 总页数
     */
    private Integer lastPage=0;

    public PageResult(){

    }
    public PageResult(int pageIndex, int pageSize, int record, T data){
        wrapPageResult(pageIndex, pageSize, record, data);
    }

    /**
     * 总页数
     */
    public void setTotalPageCount() {
        int totalP = record % getPageSize() == 0 ? record / getPageSize() :
                record/ getPageSize() + 1;
        this.totalPageCount = totalP;
    }


    /**
     * 总记录数
     * @param record
     */
    public void setRecord(Integer record) {
        this.record = record;
        //设置总页数
        setTotalPageCount();
    }


    public void wrapPageResult(int pageIndex, int pageSize, int record, T data){
        if (record == 0) {
            return;
        }
        this.record = record;
        super.setData(data);
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        // 设置总页数
        this.totalPageCount = (record - 1) / pageSize + 1;
    }
}
