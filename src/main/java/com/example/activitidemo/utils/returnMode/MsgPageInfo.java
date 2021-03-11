package com.example.activitidemo.utils.returnMode;

import java.io.Serializable;

import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class MsgPageInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer page;
    private Integer size;
    private Long total;
    private Integer numberOfElements;

    public static MsgPageInfo loadFromPageable(Page<?> page) {
        MsgPageInfo msgPageInfo = new MsgPageInfo();
        msgPageInfo.setNumberOfElements(page.getNumberOfElements());
        msgPageInfo.setPage(page.getNumber());
        msgPageInfo.setSize(page.getSize());
        msgPageInfo.setTotal(page.getTotalElements());
        return msgPageInfo;
    }

}
