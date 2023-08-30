package ra.model.repository;

import ra.model.entity.FeedBack;

import java.util.List;

public interface IFeedBackRepository {
    List<FeedBack> findAll();
    FeedBack findById(Long id);
    void save(FeedBack feedback);
    void delete(Long id);
}
