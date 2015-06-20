##hcloud
----------------

###背景
学校要搞一个学生的爱好兴趣技术培养的计划，那时候远程实习还没开始，闲来无事，就带着三个小伙伴风风火火的开始了。以此项目作为我们的练手项目。

###一个渣渣的想法
这个项目是依托于学校的学生会的学习部搞的云互助的活动而产生的，学习部号召同学们建立一个学习互助平台，所以这个项目就是一个校园学习帮手项目，也希望其他学校的同学可以参与其中。

###项目规范上的一些事
####sdk & buildTool
- compileSdkVersion 22
- buildToolsVersion "22.0.1"

####使用的开源库

 - compile 'com.jakewharton:butterknife:6.1.0'
 - compile 'de.greenrobot:eventbus:2.2.1'
 - compile 'com.squareup.okhttp:okhttp:2.3.0'
 - compile 'com.squareup.retrofit:retrofit:1.9.0'
 - compile 'com.squareup.picasso:picasso:2.5.2'
 - compile 'com.alibaba:fastjson:latest.integration'
 -  compile 'com.github.siyamed:android-shape-imageview:0.9.+@aar'
 -  compile 'com.orhanobut:logger:1.10'

####命名规范

<pre><code>
包名小写
JAVA部分
    采用驼峰法
    Activity类：Activity为后缀、Fragment类：Fragment为后缀、Adapter类：Adapter为后缀...
    抽象类Abs开头
    接口I开头
资源文件
    小写加下划线分割
    contentview命名：activity_功能模块.xml，fragment_功能模块.xml
    例如：activity_main.xml、activity_more.xml、fragment_main.xml
    组件命名：组件简写\_模块\_描述.xml
        Button：btn\_模块\_描述.xml
        例如：btn\_main\_login.xml
        Dialog：dialog\_模块\_描述.xml
        例如：dialog\_main\_hint.xml
        PopupWindow命名：pw\_模块\_描述.xml
        例如：pw\_main\_info.xml
    adapter的子布局：item\_功能模块\_描述.xml
    例如：item_main_goods_list.xml
    包含项：include_描述.xml（include文件可能多模块复用，所以不加模块）
    例如：include_head.xml、include_bottom.xml
    延迟加载部分：viewstub_描述.xml
    例如：viewstub_empty.xml
    合并：merge_描述.xml
</code></pre>


 