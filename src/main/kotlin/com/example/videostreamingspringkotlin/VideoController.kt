package com.example.videostreamingspringkotlin

import org.springframework.core.io.ByteArrayResource
import org.springframework.core.io.Resource
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/video")
@CrossOrigin
class VideoController(
    private val videoService: VideoService
) {

    @GetMapping
    fun getNames(): List<String> {
        return videoService.getVideosNames()
    }

    @GetMapping("/{name}")
    fun getVideoByName(@PathVariable name: String): ResponseEntity<Resource> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            .body(ByteArrayResource(videoService.getVideo(name)!!.data))
    }

    @PostMapping
    fun saveVideo(@RequestParam file: MultipartFile, @RequestParam name: String): String {
        videoService.save(file, name)
        return "OK"
    }
}