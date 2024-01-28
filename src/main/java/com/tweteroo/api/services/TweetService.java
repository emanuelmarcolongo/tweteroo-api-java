package com.tweteroo.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.repositories.TweetRepository;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class TweetService {

    final TweetRepository tweetRepository;
    final UserRepository userRepository;

    TweetService(TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    public Optional<TweetModel> postTweet(TweetDTO dto) {

        Optional<UserModel> user = userRepository.findById(dto.getUserId());

        if (!user.isPresent()) {
            return Optional.empty();
        }

        TweetModel newTweet = new TweetModel(dto, user.get());
        return Optional.of(tweetRepository.save(newTweet));
    }

    public List<TweetModel> getAllTweets() {

        List<TweetModel> allTweets = tweetRepository.findAll();

        return allTweets;
    }

    public Optional<Object> getUserTweets(Long id) {

        Optional<UserModel> user = userRepository.findById(id);

        if (!user.isPresent()) {
            return Optional.empty();
        }

        List<TweetModel> allTweets = tweetRepository.findByUserId(id);
        return Optional.of(allTweets);
    }

}
