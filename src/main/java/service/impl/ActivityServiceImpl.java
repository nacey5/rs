package service.impl;

import common.utils.SqlUtil;
import dao.ActivityDao;
import org.apache.ibatis.session.SqlSession;
import pojo.bean.ActivityUser;
import pojo.bean.Participater;
import pojo.bean.Pictures;
import service.ActivityService;

import java.util.List;

/**
 * @author WEIR
 * @description
 * @date 14/10/2021 - 16:04
 */
public class ActivityServiceImpl implements ActivityService {

    private final SqlSession openSession = SqlUtil.getOpeningSession();
    private final ActivityDao activityDao = openSession.getMapper(ActivityDao.class);

    @Override
    public void addActivity(ActivityUser activityUser) {
        try {
            activityUser.setId(activityDao.countAllAct());
            activityDao.addActivity(activityUser);
            openSession.commit();
        } catch (Exception e) {
            throw new RuntimeException("添加活动失败!");
        }
    }

    @Override
    public void deleteActivityById(Integer id) {
        activityDao.deleteActivity(id);
    }

    @Override
    public void updateActivityById(Integer id, ActivityUser activityUser) {
        try {
            activityDao.addActivityInfo(id, activityUser.getInfo());
            openSession.commit();
        } catch (Exception e) {
            throw new RuntimeException("更新活动信息失败!");
        }
    }

    @Override
    public ActivityUser selectActivity(Integer id) {
        return activityDao.selectInfoById(id);
    }

    @Override
    public boolean checkActivityName(String name) {
        return activityDao.checkActivityExist(name);
    }

    @Override
    public void addPicture(Integer id, String pic) {
        try {
            activityDao.addActivityPicture(id, pic);
            openSession.commit();
        } catch (Exception e) {
            throw new RuntimeException("注册失败!");
        }
    }

    @Override
    public List<Pictures> getPicture(Integer id) {
        return activityDao.selectPicturesById(id);
    }

    @Override
    public List<Participater> selectStudentInActivity(Integer id) {
        return activityDao.selectStudentsByArtId(id);
    }

    @Override
    public List<ActivityUser> getActivity(int start, int end) {
        return activityDao.getActivity(start, end);
    }


    @Override
    public void addActivityInfo(Integer id, String info) {
        try {
            activityDao.addActivityInfo(id, info);
            openSession.commit();
        } catch (Exception e) {
            throw new RuntimeException("添加活动失败!");
        }
    }

    @Override
    public List<ActivityUser> selectActivitiesByOrganizer(Integer organizer) {
        return activityDao.selectActivitiesByOrganizer(organizer);
    }

    @Override
    public List<ActivityUser> selectInfoIncludePars(Integer id) {
        return activityDao.selectInfoIncludePars(id);
    }

    @Override
    public List<ActivityUser> searchActivityByName(String searchText) {
        return null;
    }

}
