package ra.model.service;

import ra.model.dto.FormFeedBackDto;
import ra.model.entity.FeedBack;

import java.util.List;

public interface IFeedBackService {
    List<FeedBack> findAll();
    FeedBack findById(Long id);
    void save(FormFeedBackDto feedbackDto);
    void delete(Long id);
    void like(Long id);
}