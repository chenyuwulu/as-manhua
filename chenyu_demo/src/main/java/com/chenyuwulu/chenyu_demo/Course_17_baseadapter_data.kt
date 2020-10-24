package com.chenyuwulu.chenyu_demo

class Course_17_baseadapter_data {
    // Getter和Setter方法
    var icon: Int = 0 // 图标数据
    var title: String? = null // 标题数据
    var info: String? = null // 信息描述数据

    // 构造方法
    constructor() {}

    constructor(icon: Int, title: String, info: String) {
        this.icon = icon
        this.title = title
        this.info = info
    }
}