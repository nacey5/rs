package service.impl;

import common.factory.DaoFactory;
import dao.ActivityDao;
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

     private final ActivityDao activityDao= (ActivityDao) DaoFactory.getDao(ActivityDao.class);

    @Override
    public void addActivity(ActivityUser activityUser) {
        activityDao.addActivity(activityUser);
    }

    @Override
    public void deleteActivityById(Integer id) {
        activityDao.deleteActivity(id);
    }

    @Override
    public void updateActivityById(Integer id, ActivityUser activityUser) {
        activityDao.addActivityInfo(id,activityUser.getInfo());
    }

    @Override
    public ActivityUser selectActivity(Integer id) {
        return activityDao.selectInfoById(id);
    }

    @Override
    public void addPicture(Integer id, String pic) {
        activityDao.addActivityPicture(id, pic);
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
    public void addActivityInfo(Integer id, String info) {
        activityDao.addActivityInfo(id,info);
    }

    @Override
    public List<ActivityUser> selectActivitiesByOrganizer(Integer organizer) {
        return activityDao.selectActivitiesByOrganizer(organizer);
    }

    @Override
    public List<ActivityUser> selectInfoIncludePars(Integer id) {
        return activityDao.selectInfoIncludePars(id);
    }

}
