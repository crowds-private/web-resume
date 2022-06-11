package com.liuqi.springbootfreemarkerpjax.core

import org.springframework.stereotype.Component
import org.springframework.util.StringUtils
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * 类说明 <br></br>
 * Pjax 请求拦截器
 *
 * @author : alexliu
 * @version v1.0 , Create at 22:41 2020-03-25
 */
@Component
class PjaxInterceptor : HandlerInterceptor {
    private var RequestURI = ""
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val scheme = request.scheme
        val serverName = request.serverName
        val port = request.serverPort
        val path = request.contextPath
        val basePath = "$scheme://$serverName:$port$path"
        request.setAttribute("basePath", basePath)
        return true
    }

    /**
     * Post 处理
     */
    override fun postHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        modelAndView: ModelAndView?
    ) {
        RequestURI = request.requestURI
        if (modelAndView == null) {
            // == 空 请求可能是下载文件等，或者错误。不执行模板渲染
            return
        }
        if (isPjax(request)) {
            setPjaxResult(modelAndView)
        } else if (!isAjax(request)) {
            // 不是 pjax 不是 ajax
            // 返回普通视图模板
            setNormalResult(modelAndView)
        } else {
            //不是 pjax 不是 ajax 不处理
            return
        }
    }

    /**
     *
     */
    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        ex: Exception?
    ) {

    }

    private fun setPjaxResult(modelAndView: ModelAndView) {
        modelAndView.addObject("baseTemplate", PJAX_TEMPLATE_PATH)
    }

    private fun setNormalResult(modelAndView: ModelAndView) {
        modelAndView.addObject("baseTemplate", NORMAL_TEMPLATE_PATH)
    }

    private fun isPjax(request: HttpServletRequest): Boolean {
        val pjax = java.lang.Boolean.parseBoolean(request.getHeader("X-PJAX"))
        return pjax
    }

    private fun isAjax(request: HttpServletRequest): Boolean {
        var ajax = java.lang.Boolean.FALSE
        // 判断是否 ajax
        if (!StringUtils.isEmpty(request.getHeader("x-requested-with")) && (request.getHeader("x-requested-with") == "XMLHttpRequest")) {
            ajax = java.lang.Boolean.TRUE
        }
        return ajax
    }

    companion object {
        private const val PJAX_TEMPLATE_PATH = "/common/basePjax.ftl"
        private const val NORMAL_TEMPLATE_PATH = "/common/base.ftl"
    }
}