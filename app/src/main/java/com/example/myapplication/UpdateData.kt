package com.example.myapplication

class UpdateData {
    var imgId: Int = 0
    var content: String? = null

    constructor() {}

    constructor(imgId: Int, content: String) {
        this.imgId = imgId
        this.content = content
    }
}