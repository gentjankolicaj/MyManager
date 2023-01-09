package io.gentjankolicaj.app.mymanager.desktop.service.impl;

import io.gentjankolicaj.app.mymanager.desktop.data.dao.AdditionalDao;
import io.gentjankolicaj.app.mymanager.desktop.data.dao.impl.AdditionalDaoImpl;
import io.gentjankolicaj.app.mymanager.desktop.data.models.Additional;
import io.gentjankolicaj.app.mymanager.desktop.service.AdditionalService;

import java.util.List;

/**
 * @author gentjan kolicaj
 */
public class AdditionalServiceImpl implements AdditionalService {

    private final AdditionalDao additionalDao;

    public AdditionalServiceImpl() {
        super();
        this.additionalDao = new AdditionalDaoImpl();
    }

    @Override
    public List<Additional> getAllAdditionals() throws Exception {
        return additionalDao.findAllAdditionals();
    }

    @Override
    public List<Additional> getAllAdditionals(int limit, int offset) throws Exception {
        return additionalDao.findAllAdditionals(limit, offset);
    }

    @Override
    public Additional getAdditional(String employeeId) throws Exception {
        return additionalDao.findAdditional(employeeId);
    }

    @Override
    public int updateAdditional(Additional oldAdditional, Additional newAdditional) throws Exception {
        return additionalDao.updateAdditional(oldAdditional, newAdditional);
    }

    @Override
    public int saveAdditional(Additional additional) throws Exception {
        return additionalDao.saveAdditional(additional);
    }

    @Override
    public int deleteAdditional(Additional additional) throws Exception {
        return additionalDao.deleteAdditional(additional);
    }

}
