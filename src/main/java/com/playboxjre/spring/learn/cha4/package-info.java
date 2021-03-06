/**
 * com.playboxjre.spring.learn.cha4
 * Administrator
 * 2018\1\25 0025 17:50
 * EMAIL : playboxjre@gmail.com
 * @see org.springframework.core.io.Resource
 * @see org.springframework.core.io.InputStreamSource
 */
package com.playboxjre.spring.learn.cha4;
/*
<pre>
4.1 介绍
仅仅使用 java 标准java.net.URL和针对不同 URL 前缀的标准处理器并不能满足
我们对各种底层资源的访问，比如：我们就不能通过URL的标准实现来访问相对类路
径或者相对ServletContext 的各种资源。虽然我们可以针对特定的 url 前缀来注
册一个新的处理handler（和现有的针对各种特定前缀的处理器类似，比如 http：），
然而这往往会是一件比较麻烦的事情(要求了解 url 的实现机制等），而且 url 接口
也缺少了部分基本的方法，如检查当前资源是否存在的方法。
</pre>
 */