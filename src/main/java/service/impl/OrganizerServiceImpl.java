package service.impl;

import common.utils.SqlUtil;
import dao.OrganizatorDao;
import org.apache.ibatis.session.SqlSession;
import pojo.bean.Organizer;
import service.OrganizerService;

import java.util.List;

/**
 * @author WEIR
 * @description
 * @date 20/10/2021 - 19:30
 */
public class OrganizerServiceImpl implements OrganizerService {

    private final SqlSession openSession = SqlUtil.getOpeningSession();
    private final OrganizatorDao orgDao = openSession.getMapper(OrganizatorDao.class);

    @Override
    public Organizer checkOrgPhone(String name) {
        return orgDao.checkOrgPhone(name);
    }

    @Override
    public Organizer selectOrgByHeadPortrait(String picCode) {
        return orgDao.selectOrgByHeadPortrait(picCode);
    }

    @Override
    public Organizer orgLogin(String phone, String password) {
        try {
            return orgDao.selectInfoByPhoneAndPassword(phone, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void orgRegister(Organizer org) {
        Integer sum = orgDao.countAllOrg();
        org.setId(++sum);
        System.out.println(org.toString());
        orgDao.addOrg(org);
        try {
            openSession.commit();
        } catch (Exception e) {
            throw new RuntimeException("组织注册失败");
        }
    }

    @Override
    public String selectHeadPortrait(Integer id) {
        return orgDao.getHeadPortrait(id);
    }

    @Override
    public void addInfo(Integer id, String info) {
        orgDao.addInfo(id, info);
        openSession.commit();
    }

    @Override
    public String selectInfo(Integer id) {
        return orgDao.selectInfo(id);
    }

    @Override
    public List<Organizer> getOrgs(int start, int end) {
        return orgDao.getOrgs(start, end);
    }

    @Override
    public boolean checkOrgName(String name) {
        return orgDao.checkOrgName(name) != null;
    }


}
