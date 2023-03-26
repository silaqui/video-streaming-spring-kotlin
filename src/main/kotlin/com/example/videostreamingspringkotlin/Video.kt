package com.example.videostreamingspringkotlin

import jakarta.persistence.*

@Entity
open class Video(
    @Id
    @GeneratedValue
    open var id: Long? = null,

    @Column(unique = true)
    open var name: String? = null,

    @Lob
    open var data: ByteArray

)