package com.tweteroo.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.services.TweetService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/tweets")
public class TweetController {
    final TweetService tweetService;

    TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping()
    public ResponseEntity<List<TweetModel>> getAllTweets() {

        List<TweetModel> allTweets = tweetService.getAllTweets();
        return ResponseEntity.status(HttpStatus.OK).body(allTweets);

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Object> getUserTweets(@PathVariable Long userId) {

        Optional<Object> allTweets = tweetService.getUserTweets(userId);

        if (!allTweets.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There's no tweets from this user");
        }

        return ResponseEntity.status(HttpStatus.OK).body(allTweets);

    }

    @PostMapping()
    public ResponseEntity<Object> postTweet(@RequestBody @Valid TweetDTO dto) {

        Optional<TweetModel> tweet = tweetService.postTweet(dto);

        if (!tweet.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No user match informed userId");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(tweet);
    }

}
