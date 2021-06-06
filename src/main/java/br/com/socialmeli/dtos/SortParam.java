package br.com.socialmeli.dtos;

public class SortParam {

    private String order;

    public SortParam() {
    }

    public SortParam(String order) {
        this.order = order;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
