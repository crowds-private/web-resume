package com.crowds.myresume.config

import com.crowds.myresume.model.Article
import freemarker.template.Template
import freemarker.template.TemplateExceptionHandler
import org.apache.commons.lang3.StringUtils
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.File
import java.io.OutputStreamWriter
import java.io.Writer
import javax.annotation.Resource
import freemarker.template.Configuration as MakerConfiguration

@Configuration
class TemplateConfig {

//
//    @Bean(name = ["makerConfiguration"])
//    fun getConfigurationBean(): MakerConfiguration {
//        var configuration = MakerConfiguration(MakerConfiguration.VERSION_2_3_31)
//        configuration.defaultEncoding = "UTF-8"
//        // 设置 Templates 地址
//        var path: String = TemplateConfig::class.java.getResource("/").path
//
//        if (StringUtils.contains(path, "/build/classes/kotlin") || StringUtils.contains(
//                path,
//                "/build/classes/kotlin/test"
//            )
//        ) {
//            // 开发时使用源码目录
//            path = StringUtils.replace(path, "/build/classes/kotlin/main", "/src/main/resources/templates")
//            path = StringUtils.replace(path, "/build/classes/kotlin/test", "/src/main/resources/templates")
//        }
//        configuration.setDirectoryForTemplateLoading(File(path))
//
//        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER)
//        configuration.logTemplateExceptions = false
//
//        var article= Article("Title", "Abstract", "Content")
//        var testMap = mutableMapOf<String, Any>()
//        var articles = mutableListOf<Article>();
//        articles.add(article)
//        testMap["articles"] = articles
////        Fill Articles
//        var template: Template = configuration.getTemplate("index.ftl")
//        val out: Writer = OutputStreamWriter(System.out)
//        template.process(testMap, out)
//        return configuration
//    }
}