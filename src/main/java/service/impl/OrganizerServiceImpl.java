package service.impl;

import common.utils.SqlUtil;
import dao.OrganizatorDao;
import org.apache.ibatis.session.SqlSession;
import pojo.bean.Organizer;
import service.OrganizerService;

/**
 * @author WEIR
 * @description
 * @date 20/10/2021 - 19:30
 */
public class OrganizerServiceImpl implements OrganizerService {

    private final SqlSession openSession = SqlUtil.getOpeningSession();
    private final OrganizatorDao orgDao= openSession.getMapper(OrganizatorDao.class);

    @Override
    public Organizer selectInfoByPhoneAndPassword(String phone, String password) {
        return orgDao.selectInfoByPhoneAndPassword(phone, password);
    }

    @Override
    public void orgRegister(Organizer org) {
        orgDao.addOrg(org);
        openSession.commit();
    }

    @Override
    public String selectHeadPortrait(Integer id) {
        return orgDao.getHeadPortrait(id);
    }
}
