package com.example.videostreamingspringkotlin

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.IOException

@Service
class VideoService(
    private val videoRepository: VideoRepository
) {

    fun getVideo(name: String): Video? {
        return videoRepository.findVideoByName(name)
    }

    fun getVideosNames(): List<String> {
        return videoRepository.getAllNames()
    }

    @Throws(IOException::class)
    fun save(file: MultipartFile, name: String) {
        videoRepository.save(Video(name = name, data = file.bytes))
    }
}