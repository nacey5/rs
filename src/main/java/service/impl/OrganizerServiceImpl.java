package service.impl;

import common.factory.DaoFactory;
import dao.OrganizatorDao;
import pojo.bean.Organizer;
import service.OrganizerService;

/**
 * @author WEIR
 * @description
 * @date 20/10/2021 - 19:30
 */
public class OrganizerServiceImpl implements OrganizerService {
    private static OrganizatorDao orgDao = (OrganizatorDao) DaoFactory.getDao(OrganizatorDao.class);

    @Override
    public Organizer selectInfoByPhoneAndPassword(String phone, String password) {
        return orgDao.selectInfoByPhoneAndPassword(phone, password);
    }

    @Override
    public void orgRegister(Organizer org) {
        orgDao.addOrg(org);
    }

    @Override
    public String selectHeadPortrait(Integer id) {
        return orgDao.getHeadPortrait(id);
    }
}
