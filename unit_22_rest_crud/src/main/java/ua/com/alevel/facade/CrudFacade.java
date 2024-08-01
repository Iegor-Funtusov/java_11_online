package ua.com.alevel.facade;

import ua.com.alevel.dto.req.BaseReqDto;
import ua.com.alevel.dto.res.BaseResDto;

import java.util.Collection;

public interface CrudFacade<REQ extends BaseReqDto, RES extends BaseResDto> {

    void create(REQ req);
    void update(REQ req, Long id);
    void delete(Long id);
    RES findById(Long id);
    Collection<RES> findAll();
}
