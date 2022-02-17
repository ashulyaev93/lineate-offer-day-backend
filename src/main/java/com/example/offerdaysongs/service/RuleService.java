package com.example.offerdaysongs.service;

import com.example.offerdaysongs.dto.requests.CreateRecordingRequest;
import com.example.offerdaysongs.model.Rule;
import com.example.offerdaysongs.model.Singer;
import com.example.offerdaysongs.repository.RecordingRepository;
import com.example.offerdaysongs.repository.RuleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RuleService {

    private RuleRepository ruleRepository;
    private RecordingRepository recordingRepository;

    public RuleService(RuleRepository ruleRepository,
                       RecordingRepository recordingRepository){}

    public List<Rule> getAll() {
        return ruleRepository.findAll();
    }

    public Rule getById(long id) {
        return ruleRepository.getById(id);
    }

    public void delete(Long id){ruleRepository.deleteById(id);}

//    @Transactional
//    public Rule create(CreateRecordingRequest request) {
//        Rule rule = new Rule();
//        rule.setStartDate(request.getStartDate());
//        rule.setEndDate(request.getEndDate());
//        rule.setCompany(request.getCompany());
//        rule.setPrice(request.getPrice());
//        var singerDto = request.getSinger();
//        if (singerDto != null) {
//            var singer = singerRepository.findById(singerDto.getId()).orElseGet(() -> {
//                var temp = new Singer();
//                temp.setName(singerDto.getName());
//                return singerRepository.save(temp);
//            });
//            recording.setSinger(singer);
//        }
//        return recordingRepository.save(recording);
//    }

    //update
}
