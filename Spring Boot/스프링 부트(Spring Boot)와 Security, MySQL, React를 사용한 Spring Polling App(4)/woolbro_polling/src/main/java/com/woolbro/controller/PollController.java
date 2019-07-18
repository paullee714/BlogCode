package com.woolbro.controller;

import java.net.URI;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.woolbro.model.Poll;
import com.woolbro.payload.request.PollRequest;
import com.woolbro.payload.request.VoteRequest;
import com.woolbro.payload.response.ApiResponse;
import com.woolbro.payload.response.PagedResponse;
import com.woolbro.payload.response.PollResponse;
import com.woolbro.repository.PollRepository;
import com.woolbro.repository.UserRepository;
import com.woolbro.repository.VoteRepository;
import com.woolbro.security.CurrentUser;
import com.woolbro.security.UserPrincipal;
import com.woolbro.service.PollService;
import com.woolbro.util.AppConstants;

@RestController
@RequestMapping("/api/polls")
public class PollController {

	@Autowired
	private PollRepository pollRepository;

	@Autowired
	private VoteRepository voteRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PollService pollService;

	private static final Logger logger = LoggerFactory.getLogger(PollController.class);

	@GetMapping
	public PagedResponse<PollResponse> getPolls(@CurrentUser UserPrincipal currentUser,
			@RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
			@RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
		return pollService.getAllPolls(currentUser, page, size);
	}

	@PostMapping
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> createPoll(@Valid @RequestBody PollRequest pollRequest) {
		Poll poll = pollService.createPoll(pollRequest);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{pollId}").buildAndExpand(poll.getId())
				.toUri();

		return ResponseEntity.created(location).body(new ApiResponse(true, "Poll Created Successfully"));
	}

	@GetMapping("/{pollId}")
	public PollResponse getPollById(@CurrentUser UserPrincipal currentUser, @PathVariable Long pollId) {
		return pollService.getPollById(pollId, currentUser);
	}

	@PostMapping("/{pollId}/votes")
	@PreAuthorize("hasRole('USER')")
	public PollResponse castVote(@CurrentUser UserPrincipal currentUser, @PathVariable Long pollId,
			@Valid @RequestBody VoteRequest voteRequest) {
		return pollService.castVoteAndGetUpdatedPoll(pollId, voteRequest, currentUser);
	}
}