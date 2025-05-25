package com.zeroo8.quora.controller;

import com.zeroo8.quora.dto.likeDTO.LikeRequest;
import com.zeroo8.quora.dto.likeDTO.LikeResponse;
import com.zeroo8.quora.services.LikeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("{type}/{id}/likes")
    public ResponseEntity<LikeResponse> like(
            @PathVariable String type,
            @PathVariable String id,
            @RequestBody @Valid LikeRequest request
    ) {
        if (!type.equals("questions") && !type.equals("answers") && !type.equals("comments")) {
            return ResponseEntity.badRequest().build();
        }

        LikeResponse response = likeService.like(type, id, request);
        return ResponseEntity.status(201).body(response);
    }
}
