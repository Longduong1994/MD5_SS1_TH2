package ra.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.dto.FormFeedBackDto;
import ra.model.entity.FeedBack;
import ra.model.repository.IFeedBackRepository;

import java.util.List;

@Service
public class FeedBackService implements IFeedBackService {
    @Autowired
    private IFeedBackRepository feedbackRepository;

    @Override
    public List<FeedBack> findAll() {
        return feedbackRepository.findAll();
    }

    @Override
    public FeedBack findById(Long id) {
        return feedbackRepository.findById(id);
    }

    @Override
    public void save(FormFeedBackDto f) {
        FeedBack feedback = new FeedBack(f.getId(),
                f.getRate(),f.getAuthor(),
                f.getContent(),f.getDate(), f.getLike());
        feedbackRepository.save(feedback);

    }

    @Override
    public void delete(Long id) {
        feedbackRepository.delete(id);
    }

    @Override
    public void like(Long id) {
        FeedBack f = feedbackRepository.findById(id);
        f.setLikes(f.getLikes()+1);
        feedbackRepository.save(f);
    }
}