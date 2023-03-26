package com.example.videostreamingspringkotlin

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface VideoRepository : JpaRepository<Video, Long> {

    fun findVideoByName(name: String): Video?

    @Query(nativeQuery = true, value = "SELECT name FROM video")
    fun getAllNames(): List<String>
}